package org.alexcawl.memorize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(org.alexcawl.memorize.newsline.R.layout.fragment_news_line)
    }
}