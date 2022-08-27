package com.example.githubusers.repository

import com.example.githubusers.model.GitUsers
import com.example.githubusers.model.UserDto
import io.reactivex.rxjava3.core.Single

interface GitUsersRepository {
    fun getUser():Single<List<UserDto>>
    fun getLoginUser(login:String):Single<UserDto>
    fun getRepoUser(repo:String):Single<UserDto>
    fun getSubUser(subscriptions:String):Single<UserDto>
    fun getOrgsUser(organizations:String):Single<UserDto>
}