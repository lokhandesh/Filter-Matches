package com.santoshlokhande.filteringmatches.repository

import android.app.Application
import androidx.lifecycle.LiveData
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.santoshlokhande.filteringmatches.data.Matches
import com.santoshlokhande.filteringmatches.db.MatchesDatabase
import com.santoshlokhande.filteringmatches.db.dao.MatchesDao

/**
 * Created by Santosh Lokhande on 27/7/2019
 *
 * This class is used to communicate with RoomDb and Network Call
 *
 * @param Context
 *
 * In init block we initialise MatchesDatabase class.
 *
 */

class MatchesRepository(application: Application) {

    private var matchesDao: MatchesDao
    private var matchesData: LiveData<List<Matches>>
    var errorString = MutableLiveData<String>()
    var selectedMatchObject = MutableLiveData<Matches>()

    init {
        val database: MatchesDatabase = MatchesDatabase.getInstance(
            application
        )!!
        matchesDao = database.albumDao()
        matchesData = matchesDao.getAllAlbumList()

    }

    fun getAllMatchesList(): LiveData<List<Matches>> {
        return matchesData
    }

    fun getAllSelectedMatches(): MutableLiveData<Matches> {
        return selectedMatchObject
    }

    fun getError(): LiveData<String> {
        return errorString
    }

    fun getSelectedMatches(id: Int) {
        return retriveSelectedMatches(id)
    }

    fun insert(matches: List<Matches>) {
        val insertAlbumListAsyncTask = InsertMatchesListAsyncTask(matchesDao).execute(matches)
    }

    fun retriveMatchesList() {


    }

    fun retriveSelectedMatches(id:Int)  {



    }


    private class InsertMatchesListAsyncTask(matchesDao: MatchesDao) : AsyncTask<List<Matches>, Unit, Unit>() {
        val matchesDao = matchesDao

        override fun doInBackground(vararg p0: List<Matches>?) {
            matchesDao.deleteAll()
            matchesDao.insert(p0[0]!!)
        }

    }

}