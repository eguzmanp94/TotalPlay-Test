package com.legp.totalplaytest.mvp.presenter.view

import com.legp.totalplaytest.mvp.model.response.BankModel

interface MainView : BaseView{


    fun setAdapter(arrayReferences: ArrayList<BankModel>)
}