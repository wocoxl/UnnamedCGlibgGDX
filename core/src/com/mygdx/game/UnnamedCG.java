package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GameLogic.GameLogic;
import com.mygdx.game.Screens.menuScreen;


public class UnnamedCG extends Game {
	SpriteBatch batch;
	Texture img;
	public GameLogic logic;



	public UnnamedCG(){
		super();


	}

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//row/col helper
		//gameSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
		this.setScreen(new menuScreen(this));

		//game
		//gameStage = new Stage(new ScreenViewport());
		//Gdx.input.setInputProcessor(gameStage);
		//Image gameBG = new Image(img);
		//gameStage.addActor(gameBG);

	}

	@Override
	public void render () {
		super.render();
		//Gdx.gl.glClearColor(1, 1, 1, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}


	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
}
