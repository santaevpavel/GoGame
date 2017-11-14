package com.mygdx.game.view.stage

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.mygdx.game.model.Player

class Stone : Actor() {

    var player: Player
    private var texture: Texture

    init {
        player = Player.WHITE

        val pixmap = Pixmap(100, 100, Pixmap.Format.RGBA8888)
        pixmap.setColor(Color.WHITE)
        pixmap.fillCircle(50, 50, 50)
        texture = Texture(pixmap)
    }

    override fun act(delta: Float) {
        super.act(delta)
    }

    override fun draw(batch: Batch, parentAlpha: Float) {
        super.draw(batch, parentAlpha)
        batch.draw(texture, x, y, width, height,
                0, 0, texture.width, texture.height, false, false)
    }
}
