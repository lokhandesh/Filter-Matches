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

    @Mock
    lateinit var mainActivity: MainActivity

    @Mock
    private lateinit var mockContext: Context

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)
        MockitoAnnotations.initMocks(mainActivity)
        this.matchesViewModel = MatchesViewModel(application)
        this.mainActivity = MainActivity()

    }

    @Test
    fun getMatchesList() {
        var matchList = matchesViewModel.getAllMatches(mainActivity)
        assertNotNull(matchList)
    }

    @Test
    fun retriveMatchesList() {
        var matchList = matchesViewModel.retriveMatchesList(mainActivity)
        assertNotNull(matchList)
    }

    @Test
    fun loadJSONFromAssets() {
        var matchList = matchesViewModel.loadJSONFromAssets(mainActivity)
        assertNotNull(matchList)
    }

    @After
    fun tearDown() {
    }


}