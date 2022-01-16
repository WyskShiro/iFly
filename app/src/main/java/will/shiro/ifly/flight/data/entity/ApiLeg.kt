package will.shiro.ifly.flight.data.entity

import com.google.gson.annotations.SerializedName

data class ApiLeg(
    @SerializedName("id") val id: String? = null,
    @SerializedName("departure_airport") val departureAirport: String? = null,
    @SerializedName("arrival_airport") val arrivalAirport: String? = null,
    @SerializedName("departure_time") val departureTime: String? = null,
    @SerializedName("arrival_time") val arrivalTime: String? = null,
    @SerializedName("stops") val stops: Int? = null,
    @SerializedName("airline_name") val airlineName: String? = null,
    @SerializedName("airline_id") val airlineId: String? = null,
    @SerializedName("duration_mins") val durationMins: Int? = null
)