package com.mygdx.doodlesiege;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * class to store global important objects, like player
 */
public class Global {
    public static Player player;
    public static ArrayList<Mob> mobs;
    public static SpriteBatch batch;
    public static float getDeltaTimeMultiplier(){
        return 60*Gdx.graphics.getDeltaTime();
    }
}
