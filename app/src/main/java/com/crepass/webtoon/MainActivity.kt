package com.crepass.webtoon

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import com.crepass.webtoon.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), OnTabLayoutNameChanged {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shared=getSharedPreferences(WebViewFragment.Companion.SHARED_PREFERENCE,Context.MODE_PRIVATE)

        val tab0=shared?.getString("tab0_name","월요 웹툰")
        val tab1=shared?.getString("tab1_name","화요 웹툰")
        val tab2=shared?.getString("tab2_name","수요 웹툰")

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter=ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout , binding.viewPager){ tab , position ->
            run{
//                val textView=TextView(this@MainActivity)
//                textView.text="position $position"
//                textView.gravity=Gravity.CENTER
//                tab.customView=textView

                tab.text=when(position){
                    0->tab0
                    1->tab1
                    else->tab2
                }


            }
        }.attach()
    }

    override fun onBackPressed() {

        val currentFragment=supportFragmentManager.fragments[binding.viewPager.currentItem]
        if(currentFragment is WebViewFragment){
            if(currentFragment.canGoBack()){
                currentFragment.goBack()
            }else{
                super.onBackPressed()
            }
        }
    }

    override fun nameChanged(position: Int, name: String) {
        val tab=binding.tabLayout.getTabAt(position)
        tab?.text=name
    }
}