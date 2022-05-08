package will.shiro.ifly.flight.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import will.shiro.ifly.BuildConfig
import will.shiro.ifly.flight.data.mapper.ItineraryMapper
import will.shiro.ifly.flight.data.mapper.LegMapper
import will.shiro.ifly.flight.data.repository.FlightRepositoryImpl
import will.shiro.ifly.flight.data.service.FlightApiService
import will.shiro.ifly.flight.domain.repository.FlightRepository
import will.shiro.ifly.flight.domain.usecase.GetItinerariesUseCase
import will.shiro.ifly.flight.presentation.ui.MyObserver
import will.shiro.ifly.flight.presentation.viewmodel.ItinerariesViewModel
import will.shiro.ifly.utils.network.NetworkService.providesRetrofit

const val API_URL = "API_URL"

object FlightModule {

    fun module() = module {
        // Data
        factory<FlightRepository> { FlightRepositoryImpl(get(), get()) }
        factory { ItineraryMapper(get()) }
        factory { LegMapper() }
        factory<FlightApiService> {
            providesRetrofit(
                get(qualifier = named(API_URL)),
                get()
            )
        }
        factory(named(API_URL)) { BuildConfig.API_URL }

        // Domain
        factory { GetItinerariesUseCase(get()) }

        // Presentation
        viewModel { ItinerariesViewModel(get(), get()) }
        single { MyObserver(get()) }
    }
}