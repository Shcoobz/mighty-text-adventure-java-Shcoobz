package com.codecool.mightytextadventure.data.arearooms;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import java.util.Map;

public class ForrestEnter {
  public static void loadForrestEnterRoom(Map<AreaName, Area> areas) {
    areas.put(AreaName.FORREST_ENTER, new Area("You venture into the dense forest. The environment is both magical and eerie. As you tread deeper, the responsibility of\n" +
        "finding Fang weighs heavily."));
  }
}
