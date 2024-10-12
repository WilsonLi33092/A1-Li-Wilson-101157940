package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RESP_12_Test_1 {
    @Test
    public void testParticipantDrawAndTrim() {
        Player sponsor = new Player();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        sponsor.setNumPlayer(1);
        player1.setNumPlayer(2);
        player2.setNumPlayer(3);
        player3.setNumPlayer(4);
        QuestCard questCard = new QuestCard();
        Card foe1 = new Card();
        Card weapon1 = new Card();
        Card foe2 = new Card();
        Card weapon2 = new Card();
        foe1.setType("Foe");
        foe1.setValue(10);
        weapon1.setType("Horse");
        weapon1.setValue(10);
        foe2.setType("Foe");
        foe2.setValue(15);
        weapon2.setType("Lance");
        weapon2.setValue(20);
        questCard.setType("Quest");
        questCard.setValue(2);

        List<Player> participants = List.of(player1, player2, player3);
        ArrayList<Stage> stages = new ArrayList<>();
        Stage stage1 = new Stage(List.of(foe1,weapon1));
        stages.add(stage1);
        Quest quest = new Quest(stages, sponsor, participants);
        Decks deck = new Decks();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        player1.setHand(deck.player2Hand);
        player2.setHand(deck.player3Hand);
        player3.setHand(deck.player4Hand);
        quest.promptParticipation(1, player1, "continue");
        int intialHandSize = player1.getHand().size();
        Card drawnCard = deck.drawCard();
        if(drawnCard != null) {
            player1.getHand().add(drawnCard);
        }
        assertEquals(13,player1.getHand().size());
        Card cardToRemove = player1.trimHand(player1.getHand(),1);
        player1.getHand().remove(cardToRemove);

        assertEquals((intialHandSize), player1.getHand().size());

    }
}