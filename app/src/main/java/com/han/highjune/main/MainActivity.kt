package com.han.highjune.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.view.updatePadding
import androidx.fragment.app.commitNow
import com.google.android.material.appbar.AppBarLayout
import com.han.highjune.R
import com.han.highjune.Util.EdgeToEdge

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configure edge-to-edge display.
        EdgeToEdge.setUpRoot(findViewById(R.id.root))
        EdgeToEdge.setUpAppBar(findViewById(R.id.app_bar), toolbar)

        // Set up the fragment.
        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                replace(R.id.container, MainFragment())
            }
        }
    }
}
