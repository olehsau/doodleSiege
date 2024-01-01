package com.mygdx.doodlesiege;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Mob extends Entity{
    public Mob(String id, int maxHp, int hp, int damage, int movementSpeed, String appearancePath, Weapon weapon) {
        super(id, maxHp, hp, damage, movementSpeed, appearancePath, weapon);
    }

    @Override
    public void spawn(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void idle() {

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

    private boolean isMoving = false;
    private int dx = 0;
    private int dy = 0;


    @Override
    public void move(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void goTo(int x, int y) {

    }

    @Override
    public void update(SpriteBatch batch) {
        this.x += Integer.compare(Global.player.x, this.x)*this.movementSpeed;
        this.y += Integer.compare(Global.player.y, this.y)*this.movementSpeed;
        batch.draw(this.appearance, this.x, this.y);
    }
}
