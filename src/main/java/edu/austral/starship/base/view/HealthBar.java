package edu.austral.starship.base.view;

import edu.austral.starship.base.game.Damageable;
import edu.austral.starship.base.vector.Vector2;
import processing.core.PConstants;
import processing.core.PGraphics;

public class HealthBar implements Drawable{

    private PlaceableObject placeable;
    private Damageable damageable;
    private Vector2 offset;

    public HealthBar(PlaceableObject object, Vector2 offset, Damageable damageable) {
        this.placeable = object;
        this.damageable = damageable;
        this.offset = offset;
    }

    public void draw(PGraphics graphics) {
        if (damageable.getHealth() > 0) {
            //Vector2 position = placeable.getPosition();
            //Vector2 newPosition = position.add(offset);
            //graphics.text(damageable.getHealth() + "/" + damageable.getMaxHealth(), newPosition.getX(), newPosition.getY());
            graphics.pushMatrix();
            //graphics.rectMode(PConstants.CENTER);
            graphics.translate(placeable.getPosition().getX()-50, placeable.getPosition().getY()+64);
            graphics.pushStyle();
            graphics.fill(255, 0, 0);
            graphics.rect(0, 0, damageable.getMaxHealth(), 5);
            graphics.fill(0, 255, 0);
            graphics.rect(0, 0, damageable.getHealth(), 5);
            graphics.popStyle();
            graphics.popMatrix();
        }
    }
}
