package com.santoshlokhande.filteringmatches.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Santosh Lokhande on 27/7/2019
 *
 * Matches is Data class
 *
 * All field of this class works as a column name of album_table
 *
 */

@Entity(tableName = "album_table")
data class Matches(
        @PrimaryKey
        val id: Int,
        val userId: Int,
        val title: String
)

data class MatchesResponse(
        val results: List<Matches>
)