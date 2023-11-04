package org.alexcawl.memorize

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.alexcawl.memorize.newsline.ui.base.NewsFragment
import org.alexcawl.memorize.ui.replace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, NewsFragment::class.java).commit()
    }
}