package com.codecool.mightytextadventure.logic;

import com.codecool.mightytextadventure.ui.Display;

public class Battle {
    private Player player;
    private Enemy enemy;

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startBattle() {
        Display display = new Display();
        while (player.getHP() > 0 && enemy.getHP() > 0) {
            int playerDamage = player.getAttackStrength();
            int enemyDamage = enemy.getAttackStrength();

            /*------------ Heilung der Player ----------*/
            if (player.getHP() < 60) {

                int potionNumber = player.getPotion();
                if (potionNumber > 0) {
                    player.healWithPotion();
                    display.printMessage("--->>> the remaining potions are : " + Integer.toString(potionNumber) + " pieces");
                }
            }
            ;

            /*------------ Spieler greift den Gegner an ----------*/
            enemy.takeDamage(playerDamage);
            display.printMessage(player.getName() + " greift " + enemy.getName() + " an und fügt " + playerDamage + " Schaden zu.");

            /*------------ Gegner greift den Spieler an ----------*/
            player.takeDamage(enemyDamage);
            display.printMessage(enemy.getName() + " greift " + player.getName() + " an und fügt " + enemyDamage + " Schaden zu.");

            System.out.println(player.getName() + " HP: " + player.getHP());
            System.out.println(enemy.getName() + " HP: " + enemy.getHP());
        }

        if (player.getHP() <= 0) {
            display.printLoseMessage();
        } else {
            display.printWinMessage();
        }
    }
}
