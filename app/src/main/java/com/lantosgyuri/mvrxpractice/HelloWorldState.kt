package com.lantosgyuri.mvrxpractice

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class HelloWorldState(
    val title: String = "Hello World",
    val temperature: Async<Int> = Uninitialized
) : MvRxState {
}