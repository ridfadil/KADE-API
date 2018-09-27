package subduapartdua.dicoding.farid.footballschedulepart2.content.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_prev_match.*
import subduapartdua.dicoding.farid.footballschedulepart2.R
import subduapartdua.dicoding.farid.footballschedulepart2.adapter.MatchAdapter
import subduapartdua.dicoding.farid.footballschedulepart2.api.EndPointApi
import subduapartdua.dicoding.farid.footballschedulepart2.api.FootballApiService
import subduapartdua.dicoding.farid.footballschedulepart2.content.presenter.MatchPresenter
import subduapartdua.dicoding.farid.footballschedulepart2.content.view.MatchView
import subduapartdua.dicoding.farid.footballschedulepart2.model.EventResponse
import subduapartdua.dicoding.farid.footballschedulepart2.model.MatchFunction
import subduapartdua.dicoding.farid.footballschedulepart2.utils.AppSchedulerProvider

class PrevMatchActivity : AppCompatActivity(), MatchView.View {

    lateinit var presenterMatch : MatchPresenter

    private var listPrevMatch : MutableList<EventResponse> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prev_match)
        val serviceClient = FootballApiService.getClient()
                            .create(EndPointApi::class.java)
        val requestAPI = MatchFunction(serviceClient)
        val scheduler = AppSchedulerProvider()

        presenterMatch = MatchPresenter(this, requestAPI, scheduler)
        presenterMatch.getMatchFootball()
    }

    override fun displayMatchFootball(matchList: List<EventResponse>) {
        //initialized()
        listPrevMatch.clear()
        listPrevMatch.addAll(matchList)
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rv_prev_match.layoutManager = layoutManager
        rv_prev_match.adapter = MatchAdapter(matchList,applicationContext)
    }
}
