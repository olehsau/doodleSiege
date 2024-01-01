package com.mygdx.doodlesiege;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Entity{
    public Player(String id, int maxHp, int hp, int damage, int movementSpeed, Appearance appearance, Weapon weapon) {
        super(id, maxHp, hp, damage, movementSpeed, appearance, weapon);
    }
    public Player(String id, int maxHp, int hp, int damage, int movementSpeed, String appearancePath, Weapon weapon) {
        super(id, maxHp, hp, damage, movementSpeed, appearancePath, weapon);
    }

    @Override
    public void spawn(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void spawn(){
        this.x = Gdx.graphics.getWidth()/2;
        this.y = Gdx.graphics.getHeight()/2;
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

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public void goTo(int x, int y) {

    }
    /**
     * Updates and draws the updated player
     * @param batch
     */
    @Override
    public void update(SpriteBatch batch){
        if(Gdx.input.isKeyPressed(Controls.MOVE_UP)) this.y += this.movementSpeed;
        if(Gdx.input.isKeyPressed(Controls.MOVE_DOWN)) this.y -= this.movementSpeed;
        if(Gdx.input.isKeyPressed(Controls.MOVE_LEFT)) this.x -= this.movementSpeed;
        if(Gdx.input.isKeyPressed(Controls.MOVE_RIGHT)) this.x += this.movementSpeed;
        batch.draw(this.appearance, this.x, this.y);
    }
}
