package edu.austral.starship.base.game;

import edu.austral.starship.base.vector.Vector2;

public class Asteroid extends GameObject implements Damageable {

    private int health;

    private int pointValue;

    private float size;

    public Asteroid(String id, Vector2 position, Vector2 velocity, float size) {
        this.health = (int) size/10;
        this.pointValue = health;
        this.size = size;
        super.position = position;
        super.velocity = velocity;
        super.id = id;
    }

    public void update() {
        updatePosition();
        if (health <= 0) destroy();
    }

    public void damage(int health) {
        this.health -= health;
    }

    public void leftPerimeter() {
        //System.out.println("What?");
        this.destroy();
    }

    public float getSize() {
        return size;
    }
}
