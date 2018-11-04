package edu.austral.starship.base.collision;

import edu.austral.starship.base.game.Asteroid;
import edu.austral.starship.base.game.Projectile;
import edu.austral.starship.base.game.Spaceship;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ShapedAsteroid extends ShapedObject{

    private Asteroid asteroid;

    public ShapedAsteroid(Asteroid asteroid, Shape shape, float width, float height) {
        this.asteroid = asteroid;
        super.shape = shape;
        super.width = width;
        super.height = height;
    }

    public void accept(Visitor visitor) {
        visitor.visitAsteroid(this.asteroid);
    }

    public void update() {
        super.shape = new Rectangle2D.Float(asteroid.getPosition().getX() - width/2, asteroid.getPosition().getY() - height/2, width, height);
    }

    public void visitAsteroid(Asteroid asteroid) {

    }

    public void visitProjectile(Projectile projectile) {
        asteroid.damage(projectile.getDamage());
    }

    public void visitSpaceship(Spaceship spaceship) {
        asteroid.destroy();
    }
}
