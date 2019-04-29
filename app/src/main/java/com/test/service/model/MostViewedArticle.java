package com.test.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MostViewedArticle {

    @SerializedName("status")
    private String mStatus;
    @SerializedName("num_results")
    private int mResultCount;
    @SerializedName("results")
    private List<MostViewedArticleResult> mArticleResultList;


    public String getStatus() {
        return mStatus;
    }

    public int getResultCount() {
        return mResultCount;
    }

    public List<MostViewedArticleResult> getArticleResultList() {
        return mArticleResultList;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public void setResultCount(int resultCount) {
        this.mResultCount = resultCount;
    }

    public void setArticleResultList(List<MostViewedArticleResult> articleResultList) {
        this.mArticleResultList = articleResultList;
    }
}
