package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaDescription;
import com.codecool.mightytextadventure.data.AreaConnections;
import com.codecool.mightytextadventure.data.AreaName;
import com.codecool.mightytextadventure.data.arearooms.Room;
import com.codecool.mightytextadventure.data.arearooms.StartingArea;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.logic.Player;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.EnumMap;

// TODO: implement back option

public class Application {
  private Map<AreaName, Room> rooms = new HashMap<>();

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

    AreaDescription.loadStart(areas);
    AreaDescription.loadHutInside(areas);
    AreaDescription.loadWayToForrest(areas);
    AreaDescription.loadForrestEnter(areas);
    AreaDescription.loadForrestDirections(areas);
    AreaDescription.loadFindFang(areas); // winning area
    AreaDescription.loadGameOver(areas); // loosing area

    return areas;
  }

  private static void setupAreaConnections(Map<AreaName, Area> areas) {
    AreaConnections.setupStart(areas);
    AreaConnections.setupHutInside(areas);
    AreaConnections.setupWayToForrest(areas);
    AreaConnections.setupForrestEnter(areas);
    AreaConnections.setupForrestDirections(areas);
  }

/*  private void initRooms() {
    rooms.put(AreaName.STARTING_AREA, new Room("""
        On the muddy path, Hagrid's rustic hut stands prominently, its patchwork roof contrasting the overcast sky. Rain gently
        mists your face, carrying scents of damp earth and woodsmoke, suggesting a fire within. A dim light shines from a
        window, causing raindrops to shimmer. To your left, the Forbidden Forest displays muted autumn hues, punctuated by
        occasional owl hoots and rustlings of unseen creatures.
        """));

    rooms.put(AreaName.SA_KNOCK, new Room("""
        You knock on Hagrid's door, the sound contrasting the steady rain. Silence ensues; no footsteps, no reply.
        """));
  }

  private void initConnections() {
  rooms.get(AreaName.STARTING_AREA).addConnection("[Knock]",rooms.get(AreaName.SA_KNOCK));
  }*/

}
