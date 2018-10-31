package edu.austral.starship.base.factory;

import edu.austral.starship.base.collision.ShapedObject;
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

        Drawable drawable = new Sprite(image, element, 128, 128);

        drawables.addDrawable(drawable, id);

        //ShapedObject collisionable = new ShapedObject(); //TODO

        return object;
    }
}
