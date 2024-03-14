package com.jester.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import gameObjects.*;
import managers.CourtManager;

public class Jester extends ApplicationAdapter {
	SpriteBatch batch;

	Texture table;
	Texture wall;

	King king;
	CourtManager courtManager;
	@Override
	public void create () {
		batch = new SpriteBatch();
		table = new Texture(Gdx.files.internal("assets/table.png"));
		wall = new Texture(Gdx.files.internal("assets/wall.png"));
		king = new King(830.0f, 430.0f, 300.0f, 425.0f, "king");
		courtManager = new CourtManager(king);
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
		courtManager.drawObjects(batch);
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
				-50.0f, 0.0f, 2050.0f, 1080.0f,
				0,0, table.getWidth(), table.getHeight(),
				false, false
		);
	}
}
