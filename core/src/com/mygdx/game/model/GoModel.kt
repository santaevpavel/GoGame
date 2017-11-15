package com.mygdx.game.model

import com.mygdx.game.utils.ObservableField

class GoModel(var partySettings: PartySettings) {

    var board: ObservableField<Board>
        private set
    var currentPlayer: Player = Player.WHITE
        private set(value){ field = value}

    val turnNumber: ObservableField<Int> = ObservableField(0)

    init {
        board = ObservableField<Board>(Board(partySettings.boardWidth,
                partySettings.boardHeight))
        currentPlayer = Player.WHITE
    }

    fun addStone(x: Int, y: Int){
        if (board.value.getGoPoint(x, y) == GoPoint.EMPTY) {
            board.value.setGoPoint(x, y, currentPlayer.getStone())
            currentPlayer = currentPlayer.getOpposite()
        }
        turnNumber.value++
        board.notifySubscribers()
    }
}

enum class Player {
    BLACK,
    WHITE;

    fun getStone(): GoPoint{
        return when (this){
            BLACK -> GoPoint.BLACK_STONE
            WHITE -> GoPoint.WHITE_STONE
        }
    }

    fun getOpposite(): Player {
        return when (this){
            BLACK -> WHITE
            WHITE -> BLACK
        }
    }
}