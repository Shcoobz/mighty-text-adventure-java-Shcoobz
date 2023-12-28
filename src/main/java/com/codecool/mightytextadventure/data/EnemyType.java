package com.codecool.mightytextadventure.data;

import java.util.Random;

/**
 * Enumeration of enemy types for the game, each associated with specific enemy information.
 * This enum encapsulates various types of enemies a player might encounter, providing
 * essential attributes like name, health points (hp), and attack strength.
 */
public enum EnemyType {
    DEATH_EATER(new EnemyInfo("Death Eater", 100, 18)),
    DEMENTOR(new EnemyInfo("Dementor", 80, 15)),
    BASILISK(new EnemyInfo("Basilisk", 150, 15)),
    ACROMANTULA(new EnemyInfo("Acromantula", 120, 18)),;

    private final EnemyInfo enemyInfo;

    /**
     * Constructor for the EnemyType enumeration.
     * Initializes an enemy type with specific attributes defined in {@link EnemyInfo}.
     *
     * @param enemyInfo The EnemyInfo object containing name, health points, and attack strength.
     */
    EnemyType(EnemyInfo enemyInfo) {
        this.enemyInfo = enemyInfo;
    }

    /**
     * Retrieves the name of the enemy.
     *
     * @return A string representing the name of the enemy.
     */
    public String getName() {
        return enemyInfo.name();
    }

    /**
     * Retrieves the health points (hp) of the enemy.
     *
     * @return An integer value representing the health points of the enemy.
     */
    public int getHp() {
        return enemyInfo.hp();
    }

    /**
     * Retrieves the attack strength of the enemy.
     *
     * @return An integer value representing the attack strength of the enemy.
     */
    public int getAttackStrength() {
        return enemyInfo.attackStrength();
    }

    /**
     * Selects a random enemy type from the available types.
     * Utilizes {@link java.util.Random} to generate a random index for selecting an enemy type.
     *
     * @return A randomly selected {@link EnemyType}.
     */
    public static EnemyType randomEnemyName() {
        EnemyType[] enemyTypes = EnemyType.values();
        Random random = new Random();
        int randomIndex = random.nextInt(enemyTypes.length);
        return enemyTypes[randomIndex];
    };
}

