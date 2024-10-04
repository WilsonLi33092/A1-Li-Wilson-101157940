package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RESP_1_Test_1 {
    @Test
    void getAdventureDeckSize() {
        Main game = new Main();
        game.intializeAdventureDeck();
        int decksize = game.getAdventureDeckSize();
        assertEquals(100,decksize);
    }
    @Test
    void getEventDeckSize() {
        Main game = new Main();
        game.intializeEventDeck();
        int decksize = game.getEventDeckSize();
        assertEquals(17,decksize);
    }

}