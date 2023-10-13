package com.codecool.mightytextadventure.data.arearooms;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ForrestDirections {

  // private constructor to prevent instantiation
  private ForrestDirections() {
    throw new AssertionError("Cannot instantiate WayToForrest class");
  }

  public static void loadForrestDirectionsRoom(Map<AreaName, Area> areas) {
    Map<AreaName, String[]> forestDescriptions = new HashMap<>();

    forestDescriptions.put(AreaName.F_NORTH, new String[]{
        "Towering trees and thick vines envelop the area. Ahead, the land seems to rise.",
        "A clear stream crosses your path, with birdsong adding to the serenity.",
        "A mossy clearing showcases large stones arranged in a pattern, hinting at ancient magic."
    });

    forestDescriptions.put(AreaName.F_EAST, new String[]{
        "The eastern forest has patches of sky visible, with flowers that emit a soft glow.",
        "Brambles, thorns, and dewy spider webs impede your path, with fluttering wings suggesting company.",
        "Moving east, barren trees emerge and a chilling mist obscures your way"
    });

    forestDescriptions.put(AreaName.F_SOUTH, new String[]{
        "Dense underbrush fills the southern path, with a waterfall's distant echo.",
        "Ferns and glowing berries light the trail, suggesting enchantment.",
        "Venturing further south, shifting shadows and faint whispers create an eerie atmosphere."
    });

    forestDescriptions.put(AreaName.F_WEST, new String[]{
        "The western terrain becomes marshy, with audible amphibian calls.",
        "Weeping willows with drooping branches unveil hidden groves.",
        "Heading west, the scent of pine grows, with the ground hinting at foothills and rustling leaves implying hidden\n" +
            "inhabitants."
    });

    areas.put(AreaName.F_NORTH, new Area(AreaName.F_NORTH, getRandomDescription(forestDescriptions, AreaName.F_NORTH)));
    areas.put(AreaName.F_EAST, new Area(AreaName.F_EAST, getRandomDescription(forestDescriptions, AreaName.F_EAST)));
    areas.put(AreaName.F_SOUTH, new Area(AreaName.F_SOUTH, getRandomDescription(forestDescriptions, AreaName.F_SOUTH)));
    areas.put(AreaName.F_WEST, new Area(AreaName.F_WEST, getRandomDescription(forestDescriptions, AreaName.F_WEST)));
  }

  private static String getRandomDescription(Map<AreaName, String[]> descriptions, AreaName direction) {
    String[] descArray = descriptions.get(direction);
    Random rand = new Random();
    return descArray[rand.nextInt(descArray.length)];
  }
}
