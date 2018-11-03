package edu.austral.starship.base.game;

public class Player {

    private int points;

    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return this.points;
    }
}
