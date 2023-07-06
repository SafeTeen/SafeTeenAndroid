package com.candledle.safeteen.room.database

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.candledle.safeteen.room.dao.UserDao
import com.candledle.safeteen.room.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
    ],
    version = 2,
)
abstract class SafeteenDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {

        private lateinit var instance: SafeteenDatabase

        fun getInstance(context: Context) {
            if (!this::instance.isInitialized) {
                instance = Room.databaseBuilder(
                    context = context.applicationContext,
                    SafeteenDatabase::class.java,
                    "Safeteen_Database",
                ).allowMainThreadQueries().build()
            }
        }
    }
}
