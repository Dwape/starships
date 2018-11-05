package edu.austral.starship.base.factory;

import edu.austral.starship.base.collision.ShapedAsteroid;
import edu.austral.starship.base.collision.ShapedSpaceship;
import edu.austral.starship.base.container.DrawableContainer;
import edu.austral.starship.base.container.GameObjectContainer;
import edu.austral.starship.base.container.ShapedObjectContainer;
import edu.austral.starship.base.game.Asteroid;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.Drawable;
import edu.austral.starship.base.view.HealthBar;
import edu.austral.starship.base.view.PlaceableObject;
import edu.austral.starship.base.view.Sprite;
import processing.core.PImage;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.UUID;

public class AsteroidFactory extends Factory{

    private PImage image;

    public AsteroidFactory(ShapedObjectContainer collisionables, GameObjectContainer objects, DrawableContainer drawables, PImage image) {
        super(collisionables, objects, drawables);
        this.image = image;
    }

    public Asteroid createAsteroid(Vector2 initialPosition, Vector2 initialVelocity, float size) {

        String id = UUID.randomUUID().toString();

        Asteroid object = new Asteroid(id, initialPosition, initialVelocity, size);

        objects.addObject(object, id);

        PlaceableObject element = new PlaceableObject(object);

        Sprite drawable = new Sprite(image, element, size, size);

        //String idHealth = UUID.randomUUID().toString();
        //HealthBar bar = new HealthBar(element, Vector2.vector(0, 0), object);
        //drawables.addDrawable(bar, idHealth);
        //drawable.addChild(bar);

        drawables.addDrawable(drawable, id);

        Shape rectangle = new Rectangle2D.Float(object.getPosition().getX() - size/2, object.getPosition().getY() - size/2, size, size); // The shape could be more sophisticated

        ShapedAsteroid collisionable = new ShapedAsteroid(object, rectangle, size, size);

        collisionables.addObject(collisionable, id);

        return object;
    }
}
