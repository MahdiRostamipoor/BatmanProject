package com.mahdi.rostamipoor.batmanproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mahdi.rostamipoor.batmanproject.R
import com.mahdi.rostamipoor.batmanproject.model.MoviesModel
import com.mahdi.rostamipoor.batmanproject.model.Search
import com.squareup.picasso.Picasso

class MoviesAdapter (val models : MoviesModel , val onclickItem : OnClickItems) : Adapter<MoviesAdapter.Holder>(){

    class Holder(itemView : View) : ViewHolder(itemView){

        val title_movie = itemView.findViewById<TextView>(R.id.title_movie)
        val type_movie = itemView.findViewById<TextView>(R.id.type_movie)
        val year_movie = itemView.findViewById<TextView>(R.id.year_movie)
        val image_moview = itemView.findViewById<ImageView>(R.id.image_moview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.layout_movie,parent,false))
    }

    override fun getItemCount(): Int {
        return models.Search.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val model = models.Search.get(position)

        Picasso.get().load(model.Poster).into(holder.image_moview)

        holder.type_movie.text = "type : ${model.Type}"
        holder.year_movie.text = "year : ${model.Year}"
        holder.title_movie.text = model.Title

        holder.itemView.setOnClickListener{
            onclickItem.onClick(model)
        }

    }

    interface OnClickItems{

        fun onClick(model : Search)

    }

}