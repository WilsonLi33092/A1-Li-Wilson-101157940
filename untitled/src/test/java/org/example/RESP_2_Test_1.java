package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RESP_2_Test_1 {
    @Test
    void testPlayersHand() {
        Main game = new Main();
        game.intializeAdventureDeck();
        game.intializeEventDeck();
        game.dealPlayersHands();
        int playerOneHand = game.player1Hand.size();
        int playerTwoHand = game.player2Hand.size();
        int playerThreeHand = game.player3Hand.size();
        int playerFourHand = game.player4Hand.size();
        int adventureDeck = game.adventureDeck.size();
        assertAll(
                () -> assertEquals(12,playerOneHand),
                () -> assertEquals(12,playerTwoHand),
                () -> assertEquals(12,playerThreeHand),
                () -> assertEquals(12,playerFourHand),
                () -> assertEquals(52,adventureDeck)

        );

    }

}