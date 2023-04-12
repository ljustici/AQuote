package com.ljusticia.androidmvvm.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ljusticia.androidmvvm.domain.GetQuotesUseCase
import com.ljusticia.androidmvvm.domain.GetRandomQuoteUseCase
import com.ljusticia.androidmvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class QuoteViewModelTest{
    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase
    private lateinit var quoteViewModel: QuoteViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomQuoteUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created at the first time, get all quotes and set the first value`() = runTest{
        //Given
        val quote = listOf(Quote("Holi", "Aris"), Quote("Dame un like", "Otro Aris "))
        coEvery { getQuotesUseCase() } returns quote
        //When
        quoteViewModel.onCreate()
        //Then
        assert(quoteViewModel.quoteModel.value == quote.first())
    }

    @Test
    fun `when randomQuoteUseCase return a quote set on the livedata`() = runTest {
        //Given
        val quote = Quote("Holi", "Aris")
        coEvery { getRandomQuoteUseCase() } returns quote

        //When
        quoteViewModel.randomQuote() //no hay que igualarlo a nada porque lo que se comprueba es el livedata

        //Then
        assert(quoteViewModel.quoteModel.value == quote)
    }

    /** Comprueba que si el usecase falla y devuelve nulo, el livedata mantiene el dato anterior
     *
     */
    @Test
    fun `if randomQuoteUseCase return null keep the last value`() = runTest{
        //Given
        val quote = Quote("Aris", "Aris") //creamos un quote
        quoteViewModel.quoteModel.value = quote //le damos ese valor al livedata
        coEvery { getRandomQuoteUseCase() } returns null //hacemos que el usecase falle

        //When
        quoteViewModel.randomQuote()

        //Then
        assert(quoteViewModel.quoteModel.value == quote)
    }
}