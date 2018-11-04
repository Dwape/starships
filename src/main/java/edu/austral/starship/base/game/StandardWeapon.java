package edu.austral.starship.base.game;

import edu.austral.starship.base.factory.ProjectileFactory;
import edu.austral.starship.base.vector.Vector2;

public class StandardWeapon extends Weapon{

    public StandardWeapon(ProjectileFactory factory, Spaceship spaceship, int damage, float lifespan, float speed, int delay, float size) {
        super(factory, spaceship, damage, lifespan, speed, delay, size);
    }

    public void shoot() {
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
}
