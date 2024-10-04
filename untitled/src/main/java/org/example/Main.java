package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main game = new Main();
        game.intializeAdventureDeck();
        game.intializeEventDeck();
    }
    class Card {
        String type;
        int value;
        int sortValue;
        public String getCardType(){
            return type;
        }
        public int getCardValue() {
            return value;
        }
        public int getSortValue() {
            return sortValue;
        }
        public String toString() {
            return type + " " + value + " " + sortValue;
        }
        public void setType(String newType){
            type = newType;
        }
        public void setValue(int newValue){
            value = newValue;
        }
        public void setSortValue(int newSortValue){
            sortValue = newSortValue;
        }
    }
    class QuestCard {
        String type;
        int value;
        public void setType(String newType) {
            type = newType;
        }
        public void setValue(int newValue){
            value = newValue;
        }
        public String toString(){
            return type + " " + value;
        }
    }
    ArrayList<Card> adventureDeck = new ArrayList<Card>();
    ArrayList<Object> eventDeck = new ArrayList<Object>();
    public void intializeAdventureDeck() {
        adventureDeck = new ArrayList<Card>();

        for (int i =0; i< 8;i++){
            Card card = new Card();
            card.setType("Foe");
            card.setValue(5);
            card.setSortValue(1);
            adventureDeck.add(card);
        }
        for (int i =0; i< 7;i++){
            Card card = new Card();
            card.setType("Foe");
            card.setValue(10);
            card.setSortValue(2);
            adventureDeck.add(card);
        }
        for (int i =0; i< 8;i++){
            Card card = new Card();
            card.setType("Foe");
            card.value = 15;
            card.sortValue = 3;
            adventureDeck.add(card);
        }
        for (int i =0; i< 7;i++){
            Card card = new Card();
            card.setType("Foe");
            card.value = 20;
            card.sortValue = 4;
            adventureDeck.add(card);
        }
        for (int i =0; i< 7;i++){
            Card card = new Card();
            card.setType("Foe");
            card.value = 25;
            card.sortValue = 5;
            adventureDeck.add(card);
        }
        for (int i =0; i< 4;i++){
            Card card = new Card();
            card.setType("Foe");
            card.value = 30;
            card.sortValue = 6;
            adventureDeck.add(card);
        }
        for (int i =0; i< 4;i++){
            Card card = new Card();
            card.setType("Foe");
            card.value = 35;
            card.sortValue = 7;
            adventureDeck.add(card);
        }
        for (int i =0; i< 2;i++){
            Card card = new Card();
            card.setType("Foe");
            card.value = 40;
            card.sortValue = 8;
            adventureDeck.add(card);
        }
        for (int i =0; i< 2;i++){
            Card card = new Card();
            card.setType("Foe");
            card.value = 50;
            card.sortValue = 9;
            adventureDeck.add(card);
        }
        Card cardBigFoe = new Card();
        cardBigFoe.setType("Foe");
        cardBigFoe.value = 70;
        cardBigFoe.sortValue = 10;
        adventureDeck.add(cardBigFoe);
        for (int i =0; i< 6;i++){
            Card card = new Card();
            card.type = "Dagger";
            card.value = 5;
            card.sortValue = 11;
            adventureDeck.add(card);
        }
        for (int i =0; i< 16;i++){
            Card card = new Card();
            card.type = "Sword";
            card.value = 10;
            card.sortValue = 12;
            adventureDeck.add(card);
        }
        for (int i =0; i< 12;i++){
            Card card = new Card();
            card.type = "Horse";
            card.sortValue = 13;
            adventureDeck.add(card);
        }
        for (int i =0; i< 8;i++){
            Card card = new Card();
            card.type = "Battle-Axe";
            card.value = 15;
            card.sortValue = 14;
            adventureDeck.add(card);
        }
        for (int i =0; i< 6;i++){
            Card card = new Card();
            card.type = "Lance";
            card.value = 20;
            card.sortValue = 15;
            adventureDeck.add(card);
        }
        for (int i =0; i< 2;i++){
            Card card = new Card();
            card.type = "Excalibur";
            card.value = 50;
            card.sortValue = 16;
            adventureDeck.add(card);
        }
    }
    public void intializeEventDeck() {
        eventDeck = new ArrayList<Object>();
        for(int i=0;i<3;i++){
            QuestCard quest = new QuestCard();
            quest.type = "Quest";
            quest.value = 2;
            eventDeck.add(quest);
        }
        for(int i=0;i<4;i++){
            QuestCard quest = new QuestCard();
            quest.type = "Quest";
            quest.value = 3;
            eventDeck.add(quest);
        }
        for(int i=0;i<3;i++){
            QuestCard quest = new QuestCard();
            quest.type = "Quest";
            quest.value = 4;
            eventDeck.add(quest);
        }
        for(int i=0;i<2;i++){
            QuestCard quest = new QuestCard();
            quest.type = "Quest";
            quest.value = 5;
            eventDeck.add(quest);
        }
        eventDeck.add("Plague");
        eventDeck.add("Queen's favor");
        eventDeck.add("Queen's favor");
        eventDeck.add("Prosperity");
        eventDeck.add("Prosperity");

    }
    public int getAdventureDeckSize() {
        return adventureDeck.size();
    }
    public int getEventDeckSize() {
        return eventDeck.size();
    }
}