package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RESP_4_Test_1 {
    @Test
    public void testPlague() {
        Decks deck = new Decks();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        deck.getCurrentPlayerTurn();
        deck.drawEventCard();
        int currentHandSize = 0;
        int revisedHandSize = 0;
        if(deck.getCurrentPlayerTurn() == 1) {
            currentHandSize = deck.player1Hand.size();
            deck.drawPlagueCard(deck.player1Hand);
            revisedHandSize = deck.player1Hand.size();
        }
        else if(deck.getCurrentPlayerTurn() == 2) {
            currentHandSize = deck.player2Hand.size();
            deck.drawPlagueCard(deck.player2Hand);
            revisedHandSize = deck.player2Hand.size();
        }
        else if(deck.getCurrentPlayerTurn() == 3) {
            currentHandSize = deck.player3Hand.size();
            deck.drawPlagueCard(deck.player3Hand);
            revisedHandSize = deck.player3Hand.size();
        }
        else if(deck.getCurrentPlayerTurn() == 4) {
            currentHandSize = deck.player3Hand.size();
            deck.drawPlagueCard(deck.player4Hand);
            revisedHandSize = deck.player4Hand.size();
        }
        assertEquals((currentHandSize-2), revisedHandSize);
    }
}