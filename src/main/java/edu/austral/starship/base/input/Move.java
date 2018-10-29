package edu.austral.starship.base.input;

import edu.austral.starship.base.vector.Vector2;

public class Move implements Action{

    private Movable movable;

    private Vector2 movement;

    public Move(Movable movable, Vector2 movement) {
        this.movable = movable;
        this.movement = movement;
    }

    public void execute() {
        movable.accelerate(movement);
    }
}
