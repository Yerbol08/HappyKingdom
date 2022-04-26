package com.enu.happykingdom.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.enu.happykingdom.R
import com.enu.happykingdom.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val data = arrayListOf<HomeItems>()
        data.add(HomeItems("Лаборатория творчества", R.drawable.image, "Провести занимательные эксперименты в виде игры можно в нашей волшебной «Лаборатории творчества»!"))
        data.add(HomeItems("Фортепиано", R.drawable.piano, "Уроки игры на фортепиано обогащают внутренний мир."))
        data.add(HomeItems("Репетиторство", R.drawable.repetiter, "Помощь ребенку в уроках с 1 по 4 класс"))
        data.add(HomeItems("Подготовка к школе", R.drawable.podgotovka, "Боевой курс подготовки к школе для наших детей!"))
        data.add(HomeItems("Психолог", R.drawable.psiholig, "Советы и консультация детского психолога."))
        data.add(HomeItems("Мини-сад", R.drawable.minisad, "Комплекс занятий для детей 2–3 лет!"))


        val adapter = context?.let { HomeAdapter(data, it) }
        binding.recycylerHome.adapter = adapter
        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
