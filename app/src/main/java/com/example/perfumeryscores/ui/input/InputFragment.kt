package com.example.perfumeryscores.ui.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.perfumeryscores.AppApplication
import com.example.perfumeryscores.R
import com.example.perfumeryscores.databinding.FragmentInputBinding

class InputFragment : Fragment(), View.OnClickListener {

    private val viewModel: InputViewModel by viewModels {
        InputViewModelFactory((requireContext().applicationContext as AppApplication).repository)
    }
    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.players.observe(viewLifecycleOwner, { players ->
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                players.map { it.name }.toTypedArray()
            )
            binding.apply {
                editTextP1.setAdapter(adapter)
                editTextP2.setAdapter(adapter)
                editTextP3.setAdapter(adapter)
                editTextP4.setAdapter(adapter)
            }
        })

        // SAVEボタン
        binding.buttonSave.setOnClickListener(this)
    }

    // Save
    override fun onClick(v: View?) {
        viewModel.onClickSave()
        // 遷移
        findNavController().navigate(R.id.navigation_histories)
    }
}