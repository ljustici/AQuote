package com.ljusticia.androidmvvm.data

import com.ljusticia.androidmvvm.data.model.QuoteModel
import com.ljusticia.androidmvvm.data.model.QuoteProvider
import com.ljusticia.androidmvvm.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        //Llama al backend y recuper la frase
        val response = api.getQuotes()
        //Guarda la frase
        QuoteProvider.quotes = response
        //Devuelve la respuesta
        return response
    }
}