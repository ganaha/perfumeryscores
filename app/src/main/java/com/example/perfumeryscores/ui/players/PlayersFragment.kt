package com.example.perfumeryscores.ui.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.perfumeryscores.R

class PlayersFragment : Fragment() {

    private lateinit var playersViewModel: PlayersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        playersViewModel =
            ViewModelProvider(this).get(PlayersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_players, container, false)
        val textView: TextView = root.findViewById(R.id.text_players)
        playersViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}