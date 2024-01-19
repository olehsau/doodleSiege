package com.mygdx.doodlesiege;

public class Bullet extends Entity {
    public int x;
    public int y;
    /**
     * speed
     */
    public int d = 15;
    /**
     * x speed
     */
    public float dx;
    /**
     * y speed
     */
    public float dy;

    public Bullet(String id, int x, int y, int sizeX, int sizeY, int maxHp, int hp, int damage, float reloadTime, int hitRange, int movementSpeed, String appearance, Weapon weapon, int cursorX, int cursorY) {
        super(id, x, y, sizeX, sizeY, maxHp, hp, damage, reloadTime, hitRange, movementSpeed, appearance, weapon);
        this.x = x + Global.player.appearance.getWidth()/2;
        this.y = y + Global.player.appearance.getHeight()/2;
        int mdx = cursorX - x;
        int mdy = cursorY - y;
        double md = Math.sqrt(mdx*mdx + mdy*mdy);
        this.dx = (int)(((float)d/(float)md)*(float)mdx);
        this.dy = (int)(((float)d/(float)md)*(float)mdy);
        this.x += Math.signum(dx)*Global.player.sizeX/2;
        this.y += Math.signum(dy)*Global.player.sizeY/2;
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
}
