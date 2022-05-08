package will.shiro.ifly.flight.presentation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
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
    private val myObserver by inject<MyObserver>()
    private lateinit var registeredActivityResult: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItinerariesBinding.inflate(layoutInflater)
        lifecycle.addObserver(myObserver)
        setContentView(binding.root)
        setUpView()
        setUpObservers()
        setUpActivityResults()
        loadData()
        Log.d("WILLIAM", "ItinerariesActivity: onCreate")
        Log.d("WILLIAM", "ItinerariesActivity: savedState: ${viewModel.customState}")
    }

    private fun setUpActivityResults() {
        registeredActivityResult = registerForActivityResult(object: ActivityResultContract<String, String>() {
            override fun createIntent(context: Context, input: String?): Intent {
                return Intent(context, ResultActivity::class.java).apply {
                    putExtra("INPUT", input)
                }
            }

            override fun parseResult(resultCode: Int, intent: Intent?): String {
                return intent?.getStringExtra("EXTRA") ?: "No extra ???"
            }
        }) {
            Log.d("WILLIAM", "ItinerariesActivity: Extra: $it")
        }
    }

    private fun testingNewRegisterForActivityResult() {
        registeredActivityResult.launch("banana")
    }

    override fun onStart() {
        super.onStart()
        Log.d("WILLIAM", "ItinerariesActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("WILLIAM", "ItinerariesActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("WILLIAM", "ItinerariesActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("WILLIAM", "ItinerariesActivity: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("WILLIAM", "ItinerariesActivity: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("WILLIAM", "ItinerariesActivity: onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveState()
    }

    private fun setUpView() = binding.apply {
        itinerariesRecycler.adapter = adapter
        openResult.setOnClickListener {
            testingNewRegisterForActivityResult()
        }
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