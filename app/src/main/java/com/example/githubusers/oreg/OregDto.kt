package com.example.githubusers.oreg

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OregDto(
    val avatar_url: String,
    val description: String,
    val id: Long,
    val login: String,
    val node_id: String,
    val repos_url: String,

):Parcelable