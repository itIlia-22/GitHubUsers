package com.example.githubusers.repository.repo2

import com.example.githubusers.model.UserDto

interface OnRepoClick {
    fun onRepoClick(repo: UserDto)
}