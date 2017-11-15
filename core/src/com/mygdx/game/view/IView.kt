package com.mygdx.game.view

internal var WORLD_WIDTH = 100f
internal var WORLD_HEIGHT = 100f

interface IView {

    fun render(delta: Float)
    fun resize(width: Int, height: Int)
    fun dispose()

    var listener: IOnAddStoneListener?
}

typealias IOnAddStoneListener = (x: Int, y: Int) -> Unit