package com.test.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.test.BuildConfig;
import com.test.service.model.MostViewedArticle;
import com.test.service.repository.ArticleRepositoryImpl;
import com.test.view.pojo.ArticleListPojo;
import com.test.viewmodel.mapper.APIUIMapper;
import com.test.viewmodel.mapper.ModelMapper;

public class ArticleViewModel extends AndroidViewModel {


    private static final int PERIOD = 7;
    private LiveData<MostViewedArticle> mMostViewedArticleLiveData;
    private final LiveData<ArticleListPojo> mArticleListLiveData;
    private Observer<MostViewedArticle> mMostViewedArticleObserver =
            new Observer<MostViewedArticle>() {
                @Override
                public void onChanged(@Nullable MostViewedArticle mostViewedArticle) {
                    if(mostViewedArticle == null){
                        return;
                    }
                    ModelMapper<MostViewedArticle, ArticleListPojo> modelMapper = new APIUIMapper();
                    ArticleListPojo articleListPojo = modelMapper.mapsTo(mostViewedArticle);
                    ((MutableLiveData<ArticleListPojo>) mArticleListLiveData).setValue(articleListPojo);
                }
            };

    public LiveData<ArticleListPojo> getArticleListLiveData() {
        return mArticleListLiveData;
    }

    public Observer<MostViewedArticle> getMostViewedArticleObserver() {
        return mMostViewedArticleObserver;
    }

    public ArticleViewModel(
            @NonNull Application application) {
        super(application);
        mArticleListLiveData = new MutableLiveData<>();
        mMostViewedArticleLiveData = ArticleRepositoryImpl.getInstance().
                getListOfArticles("all-sections", PERIOD, BuildConfig.API_SECRET_KEY);
        addObserver();
    }

    public void addObserver() {
        mMostViewedArticleLiveData.observeForever(mMostViewedArticleObserver);
    }

    public void removeObserver() {
        mMostViewedArticleLiveData.removeObserver(mMostViewedArticleObserver);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        removeObserver();
    }

    public LiveData<ArticleListPojo.ArticlePojo> getArticlePojoLiveData(int position){
        LiveData<ArticleListPojo.ArticlePojo>  articlePojoLiveData = new MutableLiveData<>();
        ((MutableLiveData<ArticleListPojo.ArticlePojo>) articlePojoLiveData).
                setValue(mArticleListLiveData.getValue().getArticleList().get(position));
       return articlePojoLiveData;
    }
}
