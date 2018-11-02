package edu.austral.starship.base.input;

import edu.austral.starship.base.game.Weapon;

public class Shoot implements Action{

    private Weapon weapon;

    public Shoot(Weapon weapon) {
        this.weapon = weapon;
    }

    public void execute() {
        weapon.shoot();
    }
}
