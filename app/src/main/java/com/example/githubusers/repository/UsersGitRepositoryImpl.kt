package com.example.githubusers.repository

import com.example.githubusers.mapper.UserMapper
import com.example.githubusers.model.UserDto
import com.example.githubusers.oreg.OregDto
import io.reactivex.rxjava3.core.Single

class UsersGitRepositoryImpl constructor(
    private val usersApi: UsersApi
):GitUsersRepository {
    override fun getUser(): Single<List<UserDto>> {
        return usersApi.getAllUsers()
            .map {
            it.map(UserMapper::mapToEntity)
        }


    }

    override fun getLoginUser(login: String): Single<UserDto> {
       return usersApi.getLoginUsers(login)
           .map(UserMapper::mapToEntity)
    }

    override fun getRepoUser(repo: String): Single<UserDto> {
       return usersApi.getRepoUsers(repo)
           .map(UserMapper::mapToEntity)
    }

    override fun getSubUser(subscriptions: String): Single<UserDto> {
       return usersApi.getSubscriptionsUsers(subscriptions)
           .map(UserMapper::mapToEntity)
    }

    override fun getOrgsUser(organizations: String): Single<UserDto> {
       return usersApi.getOrganizationsUsers(organizations)
           .map(UserMapper::mapToEntity)
    }

    override fun getOrgs(orgs: String): Single<OregDto> {
        return usersApi.getInfoOrg(orgs)
            .map(UserMapper::mapToEntity)
    }




}