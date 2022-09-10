package com.example.githubusers.usersdetails

import com.example.githubusers.oreg.OregDto
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersDetailsView:MvpView {
    fun showLoading()
    fun hideLoading()
    fun show(user: OregDto)

}