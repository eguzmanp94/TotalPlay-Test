package com.legp.totalplaytest.mvp.presenter

import com.legp.totalplaytest.app.preferences
import com.legp.totalplaytest.mvp.core.clientapi.ServicesManager
import com.legp.totalplaytest.mvp.core.clientapi.callbacks.ILoginRequest
import com.legp.totalplaytest.mvp.core.clientapi.callbacks.IReferencesRequest
import com.legp.totalplaytest.mvp.model.SessionModel
import com.legp.totalplaytest.mvp.model.response.BankModel
import com.legp.totalplaytest.mvp.presenter.view.LoginView
import com.legp.totalplaytest.mvp.presenter.view.MainView

class MainActivityPresenter(mainView: MainView) : BasePresenter<MainView>(mainView) {


    fun getReferences(token: String) {

        view.showLoading()
        var mRequest = SessionModel(token)

        ServicesManager().callReferences(mRequest, object : IReferencesRequest {
            override fun success(arrayReferences: ArrayList<BankModel>) {
                view.hideLoading()
                view.setAdapter(arrayReferences)
            }

            override fun error(session: SessionModel) {
                view.hideLoading()
                view.showErrorMessage(session.session)
            }

        })


    }


}