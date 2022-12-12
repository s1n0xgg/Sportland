package com.example.sportlandapp.ui.adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.sportlandapp.R
import com.example.sportlandapp.ui.models.GameModel

class GamesAdaptor(private val GamesDataSet: List<GameModel>, private val ClickListener: (GameModel) -> Unit) :
    RecyclerView.Adapter<GamesAdaptor.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val game_name = view.findViewById<TextView>(R.id.game_name)
        val game_time = view.findViewById<TextView>(R.id.game_time)
        val game_city = view.findViewById<TextView>(R.id.game_city)
        val location_text = view.findViewById<TextView>(R.id.location_text)
        val number_text = view.findViewById<TextView>(R.id.number_text)
        val join_button = view.findViewById<TextView>(R.id.join_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item__games, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.game_name.text = GamesDataSet[position].Title
        holder.game_time.text = GamesDataSet[position].Time
        holder.game_city.text = holder.itemView.context.getString(R.string.city, GamesDataSet[position].City)
        holder.location_text.text = holder.itemView.context.getString(R.string.location, GamesDataSet[position].Space)
        holder.number_text.text = holder.itemView.context.getString(R.string.number, GamesDataSet[position].MinPlayers, GamesDataSet[position].MaxPlayers)
        holder.join_button.setOnClickListener{
            ClickListener(GamesDataSet[position])
            holder.join_button.isEnabled = false
            Toast.makeText(
                holder.itemView.context, "Вы успешно присоединились к игре!", Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return GamesDataSet.size
    }
}