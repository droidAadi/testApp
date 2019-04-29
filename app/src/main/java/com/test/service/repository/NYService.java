package com.test.service.repository;

import com.test.service.model.MostViewedArticle;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NYService {

    @GET("svc/mostpopular/v2/mostviewed/{section}/{period}.json")
    Call<MostViewedArticle> getMostViewedArticleList(@Path("section") String section,
                                                           @Path("period") int period,
                                                           @Query("api-key") String apiKey);
}
