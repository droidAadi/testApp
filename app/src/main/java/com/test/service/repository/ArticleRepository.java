package com.test.service.repository;

import android.arch.lifecycle.LiveData;

import com.test.service.model.MostViewedArticle;

public interface ArticleRepository {

    LiveData<MostViewedArticle> getListOfArticles(String section, int period, String apiKey);
}
