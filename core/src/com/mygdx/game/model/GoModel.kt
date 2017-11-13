package com.mygdx.game.model

public class GoModel(var partySettings: PartySettings) {

    var board: Board
        private set
    var currentPlayer: Player = Player.WHITE
        private set(value){ field = value}


    init {
        board = Board(partySettings.boardWidth, partySettings.boardHeight)
        currentPlayer = Player.WHITE
    }

    fun addStone(x: Int, y: Int){
        if (board.getGoPoint(x, y) == GoPoint.EMPTY){
            board.setGoPoint(x, y, currentPlayer.getStone())
            currentPlayer = currentPlayer.getOpposite()
        }
    }
}

public enum class Player{
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