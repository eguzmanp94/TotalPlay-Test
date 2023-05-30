package com.legp.totalplaytest.mvp.presenter

import com.legp.totalplaytest.app.preferences
import com.legp.totalplaytest.mvp.core.clientapi.ServicesManager
import com.legp.totalplaytest.mvp.core.clientapi.callbacks.ILoginRequest
import com.legp.totalplaytest.mvp.model.SessionModel
import com.legp.totalplaytest.mvp.model.request.LoginModel
import com.legp.totalplaytest.mvp.presenter.view.LoginView

class LoginActivityPresenter(loginView: LoginView) : BasePresenter<LoginView>(loginView) {


    fun loginUser(user: String, password: String) {

        var mRequest = LoginModel(user, password)
        view.showLoading()

        ServicesManager().callLogin(mRequest, object : ILoginRequest {
            override fun success(session: SessionModel) {
                view.hideLoading()
                preferences.token = session.session
                view.succesLogin()
            }

            override fun error(session: SessionModel) {
                view.hideLoading()
                view.showErrorMessage(session.session)
            }

        })


    }


}