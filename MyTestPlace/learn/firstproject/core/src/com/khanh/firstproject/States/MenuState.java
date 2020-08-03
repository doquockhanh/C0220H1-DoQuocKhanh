package com.khanh.firstproject.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.khanh.firstproject.firstproject;

public class MenuState extends State {
    private Texture backGround;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        backGround = new Texture("bg.PNG");
        playBtn = new Texture("play-button.PNG");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(backGround, 0, 0, firstproject.WIDTH, firstproject.HEIGHT);
        spriteBatch.draw(playBtn, firstproject.WIDTH / 2 - playBtn.getWidth() / 4, firstproject.HEIGHT / 2, 80, 45);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        backGround.dispose();
        playBtn.dispose();
    }
}
