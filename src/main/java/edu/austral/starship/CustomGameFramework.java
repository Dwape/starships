package edu.austral.starship;

import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.game.GameObject;
import edu.austral.starship.base.game.Spaceship;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.*;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomGameFramework implements GameFramework {
    
    public List<Drawable> drawables;

    public GameObject object2;
    
    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(500, 500);
        
        drawables = new ArrayList<>();
        //Placeable element = new UIElement(Vector2.vector(10, 10));
        GameObject object = new Spaceship(10, Vector2.vector(150, 10), Vector2.vector(0, 0.5f));
        object2 = object;
        Placeable element = new PlaceableObject(object);
        /*
        Drawable drawable = new Label(element, "Executive producer Eduardo Lalor", Vector2.vector(0, 0));
        Drawable drawable2 = new Label(element, "Music by Eduardo Lalor", Vector2.vector(0, 30));
        Drawable drawable3 = new Label(element, "Special thanks to Eduardo Lalor", Vector2.vector(0, 60));
        drawables.add(drawable);
        drawables.add(drawable2);
        drawables.add(drawable3);
        */
        PImage image = imageLoader.load("spaceship.png");
        Drawable drawable = new Sprite(image, element);
        drawables.add(drawable);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        for (Drawable drawable : drawables) {
            drawable.draw(graphics);
        }
        object2.updatePosition();
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
