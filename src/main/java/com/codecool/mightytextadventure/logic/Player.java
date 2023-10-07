package com.codecool.mightytextadventure.logic;

public class Player {
    private String name;
    private int HP = 100;
    private boolean magicWand;
    private int potion;

    public Player(String name, int HP, boolean magicWand, int potion) {
        this.name = name;
        this.HP = HP;
        this.magicWand = magicWand;
        this.potion = potion;
    }

    public Player(String name, boolean magicWand, int potion) {
        this.name = name;
        this.magicWand = magicWand;
        this.potion = potion;
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
}
