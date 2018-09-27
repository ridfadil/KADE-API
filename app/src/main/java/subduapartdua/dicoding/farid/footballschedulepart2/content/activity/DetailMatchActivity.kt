package subduapartdua.dicoding.farid.footballschedulepart2.content.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail_match.*
import kotlinx.android.synthetic.main.list_item_match.*
import subduapartdua.dicoding.farid.footballschedulepart2.R
import subduapartdua.dicoding.farid.footballschedulepart2.api.EndPointApi
import subduapartdua.dicoding.farid.footballschedulepart2.api.FootballApiService
import subduapartdua.dicoding.farid.footballschedulepart2.content.view.DetailMatchView
import subduapartdua.dicoding.farid.footballschedulepart2.content.presenter.DetailPresenter
import subduapartdua.dicoding.farid.footballschedulepart2.model.EventResponse
import subduapartdua.dicoding.farid.footballschedulepart2.model.MatchFunction
import subduapartdua.dicoding.farid.footballschedulepart2.model.TeamResponse

class DetailMatchActivity : AppCompatActivity(), DetailMatchView.View {
    private var menuItem: Menu? = null
    lateinit var event: EventResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        supportActionBar?.title ="Detail Pertandingan"
        val service = FootballApiService.getClient().create(EndPointApi::class.java)
        val request = MatchFunction(service)
        mPresenter = DetailPresenter(this, request)
        event = intent.getParcelableExtra("match")
        mPresenter.getLogoHome(event.idHomeTeam)
        mPresenter.getLogoAway(event.idAwayTeam)
        initialized(event)
    }

    override fun displayLogoAway(team: TeamResponse) {
        Glide.with(applicationContext)
                .load(team.strTeamBadge)
                .apply(RequestOptions())
                .into(iv_away)
    }

    override fun displayLogoHome(team: TeamResponse) {
        Glide.with(applicationContext)
                .load(team.strTeamBadge)
                .apply(RequestOptions())
                .into(iv_home)
    }

    lateinit var mPresenter: DetailPresenter

    fun initialized(event: EventResponse) {
  /*      if (event.intHomeScore == null) {
        tv_tanggal.setTextColor(applicationContext.getColor(R.color.colorAccent))
        }*/

        tv_tanggal.text = event.dateEvent
        name_home_club.text = event.strHomeTeam
        name_away_club.text = event.strAwayTeam
        tv_score_away.text = event.intAwayScore
        tv_score_home.text = event.intHomeScore
        tv_goal_detail_home.text = event.strHomeGoalDetails
        tv_goal_detail_away.text = event.strAwayGoalDetails

        tv_goal_keeper_home.text = event.strHomeLineupGoalkeeper
        goal_keeper_away.text = event.strAwayLineupGoalkeeper

        tv_defense_home.text = event.strHomeLineupDefense
        tv_defense_away.text = event.strAwayLineupDefense

        tv_mildfild_home.text = event.strHomeLineupMidfield
        tv_mildfield_away.text = event.strAwayLineupMidfield

        tv_forward_home.text = event.strHomeLineupForward
        tv_fordward_away.text = event.strAwayLineupForward

        tv_subtitutes_home.text = event.strHomeLineupSubstitutes
        tv_subtitutes_away.text = event.strAwayLineupSubstitutes
    }
}
