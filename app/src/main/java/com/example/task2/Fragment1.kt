package com.example.task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition


class Fragment1 : Fragment(),MainAdapter.OnItemClickListener {

    var nameList = ArrayList<MainModel>()
    lateinit var mainAdapter: MainAdapter
    var firebaseDatabase: FirebaseDatabase? = null
    var databaseReference: DatabaseReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        mainAdapter= MainAdapter(this,nameList)
        databaseReference = FirebaseDatabase.getInstance().getReference().child("list")

        databaseReference.child("list").get().addOnSuccessListener {

            nameList = it.value

        }.addOnFailureListener {


        }

        val rvList = requireActivity().findViewById<RecyclerView>(R.id.rv_list)
        rvList.apply {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            mainAdapter.notifyDataSetChanged()

        }
    }

    override fun onItemClick(nameList: MainModel, view: View) {

    }

}