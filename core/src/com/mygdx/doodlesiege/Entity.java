package com.mygdx.doodlesiege;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {
    public final String id;
    public int x;
    public int y;
    public int sizeX;
    public int sizeY;
    public int maxHp;
    public int hp;
    public int damage;
    public int hitRange;
    public int movementSpeed;
    public Appearance appearance;
    public Weapon weapon;

    public abstract void idle();
    public void step(Direction d){
        switch (d){
            case UP:
                this.y += Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()); break;
            case DOWN:
                this.y -= Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()); break;
            case RIGHT:
                this.x += Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()); break;
            case LEFT:
                this.x -= Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()); break;
            case UR:
                this.y += Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()/1.4);
                this.x += Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()/1.4); break;
            case UL:
                this.y += Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()/1.4);
                this.x -= Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()/1.4); break;
            case DL:
                this.y -= Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()/1.4);
                this.x -= Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()/1.4); break;
            case DR:
                this.y -= Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()/1.4);
                this.x += Math.round(this.movementSpeed*Global.getDeltaTimeMultiplier()/1.4); break;
        }
    }
    public abstract void step(int dx, int dy);
    public abstract void hit(int x, int y);
    public abstract void attack(Entity target);
    public abstract void pick(Item item);
    public abstract void drop(Item item);
    public abstract void die();
    private boolean collidesWith(Entity entity, boolean alreadyChecked) {
        int appearanceWidth = this.appearance.getWidth();
        int leftX1 = this.x + (appearanceWidth - sizeX) / 2;
        int rightX1 = this.x + (appearanceWidth + sizeX) / 2;
        int bottomY1 = this.y;
        int topY1 = y + sizeY;
        //
        int leftX2 = entity.x + (entity.appearance.getWidth() - entity.sizeX) / 2;
        int rightX2 = entity.x + (entity.appearance.getWidth() + entity.sizeX) / 2;
        int bottomY2 = entity.y;
        int topY2 = entity.y + entity.sizeY;
        if (leftX1 > leftX2 && leftX1 < rightX2) {
            if (bottomY1 > bottomY2 && bottomY1 < topY2) return true;
            if (topY1 > bottomY2 && topY1 < topY2) return true;
        }
        if (rightX1 > leftX2 && rightX1 < rightX2) {
            if (topY1 > bottomY2 && topY1 < topY2) return true;
            if (bottomY1 < topY2 && bottomY1 > bottomY2) return true;
        }
        if (alreadyChecked == false) {
            return entity.collidesWith(this,true);
        }
        return false;
    }
    public boolean collidesWith(Entity entity){
        return collidesWith(entity,false);
    }

    /**
     * Main life cycle function. Updates and draws the updated entity.
     */
    public abstract void mainCycle();

    public Entity(String id, int x, int y, int sizeX, int sizeY, int maxHp, int hp, int damage, int hitRange, int movementSpeed, String appearance, Weapon weapon) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.maxHp = maxHp;
        this.hp = hp;
        this.damage = damage;
        this.hitRange = hitRange;
        this.movementSpeed = movementSpeed;
        this.appearance = new Appearance(appearance);
        this.weapon = weapon;
    }
}
