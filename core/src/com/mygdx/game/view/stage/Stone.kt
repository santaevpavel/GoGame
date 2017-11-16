package com.mygdx.game.view.stage

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Actor
import com.mygdx.game.model.Player

class Stone : Actor() {

    var player: Player = Player.WHITE
        set(value) {
            field = value
            texture = Texture(if (player == Player.WHITE) "stone_white.png" else "stone_black.png")
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)

            sprite = Sprite(texture)
        }
    private var texture: Texture
    private var sprite: Sprite? = null

    init {
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
        sprite?.setSize(width, height)
        sprite?.setPosition(x, y)
        sprite?.draw(batch)
    }
}
