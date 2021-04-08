package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
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
        back.setSize(UIHelper.col_width*2,UIHelper.row_height/4);
        back.setPosition(UIHelper.col_width,Gdx.graphics.getHeight()-UIHelper.row_height*6);
        back.setTransform(true);
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
                back.setSize(UIHelper.col_width*1,UIHelper.row_height/4);
                back.setPosition(UIHelper.col_width*11,Gdx.graphics.getHeight()-UIHelper.row_height/4);
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
        stage.addActor((enterCombat));

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
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

    public void loadCombat(){
        Texture texture = null;
        Texture texture2 = null;
        hpbar(texture, texture2);

    }

    public void hpbar(Texture texture, Texture texture2){
        int w = 1;
        int h = 1;

        Pixmap pixmap = createProceduralPixmap(w, h,0,1,0);
        Pixmap pixmap2 = createProceduralPixmap(w, h,1,0,0);

        texture = new Texture(pixmap);
        texture2 = new Texture(pixmap2);

        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        batch.draw(texture2,2*UIHelper.col_width,2*UIHelper.row_height,300,20);
        batch.draw(texture,2*UIHelper.col_width,2*UIHelper.row_height,200,20);
        batch.end();



    }


    private Pixmap createProceduralPixmap (int width, int height,int r,int g,int b) {
        Pixmap pixmap = new Pixmap(width, height, Format.RGBA8888);

        pixmap.setColor(r, g, b, 1);
        pixmap.fill();

        return pixmap;
    }
}
