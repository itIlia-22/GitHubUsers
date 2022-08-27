package com.example.githubusers.users

import com.example.githubusers.model.UserDto
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView:MvpView {
    fun showLoading()
    fun hideLoading()
    fun show(user:UserDto)
}