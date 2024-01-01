package com.mygdx.doodlesiege;

public class Item {
    public final String id;
    public Item(String id) {
        this.id = id;
    }
    public boolean stackable;
    public int stackSize;
    public Appearance icon;
    public boolean equipable;
}
