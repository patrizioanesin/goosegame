package org.goose.game;

public class Player {

    private String name;
    private int position;

    public Player(String name) {
            this.name = name;
            this.position = 0;
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
