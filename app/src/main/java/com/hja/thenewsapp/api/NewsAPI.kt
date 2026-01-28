package com.hja.thenewsapp.api


import com.hja.thenewsapp.models.NewsResponse
import com.hja.thenewsapp.util.Constants.Companion.API_KEY
import retrofit2.Response

import retrofit2.http.Query
import retrofit2.http.GET

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country")
        countryCode: String = "cn",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apikey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey")
        apikey: String = API_KEY
    ): Response<NewsResponse>

}