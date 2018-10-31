package edu.austral.starship.base.collision;

import edu.austral.starship.base.game.Asteroid;
import edu.austral.starship.base.game.Projectile;
import edu.austral.starship.base.game.Spaceship;

public interface Visitor {

    public void visitAsteroid(Asteroid asteroid);

    public void visitSpaceship(Spaceship spaceship);

    public void visitProjectile(Projectile projectile);
}
