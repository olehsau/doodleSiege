package com.mygdx.doodlesiege.mobs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.doodlesiege.Appearance;
import com.mygdx.doodlesiege.Global;
import com.mygdx.doodlesiege.Mob;
import com.mygdx.doodlesiege.Weapon;

public class Ghost extends Mob {

    public Ghost(String id, int x, int y, int sizeX, int sizeY, int maxHp, int hp, int damage, int hitRange, int movementSpeed, String appearance, Weapon weapon) {
        super(id, x, y, sizeX, sizeY, maxHp, hp, damage, hitRange, movementSpeed, appearance, weapon);
    }
}
