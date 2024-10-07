package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RESP_9_Test_1 {
    @Test
    public void testDeclineQuest() {
        Decks deck = new Decks();
        QuestCard quest = new QuestCard();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        deck.drawEventCard();
        int currentPlayerTurn = deck.getCurrentPlayerTurn();
        List<String> decisions = Arrays.asList("N", "N", "N", "N");
        int revisedPlayerTurn = quest.questCardDrawn(currentPlayerTurn, decisions);
        if(currentPlayerTurn < 4) {
            assertEquals(currentPlayerTurn + 1, revisedPlayerTurn);
        }
        else {
            assertEquals(1, revisedPlayerTurn);
        }
    }
}