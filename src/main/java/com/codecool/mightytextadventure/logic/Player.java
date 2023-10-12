package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;

public class Player {
    private String name;
    private int HP = 100;
    private boolean magicWand = true;
    private int potion = 10;
    private Area actualArea;
    private int attackStrength;

    public Player(String name, Area actualArea) {
        this.name = name;
        this.actualArea = actualArea;
        this.attackStrength = 10;
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

    public void takeDamage(int damage) {
        HP -= damage;
        if (HP < 0) {
            HP = 0;
        }
    }

    public int addAPotion(){
        return ++potion;
    }

    public void healWithPotion() {
        if (potion > 0 && HP < 60) {
            HP += 50;
            potion--;
            if (HP > 100) {
                HP = 100;
            }
        }
    }

    public int getAttackStrength() {

        if (magicWand) {
            return 20;
        } else {
            return 10;
        }
    }
}
