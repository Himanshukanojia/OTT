package com.example.ott.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.netflixuiclone.data.setData
import com.example.netflixuiclone.data.setData.getOuterList
import com.example.netflixuiclone.data.setData.movieList
import com.example.ott.R
import com.example.ott.adapter.InnerAdapter
import com.example.ott.adapter.OutterAdapter
import com.example.ott.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)


        setMovieData()
        setRc()

        // Inflate the layout for this fragment
        return binding!!.root
    }

    private fun setMovieData() {
        val list = movieList()
        Glide.with(this)
            .load(list[1].url)
            .into(binding!!.headerImg)

        binding!!.title.text = list[1].name
        binding!!.genre.text = list[1].generic
    }

    private fun setRc() {
        val list2 = getOuterList()
        val adapter = OutterAdapter(list2)
        binding!!.outerRc.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        if (binding!=null) {
            binding = null
        }
    }


}