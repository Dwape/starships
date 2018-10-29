package edu.austral.starship;

import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.game.GameObject;
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
    
    private List<Drawable> drawables;

    private GameObject object2; //REMOVE

    private InputInterpreter interpreter;
    
    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(500, 500);
        
        drawables = new ArrayList<>();
        //Placeable element = new UIElement(Vector2.vector(10, 10));
        Spaceship object = new Spaceship(10, Vector2.vector(150, 10), Vector2.vector(0, 0));
        object2 = object;
        Placeable element = new PlaceableObject(object);

        // acceleration values should be way smaller
        Action moveW = new Move(object, Vector2.vector(0, -0.05f));
        Action moveA = new Move(object, Vector2.vector(-0.05f, 0));
        Action moveS = new Move(object, Vector2.vector(0, 0.05f));
        Action moveD = new Move(object, Vector2.vector(0.05f, 0));

        Action rotateCW = new Rotate(object, 0.1f);
        Action rotateCCW = new Rotate(object, -0.1f);

        // Check how to map keys to keyCodes better (or work directly with keys).
        KeyBind keyW = new KeyBind(moveW, true, 87);
        KeyBind keyA = new KeyBind(moveA, true, 65);
        KeyBind keyS = new KeyBind(moveS, true, 83);
        KeyBind keyD = new KeyBind(moveD, true, 68);

        KeyBind keyE = new KeyBind(rotateCW, true, 69);
        KeyBind keyQ = new KeyBind(rotateCCW, true, 81);

        interpreter = new InputInterpreter();
        interpreter.addKeyBind(keyW);
        interpreter.addKeyBind(keyA);
        interpreter.addKeyBind(keyS);
        interpreter.addKeyBind(keyD);

        interpreter.addKeyBind(keyE);
        interpreter.addKeyBind(keyQ);

        /*
        Drawable drawable = new Label(element, "Executive producer Eduardo Lalor", Vector2.vector(0, 0));
        Drawable drawable2 = new Label(element, "Music by Eduardo Lalor", Vector2.vector(0, 30));
        Drawable drawable3 = new Label(element, "Special thanks to Eduardo Lalor", Vector2.vector(0, 60));
        drawables.add(drawable);
        drawables.add(drawable2);
        drawables.add(drawable3);
        */
        PImage image = imageLoader.load("spaceship.png");
        Drawable drawable = new Sprite(image, element, 128, 128);
        drawables.add(drawable);
    }

    // Should draw method deal with the logic of the keys being pressed?
    // If so the name should be changed to something more representative of its new responsibility.
    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        for (Drawable drawable : drawables) {
            drawable.draw(graphics);
        }
        object2.updatePosition();

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
