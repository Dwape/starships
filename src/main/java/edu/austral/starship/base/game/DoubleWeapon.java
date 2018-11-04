package edu.austral.starship.base.game;

import edu.austral.starship.base.factory.ProjectileFactory;
import edu.austral.starship.base.vector.Vector2;

public class DoubleWeapon extends Weapon{

    public DoubleWeapon(ProjectileFactory factory, Spaceship spaceship, int damage, float lifespan, float speed, int delay, float size) {
        super(factory, spaceship, damage, lifespan, speed, delay, size);
    }

    public void shoot() {
        if (delayCounter > delay) {
            float height = spaceship.getHeight()/2; // half of the height of the spaceship
            float width = spaceship.getWidth()/2;

            float x = (float) (height * Math.sin(spaceship.getOrientation()) * (1+size/height));
            float y = (float) (height * Math.cos(spaceship.getOrientation()) * (1+size/height));
            Vector2 spawnPosition1 = spaceship.getPosition().add(Vector2.vector(x, -y));
            Vector2 velocity1 = Vector2.vectorFromModule(projectileSpeed, (float) (spaceship.getOrientation() - Math.PI/2));

            Vector2 spawnPosition2 = spaceship.getPosition().add(Vector2.vector(-x, y));
            Vector2 velocity2 = Vector2.vectorFromModule(projectileSpeed, (float) (spaceship.getOrientation() - 3*Math.PI/2));

            factory.createProjectile(spaceship.getPlayer(), spawnPosition1, velocity1, damage, lifespan, size);
            factory.createProjectile(spaceship.getPlayer(), spawnPosition2, velocity2, damage, lifespan, size);
            this.delayCounter = 0;
        }
    }
}
