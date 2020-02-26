package com.han.highjune.mediaPlayer

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import java.io.IOException


class MediaPlayerService : Service(), MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener,
    MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener,
    MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener,
    AudioManager.OnAudioFocusChangeListener {

    private var mediaPlayer: MediaPlayer? = null
    private var resumePosition = 0

    private val mBinder:MediaPlayerBinder = MediaPlayerBinder()
    inner class MediaPlayerBinder : Binder(){
        private var binder:MediaPlayerService = this@MediaPlayerService
    }
    override fun onBind(p0: Intent?): IBinder? {
      return mBinder
    }

    private fun initMediaPlayer(url:String) {
        mediaPlayer = MediaPlayer().apply {
            //Set up MediaPlayer event listeners
            setOnCompletionListener(this@MediaPlayerService)
            setOnErrorListener(this@MediaPlayerService)
            setOnPreparedListener(this@MediaPlayerService)
            setOnBufferingUpdateListener(this@MediaPlayerService)
            setOnSeekCompleteListener(this@MediaPlayerService)
            setOnInfoListener(this@MediaPlayerService)
            //Reset so that the MediaPlayer is not pointing to another data source
            reset()
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()
            )

            try { // Set the data source to the mediaFile location
                setDataSource(url)
            } catch (e: IOException) {
                e.printStackTrace()
                stopSelf()
            }
            prepareAsync()
        }
    }

    private fun playMedia() {
        if (!mediaPlayer!!.isPlaying) {
            mediaPlayer!!.start()
        }
    }

    private fun stopMedia() {
        if (mediaPlayer == null) return
        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
        }
    }

    private fun pauseMedia() {
        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
            resumePosition = mediaPlayer!!.currentPosition
        }
    }

    private fun resumeMedia() {
        if (!mediaPlayer!!.isPlaying) {
            mediaPlayer!!.seekTo(resumePosition)
            mediaPlayer!!.start()
        }
    }

    override fun onCompletion(p0: MediaPlayer?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPrepared(p0: MediaPlayer?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(p0: MediaPlayer?, p1: Int, p2: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSeekComplete(p0: MediaPlayer?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onInfo(p0: MediaPlayer?, p1: Int, p2: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBufferingUpdate(p0: MediaPlayer?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // 현재앱이나 다른앱의 service클래스에 우선순위가 뺏기거나 가저올때 작동한다.
    override fun onAudioFocusChange(p0: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}