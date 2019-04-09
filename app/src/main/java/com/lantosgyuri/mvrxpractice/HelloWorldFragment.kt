package com.lantosgyuri.mvrxpractice


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.*
import kotlinx.android.synthetic.main.fragment_hello_world.*

class HelloWorldFragment : BaseMvRxFragment() {

    private val viewModel : HelloWorldViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello_world, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        hello_text_view.setOnClickListener{
            viewModel.fetchTemperature()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.subscribe {state ->
            Log.d(TAG, "The state is $state")
        }

        viewModel.selectSubscribe(HelloWorldState::temperature) { temperature ->
            Log.d(TAG, "The temperature is $temperature")
        }

        viewModel.asyncSubscribe(HelloWorldState:: temperature, onSuccess = { temperature ->
            Log.d(TAG, "The temperature is $temperature")
        }, onFail = { error ->
            Log.d(TAG, "the error is: $error")
        })
    }

    override fun invalidate() {
        withState(viewModel) {state ->
            hello_text_view.text = when(state.temperature){
                is Uninitialized -> "Click to load weather"
                is Loading -> "Loading"
                is Success -> "Weather: ${state.temperature()} degrees"
                is Fail -> "Failed to load"
            }
        }
    }

    companion object {
        const val TAG = "HelloWorldFragment"
    }
}
