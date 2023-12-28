

package com.codecool.mightytextadventure.ui;

import com.codecool.mightytextadventure.logic.Player;

import java.util.List;

/**
 * Handles displaying messages and game-related information to the player in the console.
 * This class is responsible for printing various types of messages including game status, area descriptions,
 * and actions available to the player.
 */
public class Display {

  /**
   * Prints a message to the console.
   *
   * @param message The message to be printed.
   */
  public void printMessage(String message) {
    System.out.println(message);
  }

  /**
   * Prints the game's logo to the console.
   */
  public void printLogo() {
    printMessage("    __  __   _           _       _              ");
    printMessage("   |  \\/  | (_)         | |     | |             ");
    printMessage("   | \\  / |  _    __ _  | |__   | |_   _   _    ");
    printMessage("   | |\\/| | | |  / _` | | '_ \\  | __| | | | |   ");
    printMessage("   | |  | | | | | (_| | | | | | | |_  | |_| |   ");
    printMessage("   |_|  |_| |_|  \\__, | |_| |_|  \\__|  \\__, |   ");
    printMessage("                  __/ |                 __/ |   ");
    printMessage("                 |___/                 |___/    ");
    printMessage("                            _______                 _   ");
    printMessage("                           |__   __|               | |  ");
    printMessage("                              | |      ___  __  __ | |_ ");
    printMessage("                              | |     / _ \\ \\ \\/ / | __|");
    printMessage("                              | |    |  __/  >  <  | |_ ");
    printMessage("                              |_|     \\___| /_/\\_\\  \\__|");
    printMessage("                                                           ");
    printMessage("                                                           ");
    printMessage("                                                           _                          _   ");
    printMessage("                                               /\\         | |                        | |  ");
    printMessage("                                              /  \\      __| | __   __   ___   _ __   | |_ ");
    printMessage("                                             / /\\ \\    / _` | \\ \\ / /  / _ \\ | '_ \\  | __|");
    printMessage("                                            / ____ \\  | (_| |  \\ V /  |  __/ | | | | | |_ ");
    printMessage("                                           /_/    \\_\\  \\__,_|   \\_/    \\___| |_| |_|  \\__|");
  }

  /**
   * Prints a welcome message at the start of the game.
   */
  public void printWelcomeMsg() {
    printSeparator();
    printMessage("Welcome to our Mighty Text Adventure!");
  }

  /**
   * Prints the description of the current area in the game.
   *
   * @param description The description of the current area.
   */
  public void printAreaDescription(String description) {
    printSeparator();
    printMessage("\nNARRATOR: " + description);
  }

  /**
   * Prints a win message including the player's name.
   *
   * @param player The player who has won.
   */
  public void printWinMessage(Player player) {
    printSeparator();
    printMessage("\nCONGRATULATIONS " + player.getName() + "! YOU WIN!");
  }

  /**
   * Prints a lose message including the player's name.
   *
   * @param player The player who has lost.
   */
  public void printLoseMessage(Player player) {
    printSeparator();
    printMessage("\nGAME OVER! " + player.getName() + ", YOU HAVE LOST!");
  }

  /**
   * Prints the list of available actions for the player.
   *
   * @param actions The list of actions that can be taken by the player.
   */
  public void printAvailableActions(List<String> actions) {
    printActionSeparator();
    printMessage("\nWhat will you do:");
    int index = 1;
    for (String action : actions) {
      System.out.println(index + ". " + action);
      index++;
    }
  }

  /**
   * Prints a message indicating an invalid action was taken.
   */
  public void printInvalidAction() {
    printInvalidSeparator();
    printMessage("Invalid action! Try again.");
  }

  /**
   * Prints a separator for general messages.
   */
  public void printSeparator() {
    printMessage("\n------------------------------");
  }

  /**
   * Prints a separator specifically for actions.
   */
  public void printActionSeparator() {
    printMessage("\n*****");
  }

  /**
   * Prints a separator specifically for invalid actions.
   */
  public void printInvalidSeparator() {
    printMessage("\n>>>>> !!!");
  }

  /**
   * Prints help information for further actions.
   */
  public void printHelp() {
    printMessage("HELP INFORMATION:");
    printMessage("-----------------");
    printMessage("Typing 'quit' to exit the game at anytime (progress wil not be saved).");
    printMessage("Typing 'battle' will start a battle immediately.");
    printMessage("Typing 'woods' will skip most of teh story and teleport you to the forrest entrance.");
    printMessage("Typing 'win' will instantly win the game.");
  }

  /**
   * Prints teh user name.
   */
  public void printUserName() {
    printMessage("\nYour name: ");
  }
}
