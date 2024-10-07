package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

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
        playerOne = new Player();
        playerTwo = new Player();
        playerThree = new Player();
        playerFour = new Player();
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
    }
    @Test
    public void testEventDisplay() {
        assertFalse(playerOne.getHand().isEmpty());
        playerOne.deleteCard(0);
        assertEquals(playerOne.getHand().size(), deck.player1Hand.size()-1);

    }
    @AfterEach
    public void tearDown() {
        System.setOut(oringinalOutput);
    }

}