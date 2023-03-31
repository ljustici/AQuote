package com.ljusticia.androidmvvm.di

import com.ljusticia.androidmvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Módulo que provee dependencias de librerías o interfaces
//Es un módulo porque los módulos son los que proveen dependencias
//
//Instala a nivel de aplicación (singleton)
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    //Provee siempre la misma instancia de Retrofit (singleton)
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit):QuoteApiClient{
        return retrofit.create(QuoteApiClient::class.java)
    }
}