package com.example.shoestap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestap.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null

    private lateinit var button: Button
    private var isHeartRed: Boolean = false
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
        data.add(datosLista("ZAPATILLAS WEB BOOST Negra ", "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/c7b5a207c6dc4f7cbc3eaea800144afe_9366/Zapatillas_Web_Boost_Negro_GZ6445_01_standard.jpg", "99.990","zapatilla negra"))
        data.add(datosLista("ZAPATILLAS WEB BOOST Gris", "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/b5434b62ca0a4c7fac32aeb60007ea5e_9366/Zapatillas_Web_Boost_Gris_GZ6444_01_standard.jpg", "79.990","zapatilla gris"))
        data.add(datosLista("ZAPATILLAS ULTRABOOST LIGHT 23", "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/eafe6dfb44794a428ddd18ae244935cf_9366/Zapatillas_Ultraboost_Light_23_Blanco_IE1689_HM4.jpg", "149.990",""))
        data.add(datosLista("ZAPATILLAS ADIZERO ADIOS PRO 3.0", "https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/bc9622ad67f046e8b037af89012b89b4_9366/Zapatillas_Adizero_Adios_Pro_3.0_Naranjo_GX9777_01_standard.jpg", "129.990","zapatilla naranja"))
        data.add(datosLista("ZAPATILLAS DE TRAIL RUNNING TERREX SOULSTRIDE", "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a42ad7da955e490b8526af5f00abad27_9366/Zapatillas_de_Trail_Running_Terrex_Soulstride_Negro_HR1191_01_standard.jpg", "67.990","zapatilla bicolor"))
        data.add(datosLista("ZAPATILLAS DE RUNNING ADIDAS ADIZERO SL", "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/cacdfe6bde8d41209e27aef600ebc823_9366/Zapatillas_De_Running_Adidas_Adizero_SL_Turquesa_GV9090_01_standard.jpg", "89.990","zapatilla turquesa"))
        data.add(datosLista("ZAPATILLAS ADIZERO ROSE 1", "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/23e074c425c34e98b6a3abfd0158709c_9366/Zapatillas_Adizero_Rose_1_Rojo_G57744_01_standard.jpg", "109.990","zapatilla roja"))
        data.add(datosLista("ZAPATILLAS ULTRABOOST 1.0 DÍA DE SAN VALENTÍN", "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/cf4bee90c62a425fa5dbaf3c0081dbc0_9366/Zapatillas_Ultraboost_1.0_Dia_de_San_Valentin_Negro_HQ6174_HM4.jpg", "169.990","zapatilla SAN VALENTIN"))
        data.add(datosLista("ZAPATILLAS DURAMO SL", "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/643a8844d26a446c86e5acb800b3dfe6_9366/Zapatillas_Duramo_SL_Blanco_GV7125_01_standard.jpg", "33.593","zapatilla blanca"))
        data.add(datosLista("ZAPATILLAS SUPERSTAR", "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/15f901c90a9549d29104aae700d27efb_9366/Zapatillas_Superstar_Negro_EG4959_01_standard.jpg", "89.990","zapatilla negra"))
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

