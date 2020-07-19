package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_pod_empty.view.*

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var mDelegate : Delegate

    override fun onFinishInflate() {
        super.onFinishInflate()

        setUpListener()
    }

    fun setDelegate(delegate : Delegate){
        mDelegate=delegate
    }

    fun setEmptyData(emptyMessage : String, emptyImageUrl: String){
        tvEmpty.text = emptyMessage

        Glide.with(context)
            .load(emptyImageUrl)
            .into(ivEmptyImage)
    }

    private fun setUpListener(){
        btn_try_again.setOnClickListener {
            mDelegate.onTapTryAgainButton()
        }
    }

    interface Delegate{
        fun onTapTryAgainButton()
    }


}