package com.example.mainproject.presentation


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mainproject.R
import com.example.mainproject.presentation.checkList.CheckListFragment
import com.example.mainproject.presentation.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, CheckListFragment()).commit()

        navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.main -> supportFragmentManager.beginTransaction().replace(R.id.container, CheckListFragment()).commit()
                R.id.profile -> supportFragmentManager.beginTransaction().replace(R.id.container, ProfileFragment()).commit()
            }
            true
        }
    }
}