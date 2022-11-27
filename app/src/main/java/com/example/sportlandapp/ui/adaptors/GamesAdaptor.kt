package com.example.sportlandapp.ui.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportlandapp.R
import com.example.sportlandapp.ui.models.GameModel

class GamesAdaptor(private val GamesDataSet: List<GameModel>) :
    RecyclerView.Adapter<GamesAdaptor.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val game_name = view.findViewById<TextView>(R.id.game_name)
        val game_time = view.findViewById<TextView>(R.id.game_time)
        val game_city = view.findViewById<TextView>(R.id.game_city)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item__games, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.game_name.text = GamesDataSet[position].Title
        holder.game_time.text = GamesDataSet[position].Time
        holder.game_city.text = holder.itemView.context.getString(R.string.city, GamesDataSet[position].City)
    }

    override fun getItemCount(): Int {
        return GamesDataSet.size
    }
}