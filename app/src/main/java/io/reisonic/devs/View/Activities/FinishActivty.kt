package io.reisonic.devs.View.Activities

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import io.reisonic.devs.Model.Variables.Var
import com.example.test.R
import io.reisonic.devs.Presenter.Interfaces.FinishInterface

class FinishActivty: AppCompatActivity(),FinishInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finish_activity)

        val mini_title = findViewById<TextView>(R.id.textView)
        val detailed_text = findViewById<TextView>(R.id.textView2)
        val title = findViewById<TextView>(R.id.textView3)
        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        val image = findViewById<ImageView>(R.id.imageView)

        imageButton.setOnClickListener {
            onBackPressed()
        }
        initData(title,mini_title,detailed_text,image,this)
    }
}