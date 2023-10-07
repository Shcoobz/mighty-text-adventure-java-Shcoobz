package com.codecool.mightytextadventure.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Area {
    private String description;
    private Map<String, Area> connectedAreas; // represents actions & their result
    public Area(String description) {
        this.description = description;
        this.connectedAreas = new HashMap<>();
    }

    public String getDescription() {
        return  description;
    }

    /**
     * Adds a connected area to this area.
     *
     * @param action      The action required to move to the connected area.
     * @param destination The connected area.
     */
    public void addConnection(String action, Area destination){
        connectedAreas.put(action, destination);
    }

    /**
     * Gets the area resulting from an action.
     *
     * @param action The action to perform.
     * @return The resulting area or null if action is invalid.
     */
    public Area getAreaForAction(String action) {
        return connectedAreas.get(action);
    }

    /**
     * Returns a list of available actions for this area.
     *
     * @return List of available actions.
     */
    public List<String> getAvailableActions() {
        return new ArrayList<>(connectedAreas.keySet());
    }
}
