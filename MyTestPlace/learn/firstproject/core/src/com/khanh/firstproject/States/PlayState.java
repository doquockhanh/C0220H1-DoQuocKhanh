package com.khanh.firstproject.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.khanh.firstproject.firstproject;
import com.khanh.firstproject.sprites.Bird;
import com.khanh.firstproject.sprites.Tube;

public class PlayState extends State {
    private static final int BIRD_WIDTH = 40;
    private static final int BIRD_HEIGHT = 25;
    private static final int TUBE_SPACING = 125 ;
    private static final int TUBE_COUNT = 4;

    private Bird bird;
    private Texture backGround;
    private Tube tube;

    private Array<Tube> tubeArray;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 300);
        camera.setToOrtho(false, firstproject.WIDTH / 2, firstproject.HEIGHT / 2);
        backGround = new Texture("bg.PNG");

        tubeArray = new Array<>();
        for (int i = 1; i <= TUBE_COUNT; i++) {
            tubeArray.add(new Tube(i * (TUBE_SPACING + tube.TUBE_WIDTH)));
        }
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
        bird.update(delta);
        System.out.println(delta);
        camera.position.x = bird.getPosition().x + 80;
        for (Tube tube : tubeArray) {
            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
                tube.reposition(tube.getPosTopTube().x + (tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT);
            }
            if(tube.collides(bird.getBounds())){
                gsm.pop();
            }
        }

        camera.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(backGround, camera.position.x - (camera.viewportWidth / 2), 0);
        spriteBatch.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y, BIRD_WIDTH, BIRD_HEIGHT);

        for (Tube tube : tubeArray) {
            spriteBatch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            spriteBatch.draw(tube.getBotTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }

        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
