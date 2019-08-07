package com.santoshlokhande.filteringmatches

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santoshlokhande.filteringmatches.adapter.MatchesAdapter
import com.santoshlokhande.filteringmatches.data.Matches
import com.santoshlokhande.filteringmatches.viewmodel.MatchesViewModel

import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Santosh Lokhande on 05/8/2019
 *
 * This is Activity where use can see Matches List
 *
 * Here we used recycler view and MatchesAdapter.
 *
 */

class MainActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var parentCoordinate: ConstraintLayout
    private lateinit var matchesViewModel: MatchesViewModel
    private val adapter = MatchesAdapter(this)
    private var matchesList: List<Matches> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        matchesViewModel = ViewModelProviders.of(this).get(MatchesViewModel::class.java)

        initUi()

        matchesViewModel.getAllMatches(this).observe(this,
            Observer<List<Matches>> { t ->
                adapter.setBooks(t!!,0)
                this.matchesList = t
                progressBar.visibility=View.INVISIBLE
            })

    }

    fun initUi(){

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        progressBar = findViewById(R.id.progressBar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        matchesViewModel.retriveMatchesList(this);

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.all_matches ->  {sortList(0) ; return true }
            R.id.action_favorite_yes -> {sortList(1) ; return true }
            R.id.action_favorite_no -> {sortList(2) ; return true }
            R.id.age_40 -> {sortList(3) ; return true }
            R.id.age_greaterthan_40 -> {sortList(4) ; return true }
            R.id.religion_christian -> {sortList(5) ; return true }
            R.id.religiona_atheist -> {sortList(6) ; return true }
            else -> super.onOptionsItemSelected(item)
        }

    }

    fun sortList(pos:Int){
        adapter.setBooks(matchesList,pos)
    }

}