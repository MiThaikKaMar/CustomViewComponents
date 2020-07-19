package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.models.NewsModelImpl
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.views.MainView
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods.EmptyViewPod
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods.ReactionViewPod

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {
    private val mNewsModel = NewsModelImpl

    override fun onTapNewsItem(newsId: Int) {
        mView?.navigateToNewsDetails(newsId)
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestAllNews(lifecycleOwner)
    }

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        requestAllNews(lifeCycleOwner)
    }

    private fun requestAllNews(lifeCycleOwner: LifecycleOwner) {
        mView?.enableSwipeRefresh()
        mNewsModel.getAllNews(onError = {
            mView?.disableSwipeRefresh()
        }).observe(lifeCycleOwner, Observer {
            mView?.disableSwipeRefresh()
            mView?.displayNewsList(it)
        })
    }

    private fun loadAllNewsFromApi(){
        mNewsModel.getAllNewsFromApiAndSaveToDatabase(
            onSuccess = {},
            onError = {}
        )
    }

    override fun onTapTryAgainButton() {
        loadAllNewsFromApi()
    }

    override fun onTapLike() {
        Log.d("Tap","Tap on Like")
    }

    override fun onTapComment() {
        Log.d("Tap","Tap on Comment")
    }

    override fun onTapShare() {
        Log.d("Tap","Tap on Share")
    }
}