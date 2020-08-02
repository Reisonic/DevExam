package io.reisonic.devs.Presenter.Interfaces

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import io.reisonic.devs.Model.Variables.Var

interface FinishInterface {

    fun initData(title: TextView, mini_title: TextView,
                 detailed_text: TextView, image: ImageView,context: Context){
        Glide.with(context).load(Var.image).into(image);
        title.text = Var.title
        mini_title.text = Var.title
        detailed_text.text = Var.detailed_text
    }
}