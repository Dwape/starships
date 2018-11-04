package edu.austral.starship.base.input;

import edu.austral.starship.base.game.Spaceship;

public class SwitchWeapon implements Action{

    private Spaceship spaceship;

    public SwitchWeapon(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    public void execute() {
        spaceship.changeWeapon();
    }
}
