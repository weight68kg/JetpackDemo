package com.weight68kg.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Hello world!")
        }
//        setContentView(R.layout.activity_main)
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//
//
//        bnv.setOnNavigationItemSelectedListener(object :
//            BottomNavigationView.OnNavigationItemSelectedListener {
//            override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                when (item.getItemId()) {
//                    R.id.action_home -> {
//                        navController.navigate(R.id.homeFragment)
//                    }
//                    R.id.action_list -> {
//                        navController.navigate(R.id.listFragment)
//                    }
//                    R.id.action_person -> {
//                        navController.navigate(R.id.personFragment)
//                    }
//                }
//                // 默认 false
//                // false 的话 下面颜色不会变化
//                return true;
//
//            }
//        })
//
//        bnv.setOnNavigationItemReselectedListener(
//            object :
//                BottomNavigationView.OnNavigationItemReselectedListener {
//                override fun onNavigationItemReselected(item: MenuItem) {
//                }
//
//            })
    }
}