package com.mylookout.task.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mylookout.task.databinding.FragmentSecondBinding
import com.mylookout.task.viewModel.FirstViewModel
import com.mylookout.task.viewModel.SecondViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val secondViewModel: SecondViewModel by viewModels()

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val list1 = listOf(-1, 5, 3, -5, 4)
    private val list2 = listOf(1, 5, 3, 2, -7)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val finalLists = secondViewModel.partition(list1, list2, ::provideRealNumber)
        binding.textviewSecond.text = "Result is  $finalLists"
    }

    private fun provideRealNumber(x: Int): Int {
        return x % 2
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}