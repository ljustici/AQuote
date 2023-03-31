package com.ljusticia.androidmvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

//Si no lo injectamos como singleton se creará más de una instancia QuoteProvider cuyas listas
//estarán vacías, y no se devolverá la instancia con los resultados
@Singleton
class QuoteProvider @Inject constructor(){
        var quotes:List<QuoteModel> = emptyList()
}