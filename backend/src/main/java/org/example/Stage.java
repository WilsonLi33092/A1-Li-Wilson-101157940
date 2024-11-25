package org.example;

import java.util.List;

public class Stage {
    List<Card> cards;
    public Stage(List<Card> newCards){
        cards = newCards;
    }
    public int getTotalValue() {
        int totalValue = 0;
        for (int i=0;i<cards.size();i++){
            totalValue+=cards.get(i).getCardValue();
        }
        return totalValue;
    }
    public List<Card> getCards() {
        return cards;
    }

}
