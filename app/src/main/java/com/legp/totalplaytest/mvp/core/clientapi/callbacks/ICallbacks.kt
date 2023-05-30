package com.legp.totalplaytest.mvp.core.clientapi.callbacks

import com.legp.totalplaytest.mvp.model.SessionModel
import com.legp.totalplaytest.mvp.model.response.BankModel
import com.legp.totalplaytest.mvp.model.response.BankReferencesModel

interface ILoginRequest {
    fun success(session: SessionModel)
    fun error(session: SessionModel)
}

interface IReferencesRequest {
    fun success(arrayReferences: ArrayList<BankModel>)
    fun error(session: SessionModel)
}

