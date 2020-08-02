package io.reisonic.devs.View.Activities

import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reisonic.devs.Model.Variables.Var
import io.reisonic.devs.Presenter.Interfaces.MainInterface
import com.example.test.R
import io.reisonic.devs.Model.AdapterData.ContentProvider
import io.reisonic.devs.Presenter.Interfaces.SecondInterface
import io.reisonic.devs.View.Adapter.RVAdapter

class SecondActivity:AppCompatActivity(), SecondInterface{

    private lateinit var recyclerView: RecyclerView
    private var timer:Long = 250

    private val provider = ContentProvider()
    private var adapter = RVAdapter()
    private val handler = Handler()
    val runnable = { fillAdapter(adapter, recyclerView, provider); scheduleReload(timer)}

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val refresh = findViewById<ImageButton>(R.id.imageButton2)
        val server_sort = findViewById<Button>(R.id.button4)
        val by_date_sort = findViewById<Button>(R.id.button5)
        recyclerView = findViewById(R.id.rv)
        val llm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = llm
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        runnable()
        timer = 10000


        server_sort.setOnClickListener {
            Var.switch_line = 0
            updateData(Var.switch_line,adapter, recyclerView)
        }

        by_date_sort.setOnClickListener {
            Var.switch_line = 1
            updateData(Var.switch_line,adapter, recyclerView)
        }

        refresh.setOnClickListener {
            updateData(adapter, recyclerView, provider)
        }
    }

    private fun scheduleReload(timer:Long) {
        handler.postDelayed(runnable, timer)
    }


}