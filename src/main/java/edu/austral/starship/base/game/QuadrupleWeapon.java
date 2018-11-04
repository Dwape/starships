package edu.austral.starship.base.game;

import edu.austral.starship.base.factory.ProjectileFactory;
import edu.austral.starship.base.vector.Vector2;

public class QuadrupleWeapon extends Weapon{

    public QuadrupleWeapon(ProjectileFactory factory, Spaceship spaceship, int damage, float lifespan, float speed, int delay, float size) {
        super(factory, spaceship, damage, lifespan, speed, delay, size);
    }

    public void shoot() {
        if (delayCounter > delay) {
            float height = spaceship.getHeight()/2; // half of the height of the spaceship
            float width = spaceship.getWidth()/2;

            float x1 = (float) (height * Math.sin(spaceship.getOrientation()) * (1+size/height));
            float y1 = (float) (height * Math.cos(spaceship.getOrientation()) * (1+size/height));
            Vector2 spawnPosition1 = spaceship.getPosition().add(Vector2.vector(x1, -y1));
            Vector2 velocity1 = Vector2.vectorFromModule(projectileSpeed, (float) (spaceship.getOrientation() - Math.PI/2));

            Vector2 spawnPosition2 = spaceship.getPosition().add(Vector2.vector(-x1, y1));
            Vector2 velocity2 = Vector2.vectorFromModule(projectileSpeed, (float) (spaceship.getOrientation() - 3*Math.PI/2));

            Vector2 spawnPosition3 = spaceship.getPosition().add(Vector2.vector(y1, x1));
            Vector2 velocity3 = Vector2.vectorFromModule(projectileSpeed, (float) (spaceship.getOrientation() - 2*Math.PI));

            Vector2 spawnPosition4 = spaceship.getPosition().add(Vector2.vector(-y1, -x1));
            Vector2 velocity4 = Vector2.vectorFromModule(projectileSpeed, (float) (spaceship.getOrientation() - Math.PI));

            factory.createProjectile(spaceship.getPlayer(), spawnPosition1, velocity1, damage, lifespan, size);
            factory.createProjectile(spaceship.getPlayer(), spawnPosition2, velocity2, damage, lifespan, size);
            factory.createProjectile(spaceship.getPlayer(), spawnPosition3, velocity3, damage, lifespan, size);
            factory.createProjectile(spaceship.getPlayer(), spawnPosition4, velocity4, damage, lifespan, size);

            this.delayCounter = 0;
        }
    }
}
