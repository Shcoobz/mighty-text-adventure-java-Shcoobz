package com.codecool.mightytextadventure.data.arearooms;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import java.util.Map;

public class GameOver {
  public static void loadGameOverRoom(Map<AreaName, Area> areas) {
    areas.put(AreaName.GAME_OVER, new Area(AreaName.GAME_OVER, "Your journey has reached an unexpected crossroads. \n" +
        "\n" +
        "Whether by fate's hand or a twist of destiny, this path has ended.\n" +
        "\n" +
        "But every end is a new beginning..."));
  }
}
