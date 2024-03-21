package com.jester.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import gameObjects.*;
import managers.CourtManager;
import managers.CupManager;

public class Jester extends ApplicationAdapter {
	SpriteBatch batch;

	Texture table;
	Texture wall;
	Texture jester;

	King king;
	CourtManager courtManager;
	CupManager cupManager;
	@Override
	public void create () {
		batch = new SpriteBatch();
		table = new Texture(Gdx.files.internal("assets/table.png"));
		wall = new Texture(Gdx.files.internal("assets/wall.png"));
		jester = new Texture(Gdx.files.internal("assets/jester.png"));
		king = new King(830.0f, 430.0f, 300.0f, 425.0f, "king");
		courtManager = new CourtManager(king);
		cupManager = new CupManager(courtManager);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			cupManager.moveCups(courtManager);
		}

		batch.begin();
		drawEnviron(wall, table);
		king.drawObject(batch);
		courtManager.drawObjects(batch);
		cupManager.drawObjects(batch);
		batch.draw(
				jester,
				0.0f, 0.0f, 300.0f, 500.0f,
				0, 0, jester.getWidth(), jester.getHeight(),
				false, false
		);
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
