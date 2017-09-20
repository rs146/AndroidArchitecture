package uk.co.mycompany.di

import android.content.Context
import uk.co.mycompany.ArchitectureApplication

object InjectHelper {

    var architectureApplication: ArchitectureApplication? = null

    val appComponent: AppComponent?
        get() = architectureApplication?.appComponent

    fun setApplication(application: ArchitectureApplication) {
        architectureApplication = application
    }

    fun getAppComponent(context: Context): AppComponent =
            (context.applicationContext as ArchitectureApplication).appComponent!!
}