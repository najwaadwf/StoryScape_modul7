package com.example.uts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val youtube = findViewById<Button>(R.id.button)
        youtube.setOnClickListener {
            val url = "https://mizanstore.com/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
            }

        val novel = intent.getParcelableExtra<NovelClass>(MainActivity.INTENT_PARCELABLE)

        val novelimg = findViewById<ImageView>(R.id.image)
        val novelname = findViewById<TextView>(R.id.tv_name)
//        val novelrate = findViewById<TextView>(R.id.tv_rating)
//        val ratingbar = findViewById<RatingBar>(R.id.ratingbar)
        val noveldesc = findViewById<TextView>(R.id.tv_description)

        novelimg.setImageResource(novel?.novelimg!!)
        novelname.text = novel.novelname
//        novelrate.text = novel.novelrate
//        ratingbar.rating = novel.ratingbar.toFloat()
        noveldesc.text = novel.noveldesc
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}