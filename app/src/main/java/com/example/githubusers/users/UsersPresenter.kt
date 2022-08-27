package com.example.githubusers.users

import com.example.githubusers.repository.UsersGitRepositoryImpl
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    val repo: UsersGitRepositoryImpl,
    val router: Router

    ) : MvpPresenter<UsersView>() {
}