package edu.austral.starship.base.game;

public abstract class Projectile extends GameObject{

    int damage;

    float lifespan;

    float lifespanCounter;

    public void leftPerimeter() {
        this.destroy();
    }

    public void resolveCollision() {

    }

    public void resolveCollision(Scoreable scoreable) {
        awardPoints(scoreable);
    }

    public abstract void awardPoints(Scoreable scoreable);

    public int getDamage() {
        return damage;
    }
}
