package com.widi_19102215.praktikum6

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.widi_19102215.praktikum6.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_scrolling.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_MYDATA = "extra_mydata"
    }
    inline fun <reified T : Parcelable> Activity.getParcelableExtra(key: String) = lazy {
        intent.getParcelableExtra<T>(key)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        val myData by getParcelableExtra<MyData.MyData>(DetailActivity.EXTRA_MYDATA)
        supportActionBar?.title = myData?.name.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_detail_description.text = myData?.description.toString()

        Glide.with(this)
            .load(myData?.photo.toString())
            .apply(RequestOptions().override(700, 700))
            .into(iv_detail_photo)

        binding.fab.setOnClickListener { view ->
            val moveWithObjectIntent = Intent(this, MapsActivity::class.java)
            moveWithObjectIntent.putExtra(MapsActivity.EXTRA_MYDATA, myData)
            startActivity(moveWithObjectIntent)

        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}