package com.example.githubusers.usersinfo

import com.example.githubusers.model.UserDto
import com.example.githubusers.oreg.OregDto
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersInfoView:MvpView {
    fun showLoading()
    fun hideLoading()
    fun show(user:UserDto)


}