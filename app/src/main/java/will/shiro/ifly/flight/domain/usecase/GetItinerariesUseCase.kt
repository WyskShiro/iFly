package will.shiro.ifly.flight.domain.usecase

import io.reactivex.Single
import will.shiro.ifly.flight.domain.entity.Itinerary
import will.shiro.ifly.flight.domain.repository.FlightRepository

class GetItinerariesUseCase constructor(
    private val flightRepository: FlightRepository
) {

    fun execute(): Single<List<Itinerary>> {
        return flightRepository.getItineraries()
    }
}