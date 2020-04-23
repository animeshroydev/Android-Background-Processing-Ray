# Android-Background-Processing-Ray
**Master branch** (Starter Project) - Android Background Processing

## PhotosFragment
**ThreadsAndAsyncTask branch** - Showed how to run tasks on background using Thread and Runnable. Also how to do the same using AsyncTask.

**JobSchedulerAndWorkManager** branch - In package services -> PhotosJobService showed how to use JobScheduler to download the JSON and DownloadWorker class showd how to use New JetPack component that is WorkManager to do the same stuff.  

## SongFragment
**AndroidServicesAndBroadcastReceiver** branch - Android service class is a high level android component that perform long running apction that don't require a user interface. Also worked with specific type of service name **IntentService**(perform single long running task on background thread).

This branch also uses broadcast receiver to alert other app component like an activity of event that occures in the service. **In this app we use Intent Service to download song file. Now the app downloads the media file in the background user/UI is still not notified that song to be played. We need Intent Service to communicate back to our fragment that the download is complete for that we use broadcast receiver** Also gonna use a **Foreground Service** to play music while app is in the background and keeps a notification in the foreground so that the user aware that running service. 

In this branch I also used IntentService to download the photos JSON file in PhotosRepository and use a BroadcastReceiver to listen for completion of the download. Then update the live data instead of using it with WorkManager. The advantage of using IntentService is that it reflect the changes of JSON data immediately and loads the image quicky if data changed.

# Things that convered in the App(including all branches):
1. Threads, Runnable
2. AsyncTask
3. JobScheduler, JobService
4. WorkManager (new Jetpack component)
5. Intent Service
6. Foreground Service, Show Notification
