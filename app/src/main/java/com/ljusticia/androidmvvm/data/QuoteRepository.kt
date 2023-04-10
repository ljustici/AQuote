package com.ljusticia.androidmvvm.data

import com.ljusticia.androidmvvm.data.database.dao.QuoteDao
import com.ljusticia.androidmvvm.data.database.entities.QuoteEntity
import com.ljusticia.androidmvvm.data.model.QuoteModel
import com.ljusticia.androidmvvm.data.network.QuoteService
import com.ljusticia.androidmvvm.domain.model.Quote
import com.ljusticia.androidmvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteDao: QuoteDao
){

    suspend fun getAllQuotesFromApi():List<Quote>{
        //Llama al backend y recuper la frase
        val response: List<QuoteModel> = api.getQuotes()
        //Devuelve la respuesta
        return response.map{it.toDomain()}
    }

    suspend fun getAllQuotesFromDatabase():List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map{ it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}