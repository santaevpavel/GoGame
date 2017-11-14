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

        fill()
    }

    fun start(){
        view.onModelChanged(model)
    }

    private fun fill(){
        model.addStone(0, 0)
        model.addStone(2, 2)
        model.addStone(4, 5)
        model.addStone(10, 10)
        model.addStone(0, 10)
    }
}