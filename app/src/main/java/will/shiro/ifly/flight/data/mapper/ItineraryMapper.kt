package will.shiro.ifly.flight.data.mapper

import will.shiro.ifly.flight.data.entity.ApiItinerary
import will.shiro.ifly.flight.data.entity.ApiLeg
import will.shiro.ifly.flight.domain.entity.Itinerary
import will.shiro.ifly.flight.domain.entity.Leg
import will.shiro.ifly.utils.extensions.minsToHour

class ItineraryMapper {

    fun toDomain(apiItinerary: ApiItinerary, apiLegs: List<ApiLeg>): Itinerary? {
        if (!apiItinerary.isValid() || apiLegs.any { !it.isValid() }) return null

        val airLines = apiLegs.map {
            Leg(
                airlineId = it.airlineId ?: "",
                airlineName = it.airlineName!!,
                departureTime = it.departureTime!!.takeLast(5),
                arrivalTime = it.arrivalTime!!.takeLast(5),
                departureAirport = it.departureAirport!!,
                arrivalAirport = it.arrivalAirport!!,
                stops = it.stops!!,
                duration = it.durationMins!!.minsToHour(),
            )
        }
        return Itinerary(
            legs = airLines,
            agentUrl = apiItinerary.agent!!,
            price = apiItinerary.price!!
        )
    }

    private fun ApiItinerary.isValid(): Boolean {
        return agent != null && price != null
    }

    private fun ApiLeg.isValid(): Boolean {
        return airlineName != null
            && departureTime != null
            && arrivalTime != null
            && departureAirport != null
            && arrivalAirport != null
            && stops != null
            && durationMins != null
    }
}