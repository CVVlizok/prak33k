package com.example.prak33k

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prak33k.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация ViewModel
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)

        binding.buttonNext.setOnClickListener {
            (activity as MainActivity).navigateToFragment2()
        }

        viewModel.someData.observe(viewLifecycleOwner) { data ->
            binding.textViewFragment1.text = data
        }

        viewModel.updateData("Первый фрагмент")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
