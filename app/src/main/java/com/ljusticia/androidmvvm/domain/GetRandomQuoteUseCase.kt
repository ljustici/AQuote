package com.ljusticia.androidmvvm.domain

import com.ljusticia.androidmvvm.data.model.QuoteModel
import com.ljusticia.androidmvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}