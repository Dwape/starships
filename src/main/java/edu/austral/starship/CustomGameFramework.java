package edu.austral.starship;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.collision.ShapedObject;
import edu.austral.starship.base.container.DrawableContainer;
import edu.austral.starship.base.container.GameObjectContainer;
import edu.austral.starship.base.container.ShapedObjectContainer;
import edu.austral.starship.base.factory.SpaceshipFactory;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.game.BoundingBox;
import edu.austral.starship.base.game.GameObject;
import edu.austral.starship.base.game.Player;
import edu.austral.starship.base.game.Spaceship;
import edu.austral.starship.base.input.*;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.*;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomGameFramework implements GameFramework {
    
    //private List<Drawable> drawables;

    //private GameObject object2; //REMOVE

    private InputInterpreter interpreter;

    private SpaceshipFactory spaceshipFactory;

    private CollisionEngine<ShapedObject> engine;

    // This references to containers are important
    private DrawableContainer drawables = new DrawableContainer();

    private ShapedObjectContainer collisionables = new ShapedObjectContainer();

    private GameObjectContainer objects = new GameObjectContainer();

    private BoundingBox box = new BoundingBox(500, 500);
    
    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(500, 500);

        // this responsibilities should be delegated to another class

        engine = new CollisionEngine<>();

        spaceshipFactory = new SpaceshipFactory(collisionables, objects, drawables);

        PImage image = imageLoader.load("spaceship.png");

        Player player1 = new Player();
        Player player2 = new Player();

        Spaceship object = spaceshipFactory.createSpaceship(player1, Vector2.vector(150, 150), image);
        Spaceship object2 = spaceshipFactory.createSpaceship(player2, Vector2.vector(300, 300), image);

        Action moveW = new Move(object, Vector2.vector(0, -0.05f));
        Action moveS = new Move(object, Vector2.vector(0, 0.05f));
        Action rotateCW = new Rotate(object, 0.1f);
        Action rotateCCW = new Rotate(object, -0.1f);

        KeyBind keyW = new KeyBind(moveW, true, 87);
        KeyBind keyS = new KeyBind(moveS, true, 83);
        KeyBind keyD = new KeyBind(rotateCW, true, 68);
        KeyBind keyA = new KeyBind(rotateCCW, true, 65);

        interpreter = new InputInterpreter();
        interpreter.addKeyBind(keyW);
        interpreter.addKeyBind(keyA);
        interpreter.addKeyBind(keyS);
        interpreter.addKeyBind(keyD);

        Action moveUp = new Move(object2, Vector2.vector(0, -0.05f));
        Action moveDown = new Move(object2, Vector2.vector(0, 0.05f));
        Action rotateCWRight = new Rotate(object2, 0.1f);
        Action rotateCCWLeft = new Rotate(object2, -0.1f);

        KeyBind keyUp = new KeyBind(moveUp, true, 38);
        KeyBind keyDown = new KeyBind(moveDown, true, 40);
        KeyBind keyRight = new KeyBind(rotateCWRight, true, 39);
        KeyBind keyLeft = new KeyBind(rotateCCWLeft, true, 37);

        interpreter.addKeyBind(keyUp);
        interpreter.addKeyBind(keyDown);
        interpreter.addKeyBind(keyRight);
        interpreter.addKeyBind(keyLeft);
    }

    // Should draw method deal with the logic of the keys being pressed?
    // If so the name should be changed to something more representative of its new responsibility.
    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {

        // Should these things be delegated to some other class?

        for (Drawable drawable : drawables.getDrawables()) {
            drawable.draw(graphics);
        }

        for (GameObject object : objects.getObjects()) {
            box.checkBounds(object);
            object.updatePosition();
        }

        for (ShapedObject collisionable : collisionables.getObjects()) {
            collisionable.update();
        }

        engine.checkCollisions(collisionables.getObjects());

        //object2.updatePosition();

        //graphics.ellipse(150, 150, 5, 5); //REMOVE

        // Should this be done here?
        for (Integer keyCode : keySet) {
            interpreter.interpret(keyCode);
        }
    }

    // keyPressed has already been added to the keySet, what else should we do now?
    // Honestly it would make more sense to just handle all keyCodes in keySet once,
    // instead of separately for the new key
    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
