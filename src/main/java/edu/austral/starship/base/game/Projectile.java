package edu.austral.starship.base.game;

public abstract class Projectile extends GameObject{

    int damage;

    float lifespan;

    public void leftPerimeter() {
        this.destroy();
    }

    public void resolveCollision() {

    }

    public void resolveCollision(Scoreable scoreable) {

    }
}
