package com.mygdx.game

import com.badlogic.gdx.Game
import com.mygdx.game.controller.PartyController
import com.mygdx.game.view.GoPartyScreen

class GoGame : Game() {

    override fun create() {
        val goPartyScreen = GoPartyScreen()
        setScreen(goPartyScreen)

        val partyController = PartyController(goPartyScreen)
        partyController.start()
    }

    override fun dispose() {}
}
