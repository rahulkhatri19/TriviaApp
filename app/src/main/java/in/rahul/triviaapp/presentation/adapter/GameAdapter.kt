package `in`.rahul.triviaapp.presentation.adapter

import `in`.rahul.triviaapp.R
import `in`.rahul.triviaapp.core.domain.TriviaModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.game_layout.view.*

class GameAdapter(var gameList: List<TriviaModel>): RecyclerView.Adapter<GameAdapter.ViewHolder>() {

//   private var gameList: MutableList<TriviaModel> = mutableListOf()
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvGameId = view.tv_game
        val tvDate = view.tv_date
        val tvName = view.tv_name
        val tvCricketer = view.tv_ans_cricketer
        val tvFlag = view.tv_ans_flag
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_layout, parent,false)
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

//    fun setGameList(gameDataList: MutableList<TriviaModel>){
//        gameList = gameDataList
//    }
}