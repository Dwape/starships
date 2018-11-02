package edu.austral.starship.base.collision;

import java.awt.*;

public abstract class ShapedObject implements Collisionable<ShapedObject>, Visitor, Visitable {

    Shape shape; // We could have no shape and create it when it is asked for

    float width;

    float height;

    public void collisionedWith(ShapedObject object) {
        object.accept(this);
    }

    public Shape getShape() {
        return shape;
    }

    public abstract void update();
}
