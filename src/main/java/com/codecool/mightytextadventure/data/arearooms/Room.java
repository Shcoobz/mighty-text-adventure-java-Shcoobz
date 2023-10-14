package com.codecool.mightytextadventure.data.arearooms;

import com.codecool.mightytextadventure.data.AreaName;

import java.util.HashMap;
import java.util.Map;

public class Room {
  private String description;

  private Map<String, Room> connections = new HashMap<>();

  public Room(String description) {
    this.description = description;
  }

  public void addConnection(String action, Room room) {
    connections.put(action, room);
  }
}
