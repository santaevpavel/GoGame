package com.mygdx.game.view

import com.mygdx.game.model.GoModel

internal var WORLD_WIDTH = 100f
internal var WORLD_HEIGHT = 100f

public interface View {

    fun onModelChanged(goModel: GoModel)

}