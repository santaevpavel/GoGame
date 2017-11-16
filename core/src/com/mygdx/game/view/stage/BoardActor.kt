package com.mygdx.game.view.stage

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor

class BoardActor(width: Int, height: Int) : Actor() {

    private var texture: Texture

    init {
        val pixmap = Pixmap(500, 500, Pixmap.Format.RGBA8888)
        pixmap.setColor(Color.GRAY)
        pixmap.fillRectangle(0, 0, pixmap.width, pixmap.height)

        pixmap.setColor(Color.BLACK)

        val cellWidth = pixmap.width.toFloat() / width
        val cellHeight = pixmap.height.toFloat() / height

        for (x in 0 until width) {
            val lineX = ((x + 0.5f) * cellWidth).toInt()
            pixmap.drawLine(
                    lineX,
                    (cellHeight / 2).toInt(),
                    lineX,
                    (pixmap.height - cellHeight / 2).toInt()
            )
        }
        for (y in 0 until height) {
            val lineY = ((y + 0.5f) * cellHeight).toInt()
            pixmap.drawLine(
                    (cellWidth / 2).toInt(),
                    lineY,
                    (pixmap.width - cellWidth / 2).toInt(),
                    lineY
            )
        }

        texture = Texture(pixmap)
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
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