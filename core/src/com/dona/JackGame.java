package com.dona;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import scenes.GamePlay;

public class JackGame extends Game {
	private SpriteBatch batch;

	@Override
	public void create () {
	    //Incializando el renderizador
		batch = new SpriteBatch();
		//Creando la escena
		setScreen(new GamePlay(this));
	}

	//Evitando que halla mas de un SpriteBatch
	@Override
	public void render () {
        super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

    public SpriteBatch getBatch() {
        return batch;
    }
}
