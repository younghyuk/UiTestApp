package com.dynatic.uitestapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dynatic.uitestapp.recyclerview.RecyclerViewActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.apply {
            text = "Recycler View"
            setOnClickListener {
                startActivity(intentFor<RecyclerViewActivity>())
            }
        }
    }
}
