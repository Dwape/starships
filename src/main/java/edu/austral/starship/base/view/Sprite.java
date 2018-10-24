package edu.austral.starship.base.view;

import edu.austral.starship.base.vector.Vector2;
import processing.core.PGraphics;
import processing.core.PImage;

public class Sprite implements Drawable{

    public PImage image;

    public Placeable placeable;

    public Sprite(PImage image, Placeable placeable) {
        this.image = image;
        this.placeable = placeable;
    }

    public void draw(PGraphics graphics) {
        Vector2 position = placeable.getPosition();
        graphics.image(image, position.getX(), position.getY());
    }
}
