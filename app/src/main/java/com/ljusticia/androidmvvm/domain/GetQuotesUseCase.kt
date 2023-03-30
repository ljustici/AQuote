package com.ljusticia.androidmvvm.domain

import com.ljusticia.androidmvvm.data.QuoteRepository

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke() = repository.getAllQuotes()
}