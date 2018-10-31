package edu.austral.starship.base.factory;

import edu.austral.starship.base.container.DrawableContainer;
import edu.austral.starship.base.container.GameObjectContainer;
import edu.austral.starship.base.container.ShapedObjectContainer;

public class ProjectileFactory extends Factory{

    public ProjectileFactory(ShapedObjectContainer collisionables, GameObjectContainer objects, DrawableContainer drawables) {
        super(collisionables, objects, drawables);
    }
}
