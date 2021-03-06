package edu.austral.starship.base.input;

import edu.austral.starship.base.game.Spaceship;
import edu.austral.starship.base.game.Weapon;

public class Shoot implements Action{

    private Spaceship spaceship;

    public Shoot(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    public void execute() {
        spaceship.shoot();
    }
}
