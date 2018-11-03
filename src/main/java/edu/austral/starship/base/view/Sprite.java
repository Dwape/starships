package edu.austral.starship.base.view;

import edu.austral.starship.base.vector.Vector2;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

public class Sprite implements Drawable{

    // Shouldn't there be an image size?

    public PImage image;

    public PlaceableObject placeable;

    private float width;

    private float height;

    public Sprite(PImage image, PlaceableObject placeable, float width, float height) {
        this.image = image;
        this.placeable = placeable;
        this.width = width;
        this.height = height;
    }

    public void draw(PGraphics graphics) {

        // REMOVE

        graphics.pushMatrix();
        graphics.rectMode(PConstants.CENTER);
        graphics.translate(placeable.getPosition().getX(), placeable.getPosition().getY());
        graphics.rotate(placeable.getOrientation());
        graphics.rect(0, 0, width, height);
        graphics.popMatrix();

        // END REMOVE

        graphics.pushMatrix();
        //Vector2 position = placeable.getPosition().substract(Vector2.vector(width/2, height/2));
        graphics.imageMode(PConstants.CENTER);
        //graphics.translate(position.getX(), position.getY());
        graphics.translate(placeable.getPosition().getX(), placeable.getPosition().getY());
        graphics.rotate(placeable.getOrientation());
        graphics.image(image, 0, 0, width, height);
        graphics.popMatrix();
    }
}
