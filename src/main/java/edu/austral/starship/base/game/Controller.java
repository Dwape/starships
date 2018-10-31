package edu.austral.starship.base.game;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.container.GameObjectContainer;
import edu.austral.starship.base.container.ShapedObjectContainer;
import edu.austral.starship.base.factory.AsteroidFactory;
import edu.austral.starship.base.framework.GameFramework;
import processing.core.PGraphics;

public class Controller {

    private AsteroidFactory asteroidFactory;

    private BoundingBox box;

    private ShapedObjectContainer collisionables;

    private CollisionEngine collisionEngine;

    private GameFramework framework;

    private PGraphics pGraphics;

    private GameObjectContainer objects;

    public void drawScene() {

    }

    public void loop() {

    }

    private void updateState() {

    }
}
