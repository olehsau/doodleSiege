package com.mygdx.doodlesiege;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
	ShapeRenderer shapeRenderer;
	Texture blank;
	MobsManager mobsManager;
	MyInputProcessor inputProcessor;
	BulletsManager bulletsManager;

	@Override
	public void create () {
		batch = new SpriteBatch();
		batchFixed = new SpriteBatch();
		mapManager = MapManager.getInstance();
		cameraManager = CameraManager.getInstance();
		mobsManager = MobsManager.getInstance(mapManager);
		player = new Player("player",0,0,32,34, 100, 100, 10,0.5f, 40, 5, "player.png", null);
		shapeRenderer = new ShapeRenderer();
		blank = new Texture("blank.png");
		inputProcessor = new MyInputProcessor();
		Gdx.input.setInputProcessor(inputProcessor);
		bulletsManager = new BulletsManager(mobsManager, mapManager);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1);
		batch.begin();
		mapManager.render(cameraManager.getCamera());
		player.mainCycle();
		cameraManager.update(player);
		mobsManager.mainCycle();
		batch.end();

		batchFixed.begin();
		batchFixed.setColor(Color.GRAY);
		batchFixed.draw(blank,150,100,300,15); // health bar
		batchFixed.setColor(Color.RED);
		batchFixed.draw(blank,150,100,Math.round(((float)player.hp/(float)player.maxHp)*300),15);
		batchFixed.setColor(Color.WHITE);
		batchFixed.end();

		shapeRenderer.setProjectionMatrix(cameraManager.getCamera().combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.BLACK);
		bulletsManager.mainCycle();
		for(Bullet bullet : player.firedBullets){
			shapeRenderer.circle(bullet.x, bullet.y, 5.0f, 32);
		}
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		mobsManager.dispose();
		mapManager.dispose();
		mobsManager.dispose();
	}
}
