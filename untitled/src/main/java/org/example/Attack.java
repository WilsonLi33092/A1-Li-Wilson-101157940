package org.example;

import java.util.ArrayList;
import java.util.List;

public class Attack {
    Player player;
    List<Card> attackCards;
    public Attack(Player newPlayer) {
        player = newPlayer;
        attackCards = new ArrayList<>();
    }
    public void addCardToAttack(Card card){

    }
    public List<Card> getAttackCards() {
        return attackCards;
    }
    public boolean containsCard(Card card) {
        return false;
    }
    public int getTotalValue() {
       return 0;
    }
    public Player getPlayer() {
        return null;
    }
    public void clearAttack() {

    }
}
