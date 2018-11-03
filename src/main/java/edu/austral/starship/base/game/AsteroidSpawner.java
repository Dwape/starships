package edu.austral.starship.base.game;

import edu.austral.starship.base.factory.AsteroidFactory;
import edu.austral.starship.base.vector.Vector2;

import java.util.Random;

public class AsteroidSpawner {

    private AsteroidFactory factory;
    private float size;
    private float speed;
    private int delay;
    private int delayCounter;
    private Vector2 box;

    public AsteroidSpawner(AsteroidFactory factory, float size, float speed, int delay, Vector2 box) {
        this.factory = factory;
        this.size = size;
        this.speed = speed;
        this.delay = delay;
        this.delayCounter = 0;
        this.box = box; // size of the playing field.
    }

    public void create() {
        if (delayCounter > delay) {
            float width = box.getX();
            float height = box.getY();

            double radius = Math.sqrt(Math.pow(width/2, 2) + Math.pow(height/2, 2)); //was *1.1
            Random r = new Random();

            int direction = 1;
            if(r.nextDouble() > 0.5) direction = -1;

            double x1 =  - radius + width/2 + (2*radius) * r.nextDouble();
            double y1 = height/2 - direction * Math.sqrt(Math.pow(radius, 2) - Math.pow(x1-width/2, 2));

            double x2 = - radius + width/2 + (2*radius) * r.nextDouble();
            double y2 = height/2 + direction * Math.sqrt(Math.pow(radius, 2) - Math.pow(x2-width/2, 2));

            Vector2 v1 = Vector2.vector((float) x1, (float) y1);
            Vector2 v2 = Vector2.vector((float) x2, (float) y2);

            Vector2 velocity = v2.substract(v1).unitary().multiply(speed);

            Vector2 position = Vector2.vector((float) x1, (float) y1);

            factory.createAsteroid(position, velocity, 50);

            this.delayCounter = 0;
        }
    }

    public void update() {
        this.delayCounter++;
    }
}
