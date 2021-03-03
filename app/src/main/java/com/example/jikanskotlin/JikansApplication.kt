package com.example.jikanskotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JikansApplication : Application()

    /*
        Instead of grabbing dependencies on demand from the ServiceLocator in our classes,
        we'll use Hilt to provide those dependencies for us.

        to add a container that is attached to the app's lifecycle,
        we need to annotate the Application class with @HiltAndroidApp
     */


