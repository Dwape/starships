package edu.austral.starship.base.view;

import edu.austral.starship.base.vector.Vector2;
import processing.core.PGraphics;
import processing.core.PImage;

public class Sprite implements Drawable{

    // Shouldn't there be an image size?

    public PImage image;

    public Placeable placeable;

    private float width;

    private float height;

    public Sprite(PImage image, Placeable placeable, float width, float height) {
        this.image = image;
        this.placeable = placeable;
        this.width = width;
        this.height = height;
    }

    public void draw(PGraphics graphics) {
        Vector2 position = placeable.getPosition();
        graphics.image(image, position.getX(), position.getY(), width, height);
    }
}
