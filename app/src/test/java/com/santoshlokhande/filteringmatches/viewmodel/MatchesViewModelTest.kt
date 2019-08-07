package com.santoshlokhande.filteringmatches.viewmodel

import android.app.Application
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.santoshlokhande.filteringmatches.MainActivity
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MatchesViewModelTest {


    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var application: Application

    @Mock
    lateinit var matchesViewModel: MatchesViewModel



    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        this.matchesViewModel = MatchesViewModel(application)
        this.application = Application()

    }

    @Test
    fun getMatchesList() {
        var matchList = matchesViewModel.getAllMatches()
        assertNotNull(matchList)
    }

    @Test
    fun retriveMatchesList() {
        var matchList = matchesViewModel.retriveMatchesList()
        assertNotNull(matchList)
    }

    @Test
    fun loadJSONFromAssets() {
        var matchList = matchesViewModel.loadJSONFromAssets()
        assertNotNull(matchList)
    }

    @After
    fun tearDown() {
    }


}