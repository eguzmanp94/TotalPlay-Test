package com.legp.totalplaytest.mvp.core.dagger.components

import com.legp.totalplaytest.mvp.core.dagger.modules.ContextModule
import com.legp.totalplaytest.mvp.core.dagger.modules.PreferencesModule
import com.legp.totalplaytest.mvp.presenter.LoginActivityPresenter
import com.legp.totalplaytest.mvp.presenter.view.BaseView
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton



@Singleton
@Component(modules = [(ContextModule::class)])
interface PresenterInjector {

    fun inject(loginActivityPresenter: LoginActivityPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun contextModule(contextModule: ContextModule): Builder
        fun preferencesModule(preferencesModule: PreferencesModule): Builder
        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }

}