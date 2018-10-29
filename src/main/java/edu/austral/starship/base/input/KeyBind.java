package edu.austral.starship.base.input;

import processing.event.KeyEvent;

public class KeyBind {

    private Action action;

    private boolean isDefault;

    private int keyCode;

    public KeyBind(Action action, boolean isDefault, int keyCode) {
        this.action = action;
        this.isDefault = isDefault;
        this.keyCode = keyCode;
    }

    public void changeKey(int newKeyCode) {
        this.keyCode = newKeyCode;
    }

    public void execute() {
        action.execute();
    }

    public void reset() {
        //to do
    }

    public boolean implemented(int keyCode) {
        return keyCode == this.keyCode; //check if this actually works.
    }
}
