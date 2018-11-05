package edu.austral.starship.base.view;

import edu.austral.starship.base.vector.Vector2;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class Sprite implements Drawable{

    // Shouldn't there be an image size?

    public PImage image;

    public PlaceableObject placeable;

    private float width;

    private float height;

    private boolean activated;

    private List<Drawable> children;

    public Sprite(PImage image, PlaceableObject placeable, float width, float height) {
        this.image = image;
        this.placeable = placeable;
        this.width = width;
        this.height = height;
        this.activated = true;
        this.children = new ArrayList<>();
    }

    public void draw(PGraphics graphics) {

        // REMOVE
        /*
        graphics.pushMatrix();
        graphics.rectMode(PConstants.CENTER);
        graphics.translate(placeable.getPosition().getX(), placeable.getPosition().getY());
        graphics.rotate(placeable.getOrientation());
        graphics.rect(0, 0, width, height);
        graphics.popMatrix();
        */
        // END REMOVE

        graphics.pushMatrix();
        //Vector2 position = placeable.getPosition().substract(Vector2.vector(width/2, height/2));
        graphics.imageMode(PConstants.CENTER);
        //graphics.translate(position.getX(), position.getY());
        graphics.translate(placeable.getPosition().getX(), placeable.getPosition().getY());
        graphics.rotate(placeable.getOrientation());
        graphics.image(image, 0, 0, width, height);
        graphics.popMatrix();

        for (Drawable child : children) {
            child.draw(graphics);
        }
    }

    public void addChild(Drawable drawable) {
        children.add(drawable);
    }

    public void deactivate() {
        activated = false;
        for (Drawable child : children) {
            child.deactivate();
        }
    }

    public boolean isActive() {
        return activated;
    }
}
