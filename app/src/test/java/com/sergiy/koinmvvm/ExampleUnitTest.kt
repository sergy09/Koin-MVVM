package com.sergiy.koinmvvm

import com.sergiy.koinmvvm.injection.appModule
import com.sergiy.koinmvvm.injection.networkModule
import com.sergiy.koinmvvm.injection.repositoryModule
import com.sergiy.koinmvvm.injection.useCasesModule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest


class ExampleUnitTest : KoinTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Before
    fun `checking modules`() {
        // use koinApplication instead of startKoin, to avoid having to close Koin after each test
        startKoin {
            listOf(
                appModule,
                networkModule,
                repositoryModule,
                useCasesModule
            )
        }
    }

}
