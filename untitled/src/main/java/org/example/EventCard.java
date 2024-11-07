package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class EventCard {
    public void drawPlagueCard(Player player) {
        if(player.getShields() <=2) {
            player.setShields(0);
        }
        else {
            player.setShields(player.getShields()-2);
        }
    }
    public ArrayList<Card> drawQueensFavorCard(ArrayList<Card> playerHand, ArrayList<Card> adventureDeck) {
        Random drawCard = new Random();
        for(int i =0; i< 2; i++) {
            int randInx = drawCard.nextInt(adventureDeck.size());
            Card randCard = adventureDeck.get(randInx);
            playerHand.add(randCard);
            adventureDeck.remove(randInx);
        }
        return playerHand;
    }
    public void drawQueensFavourCardRiggedDeck(Player player, ArrayList<Card> adventureDeck) {
        for(int i =0; i< 2; i++) {
            player.getHand().add(adventureDeck.get(0));
            adventureDeck.remove(0);
        }
        player.getHand().sort(Comparator.comparingInt(card -> card.getSortValue()));
    }
    public void drawProsperityRiggedDeck(Player playerOne, Player playerTwo, Player playerThree, Player playerFour, ArrayList<Card> adventureDeck) {
        for(int i =0; i<8;i++) {
            if(i % 4 == 0) {
                playerOne.getHand().add(adventureDeck.get(0));
                adventureDeck.remove(0);
            }
            else if(i % 4 == 1) {
                playerTwo.getHand().add(adventureDeck.get(0));
                adventureDeck.remove(0);
            }
            else if(i % 4 == 3) {
                playerThree.getHand().add(adventureDeck.get(0));
                adventureDeck.remove(0);
            }
            else {
                playerFour.getHand().add(adventureDeck.get(0));
                adventureDeck.remove(0);
            }
        }
        playerOne.getHand().sort(Comparator.comparingInt(card -> card.getSortValue()));
        playerTwo.getHand().sort(Comparator.comparingInt(card -> card.getSortValue()));
        playerThree.getHand().sort(Comparator.comparingInt(card -> card.getSortValue()));
        playerFour.getHand().sort(Comparator.comparingInt(card -> card.getSortValue()));
    }
    public void drawProsperity(ArrayList<Card> playerOneHand, ArrayList<Card> playerTwoHand, ArrayList<Card> playerThreeHand, ArrayList<Card> playerFourHand, ArrayList<Card> adventureDeck) {
        Random drawCard = new Random();
        for(int i =0; i<8;i++) {
            int randInx = drawCard.nextInt(adventureDeck.size());
            Card randCard = adventureDeck.get(randInx);
            if(i % 4 == 0) {
                playerOneHand.add(randCard);
                adventureDeck.remove(randInx);
            }
            else if(i % 4 == 1) {
                playerTwoHand.add(randCard);
                adventureDeck.remove(randInx);
            }
            else if(i % 4 == 3) {
                playerThreeHand.add(randCard);
                adventureDeck.remove(randInx);
            }
            else {
                playerFourHand.add(randCard);
                adventureDeck.remove(randInx);
            }
        }
    }
}
