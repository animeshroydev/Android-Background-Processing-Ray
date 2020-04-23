package com.raywenderlich.android.rwdc2018.service

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import com.raywenderlich.android.rwdc2018.app.PhotosUtils

// create an IntentService to download the photos JSON file in PhotosRepository
// and use a BroadcastReceiver to listen for completion of the download.
// Then update the live data
class FetchIntentService : IntentService("fetchIntentService") {

   companion object {
       private const val TAG = "FetchIntentService"
       private const val ACTION_FETCH = "ACTION_FETCH"
       const val FETCH_COMPLETE = "FETCH_COMPLETE"

       fun startActionFetch(context: Context) {
           val intent = Intent(context, FetchIntentService::class.java).apply {
               action = ACTION_FETCH
           }
           context.startService(intent)
       }
   }

    override fun onHandleIntent(intent: Intent?) {
        when(intent?.action) {
            ACTION_FETCH -> {
                handleActionFetch()
            }
        }
    }

    private fun handleActionFetch() {
        try {
            PhotosUtils.fetchJsonString()
        } catch (e: InterruptedException) {
            Log.e(TAG, "Error Downloading JSON: " + e.message)
        }
        broadcastFetchComplete()
    }

    private fun broadcastFetchComplete() {
        val intent = Intent(FETCH_COMPLETE)
        LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent)
    }
}
