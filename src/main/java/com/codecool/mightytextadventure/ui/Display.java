

package com.codecool.mightytextadventure.ui;

import com.codecool.mightytextadventure.logic.Player;

import java.util.List;

public class Display {

  public void printMessage(String message) {
    System.out.println(message);
  }

  public void printAreaDescription(String description) {
    printSeparator();
    printMessage("\nNARRATOR: " + description);
  }

  public void printWinMessage(Player player) {
    printSeparator();
    printMessage("\nCONGRATULATIONS " + player.getName() + "! YOU WIN!");
  }

  public void printLoseMessage(Player player) {
    printSeparator();
    printMessage("\nGAME OVER! " + player.getName() + ", YOU HAVE LOST!");
  }

  public void printAvailableActions(List<String> actions) {
    printActionSeparator();
    printMessage("\nWhat will you do:");
    int index = 1;
    for (String action : actions) {
      System.out.println(index + ". " + action);
      index++;
    }
  }

  public void printInvalidAction() {
    printInvalidSeparator();
    printMessage("Invalid action! Try again.");
  }

  public void printSeparator() {
    printMessage("\n------------------------------");
  }

  public void printActionSeparator() {
    printMessage("\n*****");
  }

  public void printInvalidSeparator() {
    printMessage("\n>>>>> !!!");
  }
}
