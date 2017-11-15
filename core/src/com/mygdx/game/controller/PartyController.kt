package com.mygdx.game.controller

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.mygdx.game.model.GoModel
import com.mygdx.game.model.PartySettings
import com.mygdx.game.view.View
import java.util.*

class PartyController(private val view: View) {

    var partySettings: PartySettings
    val model: GoModel

    init {
        partySettings = PartySettings(11, 11)
        model = GoModel(partySettings)

        fill()
    }

    fun start() {}

    fun handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            model.addStone(Random().nextInt(model.board.value.width),
                    Random().nextInt(model.board.value.height))
        }
    }

    private fun fill(){
        model.addStone(0, 0)
        model.addStone(2, 2)
        model.addStone(4, 5)
        model.addStone(10, 10)
        model.addStone(0, 10)
    }
}