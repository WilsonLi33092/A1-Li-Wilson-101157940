package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RESP_4_Test_1 {
    @Test
    public void testPlague() {
        Decks deck = new Decks();
        EventCard event = new EventCard();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        deck.getCurrentPlayerTurn();
        deck.drawEventCard();
        Player playerOne = new Player();
        Player playerTwo = new Player();
        Player playerThree = new Player();
        Player playerFour = new Player();
        int currentShields = -1;
        int revisedShields = -1;
        if(deck.getCurrentPlayerTurn() == 1) {
            currentShields = playerOne.getShields();
            playerOne.setShields(event.drawPlagueCard(playerOne.getShields()));
            revisedShields = playerOne.getShields();
        }
        else if(deck.getCurrentPlayerTurn() == 2) {
            currentShields = playerTwo.getShields();
            playerTwo.setShields(event.drawPlagueCard(playerTwo.getShields()));
            revisedShields = playerTwo.getShields();
        }
        else if(deck.getCurrentPlayerTurn() == 3) {
            currentShields = playerThree.getShields();
            playerThree.setShields(event.drawPlagueCard(playerThree.getShields()));
            revisedShields = playerThree.getShields();
        }
        else if(deck.getCurrentPlayerTurn() == 4) {
            currentShields = playerFour.getShields();
            playerFour.setShields(event.drawPlagueCard(playerFour.getShields()));
            revisedShields = playerFour.getShields();
        }
        if(currentShields <= 2 ) {
            assertEquals(0, revisedShields);
        }
        else {
            assertEquals((currentShields-2), revisedShields);
        }
    }
}