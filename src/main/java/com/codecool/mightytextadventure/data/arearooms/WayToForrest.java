package com.codecool.mightytextadventure.data.arearooms;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import java.util.Map;

public class WayToForrest {
  public static void loadWayToForrestRoom(Map<AreaName, Area> areas) {
    areas.put(AreaName.WAY_TO_FORREST, new Area("""
        Approaching the Forbidden Forest, it feels foreboding, with ancient runes marking its entrance. The dark interior
        beckons, with pathways leading left and right.
        """));
  }
}
