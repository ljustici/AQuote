package com.ljusticia.androidmvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ljusticia.androidmvvm.data.database.dao.QuoteDao
import com.ljusticia.androidmvvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}