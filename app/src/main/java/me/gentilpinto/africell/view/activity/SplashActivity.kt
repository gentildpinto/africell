package me.gentilpinto.africell.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.TypedValue
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import me.gentilpinto.africell.R
import androidx.appcompat.R as Res
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

const val SPLASH_DURATION = 10

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private val handler: Handler = Handler(Looper.getMainLooper())
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.statusBarColor = getColorFromAttr(Res.attr.colorPrimary)
        window.navigationBarColor = getColorFromAttr(Res.attr.colorPrimary)

        initComponents()
        executeProgress()
    }

    @ColorInt
    fun Context.getColorFromAttr(
        @AttrRes attrColor: Int, typedValue: TypedValue = TypedValue(), resolveRefs: Boolean = true
    ): Int {
        theme.resolveAttribute(attrColor, typedValue, resolveRefs)
        return typedValue.data
    }

    private fun initComponents() {
        progressBar = findViewById(R.id.progressBar)
    }


    private fun executeProgress() {
        executor.execute {
            progressBar.visibility = View.VISIBLE
            for (index: Int in 0..SPLASH_DURATION) {
                progressBar.progress = index
                Thread.sleep(500)
            }
            handler.post {
                progressBar.visibility = View.INVISIBLE

                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }
}