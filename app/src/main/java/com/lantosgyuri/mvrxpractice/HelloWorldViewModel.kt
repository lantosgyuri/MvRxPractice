package com.lantosgyuri.mvrxpractice

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class HelloWorldViewModel(initialState: HelloWorldState)
    : MvRxViewModel<HelloWorldState>(initialState){

    fun fetchTemperature() {
        Observable.just(72)
            .delay(3, TimeUnit.SECONDS)
            .execute { copy(temperature = it) }

    }
}