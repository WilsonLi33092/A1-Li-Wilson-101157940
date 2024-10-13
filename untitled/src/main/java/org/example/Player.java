package org.example;

import java.util.ArrayList;
import java.util.List;

class Player {
    ArrayList<Card> hand;
    int shields = 0;
    int numPlayer = 0;
    public void setHand(ArrayList<Card> newHand) {
        hand = newHand;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
    public void setShields(int newShields) {
        shields = newShields;
    }
    public int getShields() {
        return shields;
    }
    public int calculateTrimHand(ArrayList<Card> playerHand) {
            return playerHand.size()-12;
    }
    public void deleteCard(int position) {
        hand.remove(position);
    }
    public void setNumPlayer(int newNumPlayer) {
        numPlayer = newNumPlayer;
    }
    public Card trimHand(ArrayList<Card> playerHand, int removeCard) {
        Card removedCard = playerHand.get(removeCard -1);
        System.out.println("You have chosen card " + removedCard.toString() + " to be removed");
        return removedCard;
    }
    public List<Player> checkForWinner(Player playerOne, Player playerTwo, Player playerThree, Player playerFour) {
        return null;
    }
}
