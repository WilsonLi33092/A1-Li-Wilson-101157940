package org.example;

import java.util.ArrayList;

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
        return playerHand;
    }
}
