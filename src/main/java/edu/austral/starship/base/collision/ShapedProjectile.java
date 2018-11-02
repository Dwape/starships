package edu.austral.starship.base.collision;

import edu.austral.starship.base.game.Asteroid;
import edu.austral.starship.base.game.Projectile;
import edu.austral.starship.base.game.Spaceship;

import java.awt.*;

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

    public void update() {

    }

    public void visitAsteroid(Asteroid asteroid) {

    }

    public void visitProjectile(Projectile projectile) {

    }

    public void visitSpaceship(Spaceship spaceship) {

    }
}
