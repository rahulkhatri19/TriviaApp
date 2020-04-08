package `in`.rahul.triviaapp.adapter

import `in`.rahul.triviaapp.R
import `in`.rahul.triviaapp.model.TriviaModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.game_layout.view.*

class GameAdapter(val context: Context, val gameList:MutableList<TriviaModel>): RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvGameId = view.tv_game
        val tvDate = view.tv_date
        val tvName = view.tv_name
        val tvCricketer = view.tv_ans_cricketer
        val tvFlag = view.tv_ans_flag
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.game_layout, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = gameList.get(position)
        holder.tvGameId.text = "Game: ${listItem.id}"
        holder.tvDate.text = listItem.date
        holder.tvName.text = listItem.name
        holder.tvCricketer.text = listItem.cricketer
        holder.tvFlag.text = listItem.flag
    }
}