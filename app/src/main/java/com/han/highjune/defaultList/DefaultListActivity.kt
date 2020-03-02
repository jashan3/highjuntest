package com.han.highjune.defaultList

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.commitNow
import androidx.transition.TransitionManager
import com.han.highjune.R
import com.han.highjune.Util.EdgeToEdge


class DefaultListActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.default_list_activity)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configure edge-to-edge display.
        EdgeToEdge.setUpRoot(findViewById(R.id.root))
        EdgeToEdge.setUpAppBar(findViewById(R.id.app_bar), toolbar)

        // Set up the fragment.
        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                replace(R.id.container, DefaultListFragment())
            }
        }
    }


}