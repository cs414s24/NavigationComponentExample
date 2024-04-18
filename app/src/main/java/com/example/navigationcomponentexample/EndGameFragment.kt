package com.example.navigationcomponentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavOptions
import androidx.navigation.Navigation


class EndGameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_end_game, container, false)

        view.findViewById<Button>(R.id.restart_game_button).setOnClickListener {
            //Navigation.findNavController(view).navigate(R.id.action_endGameFragment_to_startGameFragment)

            // The navOptions below is optional, but it allows to set PopUpTo options to true so that
            // when back button is clicked in the startGame fragment, it allows to exit from the app
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.startGameFragment, true).build()
            Navigation.findNavController(view).navigate(R.id.action_endGameFragment_to_startGameFragment, null, navOptions)
        }

        // Inflate the layout for this fragment
        return view
    }

}