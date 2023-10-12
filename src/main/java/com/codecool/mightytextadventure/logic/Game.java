package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;
import com.codecool.mightytextadventure.data.EnemyType;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {
  private final Map<AreaName, Area> areas;
  private final Input input;
  private final Display display;
  private final Player player;
  private int battlesWon = 0;

  boolean isRunning = true;

  public Game(Map<AreaName, Area> areas, Input input, Display display, Player player) {
    this.areas = areas;
    this.input = input;
    this.display = display;
    this.player = player;
  }

  public void run() {

    while (isRunning) {
      display.printAreaDescription(player.getActualArea().getDescription());

      if (AreaName.GAME_OVER.equals(player.getActualArea().getAreaName())) {
        display.printLoseMessage(player);
        isRunning = false;
        return;
      }

      if (AreaName.FIND_FANG.equals(player.getActualArea().getAreaName())) {
        display.printWinMessage(player);
        isRunning = false;
        return;
      }

      waitForUserInput();
    }
  }

  /* We can change waitForUserInput to step as well,
  but since the code was working correctly, I didn't change anything*/
  private void waitForUserInput() {
    display.printAvailableActions(player.getActualArea().getAvailableActions());
    String userInput = input.getInputFromUser().toLowerCase();

    List<String> availableActions = player.getActualArea().getAvailableActions();
    String chosenAction = null;

        // check if user input is a number and maps to an action
        try {
            int actionIndex = Integer.parseInt(userInput) - 1; // convert to 0-based index
            if (actionIndex >= 0 && actionIndex < availableActions.size()) {
                chosenAction = availableActions.get(actionIndex);
            }
        } catch (NumberFormatException e) {
            // not a number, ignore and continue
        }

    if (userInput.equals("quit")) {
      display.printLoseMessage(player);
      isRunning = false;
    } else if (chosenAction != null) {
      Area nextArea = player.getActualArea().getAreaForAction(chosenAction);

      if (nextArea != null) {
        player.setActualArea(nextArea);
      } else {
        display.printInvalidAction();
      }
    } else {
      display.printInvalidAction();
    }

    /*-----------Determine player and enemy for battle---------------*/
    public void determinePlayerAndEnemy() {
        EnemyType enemyType = EnemyType.randomEnemyName();
        String enemyName = enemyType.getName();
        int enemyHP = enemyType.getHp();
        int enemyAttackStrength = enemyType.getAttackStrength();
        Enemy enemy = new Enemy(enemyName, enemyHP, enemyAttackStrength);
        Battle battle = new Battle(player, enemy);

    if (userInput.equals("battle")) {
      //battle.startBattle();

      boolean playerWon = battle.startBattle();

      if (playerWon) {
        battlesWon++;
        if (battlesWon >= 3) {
          player.setActualArea(areas.get(AreaName.FIND_FANG));
          return;
        }
      }

            int playerHP = player.getHP();

            if (playerHP == 0) {
                isRunning = false;
            }
        }
        ;
  }
}
