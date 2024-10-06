package org.example;

import java.util.ArrayList;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Decks deck = new Decks();
        deck.intializeAdventureDeck();
        deck.intializeEventDeck();
        deck.dealPlayersHands();
        Player playerOne = new Player();
        Player playerTwo = new Player();
        Player playerThree = new Player();
        Player playerFour = new Player();
        playerOne.setHand(deck.player1Hand);
        playerTwo.setHand(deck.player2Hand);
        playerThree.setHand(deck.player3Hand);
        playerFour.setHand(deck.player4Hand);
        Boolean winner = false;
        int turnCounter = 0;
        while (winner == false) {
            if(turnCounter % 4 == 0) {
                System.out.println("Player 1 Hand: " + playerOne.getHand());
                System.out.println("It is currently your turn Player 1");
            }
            else if(turnCounter % 4 == 1) {
                System.out.println("Player 2 Hand: " + playerTwo.getHand());
            }
            else if(turnCounter % 4 == 2) {
                System.out.println("Player 3 Hand: " + playerThree.getHand());
            }
            else if(turnCounter % 4 == 3) {
                System.out.println("Player 4 Hand: " + playerFour.getHand());
            }
            if(playerOne.getShields() >= 7 || playerTwo.getShields() >= 7 || playerThree.getShields() >= 7 || playerFour.getShields() >= 7) {
                winner = true;
            }
        }

    }



}
