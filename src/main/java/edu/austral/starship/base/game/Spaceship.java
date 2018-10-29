package edu.austral.starship.base.game;

import edu.austral.starship.base.input.Movable;
import edu.austral.starship.base.input.Rotatable;
import edu.austral.starship.base.vector.Vector2;

public class Spaceship extends GameObject implements Movable, Rotatable {

    public Spaceship(int id, Vector2 position, Vector2 velocity) {
        super(id, position, velocity);
    }

    public void accelerate(Vector2 vector) {
        this.velocity = this.velocity.add(vector);
    }

    public void rotate(float factor) {
        this.position = this.position.rotate(factor);
    }
}
