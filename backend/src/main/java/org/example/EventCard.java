package org.example;

import java.util.ArrayList;
import java.util.Random;

public class EventCard {
    public int drawPlagueCard(int playerShields) {
        if(playerShields <= 2) {
            return 0;
        }
        else {
            return playerShields-2;
        }
    }
    public ArrayList<Card> drawQueensFavorCard(ArrayList<Card> playerHand, ArrayList<Card> adventureDeck) {
        Random drawCard = new Random();
        for(int i =0; i< 2; i++) {
            int randInx = drawCard.nextInt(adventureDeck.size());
            Card randCard = adventureDeck.get(randInx);
            playerHand.add(randCard);
            adventureDeck.remove(randInx);
        }
        return playerHand;
    }
    public ArrayList<Card> drawRiggedQueensFavorCard(ArrayList<Card> playerHand, ArrayList<Card> adventureDeck) {

        for(int i =0; i< 2; i++) {
            Card randCard = adventureDeck.get(0);
            playerHand.add(randCard);
            adventureDeck.remove(0);
        }
        return playerHand;
    }
    public void drawProsperity(ArrayList<Card> playerOneHand, ArrayList<Card> playerTwoHand, ArrayList<Card> playerThreeHand, ArrayList<Card> playerFourHand, ArrayList<Card> adventureDeck) {
        Random drawCard = new Random();
        for(int i =0; i<8;i++) {
            int randInx = drawCard.nextInt(adventureDeck.size());
            Card randCard = adventureDeck.get(randInx);
            if(i % 4 == 0) {
                playerOneHand.add(randCard);
                adventureDeck.remove(randInx);
            }
            else if(i % 4 == 1) {
                playerTwoHand.add(randCard);
                adventureDeck.remove(randInx);
            }
            else if(i % 4 == 3) {
                playerThreeHand.add(randCard);
                adventureDeck.remove(randInx);
            }
            else {
                playerFourHand.add(randCard);
                adventureDeck.remove(randInx);
            }
        }
    }
    public void drawRiggedProsperity(ArrayList<Card> playerOneHand, ArrayList<Card> playerTwoHand, ArrayList<Card> playerThreeHand, ArrayList<Card> playerFourHand, ArrayList<Card> adventureDeck) {

        playerOneHand.add(adventureDeck.get(0));
        adventureDeck.remove(0);
        playerOneHand.add(adventureDeck.get(0));
        adventureDeck.remove(0);
        playerTwoHand.add(adventureDeck.get(0));
        adventureDeck.remove(0);
        playerTwoHand.add(adventureDeck.get(0));
        adventureDeck.remove(0);
        playerThreeHand.add(adventureDeck.get(0));
        adventureDeck.remove(0);
        playerThreeHand.add(adventureDeck.get(0));
        adventureDeck.remove(0);
        playerFourHand.add(adventureDeck.get(0));
        adventureDeck.remove(0);
        playerFourHand.add(adventureDeck.get(0));
        adventureDeck.remove(0);
    }
}
