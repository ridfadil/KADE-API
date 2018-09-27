package subduapartdua.dicoding.farid.footballschedulepart2.api

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import subduapartdua.dicoding.farid.footballschedulepart2.model.FootballMatch
import subduapartdua.dicoding.farid.footballschedulepart2.model.Teams
    interface EndPointApi {

        @GET("eventspastleague.php")
        fun getLastmatch(@Query("id") id:String) : Flowable<FootballMatch>

        @GET("eventsnextleague.php")
        fun getUpcomingMatch(@Query("id") id:String) : Flowable<FootballMatch>

        @GET("lookupteam.php")
        fun getTeam(@Query("id") id:String) : Flowable<Teams>

        @GET("lookupevent.php")
        fun getEventById(@Query("id") id:String) : Flowable<FootballMatch>
}