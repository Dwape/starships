package edu.austral.starship.base.collision;

import edu.austral.starship.base.game.Asteroid;
import edu.austral.starship.base.game.Projectile;
import edu.austral.starship.base.game.Spaceship;

import java.awt.*;

public class ShapedSpaceship extends ShapedObject{

    private Spaceship spaceship;

    public ShapedSpaceship(Spaceship spaceship, Shape shape) {
        this.spaceship = spaceship;
        super.shape = shape;
    }

    public void accept(Visitor visitor) {
        visitor.visitSpaceship(this.spaceship);
    }

    public void visitAsteroid(Asteroid asteroid) {

    }

    public void visitProjectile(Projectile projectile) {

    }

    public void visitSpaceship(Spaceship spaceship) {

    }
}
