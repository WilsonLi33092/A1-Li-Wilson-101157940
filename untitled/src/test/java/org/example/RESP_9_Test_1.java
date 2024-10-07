package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RESP_9_Test_1 {
    @Test
    public void testDeclineQuest() {
        Decks deck = new Decks();
        EventCard event = new EventCard();
        QuestCard quest = new QuestCard();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        deck.drawEventCard();
        Player playerOne = new Player();
        Player playerTwo = new Player();
        Player playerThree = new Player();
        Player playerFour = new Player();
        int currentPLayerTurn = deck.getCurrentPlayerTurn();
        int newPlayerTurn = 0;
        int revisedPlayerTurn = 0;
        if(deck.getCurrentPlayerTurn() == 1) {
            revisedPlayerTurn = quest.questCardDrawn(deck.getCurrentPlayerTurn());

        }
        else if(deck.getCurrentPlayerTurn() == 2) {
            revisedPlayerTurn = quest.questCardDrawn(deck.getCurrentPlayerTurn());
        }
        else if(deck.getCurrentPlayerTurn() == 3) {
            revisedPlayerTurn = quest.questCardDrawn(deck.getCurrentPlayerTurn());
        }
        else if(deck.getCurrentPlayerTurn() == 4) {
            revisedPlayerTurn = quest.questCardDrawn(deck.getCurrentPlayerTurn());
        }
        if(deck.getCurrentPlayerTurn() < 4 ) {
            assertEquals(currentPLayerTurn+1, revisedPlayerTurn);
        }
        else {
            assertEquals(1, revisedPlayerTurn);
        }
    }
}