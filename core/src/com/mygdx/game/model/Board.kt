package com.mygdx.game.model

class Board(
        val height: Int,
        val width: Int) {

    private val board: MutableList<GoPoint>

    init {
        board = ArrayList(height * width)
        for (i in (0..height * width)){
            board.add(0, GoPoint.EMPTY)
        }
    }

    fun getGoPoint(x: Int, y: Int): GoPoint {
        checkCoordinates(x, y)
        return board[y * width + x]
    }

    fun setGoPoint(x: Int, y: Int, goPoint: GoPoint) {
        checkCoordinates(x, y)
        board[y * width + x] = goPoint
    }

    fun isInBoard(x: Int, y: Int): Boolean{
        return x in 0..(width - 1) && y in 0..(height - 1)
    }

    private fun checkCoordinates(x: Int, y: Int){
        if (!isInBoard(x, y)){
            throw IllegalArgumentException("Invalid coordinates: $x $y")
        }
    }
}

enum class GoPoint{
    EMPTY,
    WHITE_STONE,
    BLACK_STONE
}