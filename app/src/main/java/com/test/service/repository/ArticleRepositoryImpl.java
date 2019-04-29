package com.test.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.test.service.model.MostViewedArticle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticleRepositoryImpl implements ArticleRepository {

    private NYService mNYService;


    private static ArticleRepositoryImpl sArticleRepository;

    private ArticleRepositoryImpl(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ServiceConstants.HTTPS_NY_API_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        mNYService = retrofit.create(NYService.class);
    }

    public static synchronized  ArticleRepositoryImpl getInstance() {

        if (sArticleRepository == null) {
            sArticleRepository = new ArticleRepositoryImpl();
        }
        return sArticleRepository;
    }

    @Override
    public LiveData<MostViewedArticle> getListOfArticles(String section, int period, String apiKey){

        final MutableLiveData<MostViewedArticle> mostViewedArticleMutableLiveData = new MutableLiveData<>();
        mNYService.getMostViewedArticleList(section, period, apiKey).enqueue(new Callback<MostViewedArticle>() {
            @Override
            public void onResponse(Call<MostViewedArticle> call, Response<MostViewedArticle> response) {
                mostViewedArticleMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MostViewedArticle> call, Throwable t) {
                Log.i("****Error", call.toString());
            }
        });

        return mostViewedArticleMutableLiveData;
    }
}
