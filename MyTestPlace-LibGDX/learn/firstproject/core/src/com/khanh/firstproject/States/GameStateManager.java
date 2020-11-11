package com.khanh.firstproject.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    private Stack<State> statesStack = new Stack<>();

    public void push(State state) {
        statesStack.push(state);
    }

    public void pop() {
        statesStack.pop();
    }

    public void set(State state) {
        statesStack.pop();
        statesStack.push(state);
    }

    public void update(float delta) {
        statesStack.peek().update(delta);
    }

    public void render(SpriteBatch spriteBatch) {
        statesStack.peek().render(spriteBatch);
    }
}
