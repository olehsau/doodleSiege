package com.mygdx.doodlesiege.mobs;

import com.badlogic.gdx.Gdx;
import com.mygdx.doodlesiege.*;

public class Ghost extends Mob {
    public static final String entityType = "ghost";
    public Ghost(String id, int x, int y, int sizeX, int sizeY, int maxHp, int hp, int damage, float reloadTime, int hitRange, int movementSpeed, String appearance, Weapon weapon) {
        super(id, x, y, sizeX, sizeY, maxHp, hp, damage, reloadTime, hitRange, movementSpeed, appearance, weapon);
    }

    public void hit(Entity entity){
        if(reloadLeft<=0){
            entity.getHit(damage);
            reloadLeft = reloadTime;
        }
    }
    @Override
    public void mainCycle(){
        reloadLeft -= Gdx.graphics.getDeltaTime();
        if(collidesWith(Global.player)){
            hit(Global.player);
        }
        stepTowardsPlayer();
        Global.batch.draw(this.appearance, this.x, this.y);
    }
}
