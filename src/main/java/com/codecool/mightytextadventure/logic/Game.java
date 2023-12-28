package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents the main game logic for the Mighty Text Adventure game.
 * This class is responsible for managing the game loop, handling user input,
 * updating game state, and coordinating between different components like
 * player, battle, and display.
 */
public class Game {
  private final Map<AreaName, Area> areas;
  private final Input input;
  private final Display display;
  private final Player player;
  private Battle battle;
  boolean isRunning = true;

  /**
   * Constructs a Game instance with specified areas, input, display, and player.
   *
   * @param areas A map linking AreaName to Area objects.
   * @param input An Input object for handling user input.
   * @param display A Display object for showing information to the user.
   * @param player The player of the game.
   */
  public Game(Map<AreaName, Area> areas, Input input, Display display, Player player) {
    this.areas = areas;
    this.input = input;
    this.display = display;
    this.player = player;
    this.battle = new Battle(player, null);
  }

  /**
   * Starts and manages the game loop. This method keeps the game running,
   * presenting options to the player, and updating game states based on player actions.
   */
  public void run() {

    while (isRunning) {
      display.printAreaDescription(player.getActualArea().getDescription());
      AreaName currentArea = player.getActualArea().getAreaName();

      checkGameOverOrWin();

      if (isRunning) {
        if (isPlayerInBattleArea(currentArea)) {
          switch (rollDice()) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 3:
              boolean playerWon = battle.determinePlayerAndEnemy(this);
              if (playerWon) {
                player.addAPotion();
              }
              break;
          }
        }

        if (isRunning) {
          waitForUserInput();
        }
      }
    }
  }

  /**
   * Ends the game by setting the running flag to false.
   */
  public void endGame() {
    isRunning = false;
  }

  /**
   * Checks if the player is currently in a battle area.
   *
   * @param currentArea The current area of the player.
   * @return true if the player is in a battle area, false otherwise.
   */
  private boolean isPlayerInBattleArea(AreaName currentArea) {
    return currentArea != null && (currentArea.equals(AreaName.F_WEST) ||
        currentArea.equals(AreaName.F_EAST) ||
        currentArea.equals(AreaName.F_SOUTH) ||
        currentArea.equals(AreaName.F_NORTH));
  }

  /**
   * Waits for and processes user input during the game.
   */
  private void waitForUserInput() {
    display.printAvailableActions(player.getActualArea().getAvailableActions());
    String userInput = input.getInputFromUser().toLowerCase();
    List<String> availableActions = player.getActualArea().getAvailableActions();
    String chosenAction = getChosenAction(userInput, availableActions);

    switch (userInput) {
      case "quit":
        display.printLoseMessage(player);
        isRunning = false;
        break;
      case "win":
        player.setActualArea(areas.get(AreaName.FIND_FANG));
        break;
      case "woods":
        player.setActualArea(areas.get(AreaName.FORREST_ENTER));
        break;
      case "battle":
        boolean playerWon = battle.determinePlayerAndEnemy(this);
        if (playerWon) {
          player.addAPotion();
        }
        int playerHP = player.getHP();
        if (playerHP == 0) {
          endGame();
        }
        break;
      default:
        if (chosenAction != null) {
          Area nextArea = player.getActualArea().getAreaForAction(chosenAction);
          if (nextArea != null) {
            player.setActualArea(nextArea);
          } else {
            display.printInvalidAction();
          }
        } else {
          display.printInvalidAction();
        }
        break;
    }
  }

  /**
   * Rolls a dice to generate a random number between 1 and 6.
   *
   * @return A random number between 1 and 6.
   */
  private int rollDice() {
    Random random = new Random();
    return random.nextInt(6) + 1;
  }

  /**
   * Determines the chosen action based on user input.
   *
   * @param userInput The input provided by the user.
   * @param availableActions A list of available actions.
   * @return The chosen action based on user input, or null if the input is invalid.
   */
  private String getChosenAction(String userInput, List<String> availableActions) {
    try {
      int actionIndex = Integer.parseInt(userInput) - 1; // convert to 0-based index
      if (actionIndex >= 0 && actionIndex < availableActions.size()) {
        return availableActions.get(actionIndex);
      }
    } catch (NumberFormatException e) {
      // not a number, ignore and continue
    }
    return null;
  }

  /**
   * Checks the game's victory or defeat conditions.
   */
  private void checkGameOverOrWin() {
    if (AreaName.GAME_OVER.equals(player.getActualArea().getAreaName())) {
      display.printLoseMessage(player);
      isRunning = false;
    } else if (AreaName.FIND_FANG.equals(player.getActualArea().getAreaName())) {
      display.printWinMessage(player);
      isRunning = false;
    }
  }
}

