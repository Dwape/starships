package edu.austral.starship.base.collision;

import edu.austral.starship.base.game.Asteroid;
import edu.austral.starship.base.game.Projectile;
import edu.austral.starship.base.game.Spaceship;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class ShapedSpaceship extends ShapedObject{

    private Spaceship spaceship;

    public ShapedSpaceship(Spaceship spaceship, Shape shape, float width, float height) {
        this.spaceship = spaceship;
        super.shape = shape;
        super.width = width;
        super.height = height;
    }

    public void accept(Visitor visitor) {
        visitor.visitSpaceship(this.spaceship);
    }

    public void update() {
        Shape newShape = new Rectangle2D.Float(0 - width/2, 0 - height/2, width, height);
        AffineTransform tx = new AffineTransform();
        tx.translate(spaceship.getPosition().getX(), spaceship.getPosition().getY());
        tx.rotate(spaceship.getOrientation());
        super.shape = tx.createTransformedShape(newShape);
    }

    public void visitAsteroid(Asteroid asteroid) {
        spaceship.damage((int) asteroid.getSize()/5); // We need to balance damage.
    }

    public void visitProjectile(Projectile projectile) {
        spaceship.damage(projectile.getDamage());
    }

    public void visitSpaceship(Spaceship spaceship) {
        //System.out.println("crashed");
    }
}
