package subduapartdua.dicoding.farid.footballschedulepart2.content.view

import subduapartdua.dicoding.farid.footballschedulepart2.model.TeamResponse

interface DetailMatchView {

    interface Presenter {
        fun getLogoAway(id: String)
        fun getLogoHome(id: String)
    }

    interface View {
        fun displayLogoHome(teamResponse: TeamResponse)
        fun displayLogoAway(teamResponse: TeamResponse)
    }
}