package com.example.githubusers.mapper

import com.example.githubusers.model.GitUsers
import com.example.githubusers.model.UserDto
import com.example.githubusers.oreg.GitOreg
import com.example.githubusers.oreg.OregDto

object UserMapper {
    fun mapToEntity(dto:GitUsers):UserDto{
        return UserDto(
            id = dto.id,
            login = dto.login,
            avatar_url = dto.avatar_url,
            repos_url = dto.repos_url,
            subscriptions_url = dto.subscriptions_url,
            organizations_url = dto.organizations_url
        )

    }
    fun mapToEntity(dto:GitOreg):OregDto{
        return OregDto(
            id = dto.id,
            login = dto.login,
            avatar_url = dto.avatar_url,
            repos_url = dto.repos_url,
            node_id = dto.node_id,
            description = dto.description,


        )

    }




}