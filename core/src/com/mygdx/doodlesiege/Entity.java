package com.mygdx.doodlesiege;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {
    public final String id;
    public int x;
    public int y;
    public int maxHp;
    public int hp;
    public int damage;
    public int movementSpeed;
    public Appearance appearance;
    public Weapon weapon;

    public abstract void spawn(int x, int y);
    public abstract void idle();
    public abstract void hit(int x, int y);
    public abstract void attack(Entity target);
    public abstract void pick(Item item);
    public abstract void drop(Item item);
    public abstract void die();
    public abstract void move(int dx, int dy);
    public abstract void goTo(int x, int y);
    /**
     * Updates and draws the updated entity
     * @param batch
     */
    public abstract void update(SpriteBatch batch);

    // Constructor with all fields
    public Entity(String id, int maxHp, int hp, int damage, int movementSpeed, Appearance appearance, Weapon weapon) {
        this.id = id;
        this.maxHp = maxHp;
        this.hp = hp;
        this.damage = damage;
        this.movementSpeed = movementSpeed;
        this.appearance = appearance;
        this.weapon = weapon;
    }
    public Entity(String id, int maxHp, int hp, int damage, int movementSpeed, String appearancePath, Weapon weapon) {
        this.id = id;
        this.maxHp = maxHp;
        this.hp = hp;
        this.damage = damage;
        this.movementSpeed = movementSpeed;
        this.appearance = new Appearance(appearancePath);
        this.weapon = weapon;
    }
}
