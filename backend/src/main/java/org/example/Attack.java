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
        attackCards.add(card);
    }
    public List<Card> getAttackCards() {
        return attackCards;
    }
    public boolean containsCard(Card card) {
        return attackCards.contains(card);
    }
    public int getTotalValue() {
       int totalValue = 0;
       for(Card card : attackCards) {
           totalValue += card.getCardValue();
       }
       return totalValue;
    }

    public Player getPlayer() {
        return player;
    }
    public void clearAttack() {
        attackCards.clear();
    }
}
