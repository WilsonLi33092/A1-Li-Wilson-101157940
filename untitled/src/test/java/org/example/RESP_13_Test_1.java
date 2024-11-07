package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RESP_13_Test_1 {
    @Test
    public void testQuestNoParticipants() {
        Player sponsor = new Player(4);
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Player player3 = new Player(3);
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
        sponsor.setNumPlayer(1);
        player1.setNumPlayer(2);
        player2.setNumPlayer(3);
        player3.setNumPlayer(4);
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
        quest.promptParticipation(1, player1, "withdraw");
        quest.promptParticipation(1, player2, "withdraw");
        quest.promptParticipation(1, player3, "withdraw");
        List<Player> remainingPlayers = quest.getEligibleParticipants(1);
        boolean questEnded = quest.isQuestEnded();
        assertTrue(questEnded);
        assertEquals(0, remainingPlayers.size());

    }
}