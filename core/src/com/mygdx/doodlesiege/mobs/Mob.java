package com.mygdx.doodlesiege.mobs;

import com.mygdx.doodlesiege.Entity;
import com.mygdx.doodlesiege.Global;
import com.mygdx.doodlesiege.Item;
import com.mygdx.doodlesiege.Weapon;

public class Mob extends Entity {
    public Mob(String id, int x, int y, int sizeX, int sizeY, int maxHp, int hp, int damage, float reloadTime, int hitRange, int movementSpeed, String appearance, Weapon weapon) {
        super(id, x, y, sizeX, sizeY, maxHp, hp, damage, reloadTime, hitRange, movementSpeed, appearance, weapon);
    }

    @Override
    public void idle() {

    }

    @Override
    public void step(int dx, int dy) {

    }

    @Override
    public void hit(int x, int y) {

    }

    @Override
    public void attack(Entity target) {

    }

    @Override
    public void pick(Item item) {

    }

    @Override
    public void drop(Item item) {

    }

    @Override
    public void die() {

    }

    @Override
    public void mainCycle() {

    }

    public void stepTowardsPlayer() {
        int dx = Global.player.x - this.x;
        int dy = Global.player.y - this.y;
        double d = Math.sqrt(dx * dx + dy * dy);
        double t = d / this.movementSpeed;
        if (t > 0.0) {
            this.x += Math.round(dx / t * Global.getDeltaTimeMultiplier());
            this.y += Math.round(dy / t * Global.getDeltaTimeMultiplier());
        }
        /*System.out.println("dx="+dx);
        System.out.println("dy="+dy);
        System.out.println("d="+d);
        System.out.println("t="+t);
        System.out.println("x="+this.x);
        System.out.println("y="+this.y);*/
    }
}
