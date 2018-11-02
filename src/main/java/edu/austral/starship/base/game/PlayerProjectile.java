package edu.austral.starship.base.game;

import edu.austral.starship.base.vector.Vector2;

public class PlayerProjectile extends Projectile{

    private Player owner;

    public PlayerProjectile(String id, Player owner, Vector2 position, Vector2 velocity, int damage, float lifespan) {
        super.damage = damage;
        super.lifespan = lifespan;
        super.id = id;
        this.owner = owner;
        super.position = position;
        super.velocity = velocity;
    }

    public void awardPoints(Scoreable scoreable) {
        owner.addPoints(scoreable.returnPoints());
    }
}
