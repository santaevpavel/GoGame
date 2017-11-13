package com.mygdx.game.controller

import com.mygdx.game.model.GoModel
import com.mygdx.game.model.PartySettings
import com.mygdx.game.view.View

public class PartyController(val view: View) {

    private val model: GoModel
    private var partySettings: PartySettings

    init {
        partySettings = PartySettings(11, 11)
        model = GoModel(partySettings)
    }
}