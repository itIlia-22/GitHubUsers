package com.example.githubusers.oreg

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitOreg(
    @Expose
    @SerializedName("avatar_url")
    val avatar_url: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("login")
    val login: String,
    @Expose
    @SerializedName("node_id")
    val node_id: String,
    @Expose
    @SerializedName("repos_url")
    val repos_url: String,
):Parcelable