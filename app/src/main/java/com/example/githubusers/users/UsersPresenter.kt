package com.example.githubusers.users

import android.util.Log
import com.example.githubusers.repository.GitUsersRepository
import com.example.githubusers.repository.UsersGitRepositoryImpl
import com.example.githubusers.screens.UserScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit

class UsersPresenter(
    val repo: GitUsersRepository,
    val router: Router,


    ) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
                repo.getUser()
            .delay(1000L, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.initList(it)
                viewState.hideLoading()
            }, {
                Log.e("1", it.toString())
            })
    }

    fun openInfoFragment(Info: String) {
        router.navigateTo(UserScreen.UserInfo(Info))
    }

    fun onBackPressed(): Boolean {
        router.replaceScreen(UserScreen)
        return true
    }
}