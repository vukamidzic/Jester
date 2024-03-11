package com.jester.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import gameObjects.*;

public class Jester extends ApplicationAdapter {
	SpriteBatch batch;

	Texture table;
	Texture wall;

	Cup cup1;
	Cup cup2;
	King king;
	@Override
	public void create () {
		batch = new SpriteBatch();
		cup1 = new Cup(860.0f, 500.0f, 125.0f, 150.0f, "cup");
		cup2 = new Cup(100.0f, 200.0f, 100.0f, 125.0f, "cup");
		king = new King(860.0f, 430.0f, 300.0f, 425.0f, "king");
		table = new Texture(Gdx.files.internal("assets/table.png"));
		wall = new Texture(Gdx.files.internal("assets/wall.png"));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}

		batch.begin();
		drawEnviron(wall, table);
		king.drawObject(batch);
		cup1.drawObject(batch);
		cup2.drawObject(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	private void drawEnviron(Texture wall, Texture table) {
		batch.draw(
				wall,
				-50.0f, 0.0f, 2000.0f, 1100.0f,
				0,0, wall.getWidth(), wall.getHeight(),
				false, false
		);
		batch.draw(
				table,
				0.0f, 0.0f, 1920.0f, 1080.0f,
				0,0, table.getWidth(), table.getHeight(),
				false, false
		);
	}
}
