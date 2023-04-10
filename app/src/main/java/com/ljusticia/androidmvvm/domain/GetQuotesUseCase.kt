package com.ljusticia.androidmvvm.domain

import com.ljusticia.androidmvvm.data.QuoteRepository
import com.ljusticia.androidmvvm.data.database.entities.toDatabase
import com.ljusticia.androidmvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository ) {
    suspend operator fun invoke():List<Quote>{
        //Cuando se inicie la app recupera la info del servidor
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map{it.toDatabase()})
            quotes
        }
        else{
            repository.getAllQuotesFromDatabase()
        }
    }
}