package uk.co.mycompany.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.mycompany.R
import uk.co.mycompany.di.InjectHelper
import uk.co.mycompany.di.main.DaggerMainActivityComponent
import uk.co.mycompany.di.main.MainActivityModule
import uk.co.mycompany.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    @Inject lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (InjectHelper.appComponent == null) {
            Log.d("MainAct", "its null")
        }

        DaggerMainActivityComponent.builder()
                .appComponent(InjectHelper.appComponent)
                .mainActivityModule(MainActivityModule(this))
                .build().inject(this)

        button.setOnClickListener({ _ ->
            compositeDisposable.add(mainViewModel.showDataFromApiAndUser()
                    .subscribeBy(
                            onSuccess = {
                                textView.text = "${it.ipAddress.ip} and ${it.person.firstName} ${it.person.surname}"
                            },
                            onError = {
                                Log.d("MainActivity", it.message)
                            }))
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
