package com.example.perfumeryscores.ui.histories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perfumeryscores.AppApplication
import com.example.perfumeryscores.databinding.FragmentHistoriesBinding

class HistoriesFragment : Fragment() {

    private val viewModel: HistoriesViewModel by viewModels {
        HistoriesViewModelFactory((requireContext().applicationContext as AppApplication).repository)
    }

    private lateinit var binding: FragmentHistoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoriesBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = HistoryRecyclerViewAdapter(viewModel, viewLifecycleOwner)

                // 罫線
                val divider = DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
                addItemDecoration(divider)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.histories.observe(viewLifecycleOwner, {
            (binding.recyclerView.adapter as HistoryRecyclerViewAdapter).submitList(it)
        })
    }
}