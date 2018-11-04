package edu.austral.starship.base.collision;

import edu.austral.starship.base.game.Asteroid;
import edu.austral.starship.base.game.Projectile;
import edu.austral.starship.base.game.Spaceship;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class ShapedProjectile extends ShapedObject{

    private Projectile projectile;

    public ShapedProjectile(Projectile projectile, Shape shape, float width, float height) {
        this.projectile = projectile;
        super.shape = shape;
        super.width = width;
        super.height = height;
    }

    public void accept(Visitor visitor) {
        visitor.visitProjectile(this.projectile);
    }

    // This could be changed to use the previous shape (In case we want projectiles to have different shapes)
    public void update() {
        //Shape newShape = new Ellipse2D.Float(0 - width/2, 0 - height/2, width, height);

        /*
        Shape newShape = new Rectangle2D.Float(0 - width/2, 0 - height/2, width, height);
        AffineTransform tx = new AffineTransform();
        tx.translate(projectile.getPosition().getX() - width/2, projectile.getPosition().getY() - height/2);
        //tx.rotate(projectile.getOrientation());
        super.shape = tx.createTransformedShape(newShape);
        */

        // For some reason the collider is not in the right place
        super.shape = new Rectangle2D.Float(projectile.getPosition().getX() - width/2, projectile.getPosition().getY() - height/2, width, height);
    }

    public void visitAsteroid(Asteroid asteroid) {
        //this.projectile.resolveCollision(asteroid);
        if (projectile.getDamage() >= asteroid.getHealth()) {
            projectile.resolveCollision(asteroid);
        }
        this.projectile.destroy();
    }

    public void visitProjectile(Projectile projectile) {

    }

    public void visitSpaceship(Spaceship spaceship) {
        //this.projectile.resolveCollision(spaceship);
        if (projectile.getDamage() >= spaceship.getHealth()) {
            projectile.resolveCollision(spaceship);
        }
        this.projectile.destroy();
    }
}
