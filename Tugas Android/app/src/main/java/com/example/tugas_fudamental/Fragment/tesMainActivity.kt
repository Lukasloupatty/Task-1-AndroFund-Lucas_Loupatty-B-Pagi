package com.example.tugas_fudamental.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tugas_fudamental.R
import com.example.tugas_fudamental.databinding.ActivityMainBinding
import com.example.tugas_fudamental.databinding.ActivityTesMainBinding

class tesMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTesMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTesMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {replaceFragment(BlankFragment_1())}

        binding.btn2.setOnClickListener {replaceFragment(BlankFragment2())}
    }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView5,fragment)
        fragmentTransaction.commit()
    }
}