package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GameLogic.GameLogic;
import com.mygdx.game.GameLogic.Helper.UIHelper;
import com.mygdx.game.UnnamedCG;

import java.util.ArrayList;

public class menuScreen implements Screen {
    private UnnamedCG game;
    private Stage Menu;
    private Label outputLabel;
    private ArrayList<Button> Buttons;


    public menuScreen (UnnamedCG aGame){
        game = aGame;
        Buttons = new ArrayList<Button>();

        //Menu
        Texture img = new Texture("Background.jpg");
        Menu = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(Menu);
        Image BG = new Image(img);
        Menu.addActor(BG);



        Label title = new Label("Unnamed Card Game",UIHelper.terraMother,"giygas");
        title.setSize(Gdx.graphics.getWidth(), UIHelper.row_height*2);
        title.setPosition(0,Gdx.graphics.getHeight()-UIHelper.row_height*2);
        title.setAlignment(Align.center);
        Menu.addActor(title);
        //play button
        Button playButton = new TextButton("PLAY",UIHelper.glassy,"small");
        playButton.setSize(UIHelper.col_width*2,UIHelper.row_height/2);
        playButton.setPosition(UIHelper.col_width,Gdx.graphics.getHeight()-UIHelper.row_height*2);
        playButton.setTransform(true);
        //playButton.scaleBy(10f);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                characterSelection();
                //play();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Button");
                //play();
                return true;
            }
        });
        Menu.addActor(playButton);
        Buttons.add(playButton);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(Menu);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Menu.act();
        Menu.draw();

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
        Menu.dispose();
    }

    private void characterSelection(){
        //choose character
        for(Button button: Buttons){
            button.remove();
        }
        Button Fire = new TextButton("Fire",UIHelper.glassy,"small");
        Buttons.add(Fire);
        Fire.setSize(UIHelper.col_width*2,UIHelper.row_height);
        Fire.setPosition(UIHelper.col_width*2,Gdx.graphics.getHeight()-UIHelper.row_height*2);
        Fire.setTransform(true);
        //playButton.scaleBy(10f);
        Fire.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");

                equipmentOption(1);
                //play();

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Button");
                //play();
                return true;
            }
        });
        Menu.addActor(Fire);

        Button Fighter = new TextButton("Fighter",UIHelper.glassy,"small");
        Buttons.add(Fighter);
        Fighter.setSize(UIHelper.col_width*2,UIHelper.row_height);
        Fighter.setPosition(UIHelper.col_width*5,Gdx.graphics.getHeight()-UIHelper.row_height*2);
        Fighter.setTransform(true);
        //playButton.scaleBy(10f);
        Fighter.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");

                equipmentOption(2);
                //play();

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Button");
                //play();
                return true;
            }
        });
        Menu.addActor(Fighter);

        Button Weapon = new TextButton("Weapon",UIHelper.glassy,"small");
        Buttons.add(Weapon);
        Weapon.setSize(UIHelper.col_width*2,UIHelper.row_height);
        Weapon.setPosition(UIHelper.col_width*8,Gdx.graphics.getHeight()-UIHelper.row_height*2);
        Weapon.setTransform(true);
        //playButton.scaleBy(10f);
        Weapon.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");

                equipmentOption(3);
                //play();

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Button");
                //play();
                return true;
            }
        });
        Menu.addActor(Weapon);

    }

    private void equipmentOption(final int num){
        for(Button button: Buttons){
            button.remove();
        }
        Button ChooseShield = new TextButton("Shield",UIHelper.glassy,"small");
        ChooseShield.setSize(UIHelper.col_width*2,UIHelper.row_height);
        ChooseShield.setPosition(UIHelper.col_width*2,Gdx.graphics.getHeight()-UIHelper.row_height*2);
        ChooseShield.setTransform(true);
        //playButton.scaleBy(10f);
        ChooseShield.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                game.logic = new GameLogic(num, "shield");
                game.setScreen(new combatScreen(game));
                //play();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Button");
                //play();
                return true;
            }
        });

        Button ChooseSword = new TextButton("Sword",UIHelper.glassy,"small");
        ChooseSword.setSize(UIHelper.col_width*2,UIHelper.row_height);
        ChooseSword.setPosition(UIHelper.col_width*5,Gdx.graphics.getHeight()-UIHelper.row_height*2);
        ChooseSword.setTransform(true);
        //playButton.scaleBy(10f);
        ChooseSword.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                game.logic = new GameLogic(num, "sword");
                game.setScreen(new combatScreen(game));
                //play();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Button");
                //play();
                return true;
            }
        });

        Button ChooseSpear = new TextButton("Spear",UIHelper.glassy,"small");
        ChooseSpear.setSize(UIHelper.col_width*2,UIHelper.row_height);
        ChooseSpear.setPosition(UIHelper.col_width*8,Gdx.graphics.getHeight()-UIHelper.row_height*2);
        ChooseSpear.setTransform(true);
        //playButton.scaleBy(10f);
        ChooseSpear.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                game.logic = new GameLogic(num, "spear");
                game.setScreen(new combatScreen(game));
                //play();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Button");
                //play();
                return true;
            }
        });
        Menu.addActor(ChooseShield);
        Menu.addActor(ChooseSword);
        Menu.addActor(ChooseSpear);

    }
}
