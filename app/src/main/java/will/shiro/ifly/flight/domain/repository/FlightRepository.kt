package will.shiro.ifly.flight.domain.repository

import io.reactivex.Single
import will.shiro.ifly.flight.domain.entity.Itinerary

interface FlightRepository {

    fun getItineraries(): Single<List<Itinerary>>
}