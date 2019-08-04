package com.santoshlokhande.filteringmatches.adapter

import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.santoshlokhande.filteringmatches.MainActivity
import com.santoshlokhande.filteringmatches.R
import com.santoshlokhande.filteringmatches.data.Matches
import com.santoshlokhande.filteringmatches.viewmodel.MatchesViewModel
import kotlin.collections.ArrayList


/**
 * Created by Santosh Lokhande on 27/7/2019
 *
 * This class is used to display item of Matches.
 *
 * @param Context
 *
 * Here we used ViewHolder design pattern
 *
 */

class MatchesAdapter(val applicationContext: Context) : RecyclerView.Adapter<MatchesAdapter.MatchesHolder>() {

    private var matchesList: List<Matches> = ArrayList()
    private lateinit var selectedMatchesModel: MatchesViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_item, parent, false)

        return MatchesHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchesHolder, position: Int) {

        val currentAlbum = matchesList[position]
        holder.textViewTitle.text = currentAlbum.title


        holder.textViewTitle.setOnClickListener {

            /*var intent = Intent(applicationContext, AlbumDetailActivity::class.java)
            intent.putExtra("ALBUM_DATA", currentAlbum.title)
            applicationContext.startActivity(intent)*/

            (applicationContext as MainActivity).retriveSelectedAlbum(currentAlbum.id)

            //Need to call API
            //  selectedMatchesModel.retriveSelectedAlbumList(currentAlbum.id)

        }


    }

    override fun getItemCount(): Int {
        return matchesList.size
    }

    fun setBooks(
        list: List<Matches>,
        matchesViewModel: MatchesViewModel
    ) {
        this.matchesList = list.sortedBy { list -> list.title }
        this.selectedMatchesModel = matchesViewModel
        notifyDataSetChanged()
    }

    class MatchesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewTitle: TextView = itemView.findViewById(R.id.text_view_title)

    }

}
