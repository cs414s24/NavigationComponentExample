package com.example.navigationcomponentexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs


class DuringGameFragment : Fragment() {

    // A class is created for the receiving destination.
    // The name of this class is the name of the destination, appended with the word "Args".
    // For example, if the destination fragment is named ConfirmationFragment,
    // the generated class is called ConfirmationFragmentArgs.
    val args: StartGameFragmentArgs by navArgs()

    private val TAG = "DuringGameFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_during_game, container, false)

        // The following shows how you can retrieve the data coming via safe args
        // In your receiving destination’s code, use the getArguments() method to retrieve the bundle
        // and use its contents. When using the -ktx dependencies, Kotlin users can also use
        // the by navArgs() property delegate to access arguments.

        val number = args.number
        Log.d(TAG, "$number")
        view.findViewById<TextView>(R.id.tv_number).text = number.toString()

        view.findViewById<Button>(R.id.finish_game_button).setOnClickListener {
            //Navigation.findNavController(view).navigate(R.id.action_duringGameFragment_to_endGameFragment)


            // The navOptions below is optional, but it allows to set PopUpTo options to true so that
            // when back button is clicked in the endGame fragment, it goes back to startGame instead of duringGame fragment
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.duringGameFragment, true).build()
            Navigation.findNavController(view).navigate(R.id.action_duringGameFragment_to_endGameFragment, null, navOptions)

        }

        // Inflate the layout for this fragment
        return view
    }

}