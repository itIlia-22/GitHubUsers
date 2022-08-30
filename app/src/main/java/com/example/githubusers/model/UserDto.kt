package com.example.githubusers.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDto(
    val id: Long,
    val login: String,
    val avatar_url: String?,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
):Parcelable
