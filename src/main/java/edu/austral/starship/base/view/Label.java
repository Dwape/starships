package edu.austral.starship.base.view;

import edu.austral.starship.base.vector.Vector2;
import processing.core.PGraphics;

public class Label implements Drawable{

    public Placeable placeable; //we could add a movable ai element (maybe)

    public String text;

    public Vector2 offset; //this would allow to write text over a spaceship, for example.

    public Label(Placeable placeable, String text, Vector2 offset) {
        this.placeable = placeable;
        this.text = text;
        this.offset = offset;
    }

    public void draw(PGraphics graphics) {
        Vector2 position = placeable.getPosition();
        Vector2 newPosition = position.add(offset);
        graphics.text(text, newPosition.getX(), newPosition.getY());
    }
}
