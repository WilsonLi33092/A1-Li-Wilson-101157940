package org.example;

import java.util.ArrayList;

class Player {
    ArrayList<Card> hand;
    int shields = 0;
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

}