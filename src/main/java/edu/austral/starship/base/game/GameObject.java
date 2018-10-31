package edu.austral.starship.base.game;

import edu.austral.starship.base.vector.Vector2;

public abstract class GameObject {

    //public Destroyer destroyer;

    String id; //could be changed to String

    Vector2 position;

    Vector2 velocity;

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
}
