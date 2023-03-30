package com.ljusticia.androidmvvm.model

class QuoteProvider {
    companion object {

        fun random():QuoteModel{
            val position:Int = (0..4).random()
            return quote[position]
        }

        private val quote = listOf<QuoteModel>(
            QuoteModel("Test", "ljustici"),
            QuoteModel("Lorem ipsum dolor sit amet", "Lorem"),
            QuoteModel("Cras nec rhoncus ligula", "Ipsum"),
            QuoteModel("Morbi vehicula ex ac molestie blandit", "Dolor"),
            QuoteModel("Sed et nibh suscipit tellus mattis viverra vel a nulla", "Sit Amet"),
        )
    }
}