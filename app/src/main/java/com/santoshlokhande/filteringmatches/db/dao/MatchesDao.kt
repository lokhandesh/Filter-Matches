package com.santoshlokhande.filteringmatches.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.santoshlokhande.filteringmatches.data.Matches

/**
 * Created by Santosh Lokhande on 28/8/2019.
 *
 * Here we declare method for Room Db
 *
 * THis interface should annotate with @Dao
 *
 */

@Dao
interface MatchesDao {

    @Insert
    fun insert(users: List<Matches>)

    @Query("SELECT * FROM album_table ")
    fun getAllAlbumList(): LiveData<List<Matches>>

    @Query("DELETE FROM album_table")
    fun deleteAll()

}