package com.example.jikanskotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jikanskotlin.R
import dagger.hilt.android.AndroidEntryPoint
import com.google.android.material.bottomnavigation.BottomNavigationView

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BottomNavigationView.OnNavigationItemSelectedListener{
            when(it.itemId){

                R.id.manga_menu->{

                    true
                }
                R.id.favorites_menu->{

                    true
                }
                R.id.search_menu->{
                    true

                }
                else -> false
            }

        }

    }






}