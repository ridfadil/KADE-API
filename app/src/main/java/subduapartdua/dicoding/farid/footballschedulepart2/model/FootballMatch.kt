package subduapartdua.dicoding.farid.footballschedulepart2.model


import com.google.gson.annotations.SerializedName

data class FootballMatch (
        @SerializedName("events") var eventResponses: List<EventResponse>)
