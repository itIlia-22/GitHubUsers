package com.example.githubusers.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubusers.MyApp
import com.example.githubusers.OnBackPressendListener
import com.example.githubusers.databinding.FragmentUserInfoBinding
import com.example.githubusers.model.UserDto
import com.example.githubusers.repository.UsersGitRepositoryImpl
import com.example.githubusers.repository.network.Network
import com.example.githubusers.users.UsersPresenter
import com.example.githubusers.users.UsersView
import com.example.githubusers.usersinfo.UsersInfoPresenter
import com.example.githubusers.usersinfo.UsersInfoView
import com.example.githubusers.utils.loadImage
import com.example.githubusers.utils.makeGone
import com.example.githubusers.utils.makeVisible
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserInfoFragment : MvpAppCompatFragment(), UsersInfoView, OnBackPressendListener {
    private val presenter: UsersInfoPresenter by moxyPresenter {
        UsersInfoPresenter(UsersGitRepositoryImpl(Network.usersApi), MyApp.instance.router)
    }
    private lateinit var banding: FragmentUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString(ARG_LOGIN)?.let {
            presenter.loadUser(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return FragmentUserInfoBinding.inflate(inflater, container, false).also {
            banding = it
        }.root
    }

    companion object {

        private const val ARG_LOGIN = "ARG_LOGIN"

        fun getInstance(Info: String): UserInfoFragment {
            return UserInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, Info)
                }
            }
        }
    }

    override fun showLoading() {
        banding.apply {
            imageInfoUser.makeGone()
            loginInfoUser.makeGone()
            InfoRepo.makeGone()
            InfoSub.makeGone()
            InfoOrg.makeGone()
            progress.makeVisible()
        }
    }

    override fun hideLoading() {
        banding.apply {
            imageInfoUser.makeVisible()
            loginInfoUser.makeVisible()
            InfoRepo.makeVisible()
            InfoSub.makeVisible()
            InfoOrg.makeVisible()
            progress.makeGone()
        }
    }

    override fun show(user: UserDto) {
        banding.apply {
            imageInfoUser.loadImage(user.avatar_url)
            loginInfoUser.text = user.login
            InfoRepo.text = user.repos_url
            InfoSub.text = user.subscriptions_url
            InfoOrg.text = user.organizations_url
        }
    }

    override fun onBackPressend() = presenter.onBackPressed()
}