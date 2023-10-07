package com.codecool.mightytextadventure.ui;

import com.codecool.mightytextadventure.logic.Player;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getInputFromUser(){
        String input = scanner.nextLine().trim();

        // make input case-insensitive by converting it to lowercase
        input = input.toLowerCase();

        // check for 'help' or 'h' & provide the help information
        if ("help".equals(input) || "h".equals(input)) {
            displayHelp();
            return getInputFromUser(); // after displaying help, ask for input again
        }



        return input;
    }
public String getNameFromUser(){
    System.out.println("please enter the name of player: ");
    String name = scanner.nextLine();
    return name;
}



    private void displayHelp() {
        System.out.println("HELP INFORMATION:");
        System.out.println("- Type the action you want to take (e.g., 'move to Room 1').");
        System.out.println("- Actions are case-insensitive.");
        System.out.println("- Type 'h' or 'help' for this help message.");
        System.out.println("- More...?");
    }
}
