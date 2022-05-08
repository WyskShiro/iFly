package will.shiro.ifly.flight.presentation.ui

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import will.shiro.ifly.flight.presentation.viewmodel.ItinerariesViewModel

class MyObserver constructor(
    private val viewModel: ItinerariesViewModel
): DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        Log.d("WILLIAM", "MyObserver: onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d("WILLIAM", "MyObserver: onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d("WILLIAM", "MyObserver: onResume")
        viewModel.call()
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d("WILLIAM", "MyObserver: onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d("WILLIAM", "MyObserver: onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d("WILLIAM", "MyObserver: onDestroy")
    }
}