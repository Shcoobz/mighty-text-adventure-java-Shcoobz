package com.codecool.mightytextadventure.data;

import java.util.Map;

public class AreaConnections {

  public static final String LEAVE = "[Leave]";
  public static final String NORTH = "[Go North]";
  public static final String EAST = "[Go East]";
  public static final String SOUTH = "[Go South]";
  public static final String WEST = "[Go West]";

  // private constructor to prevent instantiation
  private AreaConnections() {
    throw new AssertionError("Cannot instantiate WayToForrest class");
  }

  public static void setupStart(Map<AreaName, Area> areas) {
    // ========== STARTING AREA ==========
    areas.get(AreaName.STARTING_AREA).addConnection("[Knock]", areas.get(AreaName.SA_KNOCK));
    areas.get(AreaName.STARTING_AREA).addConnection(LEAVE, areas.get(AreaName.GAME_OVER));

    // ========== SA_KNOCKING ==========
    areas.get(AreaName.SA_KNOCK).addConnection("[Knock again]", areas.get(AreaName.SA_KNOCK_AGAIN));
    areas.get(AreaName.SA_KNOCK).addConnection("[Call his name]", areas.get(AreaName.SA_CALL_NAME));
    areas.get(AreaName.SA_KNOCK).addConnection(LEAVE, areas.get(AreaName.GAME_OVER));

    // ========== SA_KNOCK_AGAIN ==========
    areas.get(AreaName.SA_KNOCK_AGAIN).addConnection("[Knock yet again]", areas.get(AreaName.SA_KNOCK));
    areas.get(AreaName.SA_KNOCK_AGAIN).addConnection(LEAVE, areas.get(AreaName.GAME_OVER));

    // ========== SA_CALL_NAME ==========
    areas.get(AreaName.SA_CALL_NAME).addConnection("[Knock yet again]", areas.get(AreaName.SA_KNOCK));
    areas.get(AreaName.SA_CALL_NAME).addConnection("[Reassure him]", areas.get(AreaName.HUT_INSIDE));
    areas.get(AreaName.SA_CALL_NAME).addConnection(LEAVE, areas.get(AreaName.GAME_OVER));
  }

  public static void setupHutInside(Map<AreaName, Area> areas) {
    // ========== HUT_INSIDE ==========
    areas.get(AreaName.HUT_INSIDE).addConnection("[Enter]", areas.get(AreaName.HI_ENTER));

    // ========== HI_ENTER ==========
    areas.get(AreaName.HI_ENTER).addConnection("[Look around]", areas.get(AreaName.HI_LOOK_AROUND));
    areas.get(AreaName.HI_ENTER).addConnection("[Make Tea]", areas.get(AreaName.HI_MAKE_TEA));

    // ========== HI_LOOK_AROUND ==========
    areas.get(AreaName.HI_LOOK_AROUND).addConnection("[Ask what happened]", areas.get(AreaName.HI_ASK));

    // ========== HI_MAKE_TEA ==========
    areas.get(AreaName.HI_MAKE_TEA).addConnection("[Share tea]", areas.get(AreaName.HI_SHARE_TEA));
    areas.get(AreaName.HI_MAKE_TEA).addConnection("[Drink tea alone]", areas.get(AreaName.HI_DRINK_ALONE));

    // ========== HI_ASK ==========
    areas.get(AreaName.HI_ASK).addConnection("[Listen]", areas.get(AreaName.HI_HAGRID_ANSWERS));

    // ========== HI_SHARE_TEA ==========
    areas.get(AreaName.HI_SHARE_TEA).addConnection("[Smile reassuringly]", areas.get(AreaName.HI_HAGRID_ANSWERS));

    // ========== HI_HAGRID_ANSWERS ==========
    areas.get(AreaName.HI_HAGRID_ANSWERS).addConnection("[Say that you can't help]", areas.get(AreaName.GAME_OVER));
    areas.get(AreaName.HI_HAGRID_ANSWERS).addConnection("[Offer to find a teacher]", areas.get(AreaName.HI_OPTION_TEACHER));
    areas.get(AreaName.HI_HAGRID_ANSWERS).addConnection("[Offer to look for Fang yourself]", areas.get(AreaName.HI_OPTION_GO_ALONE));

    // ========== HI_OPTION_TEACHER ==========
    areas.get(AreaName.HI_OPTION_TEACHER).addConnection("[You're just a kid, what can you do]", areas.get(AreaName.GAME_OVER));
    areas.get(AreaName.HI_OPTION_TEACHER).addConnection("[You will go look for Fang yourself]", areas.get(AreaName.HI_OPTION_KID));

    // ========== HI_OPTION_GO_ALONE ==========
    areas.get(AreaName.HI_OPTION_GO_ALONE).addConnection("[Continue]", areas.get(AreaName.WAY_TO_FORREST));
    areas.get(AreaName.HI_OPTION_GO_ALONE).addConnection("[Run away in fear]", areas.get(AreaName.GAME_OVER));
  }

  public static void setupWayToForrest(Map<AreaName, Area> areas) {
    areas.get(AreaName.WAY_TO_FORREST).addConnection("[Enter]", areas.get(AreaName.FORREST_ENTER));
    areas.get(AreaName.WAY_TO_FORREST).addConnection("[Run away in fear]", areas.get(AreaName.GAME_OVER));
  }

  public static void setupForrestEnter(Map<AreaName, Area> areas) {
    areas.get(AreaName.FORREST_ENTER).addConnection(NORTH, areas.get(AreaName.F_NORTH));
    areas.get(AreaName.FORREST_ENTER).addConnection(EAST, areas.get(AreaName.F_EAST));
    areas.get(AreaName.FORREST_ENTER).addConnection(SOUTH, areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.FORREST_ENTER).addConnection(WEST, areas.get(AreaName.F_WEST));
  }

  public static void setupForrestDirections(Map<AreaName, Area> areas) {
    // ========== F_NORTH ==========
    areas.get(AreaName.F_NORTH).addConnection(NORTH, areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_NORTH).addConnection(EAST, areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_NORTH).addConnection(SOUTH, areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.F_NORTH).addConnection(WEST, areas.get(AreaName.F_WEST));

    // ========== F_EAST ==========
    areas.get(AreaName.F_EAST).addConnection(NORTH, areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_EAST).addConnection(EAST, areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_EAST).addConnection(SOUTH, areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.F_EAST).addConnection(WEST, areas.get(AreaName.F_WEST));

    // ========== F_SOUTH ==========
    areas.get(AreaName.F_SOUTH).addConnection(NORTH, areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_SOUTH).addConnection(EAST, areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_SOUTH).addConnection(SOUTH, areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.F_SOUTH).addConnection(WEST, areas.get(AreaName.F_WEST));

    // ========== F_WEST ==========
    areas.get(AreaName.F_WEST).addConnection(NORTH, areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_WEST).addConnection(EAST, areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_WEST).addConnection(SOUTH, areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.F_WEST).addConnection(WEST, areas.get(AreaName.F_WEST));
  }
}
