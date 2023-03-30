package com.ljusticia.androidmvvm.data.network

import com.ljusticia.androidmvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json/")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}