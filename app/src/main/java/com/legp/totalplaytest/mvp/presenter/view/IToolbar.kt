package com.legp.totalplaytest.mvp.presenter.view

import androidx.appcompat.widget.Toolbar

interface IToolbar {

    fun toolbarToLoad(toolbar: Toolbar)
    fun enableHomeDisplay(value: Boolean)
}