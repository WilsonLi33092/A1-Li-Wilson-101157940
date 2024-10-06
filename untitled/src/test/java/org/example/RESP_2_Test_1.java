package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RESP_2_Test_1 {
    @Test
    void testPlayersHand() {
        Decks deck = new Decks();
        deck.intializeAdventureDeck();
        deck.intializeEventDeck();
        deck.dealPlayersHands();
        int playerOneHand = deck.player1Hand.size();
        int playerTwoHand = deck.player2Hand.size();
        int playerThreeHand = deck.player3Hand.size();
        int playerFourHand = deck.player4Hand.size();
        int adventureDeck = deck.adventureDeck.size();
        assertAll(
                () -> assertEquals(12,playerOneHand),
                () -> assertEquals(12,playerTwoHand),
                () -> assertEquals(12,playerThreeHand),
                () -> assertEquals(12,playerFourHand),
                () -> assertEquals(52,adventureDeck)

        );

    }

}