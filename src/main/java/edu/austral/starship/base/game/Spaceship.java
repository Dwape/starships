package edu.austral.starship.base.game;

import edu.austral.starship.base.input.Movable;
import edu.austral.starship.base.input.Rotatable;
import edu.austral.starship.base.vector.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Spaceship extends GameObject implements Movable, Rotatable, Damageable, Scoreable {

    private int health;

    private Player player;

    private int pointValue;

    private List<Weapon> weapons;

    private int selectedWeapon;

    private float height;

    private float width;

    public Spaceship(String id, Vector2 position, Player player, int pointValue, int health, float width, float height) {
        super.id = id;
        super.position = position;
        super.velocity = Vector2.vector(0, 0);
        this.player = player;
        this.health = health;
        this.pointValue = pointValue;
        super.destroyed = false;
        this.weapons = new ArrayList<>();
        this.selectedWeapon = 0;
        this.width = width;
        this.height = height;
    }

    public void update() {
        updatePosition();
        for (Weapon weapon : weapons) {
            weapon.update();
        }
        if (health <= 0) destroy();
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

    public void damage(int health) {
        this.health -= health;
    }

    public int returnPoints() {
        return this.pointValue;
    }

    public void shoot() {
        // fix it to consider other cases
        weapons.get(selectedWeapon).shoot();
    }

    public void changeWeapon() {
        // Check if this works.
        selectedWeapon = Math.floorMod(selectedWeapon+1, weapons.size());
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public int getHealth() {
        return health;
    }
}
