package will.shiro.ifly.flight.data.service

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import will.shiro.ifly.flight.data.entity.ApiFlight

interface FlightApiService {

    @GET("/skyscanner-prod-takehome-test/flights.json")
    fun getItineraries(): Single<Response<ApiFlight>>
}