package subduapartdua.dicoding.farid.footballschedulepart2.content.view

import subduapartdua.dicoding.farid.footballschedulepart2.model.EventResponse

interface MatchView {
    interface View {
        fun displayMatchFootball(matchList: List<EventResponse>)
    }

    interface Presenter {
        fun getMatchFootball()
    }
}