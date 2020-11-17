package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Character.Extends.Gunner;
import com.mygdx.game.Screens.PlayScreen;

import java.util.ArrayList;
import java.util.List;

public class GunGame extends Game {
	public static final int GUNNER = 1;

    public SpriteBatch batch;
    public List<Integer> players = new ArrayList<>();
    public Gunner gunner;
    public Integer turn;

    @Override
	public void create () {
    	turn = 0;
//    	bo qua buoc chon nhan vat
    	players.add(GUNNER);
    	gunner = new Gunner(this);

    	batch = new SpriteBatch();
    	setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
    	super.render();

		switch (players.get(turn)){
			case 1:{
				gunner.controller();
			}
		}
	}
}
