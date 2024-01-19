package com.mygdx.doodlesiege;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class MyInputProcessor implements InputProcessor {
    public boolean keyDown (int keycode) {
        return false;
    }

    public boolean keyUp (int keycode) {
        return false;
    }

    public boolean keyTyped (char character) {
        return false;
    }

    public boolean touchDown (int x, int y, int pointer, int button) {
        // Convert screen coordinates to world coordinates
        Vector3 worldCoordinates = Global.cameraManager.getCamera().unproject(new Vector3(x, y,0));

        // Spawn a bullet at the clicked position
        Global.player.getState().fireBullet(Global.player, (int)worldCoordinates.x, (int)worldCoordinates.y);

        return true; // Return true to indicate the event was handled

    }

    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    public boolean mouseMoved (int x, int y) {
        return false;
    }

    public boolean scrolled (float amountX, float amountY) {
        return false;
    }
}
