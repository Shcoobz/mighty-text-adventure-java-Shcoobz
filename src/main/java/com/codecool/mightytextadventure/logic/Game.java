package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

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

        if (userInput.equals("quit")) {
            display.printMessage("Exiting the game.");
            isRunning = false;
        } else {
            Area nextArea = player.getActualArea().getAreaForAction(userInput);
            if (nextArea != null) {
                player.setActualArea(nextArea);
            } else {
                display.printInvalidAction();
            }
        }
    }
}
