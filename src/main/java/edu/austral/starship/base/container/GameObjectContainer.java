package edu.austral.starship.base.container;

import edu.austral.starship.base.game.GameObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameObjectContainer {

    private Map<String, GameObject> objects;

    public GameObjectContainer() {
        objects = new HashMap<>();
    }

    public void addObject(GameObject object, String key) {
        objects.put(key, object);
    }

    public void removeObject(String key) {
        objects.remove(key);
    }

    public List<GameObject> getObjects() {
        return new ArrayList<>(objects.values());
    }
}
