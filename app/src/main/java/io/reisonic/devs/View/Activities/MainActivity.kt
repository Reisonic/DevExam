package io.reisonic.devs.View.Activities

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import io.reisonic.devs.Model.Database.UserDatabase
import io.reisonic.devs.Presenter.Interfaces.MainInterface
import io.reisonic.devs.Model.Variables.Var
import com.example.test.R

class MainActivity : AppCompatActivity(),
    MainInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<EditText>(R.id.editTextTextPersonName)
        val password = findViewById<EditText>(R.id.editTextTextPersonName2)
        val sign_up = findViewById<Button>(R.id.button)
        val image = findViewById<ImageView>(R.id.imageView2)

        Glide.with(this).load(R.drawable.logo_group).into(image)
        val db = UserDatabase(this)
        Thread{
            getDataDatabase(db,this,login,password)
        }.start()
        sign_up.setOnClickListener {
            getPosts(login, password, Intent(this, SecondActivity::class.java),this,db)
        }
    }
}