package subduapartdua.dicoding.farid.footballschedulepart2.model

import io.reactivex.Flowable
import subduapartdua.dicoding.farid.footballschedulepart2.api.EndPointApi

class MatchFunction(private val footballRest: EndPointApi) : MatchRepository {

    override fun getEventById(id: String): Flowable<FootballMatch> = footballRest.getEventById(id)

    override fun getUpcomingMatch(id: String): Flowable<FootballMatch> = footballRest.getUpcomingMatch(id)

    override fun getMatchFootball(id: String): Flowable<FootballMatch> = footballRest.getLastmatch(id)

    override fun getTeams(id: String): Flowable<Teams> = footballRest.getTeam(id)
}