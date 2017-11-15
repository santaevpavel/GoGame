package com.mygdx.game.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.utils.viewport.FitViewport
import com.mygdx.game.model.IModel
import com.mygdx.game.view.stage.GoStage

class View(private val model: IModel) : IView {

    override var listener: IOnAddStoneListener? = null

    private val camera: OrthographicCamera
    private val goStage: GoStage

    init {
        // Init camera
        camera = OrthographicCamera()
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT)
        camera.zoom = 1f

        // Init stage
        goStage = GoStage(FitViewport(WORLD_WIDTH, WORLD_HEIGHT))
        goStage.boardWidth = model.width
        goStage.boardHeight = model.height

        Gdx.input.inputProcessor = goStage
        model.board.observe({
            val listener: InputListener = object : InputListener() {

                override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                    val posX = x / (goStage.width / goStage.boardWidth)
                    val posY = y / (goStage.height / goStage.boardHeight)
                    listener?.invoke(posX.toInt(), posY.toInt())
                    return true
                }
            }

            goStage.updateBoard(model)
            goStage.addListener(listener)
        })

    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1f, 0.5f, 0.5f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera.update()

        goStage.act(delta)
        goStage.draw()
    }

    override fun resize(width: Int, height: Int) {
        goStage.viewport.update(width, height, true);
    }

    override fun dispose() {
        goStage.dispose()
    }

}