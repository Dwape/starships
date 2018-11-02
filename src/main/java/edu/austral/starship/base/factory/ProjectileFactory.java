package edu.austral.starship.base.factory;

import edu.austral.starship.base.collision.ShapedProjectile;
import edu.austral.starship.base.container.DrawableContainer;
import edu.austral.starship.base.container.GameObjectContainer;
import edu.austral.starship.base.container.ShapedObjectContainer;
import edu.austral.starship.base.game.Player;
import edu.austral.starship.base.game.PlayerProjectile;
import edu.austral.starship.base.game.Projectile;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.Drawable;
import edu.austral.starship.base.view.PlaceableObject;
import edu.austral.starship.base.view.Sprite;
import processing.core.PImage;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.UUID;

public class ProjectileFactory extends Factory{

    public ProjectileFactory(ShapedObjectContainer collisionables, GameObjectContainer objects, DrawableContainer drawables) {
        super(collisionables, objects, drawables);
    }

    public Projectile createProjectile(Player player, Vector2 initialPosition, Vector2 velocity, int damage, float lifespan, PImage image) {

        String id = UUID.randomUUID().toString();

        //check lifespan value
        Projectile object = new PlayerProjectile(id, player, initialPosition, velocity, damage, lifespan);

        objects.addObject(object, id);

        PlaceableObject element = new PlaceableObject(object);

        int size = 10; // This should be a variable in projectile

        Drawable drawable = new Sprite(image, element, size, size);

        drawables.addDrawable(drawable, id);

        Shape ellipse = new Ellipse2D.Float(object.getPosition().getX() - size/2, object.getPosition().getY() - size/2, size, size);

        ShapedProjectile collisionable = new ShapedProjectile(object, ellipse, size, size);

        collisionables.addObject(collisionable, id);

        return object;
    }
}
