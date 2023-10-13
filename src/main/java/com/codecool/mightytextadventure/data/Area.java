package com.codecool.mightytextadventure.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Area {
  private AreaName areaName;
  private final String description;
  private final Map<String, Area> connectedAreas;

  public AreaName getAreaName() {
    return this.areaName;
  }

  public Area(String description) {
    this.description = description;
    this.connectedAreas = new HashMap<>();
  }

  public Area(AreaName areaName, String description) {
    this.areaName = areaName;
    this.description = description;
    this.connectedAreas = new HashMap<>();
  }

  public String getDescription() {
    return description;
  }

  public void addConnection(String action, Area destination) {
    connectedAreas.put(action, destination);
  }

  public Area getAreaForAction(String action) {
    return connectedAreas.get(action);
  }

  public List<String> getAvailableActions() {
    return new ArrayList<>(connectedAreas.keySet());
  }
}
