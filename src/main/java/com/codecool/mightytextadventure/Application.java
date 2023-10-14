package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.logic.Player;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.Map;
import java.util.EnumMap;

// TODO: implement back option
// TODO: move message to display

public class Application {

  public static void main(String[] args) {
    Display display = new Display();
    Input input = new Input();

    display.printMessage("\nStarting Mighty Text Adventure by >>> Master JAVA <<<!");
    display.printMessage("\nType 'h' for a help message.");

    Map<AreaName, Area> areas = loadAreas();
    setupAreaConnections(areas);
    Player player = new Player(input.getNameFromUser(), areas.get(AreaName.STARTING_AREA));
    Game game = new Game(areas, input, display, player);
    game.run();

    display.printMessage("\nExiting from Mighty Text Adventure!");

  }

  private static Map<AreaName, Area> loadAreas() {
    Map<AreaName, Area> areas = new EnumMap<>(AreaName.class);

    Area.loadAllAreas(areas);

    return areas;
  }

  private static void setupAreaConnections(Map<AreaName, Area> areas) {
    Area.setupAreaConnections(areas);
  }
}
