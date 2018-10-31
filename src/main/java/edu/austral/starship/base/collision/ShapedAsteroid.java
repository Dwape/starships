package edu.austral.starship.base.collision;

import edu.austral.starship.base.game.Asteroid;
import edu.austral.starship.base.game.Projectile;
import edu.austral.starship.base.game.Spaceship;

import java.awt.*;

public class ShapedAsteroid extends ShapedObject{

    private Asteroid asteroid;

    public ShapedAsteroid(Asteroid asteroid, Shape shape) {
        this.asteroid = asteroid;
        super.shape = shape;
    }

    public void accept(Visitor visitor) {
        visitor.visitAsteroid(this.asteroid);
    }

    public void visitAsteroid(Asteroid asteroid) {

    }

    public void visitProjectile(Projectile projectile) {

    }

    public void visitSpaceship(Spaceship spaceship) {

    }
}
