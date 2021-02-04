package com.example.kotlinquiz

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI


class StartFragment : Fragment() {

    lateinit var  startBtn: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_start)
        val view =  inflater.inflate(R.layout.fragment_start, container, false)
        setHasOptionsMenu(true)
        startBtn = view.findViewById(R.id.startBtn)
        startBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_startFragment_to_questionFragment))
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return  NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                ||  super.onOptionsItemSelected(item)
    }

}