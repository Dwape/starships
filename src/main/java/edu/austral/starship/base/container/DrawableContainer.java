package edu.austral.starship.base.container;

import edu.austral.starship.base.view.Drawable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawableContainer {

    private Map<String, Drawable> drawables;

    public DrawableContainer() {
        drawables = new HashMap<>();
    }

    public void addDrawable(Drawable drawable, String key) {
        drawables.put(key, drawable);
    }

    public void removeDrawable(String key) {
        drawables.remove(key);
    }

    public List<Drawable> getDrawables() {
        return new ArrayList<>(drawables.values());
    }
}
