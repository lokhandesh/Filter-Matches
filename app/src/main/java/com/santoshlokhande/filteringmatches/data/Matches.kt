package com.santoshlokhande.filteringmatches.data


/**
 * Created by Santosh Lokhande on 04/08/2019
 *
 * Matches is Data class
 *
 *
 */

data class Matches(
        val id: Int,
        val job_title: String,
        val display_name: String,
        val age: Int,
        val height_in_cm: Int,
        val main_photo:String,
        val compatibility_score:Float,
        val contacts_exchanged:Int,
        val favourite:Boolean,
        val religion:String,
        val city: City
)

data class City(val name:String,val lat:Double,val lon:Double)

data class MatchesResponse(
        val matches: List<Matches>
)