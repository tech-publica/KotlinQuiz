package com.example.kotlinquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation


class FailureFragment : Fragment() {

    lateinit var tryAgainBtn: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_failure, container, false)
        (activity as AppCompatActivity).supportActionBar?.title =
            ""
        tryAgainBtn = view.findViewById(R.id.retryBtn)

        tryAgainBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_failure_to_questionFragment))

        return view
    }


}