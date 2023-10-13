package com.codecool.mightytextadventure.data;

import com.codecool.mightytextadventure.data.arearooms.StartingArea;
import com.codecool.mightytextadventure.data.arearooms.HutInside;
import com.codecool.mightytextadventure.data.arearooms.WayToForrest;
import com.codecool.mightytextadventure.data.arearooms.ForrestEnter;
import com.codecool.mightytextadventure.data.arearooms.ForrestDirections;
import com.codecool.mightytextadventure.data.arearooms.FindFang;
import com.codecool.mightytextadventure.data.arearooms.GameOver;

import java.util.Map;

public class AreaDescription {

  public static void loadStart(Map<AreaName, Area> areas) {
    StartingArea.loadStartingArea(areas);
    StartingArea.loadSAKnocking(areas);
    StartingArea.loadSALeaving(areas);
    StartingArea.loadSAKnockAgain(areas);
    StartingArea.loadSACallName(areas);
  }

  public static void loadHutInside(Map<AreaName, Area> areas) {
    HutInside.loadHutInsideRoom(areas);
    HutInside.loadHIEnter(areas);
    HutInside.loadHILookAround(areas);
    HutInside.loadHIMakeTea(areas);
    HutInside.loadHIAsk(areas);
    HutInside.loadHIShareTea(areas);
    HutInside.loadHIDrinkAlone(areas);
    HutInside.loadHIHagridAnswers(areas);
    HutInside.loadHIOptionKid(areas);
    HutInside.loadHIOptionTeacher(areas);
    HutInside.loadHIOptionGoAlone(areas);
  }

  public static void loadWayToForrest(Map<AreaName, Area> areas) {
    WayToForrest.loadWayToForrestRoom(areas);

  }

  public static void loadForrestEnter(Map<AreaName, Area> areas) {
    ForrestEnter.loadForrestEnterRoom(areas);

  }

  public static void loadForrestDirections(Map<AreaName, Area> areas) {
    ForrestDirections.loadForrestDirectionsRoom(areas);

  }

  public static void loadFindFang(Map<AreaName, Area> areas) {
    FindFang.loadFindFangRoom(areas);

  }

  public static void loadGameOver(Map<AreaName, Area> areas) {
    GameOver.loadGameOverRoom(areas);

  }
}
