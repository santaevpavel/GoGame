package com.mygdx.game.view.stage

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.Viewport
import com.mygdx.game.model.GoModel
import com.mygdx.game.model.GoPoint

class GoStage(viewport: Viewport) : Stage(viewport) {

    override fun act(delta: Float) {
        super.act(delta)
    }

    fun updateBoard(goModel: GoModel){
        clear()

        val board = goModel.board.value

        val stoneSize = Math.min(width, height) / board.width
        for (x in 0 until board.width){
            for (y in 0 until board.height){

                val goPoint = board.getGoPoint(x, y)
                if (goPoint != GoPoint.EMPTY){
                    val stone = Stone()
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
