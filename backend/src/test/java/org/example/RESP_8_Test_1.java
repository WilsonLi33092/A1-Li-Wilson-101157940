package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RESP_8_Test_1 {
    @Test
    public void testProsperity() {
        Decks deck = new Decks();
        EventCard event = new EventCard();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        deck.drawEventCard();
        Player playerOne = new Player();
        Player playerTwo = new Player();
        Player playerThree = new Player();
        Player playerFour = new Player();
        playerOne.setHand(deck.player1Hand);
        playerTwo.setHand(deck.player2Hand);
        playerThree.setHand(deck.player3Hand);
        playerFour.setHand(deck.player4Hand);
        int expectedAdventureDeckSize = deck.getAdventureDeckSize() - 8;
        int expectedHandSizePlayerOne = playerOne.getHand().size() +2;
        int expectedHandSizePlayerTwo = playerTwo.getHand().size() + 2;
        int expectedHandSizePlayerThree = playerThree.getHand().size() + 2;
        int expectedHandSizePlayerFour = playerFour.getHand().size() + 2;
        event.drawProsperity(playerOne.getHand(), playerTwo.getHand(), playerThree.getHand(),playerFour.getHand(), deck.adventureDeck);

        assertAll(
                () -> assertEquals(expectedHandSizePlayerOne,playerOne.getHand().size()),
                () -> assertEquals(expectedHandSizePlayerTwo,playerTwo.getHand().size()),
                () -> assertEquals(expectedHandSizePlayerThree, playerThree.getHand().size()),
                () -> assertEquals(expectedHandSizePlayerFour, playerFour.getHand().size()),
                () -> assertEquals(expectedAdventureDeckSize, deck.adventureDeck.size())
        );
    }
}