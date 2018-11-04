package edu.austral.starship.base.game;

import edu.austral.starship.base.factory.ProjectileFactory;

public abstract class Weapon {

    ProjectileFactory factory;
    Spaceship spaceship;
    int damage;
    float lifespan;
    float projectileSpeed;
    int delay;
    int delayCounter;
    float size;

    public Weapon(ProjectileFactory factory, Spaceship spaceship, int damage, float lifespan, float speed, int delay, float size) {
        this.factory = factory;
        this.spaceship = spaceship;
        this.damage = damage;
        this.lifespan = lifespan;
        this.projectileSpeed = speed;
        this.delay = delay;
        this.delayCounter = delay+1;
        this.size = size;
    }

    public abstract void shoot();

    public void update() {
        this.delayCounter++;
    }
}
