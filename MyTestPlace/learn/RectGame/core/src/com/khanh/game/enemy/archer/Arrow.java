package com.khanh.game.enemy.archer;

import com.badlogic.gdx.math.Vector2;

public class Arrow {
    private Vector2 position;
    private Vector2 playerPosition;

    public Arrow(Vector2 player){
       playerPosition = new Vector2(player.x, player.y);
    }

    public void fire(){
        position.y += Math.sqrt((100 * Math.pow(playerPosition.y, 2)) / (Math.pow(playerPosition.x, 2) + Math.pow(playerPosition.y, 2)));
        position.x += Math.sqrt(100 - Math.pow(Math.sqrt((100 * Math.pow(playerPosition.y, 2)) / (Math.pow(playerPosition.x, 2) + Math.pow(playerPosition.y, 2))), 2));
    }
}
