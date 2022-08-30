package com.example.githubusers.usersinfo

import com.example.githubusers.repository.GitUsersRepository
import com.example.githubusers.utils.disposeBy
import com.example.githubusers.utils.subscribeByDefault
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersInfoPresenter(
    val repo: GitUsersRepository,
    val router: Router,


    ) : MvpPresenter<UsersInfoView>() {
    private val bag = CompositeDisposable()

    fun loadUser(login: String) {
        viewState.showLoading()
        repo.getLoginUser(login)
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
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }
}