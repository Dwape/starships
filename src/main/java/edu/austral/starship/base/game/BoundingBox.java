package edu.austral.starship.base.game;

import edu.austral.starship.base.vector.Vector2;

public class BoundingBox {

    private Vector2 box;

    public BoundingBox(float height, float width) {
        this.box = Vector2.vector(width, height);
    }

    //public boolean isInside()
}
