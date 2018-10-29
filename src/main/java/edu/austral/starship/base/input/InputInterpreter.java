package edu.austral.starship.base.input;


import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class InputInterpreter {

    // Could be changed to work more efficiently with a map
    // KeyBinds should be compared only by keyCode so that we can create a new KeyBind with the keyEvent.keyCode and
    // look for it in the map (check how this is done in HashMap, probably with hashcode but check how it works)
    private List<KeyBind> keyBinds;

    public InputInterpreter() {
        keyBinds = new ArrayList<>();
    }

    public void addKeyBind(KeyBind keyBind) {
        keyBinds.add(keyBind);
    }

    // Could most likely be more efficient.
    public void interpret(int keyCode) {
        for (KeyBind savedKeyBind : keyBinds) {
            if (savedKeyBind.implemented(keyCode)) {
                savedKeyBind.execute();
            }
        }
    }
}
