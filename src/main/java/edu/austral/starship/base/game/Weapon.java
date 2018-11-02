package edu.austral.starship.base.game;

import edu.austral.starship.base.factory.ProjectileFactory;
import edu.austral.starship.base.vector.Vector2;
import processing.core.PImage;

public class Weapon {

    private ProjectileFactory factory;
    private Spaceship spaceship;
    private PImage image;
    private int damage;
    private float lifespan;

    public Weapon(ProjectileFactory factory, Spaceship spaceship, int damage, float lifespan, PImage image) {
        this.factory = factory;
        this.spaceship = spaceship;
        this.image = image;
        this.damage = damage;
        this.lifespan = lifespan;
    }

    public void shoot() {
        // experiemental (change this later to make it work with spaceships of several sizes)
        float height = 64;
        float x = (float) (height * 1.1 * Math.sin(spaceship.getOrientation()));
        float y = (float) (height * 1.1 * Math.cos(spaceship.getOrientation()));
        Vector2 spawnPosition = spaceship.getPosition().add(Vector2.vector(x, -y));
        // We could have the speed of the bullet as an attribute of weapon
        Vector2 velocity = Vector2.vectorFromModule(2, (float) (spaceship.getOrientation() - Math.PI/2));
        factory.createProjectile(spaceship.getPlayer(), spawnPosition, velocity, damage, lifespan, image);
    }
}
