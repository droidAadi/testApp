package com.test;

import android.app.Application;
import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;

import com.test.service.model.MostViewedArticle;
import com.test.service.model.MostViewedArticleResult;
import com.test.view.pojo.ArticleListPojo;
import com.test.viewmodel.ArticleViewModel;
import com.test.viewmodel.mapper.APIUIMapper;
import com.test.viewmodel.mapper.ModelMapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ArticleViewModelTest {


    @Rule
    public InstantTaskExecutorRule mRule = new InstantTaskExecutorRule();
    @Mock
    private Application mAppContext;
    private ArticleViewModel mArticleViewModel;

    @Mock
    private LiveData<MostViewedArticle> mMostViewedArticleObservable;

    @Mock
    private LiveData<ArticleListPojo> mArticleListObservable;

    @Mock
    private Observer<MostViewedArticle> mMostViewedArticleObserver;

    @Before
    public void setViewModel(){
        MockitoAnnotations.initMocks(this);

        setAppContext();
        mArticleViewModel = new ArticleViewModel(mAppContext);
    }

    private void setAppContext(){
        when(mAppContext.getApplicationContext()).thenReturn(mAppContext);
    }

    @Test
    public void getArticlePojoTest(){
        LiveData<ArticleListPojo.ArticlePojo> articleLiveData = new MutableLiveData<>();
        ArticleListPojo articleListPojo = new ArticleListPojo();
        ArticleListPojo.ArticlePojo articlePojo = new ArticleListPojo.ArticlePojo();
        articlePojo.setTitle("XYZ");
        articlePojo.setByLine("By AK");
        articlePojo.setPublishedDate("28-APR-2019");
        articlePojo.setSource("NY Times");
        List<ArticleListPojo.ArticlePojo> articlePojoList = new ArrayList<>();
        articlePojoList.add(articlePojo);
        articleListPojo.setArticleList(articlePojoList);
        ((MutableLiveData<ArticleListPojo>) mArticleViewModel.getArticleListLiveData()).setValue(articleListPojo);
        Assert.assertNotNull(mArticleViewModel.getArticlePojoLiveData(0).getValue());
        Assert.assertEquals("XYZ", mArticleViewModel.getArticlePojoLiveData(0).getValue().getTitle());
    }

    @Test
    public void getObserverNullTest(){
        mArticleViewModel.getMostViewedArticleObserver().onChanged(null);
        Assert.assertNotNull(mArticleViewModel.getArticleListLiveData());
    }

    @Test
    public void getObserverNotNullTest(){
        ModelMapper<MostViewedArticle, ArticleListPojo> modelMapper = new APIUIMapper();
        MostViewedArticle mostViewedArticle = new MostViewedArticle();
        List<MostViewedArticleResult> mostViewedArticleResultList = new ArrayList<>();
        MostViewedArticleResult mostViewedArticleResult = new MostViewedArticleResult();
        mostViewedArticleResult.setPublishedDate("28-APR-2019");
        mostViewedArticleResult.setSource("NY Times");
        mostViewedArticleResult.setTitle("XYZ");
        mostViewedArticleResult.setByLine("BY AK");
        mostViewedArticleResultList.add(mostViewedArticleResult);
        mostViewedArticle.setArticleResultList(mostViewedArticleResultList);
        mArticleViewModel.getMostViewedArticleObserver().onChanged(mostViewedArticle);

        ArticleListPojo articleListPojo = modelMapper.mapsTo(mostViewedArticle);

        ((MutableLiveData<ArticleListPojo>) mArticleViewModel.getArticleListLiveData()).
                setValue(articleListPojo);
        Assert.assertEquals("XYZ", mArticleViewModel.getArticleListLiveData().getValue().
                getArticleList().get(0).getTitle());
    }


}