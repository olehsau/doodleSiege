package com.mygdx.doodlesiege;

import com.badlogic.gdx.Gdx;
import com.mygdx.doodlesiege.state.PlayerAliveState;
import com.mygdx.doodlesiege.state.PlayerDeadState;
import com.mygdx.doodlesiege.state.PlayerState;

import java.util.ArrayList;

public class Player extends Entity{
    public static final String entityType = "player";
    private PlayerState playerState;
    public void setState(PlayerState state){
        this.playerState = state;
    }
    public PlayerState getState(){
        return playerState;
    }
    public ArrayList<Bullet> firedBullets;
    public Player(String id, int x, int y, int sizeX, int sizeY, int maxHp, int hp, int damage, float reloadTime, int hitRange, int movementSpeed, String appearance, Weapon weapon) {
        super(id, x, y, sizeX, sizeY, maxHp, hp, damage, reloadTime, hitRange, movementSpeed, appearance, weapon);
        setState(new PlayerAliveState());
        firedBullets = new ArrayList<>();
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
        playerState.die(this);
    }

    @Override
    public void mainCycle(){
        playerState.mainCycle(this);
    }
}

