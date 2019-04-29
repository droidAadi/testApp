package com.test.view.pojo;

import java.util.List;

public class ArticleListPojo {

    public List<ArticlePojo> getArticleList() {
        return mArticleList;
    }

    public void setArticleList(List<ArticlePojo> articleList) {
        this.mArticleList = articleList;
    }

    private List<ArticlePojo> mArticleList;


    public static class ArticlePojo {
        private String mTitle;
        private String mPublishedDate;
        private String mByLine;
        private String mSource;
        private String mAbstract;
        private String mURL;



        public void setURL(String url){
            mURL = url;
        }

        public String getURL(){
            return mURL;
        }

        public void setAbstract(String details){
            mAbstract = details;
        }

        public String getAbstract(){
            return mAbstract;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            this.mTitle = title;
        }

        public String getPublishedDate() {
            return mPublishedDate;
        }

        public void setPublishedDate(String publishedDate) {
            this.mPublishedDate = publishedDate;
        }

        public String getByLine() {
            return mByLine;
        }

        public void setByLine(String byLine) {
            this.mByLine = byLine;
        }

        public String getSource() {
            return mSource;
        }

        public void setSource(String source) {
            this.mSource = source;
        }
    }


}
