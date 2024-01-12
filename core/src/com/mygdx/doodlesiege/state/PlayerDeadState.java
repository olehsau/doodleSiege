package com.mygdx.doodlesiege.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.doodlesiege.Global;
import com.mygdx.doodlesiege.Player;

public class PlayerDeadState implements PlayerState {
    float deathAnimationDuration = 1.0f; // seconds
    float deathAnimationLeft = deathAnimationDuration;
    @Override
    public void mainCycle(Player player) {
        if(deathAnimationLeft > 0){
            System.out.println("Oh no I'm dead!");
            deathAnimationLeft -= Gdx.graphics.getDeltaTime();
            Global.batch.setColor(0,0,0, (1.0f-(deathAnimationLeft/deathAnimationDuration))*0.7f);
        }
        else{
            System.out.println("Game over");
        }
    }

    @Override
    public void handleMovementInput(Player player) {
        // Player cannot move when dead
    }

    @Override
    public void die(Player player) {
        // Player is already dead
    }
}