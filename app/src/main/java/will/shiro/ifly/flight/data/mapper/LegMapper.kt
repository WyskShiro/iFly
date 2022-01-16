package will.shiro.ifly.flight.data.mapper

import will.shiro.ifly.flight.data.entity.ApiLeg
import will.shiro.ifly.flight.domain.entity.Leg
import will.shiro.ifly.utils.extensions.minsToHour

private const val TIME_SIZE = 5

class LegMapper {

    fun toDomain(apiLeg: ApiLeg): Leg? = with(apiLeg) {
        if (!apiLeg.isValid()) return null

        return Leg(
            airlineId = airlineId ?: "",
            airlineName = airlineName!!,
            departureTime = departureTime!!.takeLast(TIME_SIZE),
            arrivalTime = arrivalTime!!.takeLast(TIME_SIZE),
            departureAirport = departureAirport!!,
            arrivalAirport = arrivalAirport!!,
            stops = stops!!,
            duration = durationMins!!.minsToHour()
        )
    }
}

fun ApiLeg.isValid(): Boolean {
    return airlineName != null
        && departureTime != null
        && arrivalTime != null
        && departureAirport != null
        && arrivalAirport != null
        && stops != null
        && durationMins != null
}