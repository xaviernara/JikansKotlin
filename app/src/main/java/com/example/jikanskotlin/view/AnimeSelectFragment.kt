
package com.example.jikanskotlin.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jikanskotlin.adaptor.JikanAdapter
import com.example.jikanskotlin.adaptor.JikanClickListener
import com.example.jikanskotlin.databinding.FragmentAnimeSelectBinding
import com.example.jikanskotlin.model.JikanResponse
import com.example.jikanskotlin.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeSelectFragment : androidx.fragment.app.Fragment(), JikanClickListener {
    private lateinit var binding : FragmentAnimeSelectBinding
    private val args : AnimeSelectFragmentArgs by navArgs()
    private val viewModel by viewModels<MainViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentAnimeSelectBinding.inflate(inflater, container, false).also { binding = it}.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()

    }

    private fun initObservers(){
        //Log.d("search", "initObservers: ${args.search}")
        viewModel.insertAndCreateJikanResponses(args.search)
        viewModel.jikanResponseListLiveData.observe(viewLifecycleOwner, Observer {
              generateJikanAdapter(it)
        })

    }

    private fun generateJikanAdapter(jikanResponseList: List<JikanResponse>){
        binding.recyclerview.layoutManager = GridLayoutManager(binding.root.context,1)
        binding.recyclerview.adapter = JikanAdapter(jikanResponseList,this)
    }

    override fun onClickListener(jikanResponse: JikanResponse) {
        viewModel.jikanResponseLiveData.observe(viewLifecycleOwner, Observer {
            val actions = AnimeSelectFragmentDirections.actionAnimeSelectFragmentToAnimeDetailsFragment(jikanResponse)
            //val actions = AnimeSelectFragmentDirections.actionAnimeSelectFragmentToAnimeDetailsFragment()
            findNavController().navigate(actions)
        })


    }

}