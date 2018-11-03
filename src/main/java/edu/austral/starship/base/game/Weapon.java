package edu.austral.starship.base.game;

import edu.austral.starship.base.factory.ProjectileFactory;
import edu.austral.starship.base.vector.Vector2;
import processing.core.PImage;

public class Weapon {

    private ProjectileFactory factory;
    private Spaceship spaceship;
    private int damage;
    private float lifespan;
    private float projectileSpeed;
    private int delay;
    private int delayCounter;

    public Weapon(ProjectileFactory factory, Spaceship spaceship, int damage, float lifespan) {
        this.factory = factory;
        this.spaceship = spaceship;
        this.damage = damage;
        this.lifespan = lifespan;
        this.projectileSpeed = 2;
        this.delay = 10;
        this.delayCounter = delay+1; // the player can start the game shooting
    }

    public void shoot() {
        // experiemental (change this later to make it work with spaceships of several sizes)
        if (delayCounter > delay) {
            float height = 64; // half of the height of the spaceship
            float x = (float) (height * 1.1 * Math.sin(spaceship.getOrientation())); //1.1
            float y = (float) (height * 1.1 * Math.cos(spaceship.getOrientation())); //1.1
            Vector2 spawnPosition = spaceship.getPosition().add(Vector2.vector(x, -y));
            // We could have the speed of the bullet as an attribute of weapon
            Vector2 velocity = Vector2.vectorFromModule(projectileSpeed, (float) (spaceship.getOrientation() - Math.PI/2));
            //velocity = velocity.add(spaceship.getVelocity());
            factory.createProjectile(spaceship.getPlayer(), spawnPosition, velocity, damage, lifespan);

            this.delayCounter = 0;
        }
    }

    public void update() {
        this.delayCounter++;
    }
}
