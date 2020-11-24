package com.weight68kg.jetpackdemo.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weight68kg.jetpackdemo.BaseApplication
import com.weight68kg.jetpackdemo.R
import com.weight68kg.jetpackdemo.architecture.UserProfileViewModel
import com.weight68kg.jetpackdemo.data.CharacterBean
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class ListFragment : Fragment() {
    private var list = ArrayList<CharacterBean>()
    lateinit var listComponent: ListComponent


    @Inject
    lateinit var viewModel: ListViewModle
    private val mAdapter by lazy {
        object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
                MyViewHolder(
                    LayoutInflater.from(requireContext())
                        .inflate(R.layout.item_list_content, parent, false)
                )

            override fun getItemCount(): Int = list.size

            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                holder.itemView.apply {
                    findViewById<TextView>(R.id.id_text).text = list[position].name
                }
            }

        }
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        listComponent =
            (requireContext().applicationContext as BaseApplication).appComponent.loginComponent()
                .create()
        listComponent.inject(this)
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ListViewModle.Factory()
//        viewModel = ViewModelProvider(this, factory).get(ListViewModle::class.java)

        val rv_list = view.findViewById<RecyclerView>(R.id.rv_list)

        rv_list.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }

        viewModel.user.observe(viewLifecycleOwner, Observer {
            list = it as ArrayList<CharacterBean>
            mAdapter.notifyDataSetChanged()
        })
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}