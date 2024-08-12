package com.example.myview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myview.databinding.ActivityLayoutBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLayoutBinding
    private lateinit var viewModel:MyView
    private lateinit var adapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MyView::class.java)
       // viewModel.display()

//        binding.fab.setOnClickListener(object:View.OnClickListener {
//            override fun OnClick(view: View?){
//                Snackbar.make(view!!, "our message {}", Snackbar.LENGTH_LONG).show()
//        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.todos.observe(this, Observer{
            adapter = Adapter(it)
            recyclerView.adapter=adapter

        })


        }

    }