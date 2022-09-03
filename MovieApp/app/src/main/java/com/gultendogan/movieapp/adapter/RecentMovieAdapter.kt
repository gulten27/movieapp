package com.gultendogan.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gultendogan.movieapp.R
import com.gultendogan.movieapp.di.dao.GenreData
import com.gultendogan.movieapp.models.Result
import java.util.*

class RecentMovieAdapter(private val isFirstScreen:Boolean=true): RecyclerView.Adapter<RecentMovieAdapter.MyCustomHolder>() {

    var liveData: List<Result>?=null
    var genreList: List<GenreData>?=null

    fun setList(liveData: List<Result>, genreList:List<GenreData>){
        this.liveData = liveData
        this.genreList = genreList
        notifyDataSetChanged()
    }

    class MyCustomHolder(val view: View) : RecyclerView.ViewHolder(view){

        val txtTitle = view.findViewById<TextView>(R.id.txtTitle)
        val txtGenre = view.findViewById<TextView>(R.id.txtGenre)
        val posterView = view.findViewById<ImageView>(R.id.posterView)
        val txtReleaseDate = view.findViewById<TextView>(R.id.txtReleaseDate)
        val txtVoteAverage = view.findViewById<TextView>(R.id.txtVoteAverage)

        fun bind(data: Result, genreList: List<GenreData>){
            txtTitle.text = data.title

            val lang = Locale.getDefault().language

            var genres = ""
            for (id in data.genre_ids){
                val result = genreList.find { x -> x.genre_id == id}

                if(result != null){
                    if (lang == "tr"){
                        genres += result!!.tr_name + ", "
                    }else{
                        genres += result!!.en_name + ", "
                    }
                }

            }

            genres = genres.substring(0,genres.length)
            txtGenre.text = genres

            txtReleaseDate.text = data.release_date
            txtVoteAverage.text = data.vote_average.toString() + " / 10"
            Glide.with(posterView)
                .load("https://image.tmdb.org/t/p/w342/"+data.poster_path).into(posterView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentMovieAdapter.MyCustomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recent_movie_item,parent,false)
        return MyCustomHolder(view)
    }

    override fun onBindViewHolder(holder: RecentMovieAdapter.MyCustomHolder, position: Int) {
        holder.bind(liveData!!.get(position),genreList!!)
    }

    override fun getItemCount(): Int {
        if(liveData == null){
            return 0
        }else if(isFirstScreen){
            return 4
        }else{
            return liveData!!.size
        }
    }
}