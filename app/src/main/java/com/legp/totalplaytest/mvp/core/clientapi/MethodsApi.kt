package com.legp.totalplaytest.mvp.core.clientapi

import com.legp.totalplaytest.mvp.model.SessionModel
import com.legp.totalplaytest.mvp.model.request.LoginModel
import com.legp.totalplaytest.mvp.model.response.BankReferencesModel
import com.legp.totalplaytest.utils.Constantes
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

interface MethodsApi {

    @POST(Constantes.LOGIN)
    fun loginUser(@Body mRequest: LoginModel): Call<SessionModel>

    @POST(Constantes.GET_REFERENCES)
    fun getReferences(@Body mRequest: SessionModel): Call<BankReferencesModel>
}