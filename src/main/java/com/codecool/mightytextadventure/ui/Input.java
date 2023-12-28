package com.codecool.mightytextadventure.ui;

import java.util.Scanner;

/**
 * Manages user input for the game. This class handles reading input from the console,
 * processing it, and providing the necessary information back to the game.
 */
public class Input {
  private Scanner scanner;
  Display display = new Display();

  /**
   * Constructs an Input instance. Initializes the scanner to read from the standard input stream.
   */
  public Input() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * Reads input from the user, trims it, and converts it to lowercase. If the user inputs 'help' or 'h',
   * the method displays help information and then requests input again.
   *
   * @return The processed user input as a lowercase string.
   */
  public String getInputFromUser() {
    String input = scanner.nextLine().trim();

    input = input.toLowerCase();

    if ("help".equals(input) || "h".equals(input)) {
      displayHelp();
      return getInputFromUser();
    }

    return input;
  }

  /**
   * Prompts the user to enter their name and reads the input.
   *
   * @return The name entered by the user.
   */
  public String getNameFromUser() {
    display.printUserName();
    String name = scanner.nextLine();
    return name;
  }

  /**
   * Displays help information to the user, outlining various commands and their effects.
   */
  private void displayHelp() {
    display.printHelp();
  }
}
