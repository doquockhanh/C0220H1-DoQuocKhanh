package com.mygdx.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Integer world_timer;

    Label timer;

    public Hud(SpriteBatch sb) {
//        world_timer = 300;
//
//        viewport = new FitViewport(1800, 1080, new OrthographicCamera());
//        stage = new Stage(viewport, sb);
//
//        Table table = new Table();
//        table.top();
//        table.setFillParent(true);
//
//        timer = new Label(String.format("%03d", world_timer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
//        table.add(timer).expandX().padTop(10);
//        stage.addActor(table);
    }
}
