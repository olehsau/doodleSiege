package com.mygdx.doodlesiege;

import com.badlogic.gdx.Gdx;

public class Player extends Entity{


    public Player(String id, int x, int y, int sizeX, int sizeY, int maxHp, int hp, int damage, int hitRange, int movementSpeed, String appearance, Weapon weapon) {
        super(id, x, y, sizeX, sizeY, maxHp, hp, damage, hitRange, movementSpeed, appearance, weapon);
    }

    @Override
    public void idle() {

    }

    @Override
    public void step(int dx, int dy) {

    }
    public void handleMovementInput(){
        if(Gdx.input.isKeyPressed(Controls.MOVE_UP) && Gdx.input.isKeyPressed(Controls.MOVE_LEFT))
            step(Direction.UL);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_UP) && Gdx.input.isKeyPressed(Controls.MOVE_RIGHT))
            step(Direction.UR);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_DOWN) && Gdx.input.isKeyPressed(Controls.MOVE_LEFT))
            step(Direction.DL);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_DOWN) && Gdx.input.isKeyPressed(Controls.MOVE_RIGHT))
            step(Direction.DR);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_UP)) step(Direction.UP);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_DOWN)) step(Direction.DOWN);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_LEFT)) step(Direction.LEFT);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_RIGHT)) step(Direction.RIGHT);
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
    public void mainCycle(){
        handleMovementInput();
        Global.batch.draw(this.appearance, this.x, this.y);
    }
}
