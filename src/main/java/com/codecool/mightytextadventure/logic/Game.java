package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.List;

public class Game {
    private final Area[] areas;
    private final Input input;
    private final Display display;
    private final Player player;

    boolean isRunning = true;

    public Game(Area[] areas, Input input, Display display, Player player) {
        this.areas = areas;
        this.input = input;
        this.display = display;
        this.player = player;
    }


    public void run() {

        while (isRunning) {
            display.printAreaDescription(player.getActualArea().getDescription());
            waitForUserInput();

        }
    }

    private boolean step() {
        for (var action : player.getActualArea().getAvailableActions()) {
            display.printMessage(action);
        }

        return true;
    }

/*-----------stop till get user Input----------*/
    /* We can change waitForUserInput to step as well,
    but since the code was working correctly, I didn't change anything*/
    private void waitForUserInput() {
        display.printAvailableActions(player.getActualArea().getAvailableActions());
        String userInput = input.getInputFromUser().toLowerCase();

        List<String> availableActions = player.getActualArea().getAvailableActions();
        String chosenAction = null;

        // check if user input is a number and maps to an action
        try {
            int actionIndex = Integer.parseInt(userInput) - 1; // convert to 0-based index
            if (actionIndex >= 0 && actionIndex < availableActions.size()) {
                chosenAction = availableActions.get(actionIndex);
            }
        } catch (NumberFormatException e) {
            // not a number, ignore and continue
        }

        if (userInput.equals("quit")) {
            display.printMessage("Exiting the game.");
            isRunning = false;
        } else if (chosenAction != null) {
            Area nextArea = player.getActualArea().getAreaForAction(chosenAction);
            if (nextArea != null) {
                player.setActualArea(nextArea);
            } else {
                display.printInvalidAction();
            }
        } else {
            display.printInvalidAction();
        }
    }
}
