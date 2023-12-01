package com.crepass.webtoon

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.crepass.webtoon.databinding.ActivityMainBinding
import com.crepass.webtoon.databinding.FragmentWebviewBinding

class WebViewFragment(private val position: Int,private val site:String): Fragment() {

    var listener:OnTabLayoutNameChanged?=null

    private lateinit var binding: FragmentWebviewBinding
    companion object{//스테틱으로 선언 해주는거~
       const val SHARED_PREFERENCE="WEB_HISTORY"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("messss","온크리에이티브")
       binding= FragmentWebviewBinding.inflate(inflater)
        return binding.root//실제로 그려질 view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {//뷰가 생성된 다음에 나오는 생명주기
        super.onViewCreated(view, savedInstanceState)
        binding.WebView.webViewClient= WebtoonViewClient(binding.progressBar){url->
            activity?.getSharedPreferences(SHARED_PREFERENCE,Context.MODE_PRIVATE)?.edit{
                putString("tab$position",url)
            }

        } //두개의 권한을 줘서 필수적으로 만들어야됨
        binding.WebView.settings.javaScriptEnabled=true//자바 스크립트를 사용함으로써 우리가 의도하지 않은 값도 조작할 수 있다.

        binding.WebView.loadUrl(site)
        binding.backToLastButton.setOnClickListener {
            //fragment는 get쉐어드가 안됨
            val shared=activity?.getSharedPreferences(SHARED_PREFERENCE,Context.MODE_PRIVATE)
            val url=shared?.getString("tab$position","")

            if(url.isNullOrEmpty()) Toast.makeText(context,"마지막 저장 시점이 없습니다", Toast.LENGTH_SHORT).show() else binding.WebView.loadUrl(url)

        }

        binding.ChangeTabNameButton.setOnClickListener {
            val dialog=AlertDialog.Builder(context)
            val editText=EditText(context)

            dialog.setView(editText)
            dialog.setPositiveButton("저장"){_,_->
                //TODO 저장기능
                activity?.getSharedPreferences(SHARED_PREFERENCE,Context.MODE_PRIVATE)?.edit {
                    putString("tab${position}_name",editText.text.toString())
                    listener?.nameChanged(position,editText.text.toString())
                }
            }
            dialog.setNegativeButton("취소"){dialogInterface,_->
                dialogInterface.cancel()
            }
            dialog.show()
        }
    }
    fun canGoBack():Boolean{
        return binding.WebView.canGoBack()
    }
    fun goBack() {
        return binding.WebView.goBack()
    }
}


interface OnTabLayoutNameChanged{
    fun nameChanged(position:Int,name:String)
}