package com.mygdx.game.utils

typealias Observer<T> = (T) -> Unit

class ObservableField<T>(initValue: T) {

    var value: T = initValue
        set(value) {
            field = value
            notifySubscribers()
        }

    private val observers: MutableList<Observer<T>> = ArrayList()

    fun observe(observer: Observer<T>) {
        observers.add(observer)
    }

    fun remove(observer: Observer<T>) {
        observers.remove(observer)
    }

    fun notifySubscribers() {
        observers.forEach {
            it(value)
        }
    }
}

