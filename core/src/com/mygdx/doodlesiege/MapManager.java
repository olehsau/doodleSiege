package com.mygdx.doodlesiege;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapManager {
    private static MapManager instance;
    private TiledMap map;
    private TiledMap background;
    private MapRenderer mapRenderer;
    private MapRenderer backgroundRenderer;
    public int width;
    public int height;

    public TiledMap getMap(){
        return map;
    }
    public MapRenderer getMapRenderer(){
        return mapRenderer;
    }

    private MapManager(){
        map = new TmxMapLoader().load("map.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
        background = new TmxMapLoader().load("background.tmx");
        backgroundRenderer = new OrthogonalTiledMapRenderer(background);
        TiledMapTileLayer mainLayer = (TiledMapTileLayer) map.getLayers().get(0);
        int tileSize = (int) mainLayer.getTileWidth();
        width = mainLayer.getWidth() * tileSize;
        height = mainLayer.getHeight() * tileSize;
    }

    public static MapManager getInstance(){
        if(instance == null){
            instance = new MapManager();
        }
        return instance;
    }

    public void render(OrthographicCamera camera){
        mapRenderer.setView(camera);
        backgroundRenderer.setView(camera);
        backgroundRenderer.render();
        mapRenderer.render();
    }

    public void dispose(){
        this.map.dispose();
    }

}
