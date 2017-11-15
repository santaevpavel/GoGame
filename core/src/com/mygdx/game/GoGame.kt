package com.mygdx.game

import com.badlogic.gdx.Game
import com.mygdx.game.controller.PartyController
import com.mygdx.game.view.GoPartyScreen

class GoGame : Game() {

    override fun create() {
        val goPartyScreen = GoPartyScreen()
        setScreen(goPartyScreen)

        val partyController = PartyController(goPartyScreen)
        goPartyScreen.controller = partyController
        goPartyScreen.model = partyController.model

        partyController.start()
    }

    override fun dispose() {}
}
