package edu.austral.starship.base.collision;

import edu.austral.starship.base.game.Asteroid;
import edu.austral.starship.base.game.Projectile;
import edu.austral.starship.base.game.Spaceship;
import edu.austral.starship.base.vector.Vector2;

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

    // We need to rotate the shape
    public void update() {
        Shape newShape = new Rectangle2D.Float(0 - width/2, 0 - height/2, width, height);
        AffineTransform tx = new AffineTransform();
        tx.translate(spaceship.getPosition().getX() - width/2, spaceship.getPosition().getY() - width/2);
        tx.rotate(spaceship.getOrientation());
        super.shape = tx.createTransformedShape(newShape);
        //shape = tx.createTransformedShape(newShape);
        //super.shape = new Rectangle2D.Float(spaceship.getPosition().getX() - width/2, spaceship.getPosition().getY() - width/2, width, height);
    }

    public void visitAsteroid(Asteroid asteroid) {

    }

    public void visitProjectile(Projectile projectile) {

    }

    public void visitSpaceship(Spaceship spaceship) {
    }
}
