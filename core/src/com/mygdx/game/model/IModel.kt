package com.mygdx.game.model

import com.mygdx.game.model.board.GoPoint
import com.mygdx.game.model.board.IBoard
import com.mygdx.game.utils.ObservableField

interface IModel {

    val width: Int
    val height: Int
    val board: ObservableField<IBoard>
    val currentPlayer: Player
    val turnNumber: ObservableField<Int>

    fun addStone(x: Int, y: Int): Boolean
}

enum class Player {
    BLACK,
    WHITE;

    fun getStone(): GoPoint {
        return when (this) {
            BLACK -> GoPoint.BLACK_STONE
            WHITE -> GoPoint.WHITE_STONE
        }
    }

    fun getOpposite(): Player {
        return when (this) {
            BLACK -> WHITE
            WHITE -> BLACK
        }
    }
}