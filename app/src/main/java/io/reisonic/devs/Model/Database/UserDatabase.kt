package io.reisonic.devs.Model.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.reisonic.devs.Presenter.Database.UserDAO

@Database(entities = arrayOf(User::class),version = 1, exportSchema = false)
abstract class UserDatabase:RoomDatabase() {
    companion object {
        @Volatile private var instance: UserDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance
            ?: synchronized(LOCK){
            instance
                ?: buildDatabase(
                    context
                )
                    .also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            UserDatabase::class.java, "userlist.db")
            .build()
    }

    abstract fun userDao(): UserDAO?
}