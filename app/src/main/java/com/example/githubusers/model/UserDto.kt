package com.example.githubusers.model

data class UserDto(
    val id: Long,
    val login: String,
    val avatar_url: String?,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
)
