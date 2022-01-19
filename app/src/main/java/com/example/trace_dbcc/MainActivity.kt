package com.example.trace_dbcc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    val SPLASH_SCREEN = 5000
    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation
    private lateinit var logoimage: ImageView
    private lateinit var title_text: TextView
    private lateinit var description_text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.hide()

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        logoimage = findViewById(R.id.logoimage)
        title_text = findViewById(R.id.title_text)
        description_text = findViewById(R.id.description_text)

        logoimage.animation = topAnimation
        title_text.animation = bottomAnimation
        description_text.animation = bottomAnimation

        Handler().postDelayed({

        var n : Intent = Intent(this,Dashboard ::class.java)
            startActivity(n)
            finish()
        }, SPLASH_SCREEN.toLong())
    }
}
