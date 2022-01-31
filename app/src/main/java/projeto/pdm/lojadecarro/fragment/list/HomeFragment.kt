package projeto.pdm.lojadecarro.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*
import projeto.pdm.lojadecarro.R
import projeto.pdm.lojadecarro.data.CarroViewModel


class HomeFragment : Fragment() {
    private lateinit var mCarroViewModel: CarroViewModel

 override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        //recycler
        val adapter = ListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

     //CarroViewModel
     mCarroViewModel = ViewModelProvider(this).get(CarroViewModel::class.java)
     mCarroViewModel.readAllData.observe(viewLifecycleOwner, Observer {carro -> adapter.setData(carro) })
        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_addCarro)
        }

            val view2 = inflater.inflate(R.layout.fragment_home, container, false)

            view2.floatingActionButton2.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_sobre)
        }


     return view

    }
}