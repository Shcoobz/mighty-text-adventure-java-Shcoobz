package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.EnemyType;

/**
 * Represents an enemy in the game.
 * This class encapsulates the attributes and behaviors of an enemy,
 * including its name, health points (HP), and attack strength.
 */
public class Enemy {
  private String name;
  private int HP;
  private int attackStrength;

  /**
   * Constructs an Enemy instance with a specified name, health points, and attack strength.
   *
   * @param name           The name of the enemy.
   * @param HP             The health points of the enemy.
   * @param attackStrength The attack strength of the enemy.
   */
  public Enemy(String name, int HP, int attackStrength) {
    this.name = name;
    this.HP = HP;
    this.attackStrength = attackStrength;
  }

  /**
   * Retrieves the name of the enemy.
   *
   * @return The name of the enemy.
   */
  public String getName() {
    return name;
  }

  /**
   * Retrieves the current health points (HP) of the enemy.
   *
   * @return The current HP of the enemy.
   */
  public int getHP() {
    return HP;
  }

  /**
   * Retrieves the attack strength of the enemy.
   *
   * @return The attack strength of the enemy.
   */
  public int getAttackStrength() {
    return attackStrength;
  }

  /**
   * Reduces the HP of the enemy by the specified amount of damage.
   * Ensures that the HP does not drop below zero.
   *
   * @param damage The amount of damage to be inflicted on the enemy.
   */
  public void takeDamage(int damage) {
    HP -= damage;
    if (HP < 0) {
      HP = 0;
    }
  }
}

