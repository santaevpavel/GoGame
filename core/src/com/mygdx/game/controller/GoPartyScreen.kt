package com.mygdx.game.controller

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.mygdx.game.model.IModel
import com.mygdx.game.model.Model
import com.mygdx.game.model.PartySettings
import com.mygdx.game.view.IView
import com.mygdx.game.view.View
import java.util.*

class GoPartyScreen : Screen {

    private var partySettings: PartySettings
    private val model: IModel
    private val view: IView

    init {
        partySettings = PartySettings(11, 11)
        model = Model(partySettings)

        view = View(model)
        view.listener = { x, y ->
            model.addStone(x, y)
        }

        fill()
    }

    override fun hide() {}

    override fun show() {}

    override fun render(delta: Float) {
        handleInput()

        view.render(delta)
    }

    override fun pause() {}

    override fun resume() {}

    override fun resize(width: Int, height: Int) {
        view.resize(width, height)
    }

    override fun dispose() {
        view.dispose()
    }

    private fun handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            model.addStone(Random().nextInt(model.board.value.width),
                    Random().nextInt(model.board.value.height))
        }
    }

    private fun fill() {
        model.addStone(0, 0)
        model.addStone(2, 2)
        model.addStone(4, 5)
        model.addStone(10, 10)
        model.addStone(0, 10)
    }

}
