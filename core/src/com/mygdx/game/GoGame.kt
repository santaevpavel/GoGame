package com.mygdx.game

import com.badlogic.gdx.Game
import com.mygdx.game.controller.GoPartyScreen

class GoGame : Game() {

    override fun create() {
        val goPartyScreen = GoPartyScreen()
        setScreen(goPartyScreen)
    }

    override fun dispose() {}
}
