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
        Player playerOne = new Player(1);
        Player playerTwo = new Player(2);
        Player playerThree = new Player(3);
        Player playerFour = new Player(4);
        int currentShields = -1;
        int revisedShields = -1;
        if(deck.getCurrentPlayerTurn() == 1) {
            currentShields = playerOne.getShields();
            event.drawPlagueCard(playerOne);
            revisedShields = playerOne.getShields();
        }
        else if(deck.getCurrentPlayerTurn() == 2) {
            currentShields = playerTwo.getShields();
            event.drawPlagueCard(playerTwo);
            revisedShields = playerTwo.getShields();
        }
        else if(deck.getCurrentPlayerTurn() == 3) {
            currentShields = playerThree.getShields();
            event.drawPlagueCard(playerThree);
            revisedShields = playerThree.getShields();
        }
        else if(deck.getCurrentPlayerTurn() == 4) {
            currentShields = playerFour.getShields();
            event.drawPlagueCard(playerFour);
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