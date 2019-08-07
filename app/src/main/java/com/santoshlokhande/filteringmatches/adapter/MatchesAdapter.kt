package com.santoshlokhande.filteringmatches.adapter

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.santoshlokhande.filteringmatches.MainActivity
import com.santoshlokhande.filteringmatches.R
import com.santoshlokhande.filteringmatches.data.Matches
import com.santoshlokhande.filteringmatches.viewmodel.MatchesViewModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_item1.view.*
import java.lang.Exception
import kotlin.collections.ArrayList


/**
 * Created by Santosh Lokhande on 05/8/2019
 *
 * This class is used to display item of Matches.
 *
 * @param View
 *
 * Here we used ViewHolder design pattern
 *
 */

class MatchesAdapter(val applicationContext: Context) : RecyclerView.Adapter<MatchesAdapter.MatchesHolder>() {

    private var matchesList: List<Matches> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_item1, parent, false)

        return MatchesHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchesHolder, position: Int) {

        val currentMatches = matchesList[position]
        holder.textViewTitle.text = currentMatches.display_name
        holder.jobTitle.text = currentMatches.job_title
        holder.age.text = "Age :- "+currentMatches.age.toString()
        holder.height.text = "Height :- "+currentMatches.height_in_cm
        holder.isFavorite.text = "Favourite:- "+currentMatches.favourite.toString()
        holder.relegion.text = currentMatches.religion
        holder.score.text = currentMatches.compatibility_score.toString()

    }

    override fun getItemCount(): Int {
        return matchesList.size
    }

    fun setBooks(
        list: List<Matches>,position: Int
    ) {
        when (position){
            0 -> this.matchesList = list.sortedBy { list -> list.display_name }
            1 -> this.matchesList = list.filter { list -> list.favourite == true }
            2 -> this.matchesList = list.filter { list -> list.favourite == false }
            3 -> this.matchesList = list.filter { list -> list.age <= 40 }
            4 -> this.matchesList = list.filter { list -> list.age > 40 }
            5 -> this.matchesList = list.filter { list -> list.religion.equals("Christian") }
            6 -> this.matchesList = list.filter { list -> list.religion.equals("Atheist") }

        }
        notifyDataSetChanged()
    }

    class MatchesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewTitle: TextView = itemView.findViewById(R.id.text_view_title)
      //  var imageView: ImageView = itemView.findViewById(R.id.imageView)
        var jobTitle: TextView = itemView.findViewById(R.id.jobTitle)
        var age: TextView = itemView.findViewById(R.id.age)
        var height: TextView = itemView.findViewById(R.id.height)
        var score: TextView = itemView.findViewById(R.id.score)
        var isFavorite: TextView = itemView.findViewById(R.id.isFavorite)
        var relegion: TextView = itemView.findViewById(R.id.relegion)



    }

}




