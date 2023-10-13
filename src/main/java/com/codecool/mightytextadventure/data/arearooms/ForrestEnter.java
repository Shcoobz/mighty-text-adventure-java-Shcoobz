package com.codecool.mightytextadventure.data.arearooms;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import java.util.Map;

public class ForrestEnter {

  // private constructor to prevent instantiation
  private ForrestEnter() {
    throw new AssertionError("Cannot instantiate WayToForrest class");
  }
  public static void loadForrestEnterRoom(Map<AreaName, Area> areas) {
    areas.put(AreaName.FORREST_ENTER, new Area("""
    You venture into the dense forest. The environment is both magical and eerie. As you tread deeper, the responsibility of
    finding Fang weighs heavily.
    """));
  }
}
