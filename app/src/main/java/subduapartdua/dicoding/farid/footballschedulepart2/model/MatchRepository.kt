package subduapartdua.dicoding.farid.footballschedulepart2.model

import io.reactivex.Flowable

interface MatchRepository {

    fun getMatchFootball(id : String) : Flowable<FootballMatch>

    fun getTeams(id : String = "0") : Flowable<Teams>

    fun getUpcomingMatch(id : String) : Flowable<FootballMatch>

    fun getEventById(id: String) : Flowable<FootballMatch>
}