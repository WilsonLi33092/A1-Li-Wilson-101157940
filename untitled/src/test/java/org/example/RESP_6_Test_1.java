package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RESP_6_Test_1 {
    @Test
    public void testCalculateTrimHand() {
        Decks deck = new Decks();
        EventCard event = new EventCard();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        deck.drawEventCard();
        Player playerOne = new Player(1);
        Player playerTwo = new Player(2);
        Player playerThree = new Player(3);
        Player playerFour = new Player(4);
        playerOne.setHand(deck.player1Hand);
        playerTwo.setHand(deck.player2Hand);
        playerThree.setHand(deck.player3Hand);
        playerFour.setHand(deck.player4Hand);
        int revisedHandSize = 0;
        int calculateTrim = 0;
        if(deck.getCurrentPlayerTurn() == 1) {
            playerOne.setHand(event.drawQueensFavorCard(playerOne.getHand(), deck.adventureDeck));
            revisedHandSize = playerOne.getHand().size();
            calculateTrim = playerOne.calculateTrimHand(playerOne.getHand());
        }
        else if(deck.getCurrentPlayerTurn() == 2) {
            playerTwo.setHand(event.drawQueensFavorCard(playerTwo.getHand(), deck.adventureDeck));
            revisedHandSize = playerTwo.getHand().size();
            calculateTrim = playerTwo.calculateTrimHand(playerOne.getHand());
        }
        else if(deck.getCurrentPlayerTurn() == 3) {
            playerThree.setHand(event.drawQueensFavorCard(playerThree.getHand(), deck.adventureDeck));
            revisedHandSize = playerThree.getHand().size();
            calculateTrim = playerThree.calculateTrimHand(playerOne.getHand());
        }
        else if(deck.getCurrentPlayerTurn() == 4) {
            playerFour.setHand(event.drawQueensFavorCard(playerFour.getHand(), deck.adventureDeck));
            revisedHandSize = playerFour.getHand().size();
            calculateTrim = playerFour.calculateTrimHand(playerOne.getHand());
        }
        if (revisedHandSize > 12){
            assertEquals(revisedHandSize-12, calculateTrim);
        }
    }
}