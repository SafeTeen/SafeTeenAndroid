package com.candledle.safeteen

import android.app.Application
import androidx.room.Room
import com.candledle.safeteen.room.database.SafeteenDatabase

class SafeteenApplication : Application() {
    companion object {
        lateinit var database: SafeteenDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, SafeteenDatabase::class.java, "SafeteenDb").build()
    }
}