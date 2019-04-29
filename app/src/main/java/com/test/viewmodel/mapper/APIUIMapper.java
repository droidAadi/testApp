package com.test.viewmodel.mapper;

import com.test.service.model.MostViewedArticle;
import com.test.service.model.MostViewedArticleResult;
import com.test.view.pojo.ArticleListPojo;

import java.util.ArrayList;
import java.util.List;

public class APIUIMapper implements ModelMapper<MostViewedArticle, ArticleListPojo> {
    @Override
    public ArticleListPojo mapsTo(MostViewedArticle source) {
        ArticleListPojo articleListPojo = new ArticleListPojo();
        List<ArticleListPojo.ArticlePojo> articleList = new ArrayList<>();
        for (MostViewedArticleResult mostViewedArticleResult : source.getArticleResultList()) {
            ArticleListPojo.ArticlePojo article = new ArticleListPojo.ArticlePojo();
            article.setTitle(mostViewedArticleResult.getTitle());
            article.setPublishedDate(mostViewedArticleResult.getPublishedDate());
            article.setSource(mostViewedArticleResult.getSource());
            article.setByLine(mostViewedArticleResult.getByLine());
            article.setAbstract(mostViewedArticleResult.getAbstract());
            article.setURL(mostViewedArticleResult.getURL());
            articleList.add(article);
        }
        articleListPojo.setArticleList(articleList);
        return articleListPojo;
    }
}
