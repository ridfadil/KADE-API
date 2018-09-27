package subduapartdua.dicoding.farid.footballschedulepart2.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_match.view.*
import org.jetbrains.anko.AnkoLogger
import subduapartdua.dicoding.farid.footballschedulepart2.R
import subduapartdua.dicoding.farid.footballschedulepart2.content.activity.DetailMatchActivity
import subduapartdua.dicoding.farid.footballschedulepart2.model.EventResponse

class MatchAdapter(val listEventResponse: List<EventResponse>, val context: Context?) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>(), AnkoLogger {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_match, parent, false))
    }

    override fun getItemCount(): Int = listEventResponse.size


    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(listEventResponse[position])

    }

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(eventResponse: EventResponse) {

            itemView.tv_tgl_pertandingan.text = eventResponse.dateEvent
            itemView.tv_home_name_club.text = eventResponse.strHomeTeam
            itemView.tv_home_score.text = eventResponse.intHomeScore
            itemView.tv_away_name_club.text = eventResponse.strAwayTeam
            itemView.tv_away_score.text = eventResponse.intAwayScore

            itemView.setOnClickListener {
                val intent = Intent(context, DetailMatchActivity::class.java)
                intent.putExtra("match", eventResponse)
                itemView.context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            }
        }
    }

}
