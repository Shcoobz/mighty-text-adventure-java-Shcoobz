package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.logic.Player;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

public class Application {
  public static void main(String[] args) {
    Display display = new Display();
    Input input = new Input();

    display.printMessage("Starting Mighty Text Adventure!");

    Area[] areas = loadAreas();
    setupAreaConnections(areas);
    Player player = new Player(input.getNameFromUser(), areas[0]);
    Game game = new Game(areas, input, display, player);
    game.run();

    display.printMessage("Exiting from Mighty Text Adventure!");
  }

  private static Area[] loadAreas() {
    Area[] areas = new Area[7];
    areas[0] = new Area("Starting Area");
    areas[1] = new Area("Room 1");
    areas[2] = new Area("Room 2");
    areas[3] = new Area("Room 3");
    areas[4] = new Area("Room 4");
    areas[5] = new Area("Room 5");
    areas[6] = new Area("Room 6");
    return areas;
  }

  private static void setupAreaConnections(Area[] areas) {
    areas[0].addConnection("move to Room 1", areas[1]);
    areas[1].addConnection("move back to Start room", areas[0]);
    areas[1].addConnection("move to Room 2", areas[2]);
  }
}
