package com.example.githubusers.repository


import com.example.githubusers.model.GitUsers
import com.example.githubusers.oreg.GitOreg
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersApi {
    @GET("/users")
    fun getAllUsers():Single<List<GitUsers>>
    @GET("/users/{login}")
    fun getLoginUsers(@Path("login") login:String):Single<GitUsers>
    @GET("/users/{repos_url}/repos")
    fun getRepoUsers(@Path("repos_url") repos_url:String):Single<GitUsers>
    @GET("/users/{subscriptions_url}/subscriptions")
    fun getSubscriptionsUsers(@Path("subscriptions_url") subscriptions_url:String):Single<GitUsers>
    @GET("/users/{login}/orgs")
    fun getOrganizationsUsers(@Path("organizations_url") organizations_url:String):Single<GitUsers>
    @GET("users/{name_orgs}/orgs")
    fun getInfoOrg(@Path("name_orgs")name_orgs:String ):Single<GitOreg>




}