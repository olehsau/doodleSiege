package com.mygdx.doodlesiege;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.doodlesiege.mobs.Ghost;

import java.util.ArrayList;

import static com.mygdx.doodlesiege.Global.batch;
import static com.mygdx.doodlesiege.Global.player;

public class DoodleSiege extends ApplicationAdapter {
	MapManager mapManager;
	CameraManager cameraManager;
	Ghost ghost;
	ShapeRenderer shapeRenderer;

	@Override
	public void create () {
		batch = new SpriteBatch();
		mapManager = MapManager.getInstance();
		cameraManager = CameraManager.getInstance();
		player = new Player("player",0,0,42,30, 100, 100, 10, 40, 1, "player.png", null);
		ghost = new Ghost("ghost", 50,50,90,70,30,30,5,20,0,"ghost.png",null);
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1);
		batch.begin();

		mapManager.render(cameraManager.getCamera());
		player.mainCycle();
		ghost.mainCycle();



		cameraManager.update(player);
		batch.end();
		//// testing
		shapeRenderer.setProjectionMatrix(cameraManager.getCamera().combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.rect(0,0,50,50);
		shapeRenderer.end();
		if(player.collidesWith(ghost)){
			shapeRenderer.setProjectionMatrix(cameraManager.getCamera().combined);
			shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
			shapeRenderer.setColor(Color.GREEN);
			shapeRenderer.rect(0,0,50,50);
			shapeRenderer.end();
		}
		////
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		mapManager.dispose();
	}
}
