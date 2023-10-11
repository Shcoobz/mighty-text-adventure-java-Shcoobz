package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.EnemyType;

public class Enemy {
    private String name;
    private int HP;
    private int attackStrength;

    public Enemy(String name, int HP, int attackStrength) {
        this.name = name;
        this.HP = HP;
        this.attackStrength = attackStrength;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void takeDamage(int damage) {
        HP -= damage;
        if (HP < 0) {
            HP = 0;
        }
    }

/*    public static String randomEnemyName111(){
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        String[] enemyNames = {"DEATH_EATER", "DEMENTOR", "BASILISK", "ACROMANTULA"};
        return enemyNames[randomNumber];
   };*/

}

