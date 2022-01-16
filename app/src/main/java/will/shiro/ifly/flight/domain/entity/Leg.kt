package will.shiro.ifly.flight.domain.entity

import will.shiro.ifly.BuildConfig

data class Leg(
    val airlineId: String,
    val airlineName: String,
    val departureTime: String,
    val arrivalTime: String,
    val departureAirport: String,
    val arrivalAirport: String,
    val stops: Int,
    val duration: String
) {

    val airlineLogoUrl: String
        get() = "${BuildConfig.API_URL_LOGO}${airlineId}.png"
}