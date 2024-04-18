package com.example.navigationcomponentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class StartGameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_start_game, container, false)


        view.findViewById<Button>(R.id.start_game_button).setOnClickListener {
            //Navigation.findNavController(view).navigate(R.id.action_startGameFragment_to_duringGameFragment)

            // If you want to pass data through safe args you can use the following lines instead
            val number = 1
            val action = StartGameFragmentDirections.actionStartGameFragmentToDuringGameFragment(number)
            Navigation.findNavController(view).navigate(action)

        }

        // Inflate the layout for this fragment
        return view
    }

}