package com.legp.totalplaytest.mvp.presenter.view

import android.content.Context

interface BaseView {

    fun getContext(): Context

    fun showLoading()
    fun hideLoading()
    fun showErrorMessage(message: String)
fun showToast(message:String)
}