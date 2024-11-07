package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
class RESP_7_Test_1 {
    private final ByteArrayOutputStream outputStreamCap = new ByteArrayOutputStream();
    private PrintStream oringinalOutput;
    private Player playerOne;
    private Player playerTwo;
    private Player playerThree;
    private Player playerFour;
    private Decks deck;
    @BeforeEach
    public void setUp(){
        deck = new Decks();
        EventCard event = new EventCard();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        deck.drawEventCard();
        playerOne = new Player(1);
        playerTwo = new Player(2);
        playerThree = new Player(3);
        playerFour = new Player(4);
        playerOne.setHand(deck.player1Hand);
        playerTwo.setHand(deck.player2Hand);
        playerThree.setHand(deck.player3Hand);
        playerFour.setHand(deck.player4Hand);
    }
    @Test
    public void testEventDisplay() {
        assertFalse(playerOne.getHand().isEmpty());
        int playerHandSizeBeforeDeletion = playerOne.hand.size();
        playerOne.deleteCard(0);
        assertEquals((playerHandSizeBeforeDeletion-1), deck.player1Hand.size());

    }
    @AfterEach
    public void tearDown() {
        System.setOut(oringinalOutput);
    }
}