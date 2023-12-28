package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.logic.Player;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.Map;
import java.util.EnumMap;

/**
 * The main class of the Mighty Text Adventure game. It is responsible for initializing the game,
 * setting up the necessary components, and starting the game loop.
 */
public class Application {

  /**
   * The entry point of the application. It sets up the game and starts the game loop.
   *
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    Display display = new Display();
    Input input = new Input();

    display.printLogo();
    display.printWelcomeMsg();

    display.printMessage("\nGame created by Team >>> Master JAVA <<<!");
    display.printMessage("\nType 'h' for a help message.");

    Map<AreaName, Area> areas = loadAreas();
    setupAreaConnections(areas);
    Player player = new Player(input.getNameFromUser(), areas.get(AreaName.STARTING_AREA));
    Game game = new Game(areas, input, display, player);
    game.run();

    display.printMessage("\nExiting from Mighty Text Adventure!");

  }

  /**
   * Loads the areas of the game into a map.
   *
   * @return A map linking AreaName to Area objects.
   */
  private static Map<AreaName, Area> loadAreas() {
    Map<AreaName, Area> areas = new EnumMap<>(AreaName.class);

    Area.loadAllAreas(areas);

    return areas;
  }

  /**
   * Sets up connections between different areas in the game.
   *
   * @param areas The map of areas where connections need to be set up.
   */
  private static void setupAreaConnections(Map<AreaName, Area> areas) {
    Area.setupAreaConnections(areas);
  }
}
