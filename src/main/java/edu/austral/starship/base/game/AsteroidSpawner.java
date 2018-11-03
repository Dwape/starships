package edu.austral.starship.base.game;

import edu.austral.starship.base.factory.AsteroidFactory;
import edu.austral.starship.base.vector.Vector2;
import processing.core.PImage;

public class AsteroidSpawner {

    private AsteroidFactory factory;
    private float size;
    private float speed;
    private int delay;
    private int delayCounter;
    private PImage image;

    public AsteroidSpawner(AsteroidFactory factory, float size, float speed, int delay, PImage image) {
        this.factory = factory;
        this.size = size;
        this.speed = speed;
        this.delay = delay;
        this.image = image;
        this.delayCounter = 0;
    }

    public void create() {
        if (delayCounter > delay) {
            Vector2 position = Vector2.vector(0, 0);
            Vector2 velocity = Vector2.vector(speed, speed);

            factory.createAsteroid(position, velocity, 50, image);

            this.delayCounter = 0;
        }
    }

    public void update() {
        this.delayCounter++;
    }
}
