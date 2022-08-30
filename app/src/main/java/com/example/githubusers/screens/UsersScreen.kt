package com.example.githubusers.screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.githubusers.view.UserInfoFragment
import com.example.githubusers.view.UserListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UserScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserListFragment.getInstance()
    }

    data class UserInfo(val Info:String):FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment {
            return UserInfoFragment.getInstance(Info)
        }
    }
}