package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.EnemyInfo;
import com.codecool.mightytextadventure.data.EnemyType;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.List;

public class Game {
  private final Area[] areas;
  private final Input input;
  private final Display display;
  private final Player player;

  boolean isRunning = true;

  public Game(Area[] areas, Input input, Display display, Player player) {
    this.areas = areas;
    this.input = input;
    this.display = display;
    this.player = player;
  }

  public void run() {

    while (isRunning) {
      display.printAreaDescription(player.getActualArea().getDescription());
      waitForUserInput();

    }
  }

  private boolean step() {
    for (var action : player.getActualArea().getAvailableActions()) {
      display.printMessage(action);
    }

    return true;
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
          /*display.printMessage("Exiting the game.");*/
          display.printLoseMessage();
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
        EnemyType enemyType = EnemyType.randomEnemyName();
        String enemyName = enemyType.getName();
        int enemyHP = enemyType.getHp();
        int enemyAttackStrength = enemyType.getAttackStrength();
        Enemy enemy = new Enemy(enemyName, enemyHP, enemyAttackStrength);
        Battle battle = new Battle(player, enemy);

        if (userInput.equals("battle")) {
            battle.startBattle();

            int playerHP = player.getHP();

            if (playerHP == 0) {
                isRunning = false;
            }
        }
        ;
  }
}
