package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RESP_1_Test_1 {
    @Test
    void getAdventureDeckSize() {
        Decks deck = new Decks();
        deck.intializeAdventureDeck();
        int decksize = deck.getAdventureDeckSize();
        assertEquals(100,decksize);
    }
    @Test
    void getEventDeckSize() {
        Decks deck = new Decks();
        deck.intializeEventDeck();
        int decksize = deck.getEventDeckSize();
        assertEquals(17,decksize);
    }

}