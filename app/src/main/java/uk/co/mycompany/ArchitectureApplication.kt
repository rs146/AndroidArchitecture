package uk.co.mycompany

import android.app.Application
import uk.co.mycompany.di.AppComponent
import uk.co.mycompany.di.AppModule
import uk.co.mycompany.di.DaggerAppComponent
import uk.co.mycompany.di.InjectHelper

class ArchitectureApplication: Application() {

    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        InjectHelper.getAppComponent(this).inject(this)
        InjectHelper.setApplication(this)
    }
}