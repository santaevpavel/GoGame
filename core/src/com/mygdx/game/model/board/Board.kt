package com.mygdx.game.model.board

class Board(
        override val height: Int,
        override val width: Int) : IBoard {

    private val board: MutableList<GoPoint>

    init {
        board = ArrayList(height * width)
        for (i in (0..height * width)){
            board.add(0, GoPoint.EMPTY)
        }
    }

    override fun getGoPoint(x: Int, y: Int): GoPoint {
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