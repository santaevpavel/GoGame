package com.mygdx.game.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.viewport.FitViewport
import com.mygdx.game.controller.PartyController
import com.mygdx.game.model.IModel
import com.mygdx.game.view.stage.GoStage

class GoPartyScreen : Screen, View {

    var controller: PartyController? = null
    var model: IModel? = null
        set(value) {
            field = value
            value?.board?.observe {
                goStage.updateBoard(value)
            }

            value?.turnNumber?.observe { }
        }

    private val camera: OrthographicCamera
    private val goStage: GoStage

    init {
        // Init camera
        camera = OrthographicCamera()
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT)
        camera.zoom = 1f

        // Init stage
        goStage = GoStage(FitViewport(WORLD_WIDTH, WORLD_HEIGHT))

    }

    override fun hide() {}

    override fun show() {}

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        controller?.handleInput()

        camera.update()

        goStage.act(delta)
        goStage.draw()
    }

    override fun pause() {}

    override fun resume() {}

    override fun resize(width: Int, height: Int) {
        goStage.viewport.update(width, height, true);
    }

    override fun dispose() {
        goStage.dispose()
    }

}
