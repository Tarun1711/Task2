package com.example.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.firebase.database.FirebaseDatabase

class Fragment2 : Fragment() {
    lateinit var nameList:MainModel
    lateinit var mainAdapter: MainAdapter
    var firebaseDatabase: FirebaseDatabase? = null
    var database: DatabaseReference? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = FirebaseDatabase.getInstance().getReference().child("list")

        val btnAdd = requireActivity().findViewById<Button>(R.id.btnAdd)




        btnAdd.setOnClickListener {
            insertDataToFirebase( )


        }
    }

    private fun insertDataToFirebase() {
        val etName = requireActivity().findViewById<EditText>(R.id.etName)
        if (etName.text.toString() != "") {
            val name = etName.text.toString()
            val nameList = MainModel(name)
            databaseReference.child("list").setValue(nameList)
        }
    }
}
