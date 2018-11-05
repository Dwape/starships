package edu.austral.starship.base.view;

import edu.austral.starship.base.vector.Vector2;
import processing.core.PGraphics;

public class Label implements Drawable{

    private Placeable placeable; //we could add a movable ai element (maybe)

    private String beginning;

    private String end;

    private Valuable valuable;

    private Vector2 offset; //this would allow to write text over a spaceship, for example.

    private boolean activated;

    public Label(Placeable placeable, String beginning, String end, Valuable valuable, Vector2 offset) {
        this.placeable = placeable;
        this.beginning = beginning;
        this.end = end;
        this.offset = offset;
        this.valuable = valuable;
        this.activated = true;
    }

    public Label(Placeable placeable, String beginning, Vector2 offset) {
        this.placeable = placeable;
        this.beginning = beginning;
        this.end = "";
        this.offset = offset;
        this.valuable = new NoValue();
        this.activated = true;
    }

    public void draw(PGraphics graphics) {
        Vector2 position = placeable.getPosition();
        Vector2 newPosition = position.add(offset);
        graphics.text(beginning + valuable.getValue() + end, newPosition.getX(), newPosition.getY());
    }

    public void deactivate() {
        activated = false;
    }

    public boolean isActive() {
        return activated;
    }

    private class NoValue implements Valuable {

        public String getValue() {
            return "";
        }
    }
}
