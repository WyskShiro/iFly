package will.shiro.ifly.flight.data.entity

import com.google.gson.annotations.SerializedName

data class ApiItinerary(
    @SerializedName("id") val id: String? = null,
    @SerializedName("legs") val legs: List<String>? = null,
    @SerializedName("price") val price: String? = null,
    @SerializedName("agent") val agent: String? = null,
    @SerializedName("agent_rating") val agentRating: Float? = null
)