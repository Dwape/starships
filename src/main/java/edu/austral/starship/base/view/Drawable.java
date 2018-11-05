package edu.austral.starship.base.view;

import processing.core.PGraphics;

public interface Drawable {

    public void draw(PGraphics graphics);

    public void deactivate();

    public boolean isActive();

}
