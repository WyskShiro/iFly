package will.shiro.ifly.flight.data.repository

import io.reactivex.Single
import will.shiro.ifly.flight.data.mapper.ItineraryMapper
import will.shiro.ifly.flight.data.service.FlightApiService
import will.shiro.ifly.flight.domain.entity.Itinerary
import will.shiro.ifly.flight.domain.repository.FlightRepository
import will.shiro.ifly.utils.network.ResponseHandler.handleResponse

class FlightRepositoryImpl constructor(
    private val itineraryMapper: ItineraryMapper,
    private val flightApiService: FlightApiService
) : FlightRepository {

    override fun getItineraries(): Single<List<Itinerary>> {
        return flightApiService.getItineraries()
            .handleResponse()
            .map { _apiFlight ->
                _apiFlight.itineraries?.mapNotNull { _apiItinerary ->
                    val legs = _apiFlight.legs?.filter {
                        _apiItinerary.legs?.contains(it.id) ?: false
                    } ?: listOf()
                    itineraryMapper.toDomain(_apiItinerary, legs)
                }
            }
    }
}