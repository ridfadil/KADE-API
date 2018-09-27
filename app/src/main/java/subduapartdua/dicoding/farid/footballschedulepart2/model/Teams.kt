package subduapartdua.dicoding.farid.footballschedulepart2.model

import com.google.gson.annotations.SerializedName

data class Teams(
        @SerializedName("teams")
        var team: List<TeamResponse>)
