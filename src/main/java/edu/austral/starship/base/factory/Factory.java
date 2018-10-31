package edu.austral.starship.base.factory;

import edu.austral.starship.base.collision.ShapedObject;
import edu.austral.starship.base.container.DrawableContainer;
import edu.austral.starship.base.container.GameObjectContainer;
import edu.austral.starship.base.container.ShapedObjectContainer;

public abstract class Factory {

    ShapedObjectContainer collisionables;

    GameObjectContainer objects;

    DrawableContainer drawables;

    public Factory(ShapedObjectContainer collisionables, GameObjectContainer objects, DrawableContainer drawables) {
        this.collisionables = collisionables;
        this.objects = objects;
        this.drawables = drawables;
    }
}
