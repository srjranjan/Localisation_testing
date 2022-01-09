package com.srj.localisationtesting

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.srj.localisationtesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        when (this.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                binding.switch1.text = getString(R.string.lightmode)
                window.statusBarColor = getColor(R.color.black)
                binding.switch1.setOnClickListener {
                    if (!binding.switch1.isChecked) AppCompatDelegate.setDefaultNightMode(
                        MODE_NIGHT_YES
                    ) else AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                }
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                binding.switch1.text = getString(R.string.darkmode)
                window.statusBarColor = getColor(R.color.purple_500)

                binding.switch1.setOnClickListener {
                    if (binding.switch1.isChecked) AppCompatDelegate.setDefaultNightMode(
                        MODE_NIGHT_NO
                    ) else AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                }
            }
        }


    }
}
