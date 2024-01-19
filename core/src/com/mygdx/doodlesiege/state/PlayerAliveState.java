package com.mygdx.doodlesiege.state;

import com.badlogic.gdx.Gdx;
import com.mygdx.doodlesiege.*;

public class PlayerAliveState implements PlayerState {
    @Override
    public void mainCycle(Player player) {
        Global.batch.draw(player.appearance, player.x, player.y);
        handleMovementInput(player);

    }
    @Override
    public void handleMovementInput(Player player){
        if(Gdx.input.isKeyPressed(Controls.MOVE_UP) && Gdx.input.isKeyPressed(Controls.MOVE_LEFT))
            player.step(Direction.UL);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_UP) && Gdx.input.isKeyPressed(Controls.MOVE_RIGHT))
            player.step(Direction.UR);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_DOWN) && Gdx.input.isKeyPressed(Controls.MOVE_LEFT))
            player.step(Direction.DL);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_DOWN) && Gdx.input.isKeyPressed(Controls.MOVE_RIGHT))
            player.step(Direction.DR);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_UP)) player.step(Direction.UP);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_DOWN)) player.step(Direction.DOWN);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_LEFT)) player.step(Direction.LEFT);
        else if(Gdx.input.isKeyPressed(Controls.MOVE_RIGHT)) player.step(Direction.RIGHT);
    }
    @Override
    public void die(Player player) {
        player.setState(new PlayerDeadState());
    }

    @Override
    public void fireBullet(Player player, int cursorX, int cursorY) {
        player.firedBullets.add(new Bullet("", player.x, player.y,5,5,0,0,10,0,0,0,"blank5x5.png",null, cursorX, cursorY));
    }

}