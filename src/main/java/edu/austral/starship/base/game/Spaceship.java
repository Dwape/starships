package edu.austral.starship.base.game;

import edu.austral.starship.base.input.Movable;
import edu.austral.starship.base.input.Rotatable;
import edu.austral.starship.base.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Spaceship extends GameObject implements Movable, Rotatable {

    private int lives;

    private Player player;

    private int pointValue;

    private List<Weapon> weapons;

    public Spaceship(String id, Vector2 position, Player player, int pointValue, int lives) {
        super.id = id;
        super.position = position;
        super.velocity = Vector2.vector(0, 0);
        this.player = player;
        this.lives = lives;
        this.pointValue = pointValue;
        super.destroyed = false;
        this.weapons = new ArrayList<>();
    }

    public void update() {
        updatePosition();
        for (Weapon weapon : weapons) {
            weapon.update();
        }
    }

    public void accelerate(Vector2 vector) {
        this.velocity = this.velocity.add(vector.rotate(orientation));
    }

    public void rotate(float factor) {
        this.orientation += factor;
    }

    public void leftPerimeter() {

    }

    public Player getPlayer() {
        return this.player;
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }
}
