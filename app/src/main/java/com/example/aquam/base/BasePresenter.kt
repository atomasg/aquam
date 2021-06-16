package com.example.aquam.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

interface BasePresenter<View : BaseView> : LifecycleObserver {
    var view: View?
    var viewLifecycle: Lifecycle?

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun attachView(view: View, viewLifecycle: Lifecycle?) {
        this.view = view
        this.viewLifecycle = viewLifecycle
        viewLifecycle?.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onViewDestroyed() {
        view = null
        viewLifecycle = null
    }
}