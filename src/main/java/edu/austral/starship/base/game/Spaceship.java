package edu.austral.starship.base.game;

import edu.austral.starship.base.input.Movable;
import edu.austral.starship.base.input.Rotatable;
import edu.austral.starship.base.vector.Vector2;

public class Spaceship extends GameObject implements Movable, Rotatable {

    private int lives;

    private Player player;

    private int pointValue;

    public Spaceship(String id, Vector2 position, Vector2 velocity, Player player, int pointValue, int lives) {
        super.id = id;
        super.position = position;
        super.velocity = velocity;
        this.player = player;
        this.lives = lives;
        this.pointValue = pointValue;
    }

    public Spaceship(String id, Vector2 position, Player player, int pointValue, int lives) {
        super.id = id;
        super.position = position;
        super.velocity = Vector2.vector(0, 0);
        this.player = player;
        this.lives = lives;
        this.pointValue = pointValue;
    }

    public void accelerate(Vector2 vector) {
        this.velocity = this.velocity.add(vector.rotate(orientation));
    }

    public void rotate(float factor) {
        this.orientation += factor;
    }
}
