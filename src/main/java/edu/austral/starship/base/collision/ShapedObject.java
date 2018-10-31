package edu.austral.starship.base.collision;

import java.awt.*;

public class ShapedObject implements Collisionable<ShapedObject>{

    private Shape shape;

    public void collisionedWith(ShapedObject object) {

    }

    public Shape getShape() {
        return shape;
    }
}
