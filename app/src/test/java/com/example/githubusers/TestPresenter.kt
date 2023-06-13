package com.example.githubusers

import com.example.githubusers.repository.GitUsersRepository
import com.example.githubusers.usersdetails.UsersDetailsPresenter
import com.github.terrakok.cicerone.Router
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TestPresenter {

    private lateinit var presenter: UsersDetailsPresenter

    @Mock
    private lateinit var repository: GitUsersRepository

    @Mock
    private lateinit var router: Router

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = UsersDetailsPresenter(repository, router)
    }
@Test
    fun forkUser_Test(){
        val repoUrl =  "String"
        presenter.forkUser(repoUrl)
        Mockito.verify(repository,Mockito.times(1)).getOrgsUser(repoUrl)

    }


}