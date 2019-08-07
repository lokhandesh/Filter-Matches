package com.santoshlokhande.filteringmatches.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.santoshlokhande.filteringmatches.MainActivity
import com.santoshlokhande.filteringmatches.data.Matches
import com.santoshlokhande.filteringmatches.data.MatchesResponse
import java.io.IOException

/**
 * Created by Santosh Lokhande on 04/08/2019
 *
 * MatchesViewModel which is extended from AndroidViewModel.
 *
 * Here we received all MatchesList from assets.
 *
 */


class MatchesViewModel(application: Application) : AndroidViewModel(application) {



    var matchesList = MutableLiveData<List<Matches>>()
    var applicationn = application

    fun getAllMatches(): LiveData<List<Matches>> {

        return loadJSONFromAssets()
    }

    fun retriveMatchesList() {
        getAllMatches()
    }

    fun loadJSONFromAssets(): MutableLiveData<List<Matches>> {

        var json: String? = null
        try {
            val inputStream = applicationn.assets.open("matches.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            json = String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val gson = Gson()
        var model = gson.fromJson(json, MatchesResponse::class.java)

        matchesList.value=model.matches

        return matchesList
    }

}