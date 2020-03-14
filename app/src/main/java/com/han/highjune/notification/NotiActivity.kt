package com.han.highjune.notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.han.highjune.R
import com.han.highjune.Util.EdgeToEdge
import com.han.highjune.ViewModelList.VMListViewModel
import com.han.highjune.model.NotiModel

class NotiActivity : AppCompatActivity() {

    private val viewModel: NotiViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.noti_activity)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configure edge-to-edge display.
        EdgeToEdge.setUpRoot(findViewById(R.id.root))
        EdgeToEdge.setUpAppBar(findViewById(R.id.app_bar), toolbar)

        val notirv :RecyclerView = findViewById(R.id.recycle_view)
        val adapter = NotiAdapter { noti ->
            Log.d("asdf","## id : ${noti.notiID} , title : ${noti.notiTitle}, body : ${noti.notiExplain}")
            when(noti.notiID){
                "noti1"->defaultNotification()
            }
        }
        notirv.adapter = adapter

        viewModel.noti.observe(this){list: List<NotiModel> ->
            adapter.submitList(list)
        }
    }


    private fun defaultNotification(){
        NotificationHandler(this).apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel()
            }
            showNotification("제목","바디")
        }
    }

    private fun makePendingIntent(c:Context):PendingIntent{
        val i = Intent(c,)
    }
}