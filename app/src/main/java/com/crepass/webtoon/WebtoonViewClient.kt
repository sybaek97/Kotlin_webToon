package com.crepass.webtoon

import android.graphics.Bitmap
import android.util.Log
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class WebtoonViewClient(
    private val progressBar:ProgressBar,
    private val saveData:(String)->Unit,//함수를 받겠다~ 리턴형이 없는~ 이라는 뜼


) :WebViewClient(){


    //로딩이 되기 직전에 불리는 함수
//    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
//        if(request!=null&&request.url.toString().contains("comic.naver.com"))//다른곳으로 못벗어나게 할수있음
//        return false
//        else return true //false여야 정상 작동
//    }

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        //
        Log.d("test", request?.url.toString())
        if(request != null && request.url.toString().contains("comic.naver.com/webtoon/detail")){
            saveData(request.url.toString())
        }
        //https://comic.naver.com/webtoon/detail?titleId=478261&no=89&week=thu
        //
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        progressBar.visibility=View.GONE // or isvisilty=false
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {




        super.onPageStarted(view, url, favicon)

        progressBar.visibility=View.VISIBLE
    }




}