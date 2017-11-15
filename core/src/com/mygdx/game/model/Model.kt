package com.mygdx.game.model

import com.mygdx.game.model.board.Board
import com.mygdx.game.model.board.GoPoint
import com.mygdx.game.model.board.IBoard
import com.mygdx.game.utils.ObservableField

class Model(var partySettings: PartySettings) : IModel {

    override val width: Int
        get() = board.value.width
    override val height: Int
        get() = board.value.height
    override lateinit var board: ObservableField<IBoard>
    override var currentPlayer: Player = Player.WHITE
    override val turnNumber: ObservableField<Int> = ObservableField(0)

    private var boardInternal: ObservableField<Board>

    init {
        boardInternal = ObservableField<Board>(Board(partySettings.boardWidth,
                partySettings.boardHeight))
        board = ObservableField<IBoard>(boardInternal.value)
        currentPlayer = Player.WHITE
    }

    override fun addStone(x: Int, y: Int): Boolean {
        if (boardInternal.value.getGoPoint(x, y) == GoPoint.EMPTY) {
            boardInternal.value.setGoPoint(x, y, currentPlayer.getStone())
            currentPlayer = currentPlayer.getOpposite()
        } else {
            return false
        }
        turnNumber.value++
        board.notifySubscribers()
        return true
    }
}