package io.reisonic.devs.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reisonic.devs.Model.AdapterData.CardData
import io.reisonic.devs.Model.Variables.Var
import com.example.test.R
import io.reisonic.devs.View.Adapter.RVAdapter
import java.util.*

class FragmentMain:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment, null)
       /* val rv = root.findViewById<View>(R.id.rv) as RecyclerView
        val llm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv.layoutManager = llm
        rv.setHasFixedSize(true)
        initAdapter(rv)*/
        return root
    }

    /*private fun initAdapter(rv:RecyclerView) {
        val adapter = RVAdapter()
        adapter.items = Var.dataCard.sortedBy { it.id }
        rv.adapter = adapter
    }*/
}