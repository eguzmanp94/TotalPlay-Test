package com.legp.totalplaytest.mvp.presenter


import com.legp.totalplaytest.mvp.core.dagger.components.PresenterInjector
import com.legp.totalplaytest.mvp.core.dagger.modules.ContextModule
import com.legp.totalplaytest.mvp.core.dagger.modules.PreferencesModule
import com.legp.totalplaytest.mvp.presenter.view.BaseView

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

//    private val injector: PresenterInjector = DaggerPresenterInjector()
//        .builder()
//        .baseView(view)
//        .contextModule(ContextModule)
//        .preferencesModule(PreferencesModule)
//        .build()


    init {
        inject()
    }


    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated() {}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed() {}

    private fun inject() {

        when (this) {
//            is LoginActivityPresenter -> injector.inject(this)
        }
    }


}