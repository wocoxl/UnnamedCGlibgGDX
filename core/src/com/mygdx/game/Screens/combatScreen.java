package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GameLogic.Helper.UIHelper;
import com.mygdx.game.UnnamedCG;

import java.util.ArrayList;

public class combatScreen implements Screen {
    private Stage stage;
    private UnnamedCG game;
    private Label outputLabel;
    private ArrayList<Button> characters;


    Button back;
    Button enterCombat;

    public combatScreen(UnnamedCG aGame){
        game = aGame;


        Texture img = new Texture("Background.jpg");
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Image BG = new Image(img);
        stage.addActor(BG);

        //back button
        back = new TextButton("back",UIHelper.glassy,"small");
        back.setTransform(true);
        back.setSize(UIHelper.col_width*1,UIHelper.row_height/4);
        back.setPosition(UIHelper.col_width*11,Gdx.graphics.getHeight()-UIHelper.row_height/4);
        //playButton.scaleBy(10f);
        back.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                game.setScreen(new menuScreen(game));
                //play();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Button");
                //play();
                return true;
            }
        });
        stage.addActor(back);

        /**

        enterCombat = new TextButton("Enter Combat",UIHelper.glassy,"small");
        enterCombat.setSize(UIHelper.col_width*2,UIHelper.row_height);
        enterCombat.setPosition(UIHelper.col_width*4,Gdx.graphics.getHeight()-UIHelper.row_height*3);
        enterCombat.setTransform(true);
        //playButton.scaleBy(10f);
        enterCombat.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                back.remove();

                //stage.clear();
                stage.addActor(back);
                enterCombat.remove();
                loadCombat();

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Button");
                //play();
                return true;
            }
        });
        //stage.addActor((enterCombat));
        **/
        //red



    }



    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act();


    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }





}
