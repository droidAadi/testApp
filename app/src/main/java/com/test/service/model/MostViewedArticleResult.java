package com.test.service.model;

import com.google.gson.annotations.SerializedName;

public class MostViewedArticleResult {

    @SerializedName("url")
    private String mURL;

    @SerializedName("byline")
    private String mByLine;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("abstract")
    private String mAbstract;

    @SerializedName("source")
    private String mSource;

    @SerializedName("published_date")
    private String mPublishedDate;

    @SerializedName("id")
    private long mId;

    @SerializedName("views")
    private int mNumberOfViews;

    @SerializedName("type")
    private String mType;

    public String getURL() {
        return mURL;
    }

    public String getByLine() {
        return mByLine;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAbstract() {
        return mAbstract;
    }

    public String getSource() {
        return mSource;
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }

    public long getId() {
        return mId;
    }

    public int getNumberOfViews() {
        return mNumberOfViews;
    }

    public String getType() {
        return mType;
    }

    public void setURL(String url) {
        this.mURL = url;
    }

    public void setByLine(String byLine) {
        this.mByLine = byLine;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setAbstract(String mAbstract) {
        this.mAbstract = mAbstract;
    }

    public void setSource(String source) {
        this.mSource = source;
    }

    public void setPublishedDate(String publishedDate) {
        this.mPublishedDate = publishedDate;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public void setNumberOfViews(int numberOfViews) {
        this.mNumberOfViews = numberOfViews;
    }

    public void setType(String type) {
        this.mType = type;
    }
}
