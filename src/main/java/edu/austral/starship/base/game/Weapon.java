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
    private float size;

    public Weapon(ProjectileFactory factory, Spaceship spaceship, int damage, float lifespan, float speed, int delay, float size) {
        this.factory = factory;
        this.spaceship = spaceship;
        this.damage = damage;
        this.lifespan = lifespan;
        this.projectileSpeed = speed;
        this.delay = delay;
        this.delayCounter = delay+1; // the player can start the game shooting
        this.size = size;
    }

    public void shoot() {
        // experiemental (change this later to make it work with spaceships of several sizes)
        if (delayCounter > delay) {
            float height = spaceship.getHeight()/2; // half of the height of the spaceship
            float x = (float) (height * Math.sin(spaceship.getOrientation()) * (1+size/height)); //1.1
            float y = (float) (height * Math.cos(spaceship.getOrientation()) * (1+size/height)); //1.1
            Vector2 spawnPosition = spaceship.getPosition().add(Vector2.vector(x, -y));
            // We could have the speed of the bullet as an attribute of weapon
            Vector2 velocity = Vector2.vectorFromModule(projectileSpeed, (float) (spaceship.getOrientation() - Math.PI/2));
            //velocity = velocity.add(spaceship.getVelocity());
            factory.createProjectile(spaceship.getPlayer(), spawnPosition, velocity, damage, lifespan, size);
            this.delayCounter = 0;
        }
    }

    public void update() {
        this.delayCounter++;
    }
}
