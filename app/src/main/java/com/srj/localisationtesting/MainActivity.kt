package com.srj.localisationtesting

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.srj.localisationtesting.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        when (this.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {

                binding.btnThemeChange.setImageResource(R.drawable.ic_sun_warm)
                window.statusBarColor = getColor(R.color.black)
                binding.btnThemeChange.setOnClickListener {
                    AppCompatDelegate.setDefaultNightMode(
                        MODE_NIGHT_NO
                    )
                    binding.btnThemeChange.setImageResource(R.drawable.ic_night)
                }
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                binding.btnThemeChange.setImageResource(R.drawable.ic_night)
                window.statusBarColor = getColor(R.color.purple_500)

                binding.btnThemeChange.setOnClickListener {
                    AppCompatDelegate.setDefaultNightMode(
                        MODE_NIGHT_YES
                    )
                    binding.btnThemeChange.setImageResource(R.drawable.ic_sun_warm)
                }
            }
        }

        binding.button.setOnClickListener {
            changeLang(this, "hi")
            this.finish()

        }
        binding.button2.setOnClickListener {
            changeLang(this, "bn")
            this.finish()

        }
        binding.button3.setOnClickListener {
            changeLang(this, "pa")
            this.finish()

        }
    }

    private fun changeLang(context: Context, lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val dm = resources.displayMetrics
        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration, dm)

        startActivity(Intent(this, MainActivity::class.java))

    }


}
