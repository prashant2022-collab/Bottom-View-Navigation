package com.example.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigationview.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val firstfragment = FirstFragment()
        val secondfragment = SecondFragment()
        val thirdfragment = ThirdFragment()

        setcurrentFragment(firstfragment)
        binding.bottomnavigationview.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mihome ->setcurrentFragment(firstfragment)
                R.id.mimessage->setcurrentFragment(secondfragment)
                R.id.miprofile -> setcurrentFragment(thirdfragment)
            }
            true
        }

        binding.bottomnavigationview.getOrCreateBadge(R.id.mimessage).apply {
            number = 10
            isVisible = true
        }

    }

    private fun setcurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment,fragment)
            commit()
        }
}
