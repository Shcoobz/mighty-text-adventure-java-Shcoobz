

package com.codecool.mightytextadventure.ui;

import com.codecool.mightytextadventure.logic.Player;

import java.util.List;

public class Display {

  public void printMessage(String message) {
    System.out.println(message);
  }

  public void printAreaDescription(String description) {
    System.out.println("\nNARRATOR: " + description);
  }

  public void printWinMessage(Player player) {
    System.out.println("\nIn the depths of the Forbidden Forest, where the trees were ancient and the sunlight scarce, you heard a faint\n" +
        "whimper. Following the sound, you discovered a small sunlit clearing where Fang lay, bruised and muddied but mostly\n" +
        "unharmed. As you approached, his tail wagged weakly, eyes full of relief. After a brief check and reassuring words, you and\n" +
        "Fang began your journey back to Hagrid, the forest now feeling less daunting with the loyal dog by your side.\n" +
        "\n" +
        "Hagrid could not believe his eyes and was beaming with joy!\n" +
        "\n" +
        "CONGRATULATIONS " + player.getName() + "! YOU WIN!");
  }

  public void printLoseMessage(Player player) {
    System.out.println("\nGAME OVER! " + player.getName() + ", YOU HAVE LOST!");
  }

  public void printAvailableActions(List<String> actions) {
    System.out.println("\nAvailable actions:");
    int index = 1;
    for (String action : actions) {
      System.out.println(index + ". " + action);
      index++;
    }
  }

  public void printInvalidAction() {
    System.out.println("Invalid action! Try again.");
  }

  public void printSeparator() {
    System.out.println("------------------------------");
  }
}
