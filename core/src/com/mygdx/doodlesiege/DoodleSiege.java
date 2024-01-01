package com.mygdx.doodlesiege;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.doodlesiege.mobs.Ghost;

import java.util.ArrayList;

public class DoodleSiege extends ApplicationAdapter {
	SpriteBatch batch;
	MapManager mapManager;
	CameraManager cameraManager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		mapManager = MapManager.getInstance();
		cameraManager = CameraManager.getInstance();
		Global.player = new Player("player", 100, 100, 10, 5, "player.png", null);
		Global.player.spawn();

		Ghost ghost1 = new Ghost("ghost",1,1,1,2,"player.png",null);
		ghost1.spawn(50,50);
		Ghost ghost2 = new Ghost("ghost",1,1,1,1,"player.png",null);
		ghost2.spawn(550,450);
		Ghost ghost3 = new Ghost("ghost",1,1,1,3,"player.png",null);
		ghost3.spawn(250,50);
		Ghost ghost4 = new Ghost("ghost",1,1,1,1,"player.png",null);
		ghost4.spawn(10,450);
		Ghost ghost5 = new Ghost("ghost",1,1,1,2,"player.png",null);
		ghost5.spawn(330,300);
		Global.mobs = new ArrayList<>();
		Global.mobs.add(ghost1);
		Global.mobs.add(ghost2);
		Global.mobs.add(ghost3);
		Global.mobs.add(ghost4);
		Global.mobs.add(ghost5);


	}

	@Override
	public void render () {
		ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1);
		batch.begin();

		mapManager.render(cameraManager.getCamera());
		Global.player.update(batch);
		////
		for(Mob mob : Global.mobs){
			mob.update(batch);
		}
		////
		cameraManager.update(Global.player);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		mapManager.dispose();
	}
}
