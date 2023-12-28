package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;

/**
 * Represents the player in the game. This class holds the player's attributes such as name, health points (HP),
 * possession of a magic wand, number of potions, current area, and attack strength.
 */
public class Player {
  private String name;
  private int HP = 100;
  private boolean magicWand = true;
  private int potion = 15;
  private Area actualArea;
  private int attackStrength;

  /**
   * Constructs a Player instance with a specified name and initial area.
   *
   * @param name       The name of the player.
   * @param actualArea The initial area where the player starts in the game.
   */
  public Player(String name, Area actualArea) {
    this.name = name;
    this.actualArea = actualArea;
    this.attackStrength = 10;
  }

  /**
   * Constructs a Player instance with a specified magic wand possession status.
   *
   * @param magicWand The possession status of a magic wand by the player.
   */
  public Player(boolean magicWand) {
    this.magicWand = magicWand;
  }

  /**
   * Retrieves the player's name.
   *
   * @return The name of the player.
   */
  public String getName() {
    return name;
  }

  /**
   * Retrieves the current health points (HP) of the player.
   *
   * @return The current HP of the player.
   */
  public int getHP() {
    return HP;
  }

  /**
   * Checks if the player has a magic wand.
   *
   * @return true if the player has a magic wand, false otherwise.
   */
  public boolean isMagicWand() {
    return magicWand;
  }

  /**
   * Retrieves the number of potions the player has.
   *
   * @return The number of potions.
   */
  public int getPotion() {
    return potion;
  }

  /**
   * Sets the current area of the player.
   *
   * @param area The area to set as the current area of the player.
   */
  public void setActualArea(Area area) {
    this.actualArea = area;
  }

  /**
   * Retrieves the current area of the player.
   *
   * @return The current area of the player.
   */
  public Area getActualArea() {
    return actualArea;
  }

  /**
   * Reduces the player's HP by the specified damage amount. Ensures the HP does not drop below zero.
   *
   * @param damage The amount of damage to inflict on the player.
   */
  public void takeDamage(int damage) {
    HP -= damage;
    if (HP < 0) {
      HP = 0;
    }
  }

  /**
   * Increases the number of potions the player has by one.
   *
   * @return The new total number of potions.
   */
  public int addAPotion() {
    return ++potion;
  }

  /**
   * Heals the player using a potion if available, increasing the player's HP.
   * A potion is only used if the player's HP is below 60 and if potions are available.
   */
  public void healWithPotion() {
    if (potion > 0 && HP < 60) {
      HP += 50;
      potion--;
      if (HP > 100) {
        HP = 100;
      }
    }
  }

  /**
   * Retrieves the attack strength of the player.
   * The attack strength is influenced by whether the player has a magic wand.
   *
   * @return The attack strength of the player.
   */
  public int getAttackStrength() {

    if (magicWand) {
      return 20;
    } else {
      return 10;
    }
  }
}
