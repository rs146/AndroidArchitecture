package uk.co.mycompany.di.main

import dagger.Component
import uk.co.mycompany.di.AppComponent
import uk.co.mycompany.di.scope.MainActivityScope
import uk.co.mycompany.ui.MainActivity

@MainActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
}