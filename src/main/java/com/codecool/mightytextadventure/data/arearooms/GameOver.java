package com.codecool.mightytextadventure.data.arearooms;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import java.util.Map;

public class GameOver {

  // private constructor to prevent instantiation
  private GameOver() {
    throw new AssertionError("Cannot instantiate WayToForrest class");
  }
  public static void loadGameOverRoom(Map<AreaName, Area> areas) {
    areas.put(AreaName.GAME_OVER, new Area(AreaName.GAME_OVER, """
        Your journey has reached an unexpected crossroads.
        
        Whether by fate's hand or a twist of destiny, this path has ended.
        
        But every end is a new beginning...
        """));
  }
}
