package com.legp.totalplaytest.mvp.view.activities

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.legp.totalplaytest.mvp.presenter.BasePresenter
import com.legp.totalplaytest.mvp.presenter.view.BaseView
import com.legp.totalplaytest.utils.AlertsLoading
import com.legp.totalplaytest.utils.AlertsMessage

abstract class BaseActivity<P : BasePresenter<BaseView>> : BaseView, ToolbarActivity() {
    protected lateinit var presenter: P

    protected abstract fun instantiatePresenter(): P
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun showLoading() {
        AlertsLoading.showDialogLoading(this)
    }

    override fun hideLoading() {
        AlertsLoading.hidenDialogLoading(this)
    }


    override fun showErrorMessage(message: String) {
        AlertsMessage.showError(this, message)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun getContext(): Context {
        return this
    }


}