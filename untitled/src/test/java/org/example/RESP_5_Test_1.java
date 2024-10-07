package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RESP_5_Test_1 {
    @Test
    public void testQueenFavor() {
      Decks deck = new Decks();
      EventCard event = new EventCard();
      deck.intializeEventDeck();
      deck.intializeAdventureDeck();
      deck.dealPlayersHands();
      deck.getCurrentPlayerTurn();
      deck.drawEventCard();
      Player playerOne = new Player();
      Player playerTwo = new Player();
      Player playerThree = new Player();
      Player playerFour = new Player();
      playerOne.setHand(deck.player1Hand);
      playerTwo.setHand(deck.player2Hand);
      playerThree.setHand(deck.player3Hand);
      playerFour.setHand(deck.player4Hand);
      int currentHandSize = 0;
      int revisedHandSize = 0;
      int currentAdventureDeckSize = deck.getAdventureDeckSize();
      int revisedAdventureDeckSize = 0;
      if(deck.getCurrentPlayerTurn() == 1) {
          currentHandSize = playerOne.getHand().size();
          playerOne.setHand(event.drawQueensFavorCard(playerOne.getHand(), deck.adventureDeck));
          revisedHandSize = playerOne.getHand().size();
      }
      else if(deck.getCurrentPlayerTurn() == 2) {
          currentHandSize = playerTwo.getHand().size();
          playerTwo.setHand(event.drawQueensFavorCard(playerTwo.getHand(), deck.adventureDeck));
          revisedHandSize = playerTwo.getHand().size();
      }
      else if(deck.getCurrentPlayerTurn() == 3) {
          currentHandSize = playerThree.getHand().size();
          playerThree.setHand(event.drawQueensFavorCard(playerThree.getHand(), deck.adventureDeck));
          revisedHandSize = playerThree.getHand().size();
      }
      else if(deck.getCurrentPlayerTurn() == 4) {
          currentHandSize = playerFour.getHand().size();
          playerFour.setHand(event.drawQueensFavorCard(playerFour.getHand(), deck.adventureDeck));
          revisedHandSize = playerFour.getHand().size();
      }
      revisedAdventureDeckSize = deck.getAdventureDeckSize();
      assertEquals((currentHandSize + 2), revisedHandSize);
      assertEquals((currentAdventureDeckSize-2), revisedAdventureDeckSize);

    }
}