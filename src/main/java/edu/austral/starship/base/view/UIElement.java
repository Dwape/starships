package edu.austral.starship.base.view;

import edu.austral.starship.base.vector.Vector2;

public class UIElement implements Placeable{

    public Vector2 position;

    public UIElement(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition(){
        return position;
    }
}
