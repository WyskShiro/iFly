package will.shiro.ifly.flight.data.entity

import com.google.gson.annotations.SerializedName

data class ApiFlight(
    @SerializedName("itineraries") val itineraries: List<ApiItinerary>? = null,
    @SerializedName("legs") val legs: List<ApiLeg>? = null
)