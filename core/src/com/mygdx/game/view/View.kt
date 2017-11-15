package com.mygdx.game.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.viewport.FitViewport
import com.mygdx.game.model.IModel
import com.mygdx.game.view.stage.GoStage

class View(private val model: IModel) : IView {

    private val camera: OrthographicCamera
    private val goStage: GoStage

    init {
        // Init camera
        camera = OrthographicCamera()
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT)
        camera.zoom = 1f

        // Init stage
        goStage = GoStage(FitViewport(WORLD_WIDTH, WORLD_HEIGHT))

        model.board.observe({ goStage.updateBoard(model) })
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