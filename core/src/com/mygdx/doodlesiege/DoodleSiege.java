package com.mygdx.doodlesiege;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.doodlesiege.mobs.Ghost;

import java.util.ArrayList;

import static com.mygdx.doodlesiege.Global.batch;
import static com.mygdx.doodlesiege.Global.batchFixed;
import static com.mygdx.doodlesiege.Global.player;
import static com.mygdx.doodlesiege.Global.cameraManager;

public class DoodleSiege extends ApplicationAdapter {
	MapManager mapManager;
	Ghost ghost;
	ShapeRenderer shapeRenderer;
	Texture blank;

	@Override
	public void create () {
		batch = new SpriteBatch();
		batchFixed = new SpriteBatch();
		mapManager = MapManager.getInstance();
		cameraManager = CameraManager.getInstance();
		player = new Player("player",0,0,32,34, 100, 100, 10,1, 40, 5, "player.png", null);
		ghost = new Ghost("ghost", 50,50,75,64,30,30,10,2,20,2,"ghost.png",null);
		shapeRenderer = new ShapeRenderer();
		blank = new Texture("blank.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1);
		batch.begin();

		mapManager.render(cameraManager.getCamera());
		ghost.mainCycle();
		player.mainCycle();
		cameraManager.update(player);


		batch.end();

		batchFixed.begin();
		batchFixed.setColor(Color.GRAY);
		batchFixed.draw(blank,150,100,300,15); // health bar
		batchFixed.setColor(Color.RED);
		batchFixed.draw(blank,150,100,Math.round(((float)player.hp/(float)player.maxHp)*300),15);
		batchFixed.setColor(Color.WHITE);
		batchFixed.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		mapManager.dispose();
	}
}
