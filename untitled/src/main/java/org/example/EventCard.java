package org.example;

import java.util.ArrayList;
import java.util.Random;

public class EventCard {
    public ArrayList<Card> drawPlagueCard(ArrayList<Card> playerHand) {
        Random discardCard = new Random();
        for (int i =0; i < 2; i++) {
            int randInx = discardCard.nextInt(playerHand.size());
            Object randCard = playerHand.get(randInx);
            playerHand.remove(randInx);
        }
        return playerHand;
    }
}
