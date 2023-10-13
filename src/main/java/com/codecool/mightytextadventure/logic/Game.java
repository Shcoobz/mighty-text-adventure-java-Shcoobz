package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {
    private final Map<AreaName, Area> areas;
    private final Input input;
    private final Display display;
    private final Player player;
    private Battle battle;
    boolean isRunning = true;

    public Game(Map<AreaName, Area> areas, Input input, Display display, Player player) {
        this.areas = areas;
        this.input = input;
        this.display = display;
        this.player = player;
        this.battle = new Battle(player, null);
    }

    public void run() {
        while (isRunning) {
            display.printAreaDescription(player.getActualArea().getDescription());
            AreaName currentArea = player.getActualArea().getAreaName();

            checkGameOverOrWin();

            if (isRunning) {
                if (isPlayerInBattleArea(currentArea)) {
                    switch (rollDice()) {
                        case 1:
                        case 2:
                        case 3:
                            boolean playerWon = battle.determinePlayerAndEnemy(this);
                            if (playerWon) {
                                System.out.println("test for playerwon");
                            }
                            break;
                    }
                }

                if (isRunning) {
                    waitForUserInput();
                }
            }
        }
    }

    public void endGame() {
        isRunning = false;
    }

    private boolean isPlayerInBattleArea(AreaName currentArea) {
        return currentArea != null && (currentArea.equals(AreaName.F_WEST) ||
                currentArea.equals(AreaName.F_EAST) ||
                currentArea.equals(AreaName.F_SOUTH) ||
                currentArea.equals(AreaName.F_NORTH));
    }

    private void waitForUserInput() {
        display.printAvailableActions(player.getActualArea().getAvailableActions());
        String userInput = input.getInputFromUser().toLowerCase();
        List<String> availableActions = player.getActualArea().getAvailableActions();
        String chosenAction = getChosenAction(userInput, availableActions);

        switch (userInput) {
            case "quit":
                display.printLoseMessage(player);
                isRunning = false;
                break;
            case "win":
                player.setActualArea(areas.get(AreaName.FIND_FANG));
                break;
            case "woods":
                player.setActualArea(areas.get(AreaName.FORREST_ENTER));
                break;
            case "battle":
                boolean playerWon = battle.determinePlayerAndEnemy(this);
                if (playerWon) {
                    System.out.println("test for playerwon");
                }
                int playerHP = player.getHP();
                if (playerHP == 0) {
                    endGame();
                }
                break;
            default:
                if (chosenAction != null) {
                    Area nextArea = player.getActualArea().getAreaForAction(chosenAction);
                    if (nextArea != null) {
                        player.setActualArea(nextArea);
                    } else {
                        display.printInvalidAction();
                    }
                } else {
                    display.printInvalidAction();
                }
                break;
        }
    }

    private int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private String getChosenAction(String userInput, List<String> availableActions) {
        try {
            int actionIndex = Integer.parseInt(userInput) - 1; // convert to 0-based index
            if (actionIndex >= 0 && actionIndex < availableActions.size()) {
                return availableActions.get(actionIndex);
            }
        } catch (NumberFormatException e) {
            // not a number, ignore and continue
        }
        return null;
    }

    private void checkGameOverOrWin() {
        if (AreaName.GAME_OVER.equals(player.getActualArea().getAreaName())) {
            display.printLoseMessage(player);
            isRunning = false;
        } else if (AreaName.FIND_FANG.equals(player.getActualArea().getAreaName())) {
            display.printWinMessage(player);
            isRunning = false;
        }
    }
}

