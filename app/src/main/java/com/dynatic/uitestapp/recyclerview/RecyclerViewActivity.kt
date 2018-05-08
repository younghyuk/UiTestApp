package com.dynatic.uitestapp.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.dynatic.uitestapp.R

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(arrayOf("test1", "test2"))
        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager;
            adapter = (viewAdapter)
        }
    }

    class MyAdapter(private val myDataset: Array<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val textView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.my_text_view, parent, false) as TextView
            return ViewHolder(textView)
        }

        override fun getItemCount() = myDataset.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = myDataset[position]
        }

        class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
    }
}
