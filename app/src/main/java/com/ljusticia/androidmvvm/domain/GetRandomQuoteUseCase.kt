package com.ljusticia.androidmvvm.domain

import com.ljusticia.androidmvvm.data.QuoteRepository
import com.ljusticia.androidmvvm.data.model.QuoteModel
import com.ljusticia.androidmvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){
    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}