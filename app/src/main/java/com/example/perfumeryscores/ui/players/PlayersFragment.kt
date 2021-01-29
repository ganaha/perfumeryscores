package com.example.perfumeryscores.ui.players

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.perfumeryscores.AppApplication
import com.example.perfumeryscores.databinding.FragmentPlayersBinding

class PlayersFragment : Fragment() {

    private val viewModel: PlayersViewModel by viewModels {
        PlayersViewModelFactory((requireContext().applicationContext as AppApplication).repository)
    }

    private lateinit var binding: FragmentPlayersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayersBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.players.observe(viewLifecycleOwner, {
            val items = it.map { player ->
                mapOf(
                    "title" to player.name,
                    "detail" to "play: ${player.game}, win: ${player.win}, best: ${player.best}"
                )
            }
            val adapter = SimpleAdapter(
                context,
                items,
                android.R.layout.simple_list_item_2,
                arrayOf("title", "detail"),
                intArrayOf(android.R.id.text1, android.R.id.text2)
            )
            binding.listView.adapter = adapter
        })
    }
}