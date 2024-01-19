package com.mygdx.doodlesiege;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.doodlesiege.mobs.Ghost;
import com.mygdx.doodlesiege.mobs.Mob;

import java.util.ArrayList;

public class MobsManager {
    private static MobsManager instance;
    public static ArrayList<Mob> presentMobs;
    private static MapManager mapManager;
    private MobsManager(){
        presentMobs = new ArrayList<Mob>();
        timePassed = 0.0f;
    }
    public static MobsManager getInstance(MapManager mapManager){
        if(instance == null){
            instance = new MobsManager();
            instance.mapManager = mapManager;
        }
        return instance;
    }

    public void spawn(MobType mobType){
        Vector2 spawnCoords;
        switch (mobType){
            case GHOST:
                spawnCoords = getRandomPointOnMapEdge();
                presentMobs.add(new Ghost("", (int)spawnCoords.x, (int)spawnCoords.y, 75,80,
                        30,30,10,1,20,3,"ghost.png",null));
                break;
        }
    }

    private float timePassed;
    public void mainCycle(){
        for(Mob mob : presentMobs){
            mob.mainCycle();
        }
        timePassed += Gdx.graphics.getDeltaTime();
        if(timePassed >= 2.0f){
            timePassed = 0.0f;
            spawn(MobType.getRandomMobType());
        }
    }

    public void dispose(){
        instance = null;
        presentMobs.clear();
    }

    public static Vector2 getRandomPointOnMapEdge() {
        float randomX;
        float randomY;

        // Choose a random side (0: top, 1: right, 2: bottom, 3: left)
        int randomSide = MathUtils.random(0, 3);

        switch (randomSide) {
            case 0: // Top side
                randomX = MathUtils.random(0, mapManager.width);
                randomY = mapManager.height;
                break;
            case 1: // Right side
                randomX = mapManager.width;
                randomY = MathUtils.random(0, mapManager.height);
                break;
            case 2: // Bottom side
                randomX = MathUtils.random(0, mapManager.width);
                randomY = 0;
                break;
            case 3: // Left side
                randomX = 0;
                randomY = MathUtils.random(0, mapManager.height);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomSide);
        }

        return new Vector2(randomX, randomY);
    }

}
