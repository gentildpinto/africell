package me.gentilpinto.africell.view.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.appcompat.widget.Toolbar
import com.smarteist.autoimageslider.SliderView
import me.gentilpinto.africell.R
import androidx.appcompat.R as Res
import me.gentilpinto.africell.view.adapter.SliderAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var toolbarView: Toolbar
    private lateinit var resImages: List<Int>
    private lateinit var sliderView: SliderView
    private lateinit var sliderAdapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.navigationBarColor = getColorFromAttr(Res.attr.background)

        initComponents()
        setSupportActionBar(toolbarView)
        setupSlider()
    }

    @ColorInt
    fun Context.getColorFromAttr(
        @AttrRes attrColor: Int, typedValue: TypedValue = TypedValue(), resolveRefs: Boolean = true
    ): Int {
        theme.resolveAttribute(attrColor, typedValue, resolveRefs)
        return typedValue.data
    }

    private fun initComponents() {
        toolbarView = findViewById(R.id.toolbar)
        sliderView = findViewById(R.id.imageSlider)
    }

    private fun setupSlider() {
        resImages = ArrayList<Int>().apply {
            addAll(
                listOf<Int>(
                    R.drawable.zuleica_banner,
                    R.drawable.igor_banner,
                    R.drawable.tatiana_banner,
                    R.drawable.snoop_banner
                )
            )

        }
        sliderAdapter = SliderAdapter(resImages)
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.startAutoCycle()
    }
}