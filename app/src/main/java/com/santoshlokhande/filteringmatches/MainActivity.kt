package com.santoshlokhande.filteringmatches

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
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

class MainActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var parentCoordinate: ConstraintLayout
    private lateinit var matchesViewModel: MatchesViewModel
    private val adapter = MatchesAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        matchesViewModel = ViewModelProviders.of(this).get(MatchesViewModel::class.java)

        initUi()

        matchesViewModel.getAllMatchesTitle().observe(this,
            Observer<List<Matches>> { t ->
                adapter.setBooks(t!!,matchesViewModel)
                progressBar.visibility=View.INVISIBLE
            })

    }

    fun initUi(){

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        progressBar = findViewById(R.id.progressBar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

            matchesViewModel.retriveMatchesList();


    }

    fun retriveSelectedAlbum(id: Int) {
        matchesViewModel.retriveSelectedAlbum(id)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }

    }
}
