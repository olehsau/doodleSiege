package com.mygdx.doodlesiege;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.doodlesiege.mobs.Ghost;

import java.util.ArrayList;

import static com.mygdx.doodlesiege.AITextGenerator.prompt;
import static com.mygdx.doodlesiege.Global.*;

public class DoodleSiege extends ApplicationAdapter {
	MapManager mapManager;
	ShapeRenderer shapeRenderer;
	Texture blank;
	MobsManager mobsManager;
	MyInputProcessor inputProcessor;
	BulletsManager bulletsManager;
	BitmapFont font;
	BitmapFont fontTitle;
	String AITitle;
	float timePlayed;

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
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("GAME OVER.TTF"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 36;
		font = generator.generateFont(parameter);
		generator = new FreeTypeFontGenerator(Gdx.files.internal("Roboto-Regular.ttf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 56;
		fontTitle = generator.generateFont(parameter);
		generator.dispose();
		AITitle = prompt("story of the hero fighting with ghosts");
		timePlayed = 0;
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
		font.draw(batchFixed, "killed mobs: " + player.kills, 20, Gdx.graphics.getHeight() - 20);
		if(timePlayed <= 6.0) {fontTitle.draw(batchFixed, AITitle, 50, Gdx.graphics.getHeight() - 200);}
		batchFixed.end();

		shapeRenderer.setProjectionMatrix(cameraManager.getCamera().combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.BLACK);
		bulletsManager.mainCycle();
		for(Bullet bullet : player.firedBullets){
			shapeRenderer.circle(bullet.x, bullet.y, 5.0f, 32);
		}
		shapeRenderer.end();
		timePlayed += Gdx.graphics.getDeltaTime();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		mobsManager.dispose();
		mapManager.dispose();
		mobsManager.dispose();
	}
}
