package will.shiro.ifly.flight.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import will.shiro.ifly.databinding.ActivityItinerariesBinding
import will.shiro.ifly.flight.presentation.ui.adapter.ItinerariesAdapter
import will.shiro.ifly.flight.presentation.viewmodel.ItinerariesViewModel

class ItinerariesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItinerariesBinding
    private val adapter by lazy {
        ItinerariesAdapter()
    }
    private val viewModel by viewModel<ItinerariesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItinerariesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
        setUpObservers()
        loadData()
    }

    private fun setUpView() = binding.apply {
        itinerariesRecycler.adapter = adapter
    }

    private fun setUpObservers() {
        viewModel.itineraries.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun loadData() {
        viewModel.getItineraries()
    }
}