package edu.austral.starship.base.factory;

import edu.austral.starship.base.collision.ShapedObject;
import edu.austral.starship.base.collision.ShapedSpaceship;
import edu.austral.starship.base.container.DrawableContainer;
import edu.austral.starship.base.container.GameObjectContainer;
import edu.austral.starship.base.container.ShapedObjectContainer;
import edu.austral.starship.base.game.Player;
import edu.austral.starship.base.game.Spaceship;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.Drawable;
import edu.austral.starship.base.view.Placeable;
import edu.austral.starship.base.view.PlaceableObject;
import edu.austral.starship.base.view.Sprite;
import processing.core.PImage;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.UUID;


public class SpaceshipFactory extends Factory{

    public SpaceshipFactory(ShapedObjectContainer collisionables, GameObjectContainer objects, DrawableContainer drawables) {
        super(collisionables, objects, drawables);
    }

    public Spaceship createSpaceship(Player player, Vector2 initialPosition, PImage image) {

        String id = UUID.randomUUID().toString();

        Spaceship object = new Spaceship(id, initialPosition, player, 100, 3);

        objects.addObject(object, id);

        PlaceableObject element = new PlaceableObject(object);

        int width = 128;

        int height = 128;

        Drawable drawable = new Sprite(image, element, width, height);

        drawables.addDrawable(drawable, id);

        //ShapedObject collisionable = new ShapedObject(); //TODO

        // Should this be done here or in every iteration?
        //Vector2 position = object.getPosition().substract(Vector2.vector(width/2, height/2));

        Shape rectangle = new Rectangle2D.Float(object.getPosition().getX() - width/2, object.getPosition().getY() - height/2, width, height); // The shape could be more sophisticated

        ShapedSpaceship collisionable = new ShapedSpaceship(object, rectangle, width, height);

        collisionables.addObject(collisionable, id);

        return object;
    }
}
