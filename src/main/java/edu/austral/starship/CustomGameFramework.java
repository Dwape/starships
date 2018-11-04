package edu.austral.starship;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.collision.ShapedObject;
import edu.austral.starship.base.container.DrawableContainer;
import edu.austral.starship.base.container.GameObjectContainer;
import edu.austral.starship.base.container.ShapedObjectContainer;
import edu.austral.starship.base.factory.AsteroidFactory;
import edu.austral.starship.base.factory.Destroyer;
import edu.austral.starship.base.factory.ProjectileFactory;
import edu.austral.starship.base.factory.SpaceshipFactory;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.base.game.*;
import edu.austral.starship.base.input.*;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.base.view.*;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CustomGameFramework implements GameFramework {

    private InputInterpreter interpreter;

    private AsteroidSpawner asteroidSpawner;

    private CollisionEngine<ShapedObject> engine;

    private DrawableContainer drawables = new DrawableContainer();

    private ShapedObjectContainer collisionables = new ShapedObjectContainer();

    private GameObjectContainer objects = new GameObjectContainer();

    private BoundingBox box = new BoundingBox(500, 500);

    private Destroyer destroyer;

    private List<Spaceship> spaceships = new ArrayList<>();
    
    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
            .setSize(500, 500)
                .enableHighPixelDensity();

        destroyer = new Destroyer(drawables, collisionables, objects);

        engine = new CollisionEngine<>();

        SpaceshipFactory spaceshipFactory = new SpaceshipFactory(collisionables, objects, drawables);

        PImage asteroidImage = imageLoader.load("asteroid.png");

        PImage projectileImage = imageLoader.load("projectile.png");

        AsteroidFactory asteroidFactory = new AsteroidFactory(collisionables, objects, drawables, asteroidImage);

        asteroidSpawner = new AsteroidSpawner(asteroidFactory, 50, 2, 50, Vector2.vector(500, 500));

        interpreter = new InputInterpreter();

        int numberOfPlayers = 2;

        int[] keys1 = {87, 83, 68, 65, 69, 81};
        PImage spaceship1Image = imageLoader.load("spaceship1.png");
        Player player1 = createPlayer(spaceship1Image, Vector2.vector(150, 150), keys1, projectileImage, spaceshipFactory);
        createScoreLabel(player1, Vector2.vector(30, 30), 1);

        int[] keys2 = {38, 40, 39, 37, 16, 18};
        PImage spaceship2Image = imageLoader.load("spaceship2.png");
        Player player2 = createPlayer(spaceship2Image, Vector2.vector(300, 300), keys2, projectileImage, spaceshipFactory);
        createScoreLabel(player2, Vector2.vector(30, 50), 2);

        /*
        int[] keys3 = {80, 186, 222, 76, 219, 79};
        PImage spaceship3Image = imageLoader.load("spaceship3.png");
        Player player3 = createPlayer(spaceship3Image, Vector2.vector(150, 300), keys3, projectileImage, spaceshipFactory);
        createScoreLabel(player3, Vector2.vector(30, 70), 3);

        int[] keys4 = {38, 40, 39, 37, 16, 18};
        PImage spaceship4Image = imageLoader.load("spaceship4.png");
        Player player4 = createPlayer(spaceship4Image, Vector2.vector(300, 150), keys4, projectileImage, spaceshipFactory);
        createScoreLabel(player4, Vector2.vector(30, 90), 4);
        */
    }

    // Should draw method deal with the logic of the keys being pressed?
    // If so the name should be changed to something more representative of its new responsibility.
    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {

        for (Drawable drawable : drawables.getDrawables()) {
            drawable.draw(graphics);
        }

        for (GameObject object : objects.getObjects()) {
            box.checkBounds(object);
            if (object.isDestroyed()) {
                destroyer.destroy(object.getId());
            } else {
                object.update();
            }
        }

        for (ShapedObject collisionable : collisionables.getObjects()) {
            collisionable.update();
        }

        engine.checkCollisions(collisionables.getObjects());

        for (Integer keyCode : keySet) {
            interpreter.interpret(keyCode);
        }

        asteroidSpawner.update();
        asteroidSpawner.create();

        int playersAlive = 0;
        for (Spaceship spaceship : spaceships) {
            if (!spaceship.isDestroyed()) {
                playersAlive++;
            }
        }
        if (playersAlive == 0) {
            drawables = new DrawableContainer();
            collisionables = new ShapedObjectContainer();
            objects = new GameObjectContainer();
            for (int i=0; i <spaceships.size(); i++) {
                createScoreLabel(spaceships.get(i).getPlayer(), Vector2.vector(210, 100 + 20*i), i+1);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    private Player createPlayer(PImage image, Vector2 initialPosition, int[] keys, PImage projectileImage, SpaceshipFactory factory) {
        Player player = new Player();
        Spaceship spaceship = factory.createSpaceship(player, initialPosition, image, 128, 128);

        Action moveW = new Move(spaceship, Vector2.vector(0, -0.05f));
        Action moveS = new Move(spaceship, Vector2.vector(0, 0.05f));
        Action rotateCW = new Rotate(spaceship, 0.1f);
        Action rotateCCW = new Rotate(spaceship, -0.1f);
        Action shoot = new Shoot(spaceship);
        Action switchWeapon = new SwitchWeapon(spaceship);

        KeyBind keyW = new KeyBind(moveW, true, keys[0]);
        KeyBind keyS = new KeyBind(moveS, true, keys[1]);
        KeyBind keyD = new KeyBind(rotateCW, true, keys[2]);
        KeyBind keyA = new KeyBind(rotateCCW, true, keys[3]);
        KeyBind keyShoot = new KeyBind(shoot, true, keys[4]);
        KeyBind keySwitch = new KeyBind(switchWeapon, true, keys[5]);

        interpreter.addKeyBind(keyW);
        interpreter.addKeyBind(keyS);
        interpreter.addKeyBind(keyD);
        interpreter.addKeyBind(keyA);
        interpreter.addKeyBind(keyShoot);
        interpreter.addKeyBind(keySwitch);

        ProjectileFactory projectileFactory = new ProjectileFactory(collisionables, objects, drawables, projectileImage);

        Weapon weapon = new Weapon(projectileFactory, spaceship, 10, 150,2,10, 50);
        Weapon weapon2 = new Weapon(projectileFactory, spaceship, 10, 150, 5, 10, 10);

        spaceship.addWeapon(weapon);
        spaceship.addWeapon(weapon2);

        spaceships.add(spaceship);

        return player;
    }

    private void createScoreLabel(Player player, Vector2 position, int playerNumber) {
        Valuable score = new Score(player);

        Placeable spot = new UIElement(position);

        Drawable label = new Label(spot, "Player " + Integer.toString(playerNumber)+ ": ", "", score, Vector2.vector(0,0));

        String id = UUID.randomUUID().toString();

        drawables.addDrawable(label, id);
    }
}
