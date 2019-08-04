package com.santoshlokhande.filteringmatches.db


import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.santoshlokhande.filteringmatches.db.dao.MatchesDao
import com.santoshlokhande.filteringmatches.data.Matches


/**
 * Created by Santosh Lokhande 28/08/2019
 *
 * This class has used to instantiate Room Database.
 *
 *
 */

@Database(entities = [Matches::class], version = 1)
abstract class MatchesDatabase : RoomDatabase() {

    abstract fun albumDao(): MatchesDao

    companion object {
        private var instance: MatchesDatabase? = null

        fun  getInstance(context: Context): MatchesDatabase? {
            if (instance == null) {
                synchronized(MatchesDatabase::class) {
                    instance = Room.databaseBuilder(
                        context,
                        MatchesDatabase::class.java, "album_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback).allowMainThreadQueries()
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }

    }

}