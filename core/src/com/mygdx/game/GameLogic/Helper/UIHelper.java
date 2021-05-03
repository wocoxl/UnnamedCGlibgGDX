package com.mygdx.game.GameLogic.Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.Color;

public class UIHelper {
    public static int Help_Guides = 12;
    public static int row_height = Gdx.graphics.getWidth() / Help_Guides;
    public static int col_width = Gdx.graphics.getWidth() / Help_Guides;

    public static Skin terraMother= new Skin(Gdx.files.internal("terra-mother/skin/terra-mother-ui.json"));
    public static Skin glassy = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));

    //@author serhiy
    public static Drawable getColoredDrawable(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();

        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));

        pixmap.dispose();

        return drawable;
    }
}
