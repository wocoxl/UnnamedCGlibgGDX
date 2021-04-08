package com.mygdx.game.GameLogic.Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class UIHelper {
    public static int Help_Guides = 12;
    public static int row_height = Gdx.graphics.getWidth() / Help_Guides;
    public static int col_width = Gdx.graphics.getWidth() / Help_Guides;

    public static Skin terraMother= new Skin(Gdx.files.internal("terra-mother/skin/terra-mother-ui.json"));
    public static Skin glassy = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));

}
