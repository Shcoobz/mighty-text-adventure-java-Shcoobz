package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;

public class Player {
    private String name;
    private int HP = 100;
    private boolean magicWand = false;
    private int potion = 0;
    private Area actualArea;

    public Player(String name, Area actualArea) {
        this.name = name;
        this.actualArea = actualArea;
    }

    public Player(boolean magicWand) {
        this.magicWand = magicWand;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public boolean isMagicWand() {
        return magicWand;
    }

    public int getPotion() {
        return potion;
    }

    public void setActualArea(Area area) {
        this.actualArea = area;
    }
    public Area getActualArea() {
        return actualArea;
    }
}
