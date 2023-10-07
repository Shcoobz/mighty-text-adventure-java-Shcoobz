package com.codecool.mightytextadventure.ui;

import com.codecool.mightytextadventure.logic.Player;

import java.util.Scanner;

public class Input {

    public String getInputFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the name of player: ");
        String name = scanner.nextLine();

        Player player = new Player(name, 100, false, 0);


        return "";
    }

}
