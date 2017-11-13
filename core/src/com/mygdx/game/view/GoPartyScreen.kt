package com.mygdx.game.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.viewport.FitViewport
import com.mygdx.game.view.stage.GoStage

class GoPartyScreen : Screen, View {

    private val camera: OrthographicCamera
    private val goStage: GoStage

    init {
        // Init camera
        camera = OrthographicCamera()
        camera.setToOrtho(false, WIDTH, HEIGHT)
        camera.zoom = 1f

        // Init stage
        goStage = GoStage(FitViewport(WIDTH, HEIGHT))
    }

    override fun hide() {}

    override fun show() {}

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    override fun pause() {}

    override fun resume() {}

    override fun resize(width: Int, height: Int) {}

    override fun dispose() {}

    override fun onModelChanged() {

    }

}
