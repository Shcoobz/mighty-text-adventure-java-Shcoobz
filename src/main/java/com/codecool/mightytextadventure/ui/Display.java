

package com.codecool.mightytextadventure.ui;

import java.util.List;

public class Display {

  public void printMessage(String message) {
    System.out.println(message);
  }

  public void printAreaDescription(String description) { // from Area
    System.out.println("AREA: " + description);
  }

  public void printWinMessage() {
    System.out.println("CONGRATULATIONS! YOU WIN!");
  }

  public void printLoseMessage() {
    System.out.println("GAME OVER! YOU LOST!");
  }

  public void printAvailableActions(List<String> actions) {
    System.out.println("Available actions:");
    for (String action : actions) {
      System.out.println("- " + action);
    }
  }

  public void printInvalidAction() {
    System.out.println("Invalid action! Try again.");
  }

  public void printSeparator() {
    System.out.println("------------------------------");
  }
}
