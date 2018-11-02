package edu.austral.starship.base.game;

import edu.austral.starship.base.vector.Vector2;

public abstract class GameObject {

    //public Destroyer destroyer;

    String id; //could be changed to String

    Vector2 position;

    Vector2 velocity;

    float width; // add this?

    float height; // add this?

    float orientation; // Orientation may be better represented with an angle instead of a vector (check).

    public void updatePosition() {
        this.position = position.add(velocity);
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public Vector2 getVelocity()  {
        return this.velocity;
    }

    public float getOrientation() {
        return this.orientation;
    }

    public String getId() {
        return id;
    }

    public abstract void leftPerimeter();

    // This could be changed to be nicer
    // Currently it is used to stop objects when they reach the border
    // The only type of object that needs to be stopped is the spaceship, the other ones are destroyed.
    public void stop(Vector2 vector) {
        this.velocity = velocity.add(vector);
    }
}
