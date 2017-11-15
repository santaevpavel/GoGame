package com.mygdx.game.model.board

interface IBoard {

    val width: Int
    val height: Int

    fun getGoPoint(x: Int, y: Int): GoPoint
}

enum class GoPoint {
    EMPTY,
    WHITE_STONE,
    BLACK_STONE
}