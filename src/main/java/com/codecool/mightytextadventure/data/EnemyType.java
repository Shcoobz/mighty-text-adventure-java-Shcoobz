package com.codecool.mightytextadventure.data;

import java.util.Random;

public enum EnemyType {
    DEATH_EATER(new EnemyInfo("Death Eater", 100, 18)),
    DEMENTOR(new EnemyInfo("Dementor", 80, 15)),
    BASILISK(new EnemyInfo("Basilisk", 150, 15)),
    ACROMANTULA(new EnemyInfo("Acromantula", 120, 18)),;

    private final EnemyInfo enemyInfo;

    EnemyType(EnemyInfo enemyInfo) {
        this.enemyInfo = enemyInfo;
    }

    public String getName() {
        return enemyInfo.name();
    }

    public int getHp() {
        return enemyInfo.hp();
    }

    public int getAttackStrength() {
        return enemyInfo.attackStrength();
    }
    public static EnemyType randomEnemyName() {
        EnemyType[] enemyTypes = EnemyType.values();
        Random random = new Random();
        int randomIndex = random.nextInt(enemyTypes.length);
        return enemyTypes[randomIndex];
    };

    public static void main(String[] args){
        EnemyType X = randomEnemyName();
        System.out.println(X);
    }

}

