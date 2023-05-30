package com.legp.totalplaytest.mvp.core.clientapi

import com.legp.totalplaytest.mvp.core.clientapi.callbacks.ILoginRequest
import com.legp.totalplaytest.mvp.core.clientapi.callbacks.IReferencesRequest
import com.legp.totalplaytest.mvp.model.SessionModel
import com.legp.totalplaytest.mvp.model.request.LoginModel
import com.legp.totalplaytest.mvp.model.response.BankReferencesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServicesManager {

    fun callLogin(mRequest:LoginModel, callbacks: ILoginRequest){
        val call: Call<SessionModel> =
            ApiAdapter.ServicesManager().loginUser(mRequest)
        call.enqueue(object : Callback<SessionModel> {
            override fun onResponse(
                call: Call<SessionModel>,
                response: Response<SessionModel>
            ) {
                if (response.isSuccessful) {
                    callbacks.success(response.body()!!)
                } else {
                    callbacks.error(response.body()!!)
                }
            }
            override fun onFailure(call: Call<SessionModel>, t: Throwable) {

                callbacks.error(SessionModel(t.message!!))
            }
        })
    }



    fun callReferences(mRequest:SessionModel, callbacks: IReferencesRequest){
        val call: Call<BankReferencesModel> =
            ApiAdapter.ServicesManager().getReferences(mRequest)
        call.enqueue(object : Callback<BankReferencesModel> {
            override fun onResponse(
                call: Call<BankReferencesModel>,
                response: Response<BankReferencesModel>
            ) {
                if (response.isSuccessful) {
                    var body =  response.body()!!
                    if(body.status == 0) {
                        callbacks.success(body.arrayReferences)
                    }else{
                        callbacks.error(SessionModel("Ha ocurrido un error"))
                    }
                } else {
                    callbacks.error(SessionModel(response.message()))
                }
            }
            override fun onFailure(call: Call<BankReferencesModel>, t: Throwable) {

                callbacks.error(SessionModel(t.message!!))
            }
        })
    }





}