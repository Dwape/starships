package edu.austral.starship.base.game;

import edu.austral.starship.base.vector.Vector2;

public abstract class GameObject {

    //public Destroyer destroyer;

    public int id; //could be changed to String

    public Vector2 position;

    public Vector2 velocity;

    public GameObject(int id, Vector2 position, Vector2 velocity) {
        this.id = id;
        this.position = position;
        this.velocity = velocity;
    }

    public void updatePosition() {
        this.position = position.add(velocity);
    }
}
