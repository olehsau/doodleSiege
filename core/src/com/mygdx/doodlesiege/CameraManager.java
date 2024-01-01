package com.mygdx.doodlesiege;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class CameraManager {
    private static CameraManager instance;
    private OrthographicCamera camera;

    private CameraManager(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.update();
    }

    public static CameraManager getInstance(){
        if(instance == null){
            instance = new CameraManager();
        }
        return instance;
    }

    public void update(Entity entity){
        //camera.translate(entity.x-camera.position.x, entity.y-camera.position.y);
        Vector3 cursorWorldCoordinates = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        camera.translate((int)((0.85f*entity.x + 0.15f*cursorWorldCoordinates.x)-camera.position.x), (int)((0.85f*entity.y+0.15f*cursorWorldCoordinates.y)-camera.position.y));
        camera.update();
    }

    public OrthographicCamera getCamera() {
        return this.camera;
    }
}
