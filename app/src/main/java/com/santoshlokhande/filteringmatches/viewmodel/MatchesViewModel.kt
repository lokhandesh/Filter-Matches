package com.santoshlokhande.filteringmatches.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.santoshlokhande.filteringmatches.data.Matches
import com.santoshlokhande.filteringmatches.repository.MatchesRepository

/**
 * Created by Santosh Lokhande on 04/08/2019
 *
 * MatchesViewModel which is extended from AndroidViewModel.
 *
 * Here we received all albumlist from RoomDb.
 *
 */


class MatchesViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: MatchesRepository = MatchesRepository(application)

    public var matchesList: LiveData<List<Matches>> = repository.getAllMatchesList()

    public var selectedMatchesList: MutableLiveData<Matches> = repository.getAllSelectedMatches()


    fun getAllMatchesTitle(): LiveData<List<Matches>> {
        return matchesList
    }

    fun getSelectedAlbum(): MutableLiveData<Matches> {
        return selectedMatchesList
    }

    fun retriveMatchesList() {
        repository.retriveMatchesList()
    }

    fun retriveError() : LiveData<String>{
        return repository.getError()
    }

    fun retriveSelectedAlbum(id:Int) {
        return repository.getSelectedMatches(id)
    }


}