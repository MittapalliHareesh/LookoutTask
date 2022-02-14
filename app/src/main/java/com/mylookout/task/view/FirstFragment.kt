package com.mylookout.task

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mylookout.task.databinding.FragmentFirstBinding
import com.mylookout.task.viewModel.FirstViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val firstViewModel: FirstViewModel by viewModels()
    private val list1 = listOf(1, 2, 3, 3, 5)
    private val list2 = listOf(6, 7, 3, 9, 10)

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val finalLists = firstViewModel.partition(list1, list2, ::provideRealNumber)
        binding.textviewFirst.text = "Result is  $finalLists"
    }

    private fun provideRealNumber(x: Int): Int {
        return x * 2
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}