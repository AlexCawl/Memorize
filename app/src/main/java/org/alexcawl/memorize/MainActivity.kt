package org.alexcawl.memorize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.alexcawl.memorize.newsline.ui.CurrentNewsLineFragment
import org.alexcawl.memorize.ui.util.replace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO set previous fragment
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, CurrentNewsLineFragment::class.java)
            .commit()
    }
}