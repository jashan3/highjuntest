package com.han.highjune.ViewModelList

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.commitNow
import androidx.transition.TransitionManager
import com.han.highjune.R
import com.han.highjune.Util.EdgeToEdge
import com.han.highjune.Util.Parser
import com.han.highjune.defaultList.DefaultListFragment



class VMActivitiy : AppCompatActivity(){

    private val viewModel: VMListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vm_list_activity)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configure edge-to-edge display.
        EdgeToEdge.setUpRoot(findViewById(R.id.root))
        EdgeToEdge.setUpAppBar(findViewById(R.id.app_bar), toolbar)

        // Set up the fragment.
        Parser.getAlbumList(this,"DefaultList")
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.loading, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_refresh -> {

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}