package com.mygdx.doodlesiege.mobs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.doodlesiege.Global;
import com.mygdx.doodlesiege.Mob;
import com.mygdx.doodlesiege.Weapon;

public class Ghost extends Mob {
    public Ghost(String id, int maxHp, int hp, int damage, int movementSpeed, String appearancePath, Weapon weapon) {
        super(id, maxHp, hp, damage, movementSpeed, appearancePath, weapon);
    }
}
