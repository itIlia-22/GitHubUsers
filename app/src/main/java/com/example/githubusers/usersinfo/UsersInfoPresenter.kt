package com.example.githubusers.usersinfo

import com.example.githubusers.repository.GitUsersRepository
import com.example.githubusers.screens.UserScreen
import com.example.githubusers.utils.disposeBy
import com.example.githubusers.utils.subscribeByDefault
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersInfoPresenter(
    private val repo: GitUsersRepository,
    private val router: Router,


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

    fun openForksFragment(details: String) {
        router.navigateTo(UserScreen.UserDetailsInfo(details))
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