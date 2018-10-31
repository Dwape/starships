package edu.austral.starship.base.collision;

import java.awt.*;

public abstract class ShapedObject implements Collisionable<ShapedObject>, Visitor, Visitable {

    Shape shape;

    public void collisionedWith(ShapedObject object) {
        object.accept(this);
    }

    public Shape getShape() {
        return shape;
    }
}
