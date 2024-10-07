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
    public void drawProsperity(ArrayList<Card> playerOneHand, ArrayList<Card> playerTwoHand, ArrayList<Card> playerThreeHand, ArrayList<Card> playerFourHand, ArrayList<Card> adventureDeck) {

    }
}
