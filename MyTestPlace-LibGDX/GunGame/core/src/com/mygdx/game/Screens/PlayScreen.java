package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Character.Extends.Gunner;
import com.mygdx.game.GunGame;
import com.mygdx.game.Scenes.Hud;

public class PlayScreen implements Screen {
    public static final int MAP1_WIDTH = 1920;
    public static final int MAP1_HEIGHT = 1080;

    private GunGame game;
    private OrthographicCamera game_cam;
    private Viewport game_port;
    private Hud hud;

    private TmxMapLoader map_loader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private float a;
    private float b;

    public PlayScreen(GunGame game){
        this.game = game;
        game_cam = new OrthographicCamera();
        game_cam.position.set(0, 0, 0);
        game_port = new FitViewport(360, 270, game_cam);
        hud = new Hud(game.batch);

        map_loader = new TmxMapLoader();
        map = map_loader.load("map/map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

        a = 0;
        b = 0;
        game_cam.position.set(a, b, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game_cam.update();
        renderer.setView(game_cam);
        Gdx.gl.glClearColor(1, 1 , 1 ,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        game.batch.begin();
        for (int i = 0; i < game.players.size(); i++) {
            switch (game.players.get(i)){
                case 1:{
                    game_cam.position.set(game.gunner.getCharacterCoordinate().x, game.gunner.getCharacterCoordinate().y, 0);
                    if(game.gunner.getCharacterPosition() == -45){
                        game.batch.draw(
                                game.gunner.getGunnerAnimationLeft().get(game.gunner.getGunnerFrameCount()),
                                game.gunner.getCharacterCoordinate().x,
                                game.gunner.getCharacterCoordinate().y,
                                game.gunner.getCharacterSize().x,
                                game.gunner.getCharacterSize().y
                        );
                    }else {
                        game.batch.draw(
                                game.gunner.getGunnerAnimationRight().get(game.gunner.getGunnerFrameCount()),
                                game.gunner.getCharacterCoordinate().x,
                                game.gunner.getCharacterCoordinate().y,
                                game.gunner.getCharacterSize().x,
                                game.gunner.getCharacterSize().y
                        );
                    }
                    break;
                }
                default:{
                    break;
                }
            }
        }
        game.batch.end();
//        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
//        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        game_port.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
