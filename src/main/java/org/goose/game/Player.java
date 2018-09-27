package org.goose.game;

public class Player {

    private String name;

    public Player(String name) {
            this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().isInstance(this))
            return super.equals(obj);
        return getName().equals(obj.toString());
    }

    public String toString() {
        return getName();
    }
}
