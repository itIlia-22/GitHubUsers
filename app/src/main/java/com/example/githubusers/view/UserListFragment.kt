package com.example.githubusers.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.MyApp
import com.example.githubusers.OnBackPressendListener
import com.example.githubusers.databinding.FragmentUserListBinding
import com.example.githubusers.users.UsersAdapter
import com.example.githubusers.model.UserDto
import com.example.githubusers.repository.OnItemClick
import com.example.githubusers.repository.UsersGitRepositoryImpl
import com.example.githubusers.repository.network.Network
import com.example.githubusers.users.UsersPresenter
import com.example.githubusers.users.UsersView
import com.example.githubusers.utils.makeGone
import com.example.githubusers.utils.makeVisible
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserListFragment : MvpAppCompatFragment(),UsersView,OnBackPressendListener {

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(UsersGitRepositoryImpl(Network.usersApi),MyApp.instance.router)
    }

    private lateinit var binding: FragmentUserListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            RecyclerViewUsers.layoutManager = LinearLayoutManager(requireContext())
            RecyclerViewUsers.adapter = adapter


        }
    }


    private val adapter = UsersAdapter(object : OnItemClick {
        override fun onClick(login: String) {
            presenter.openInfoFragment(login)
        }

    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return FragmentUserListBinding.inflate(inflater, container, false).also {
            binding = it

        }.root

    }

    companion object {


        @JvmStatic
        fun getInstance() = UserListFragment()
    }

    override fun onBackPressend() = presenter.onBackPressed()
    override fun initList(list: List<UserDto>) {
        adapter.user = list
    }

    override fun showLoading() {
        binding.apply {
           RecyclerViewUsers.makeGone()
           lodList.makeVisible()
       }
    }

    override fun hideLoading() {
        binding.apply {
            RecyclerViewUsers.makeVisible()
            lodList.makeGone()
        }
    }


}