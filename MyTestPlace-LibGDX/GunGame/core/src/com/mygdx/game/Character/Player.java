package com.mygdx.game.Character;

public abstract class Player {
    public abstract void controller();

    public abstract void characterMoveAndAngle();

    public abstract void updateBulletPosition();

    public abstract void fire();

    public abstract void bulletFiring(double wind);
}
