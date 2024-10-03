package com.example.prak33k

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prak33k.databinding.Fragment3Binding

class Fragment3 : Fragment() {
    private var _binding: Fragment3Binding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ThirdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация ViewModel
        viewModel = ViewModelProvider(this).get(ThirdViewModel::class.java)

        binding.buttonBack.setOnClickListener {
            (activity as MainActivity).goBack()
        }

        viewModel.someData.observe(viewLifecycleOwner) { data ->
            binding.textViewFragment3.text = data
        }

        viewModel.updateData("Третий фрагмент")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

