package will.shiro.ifly.flight.presentation.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import will.shiro.ifly.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private val input by lazy {
        intent.getStringExtra("INPUT")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.goBack.setOnClickListener {
             setResult(Activity.RESULT_OK, Intent().apply {
                 putExtra("EXTRA", "Data received to second screen: $input")
             })
            finish()
        }
    }
}

