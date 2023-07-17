package com.example.shoestap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestap.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    private var dataList: MutableList<datosLista> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater, container, false)

        if (dataList.isNotEmpty()) {
            dataList.clear()
        }

        dataList = getData()

        recyclerView = binding!!.Rv
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = Adapter(dataList)
        // Implementar el OnClickListener

        recyclerView.adapter = adapter

        return binding?.root
    }

    private fun getData(): MutableList<datosLista> {
        val data: MutableList<datosLista> = ArrayList()
        data.add(datosLista("https://upload.wikimedia.org/wikipedia/commons/b/b9/Paisaje_de_Albacete.jpg", "Girasoles"))
        data.add(datosLista("https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640", "Zhuo Cheng you"))
        data.add(datosLista("https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640", "billow926"))
        data.add(datosLista("https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640", "Philipp Deiß"))
        data.add(datosLista("https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640", "Joshua Earle"))
        data.add(datosLista("https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640", "Melnychuk Nataliya"))
        data.add(datosLista("https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640", "Teagan Maddux"))
        data.add(datosLista("https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640", "Chen Liu"))
        data.add(datosLista("https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640", "John Fornander"))
        data.add(datosLista("https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640", "Parker"))
        data.add(datosLista("https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640", "XPS"))
        data.add(datosLista("https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640", "J. whack"))
        data.add(datosLista("https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640", "Amstrong"))
        return data
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
