package com.example.jikanskotlin.view

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.jikanskotlin.databinding.FragmentAnimeDetailsBinding
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAnimeDetailsBinding
    private val args: AnimeDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    )= FragmentAnimeDetailsBinding.inflate(inflater, container, false).also{binding = it}.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews()


    }

    private fun setUpViews() {

        binding.airingText.text = args.jikanResponse.results[0].airing.toString()
        binding.endDateText.text = args.jikanResponse.results[0].end_date
        binding.episodesText.text = args.jikanResponse.results[0].episodes.toString()
        binding.ratingText.text = args.jikanResponse.results[0].rated
        binding.titleText.text = args.jikanResponse.results[0].title
        binding.scoreText.text = args.jikanResponse.results[0].score.toString()
        binding.urlText.text = args.jikanResponse.results[0].url
        binding.synopsisText.text = args.jikanResponse.results[0].synopsis
        binding.startDateText.text = args.jikanResponse.results[0].start_date
        /*GlideToVectorYou.justLoadImage(binding.root.context as Activity,
            Uri.parse(args.jikanResponse!!.results[0].image_url)
            ,binding.imageView)*/
        Glide.with(binding.root).load(Uri.parse( args.jikanResponse.results[0].image_url)).into(binding.animeImage)

    }
}