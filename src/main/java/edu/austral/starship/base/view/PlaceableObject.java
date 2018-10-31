package edu.austral.starship.base.view;

import edu.austral.starship.base.game.GameObject;
import edu.austral.starship.base.vector.Vector2;

public class PlaceableObject implements Placeable, Orientable{

    private GameObject object;

    public PlaceableObject(GameObject object) {
        this.object = object;
    }

    public Vector2 getPosition(){
        return object.getPosition();
    }

    public float getOrientation(){
        return object.getOrientation();
    }
}
