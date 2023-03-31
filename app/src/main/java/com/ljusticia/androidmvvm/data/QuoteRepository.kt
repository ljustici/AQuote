package com.ljusticia.androidmvvm.data

import com.ljusticia.androidmvvm.data.model.QuoteModel
import com.ljusticia.androidmvvm.data.model.QuoteProvider
import com.ljusticia.androidmvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api : QuoteService,
                                          private val quoteProvider: QuoteProvider){

    suspend fun getAllQuotes():List<QuoteModel>{
        //Llama al backend y recuper la frase
        val response = api.getQuotes()
        //Guarda la frase
        quoteProvider.quotes = response
        //Devuelve la respuesta
        return response
    }
}