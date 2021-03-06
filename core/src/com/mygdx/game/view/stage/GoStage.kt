package com.mygdx.game.view.stage

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.Viewport
import com.mygdx.game.model.IModel
import com.mygdx.game.model.Player
import com.mygdx.game.model.board.GoPoint

class GoStage(viewport: Viewport) : Stage(viewport) {

    var boardWidth: Int = 0
    var boardHeight: Int = 0

    override fun act(delta: Float) {
        super.act(delta)
    }

    fun updateBoard(model: IModel) {
        clear()

        val boardActor = BoardActor(boardWidth, boardHeight)
        val size: Float = Math.min(width, height)
        boardActor.x = (width - size) / 2
        boardActor.y = (height - size) / 2
        boardActor.width = size
        boardActor.height = size

        addActor(boardActor)

        val board = model.board.value

        val stoneSize = Math.min(width, height) / board.width
        for (x in 0 until board.width){
            for (y in 0 until board.height){

                val goPoint = board.getGoPoint(x, y)
                if (goPoint != GoPoint.EMPTY){
                    val stone = Stone()
                    stone.player = if (goPoint == GoPoint.WHITE_STONE) Player.WHITE else Player.BLACK
                    stone.width = stoneSize
                    stone.height = stoneSize

                    stone.x = stoneSize * x
                    stone.y = stoneSize * y

                    addActor(stone)
                }

            }
        }
    }
}
