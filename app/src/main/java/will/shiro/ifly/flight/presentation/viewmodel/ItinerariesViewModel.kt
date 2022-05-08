package will.shiro.ifly.flight.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import will.shiro.ifly.flight.domain.entity.Itinerary
import will.shiro.ifly.flight.domain.usecase.GetItinerariesUseCase
import will.shiro.ifly.utils.addTo
import will.shiro.ifly.utils.scheduler.SchedulerProvider

class ItinerariesViewModel constructor(
    private val schedulers: SchedulerProvider,
    private val getItinerariesUseCase: GetItinerariesUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val _itineraries = MutableLiveData<List<Itinerary>>()

    val itineraries: LiveData<List<Itinerary>> = _itineraries

    var customState: String? = null

    fun call() {
        Log.d("WILLIAM", "ViewModel called from MyObserver")
    }

    fun saveState() {
        customState = "Saved state"
    }

    fun getItineraries() {
        getItinerariesUseCase.execute()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe(::onGetItinerariesSuccess, ::onGetItinerariesError)
            .addTo(disposables)
    }

    private fun onGetItinerariesSuccess(itineraries: List<Itinerary>) {
        _itineraries.postValue(itineraries)
    }

    private fun onGetItinerariesError(throwable: Throwable) {
        Log.d(LOG, throwable.toString())
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    companion object {
        const val LOG = "FlightVM_LOG"
    }
}