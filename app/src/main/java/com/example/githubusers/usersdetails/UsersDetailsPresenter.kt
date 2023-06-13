package com.example.githubusers.usersdetails

import com.example.githubusers.repository.GitUsersRepository
import com.example.githubusers.screens.UserScreen
import com.example.githubusers.utils.disposeBy
import com.example.githubusers.utils.subscribeByDefault
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersDetailsPresenter(
    private val repo: GitUsersRepository,
    private val router: Router,


    ) : MvpPresenter<UsersDetailsView>() {

    private val bag = CompositeDisposable()

    fun forkUser(repoUrl: String) {
        viewState.showLoading()
        repo.getOrgs(repoUrl)
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.show(it)
                    viewState.hideLoading()
                },
                {}
            ).disposeBy(bag)
    }

    fun onBackPressed(): Boolean {
        router.backTo(UserScreen)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }
}