package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;
import com.codecool.mightytextadventure.data.EnemyType;
import com.codecool.mightytextadventure.ui.Display;

/**
 * Represents a battle in the game between a player and an enemy. This class handles
 * the battle mechanics including player and enemy interactions such as attack and healing.
 */
public class Battle {
  private Player player;
  private Enemy enemy;
  private int battlesWon = 0;

  /**
   * Constructs a Battle instance with specified player and enemy.
   *
   * @param player The player participating in the battle.
   * @param enemy The enemy participating in the battle.
   */
  public Battle(Player player, Enemy enemy) {
    this.player = player;
    this.enemy = enemy;
  }

  /**
   * Starts and executes the battle sequence. The method manages turn-based combat
   * between the player and the enemy until one of them runs out of health points.
   *
   * @return true if the player wins the battle, false otherwise.
   */
  public boolean startBattle() {
    Display display = new Display();
    while (player.getHP() > 0 && enemy.getHP() > 0) {
      int playerDamage = player.getAttackStrength();
      int enemyDamage = enemy.getAttackStrength();

      /*------------ Heilung der Player ----------*/
      if (player.getHP() < 60) {

        int potionNumber = player.getPotion();
        if (potionNumber > 0) {
          player.healWithPotion();
          display.printMessage("--->>> the remaining potions are : " + Integer.toString(potionNumber) + " pieces");
        }
      }
      /*------------ Spieler greift den Gegner an ----------*/
      enemy.takeDamage(playerDamage);
      display.printMessage(player.getName() + " greift " + enemy.getName() + " an und fügt " + playerDamage + " Schaden zu.");

      /*------------ Gegner greift den Spieler an ----------*/
      player.takeDamage(enemyDamage);
      display.printMessage(enemy.getName() + " greift " + player.getName() + " an und fügt " + enemyDamage + " Schaden zu.");

      System.out.println(player.getName() + " HP: " + player.getHP());
      System.out.println(enemy.getName() + " HP: " + enemy.getHP());
    }

    if (player.getHP() <= 0) {
      display.printLoseMessage(player);
    } else {
      display.printWinMessage(player);
      return true;
    }
    return false;
  }

  /**
   * Determines the enemy for the battle based on a random selection and initiates the battle.
   * This method also checks the number of battles won and updates the game state accordingly.
   *
   * @param game The current game instance.
   * @return true if the player wins the battle, false otherwise.
   */
  public boolean determinePlayerAndEnemy(Game game) {
    EnemyType enemyType = EnemyType.randomEnemyName();
    String enemyName = enemyType.getName();
    int enemyHP = enemyType.getHp();
    int enemyAttackStrength = enemyType.getAttackStrength();
    this.enemy = new Enemy(enemyName, enemyHP, enemyAttackStrength);

    boolean playerWon = startBattle();

    if (playerWon) {
      battlesWon++;
      if (battlesWon == 3) {
        player.setActualArea(new Area(AreaName.FIND_FANG, """
            In the depths of the Forbidden Forest, where the trees were ancient and the sunlight scarce, you heard a faint
            whimper. Following the sound, you discovered a small sunlit clearing where Fang lay, bruised and muddied but mostly
            unharmed. As you approached, his tail wagged weakly, eyes full of relief. After a brief check and reassuring words, you and
            Fang began your journey back to Hagrid, the forest now feeling less daunting with the loyal dog by your side.

            Hagrid could not believe his eyes and was beaming with joy!
            """));
        Display display = new Display();
        display.printAreaDescription(player.getActualArea().getDescription());
        game.endGame(); // winGame && loseGame

        return true;
      }
    }

    int playerHP = player.getHP();

    if (playerHP == 0) {
      game.endGame();
    }

    return false;
  }

}


