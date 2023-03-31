package com.ljusticia.androidmvvm.domain

import com.ljusticia.androidmvvm.data.QuoteRepository
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository ) {
    suspend operator fun invoke() = repository.getAllQuotes()
}