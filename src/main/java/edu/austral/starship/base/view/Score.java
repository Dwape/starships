package edu.austral.starship.base.view;

import edu.austral.starship.base.game.Player;

public class Score implements Valuable {

    private Player player;

    public Score(Player player) {
        this.player = player;
    }

    public String getValue() {
        return Integer.toString(player.getPoints());
    }
}
