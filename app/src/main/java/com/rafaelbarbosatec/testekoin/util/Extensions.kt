package com.rafaelbarbosatec.testekoin.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions

/**
 * Created by rafael on 23/10/18.
 */
fun ImageView.loadFromUrl(url:String){
//    val cropOptions = RequestOptions().centerCrop(this)
    Glide.with(this)
            .load(url)
            .transition(withCrossFade())
            .into(this)
}

fun ImageView.loadCircleFromUrl(url:String){
    Glide.with(this)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .transition(withCrossFade())
            .into(this)
}