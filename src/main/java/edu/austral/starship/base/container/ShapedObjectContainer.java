package edu.austral.starship.base.container;

import edu.austral.starship.base.collision.ShapedObject;
import edu.austral.starship.base.game.GameObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapedObjectContainer {

    private Map<String, ShapedObject> collisionables;

    public ShapedObjectContainer() {
        collisionables = new HashMap<>();
    }

    public void addObject(ShapedObject object, String key) {
        collisionables.put(key, object);
    }

    public void removeObject(String key) {
        collisionables.remove(key);
    }

    public List<ShapedObject> getObjects() {
        return new ArrayList<>(collisionables.values());
    }
}
