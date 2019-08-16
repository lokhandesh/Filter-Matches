package com.santoshlokhande.filteringmatches.adapter

import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.santoshlokhande.filteringmatches.R
import com.santoshlokhande.filteringmatches.data.Matches
import com.santoshlokhande.filteringmatches.databinding.AlbumItemBinding
import kotlinx.android.synthetic.main.album_item.view.*
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

        val inflator = LayoutInflater.from(parent.context)
        val binding = AlbumItemBinding.inflate(inflator, parent, false)

        return MatchesHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchesHolder, position: Int) = holder.bind(matchesList[position])

    override fun getItemCount(): Int = matchesList.size

    fun setBooks(
        list: List<Matches>, position: Int
    ) {
        when (position) {
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

    class MatchesHolder(val binding : AlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Matches) {

            binding.matches = item
            binding.executePendingBindings()


            /*with(itemView) {

                text_view_title.text = item.display_name
                jobTitle.text = item.job_title
                age.text = item.age.toString()
                heightt.text = item.height_in_cm.toString()
                score.text = item.compatibility_score.toString()
                isFavorite.text = item.favourite.toString()
                relegion.text = item.religion

            }*/
        }

    }

}




