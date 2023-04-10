package com.ljusticia.androidmvvm.domain.model

import com.ljusticia.androidmvvm.data.database.entities.QuoteEntity
import com.ljusticia.androidmvvm.data.model.QuoteModel

data class Quote(val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)