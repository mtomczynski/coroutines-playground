package com.tomcz.coroutinesplayground

import com.tomcz.coroutinesplayground.common.BaseCoroutineTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class TestFoo : BaseCoroutineTest() {

    @Test
    fun testBar() = runTest(UnconfinedTestDispatcher()) {
        val list = mutableListOf<Int>()
        val job = launch { Foo().state.toList(list) }
        advanceUntilIdle()
        job.cancelAndJoin()
        println(list.joinToString(" "))
        assert(listOf(0, 1, 2, 3, 4, 5, 6, 7) == list)
    }
}
