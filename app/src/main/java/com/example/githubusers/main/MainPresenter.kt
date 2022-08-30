package com.example.githubusers.main

import com.example.githubusers.screens.UserScreen
import com.example.githubusers.view.UserInfoFragment
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(
    val router: Router,


    ) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UserScreen)




    }

    fun onBackPressed() {
        router.exit()
    }
}


