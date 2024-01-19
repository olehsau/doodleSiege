package com.mygdx.doodlesiege;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.doodlesiege.mobs.Mob;

import java.util.ArrayList;

/**
 * class to store global important objects, like player
 */
public class Global {
    public static Player player;
    public static SpriteBatch batch;
    /**
     * is for drawing elements which are fixed on the screen (like health bar)
     */
    public static SpriteBatch batchFixed;
    public static CameraManager cameraManager;
    public static float getDeltaTimeMultiplier(){
        return 60*Gdx.graphics.getDeltaTime();
    }
}
