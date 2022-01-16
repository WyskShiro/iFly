package will.shiro.ifly.flight.data.mapper

import will.shiro.ifly.flight.data.entity.ApiItinerary
import will.shiro.ifly.flight.data.entity.ApiLeg
import will.shiro.ifly.flight.domain.entity.Itinerary

class ItineraryMapper constructor(
    private val legMapper: LegMapper
) {

    fun toDomain(apiItinerary: ApiItinerary, apiLegs: List<ApiLeg>): Itinerary? {
        if (!apiItinerary.isValid() || apiLegs.any { !it.isValid() }) return null

        val airLines = apiLegs.mapNotNull {
            legMapper.toDomain(it)
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
}