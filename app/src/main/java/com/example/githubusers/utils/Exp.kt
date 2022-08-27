package com.example.githubusers.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.githubusers.R

fun ImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_baseline_supervised_user_circle_24)
        .into(this)
}