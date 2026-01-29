package com.hja.thenewsapp.repository

import com.hja.thenewsapp.api.RetrofitInstance
import com.hja.thenewsapp.db.ArticleDatabase
import com.hja.thenewsapp.models.Article

class NewsRepository (val db: ArticleDatabase){
    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String,pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getALLArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}