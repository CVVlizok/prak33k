package com.example.prak33k

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prak33k.R
import com.example.prak33k.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            // Загружаем Fragment1 при запуске
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Fragment1())
                .commit()
        }
    }

    fun navigateToFragment2() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Fragment2())
            .addToBackStack(null)  // Добавляем в стек для возможности возврата
            .commit()
    }

    fun navigateToFragment3() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Fragment3())
            .addToBackStack(null)
            .commit()
    }

    fun goBack() {
        supportFragmentManager.popBackStack()
    }
}
