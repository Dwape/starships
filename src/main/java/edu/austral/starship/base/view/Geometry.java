package edu.austral.starship.base.view;

import processing.core.PGraphics;
import processing.core.PShape;

public class Geometry implements Drawable{

    public Placeable placeable;

    public PShape shape;

    private boolean activated;

    public void draw(PGraphics graphics) {

    }

    public void deactivate() {
        activated = false;
    }

    public boolean isActive() {
        return activated;
    }
}
