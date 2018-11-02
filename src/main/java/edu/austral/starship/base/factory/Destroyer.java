package edu.austral.starship.base.factory;

import edu.austral.starship.base.container.DrawableContainer;
import edu.austral.starship.base.container.GameObjectContainer;
import edu.austral.starship.base.container.ShapedObjectContainer;

public class Destroyer {

    private DrawableContainer drawables;

    private ShapedObjectContainer collisionables;

    private GameObjectContainer objects;

    public Destroyer(DrawableContainer drawables, ShapedObjectContainer collisionables, GameObjectContainer objects) {
        this.drawables = drawables;
        this.collisionables = collisionables;
        this.objects = objects;
    }

    public void destroy(String id) {
        drawables.removeDrawable(id);
        collisionables.removeObject(id);
        objects.removeObject(id);
    }
}
