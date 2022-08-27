package com.example.githubusers.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitUsers(
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("login")
    val login: String,
    @Expose
    @SerializedName("avatar_url")
    val avatar_url: String?,
    @Expose
    @SerializedName("subscriptions_url")
    val subscriptions_url: String,
    @Expose
    @SerializedName("organizations_url")
    val organizations_url: String,
    @Expose
    @SerializedName("repos_url")
    val repos_url: String,
) : Parcelable

