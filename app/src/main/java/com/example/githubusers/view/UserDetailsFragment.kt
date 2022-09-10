package com.example.githubusers.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.MyApp
import com.example.githubusers.OnBackPressendListener
import com.example.githubusers.databinding.FragmentUserDetailsBinding
import com.example.githubusers.model.UserDto
import com.example.githubusers.oreg.OregDto
import com.example.githubusers.repository.UsersGitRepositoryImpl
import com.example.githubusers.repository.network.Network
import com.example.githubusers.usersdetails.UsersDetailsPresenter
import com.example.githubusers.usersdetails.UsersDetailsView
import com.example.githubusers.utils.loadImage
import com.example.githubusers.utils.makeGone
import com.example.githubusers.utils.makeVisible
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserDetailsFragment : MvpAppCompatFragment(), UsersDetailsView, OnBackPressendListener {
    private val presenter: UsersDetailsPresenter by moxyPresenter {
        UsersDetailsPresenter(UsersGitRepositoryImpl(Network.usersApi), MyApp.instance.router)
    }
    private lateinit var binding: FragmentUserDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(ARG_LOGIN)?.let {
            presenter.forkUser(it)
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return FragmentUserDetailsBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    companion object {

        private const val ARG_LOGIN = "ARG_LOGIN"

        fun getInstance(Info: String): UserDetailsFragment {
            return UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LOGIN, Info)
                }
            }
        }
    }


    override fun showLoading() {
        binding.apply {
            loginOreg.makeGone()
            imageOreg.makeGone()
            nodeOreg.makeGone()
            reposOreg.makeGone()
            progress.makeVisible()
        }
    }

    override fun hideLoading() {
        binding.apply {
            loginOreg.makeVisible()
            imageOreg.makeVisible()
            nodeOreg.makeVisible()
            reposOreg.makeVisible()
            progress.makeGone()
        }
    }

    override fun show(user: OregDto) {
        binding.apply {
            imageOreg.loadImage(user.avatar_url)
            loginOreg.text = user.login


        }
    }







    override fun onBackPressend() = presenter.onBackPressed()
}