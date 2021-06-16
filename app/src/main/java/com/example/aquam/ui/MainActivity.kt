package com.example.aquam.ui

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorCompat
import androidx.core.widget.ContentLoadingProgressBar
import com.example.aquam.R
import com.example.aquam.base.BaseView


class MainActivity : AppCompatActivity(), BaseView {
    private val STARTUP_DELAY = 200L
    private val ANIM_ITEM_DURATION = 1000L

    private val progressBar: ContentLoadingProgressBar by lazy { findViewById(R.id.progress_bar) }

    var animationStarted: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (!hasFocus || animationStarted) return
        animate()
        super.onWindowFocusChanged(hasFocus)
    }

    private fun animate() {
        val logoImageView: ImageView = findViewById<View>(R.id.img_logo) as ImageView
        logoImageView.visibility = View.GONE
        ViewCompat.animate(logoImageView)
            .alpha(0f)
            .translationY(-250f)
            .setStartDelay(STARTUP_DELAY)
            .setDuration(ANIM_ITEM_DURATION).setInterpolator(
                DecelerateInterpolator(1.2f)
            ).start()

        animationStarted = true
        setTheme(R.style.Theme_Aquam)
    }

    override fun showProgressDialog() {
        progressBar.show()
    }

    override fun hideProgressDialog() {
        progressBar.hide()
    }
}
