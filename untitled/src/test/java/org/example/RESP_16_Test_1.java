package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RESP_16_Test_1 {
    @Test
    public void testDiscardAttack() {
        Player sponsor = new Player();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        QuestCard questCard = new QuestCard();
        Card foe1 = new Card();
        Card weapon1 = new Card();
        Card foe2 = new Card();
        Card weapon2 = new Card();
        Card weapon3 = new Card();
        foe1.setType("Foe");
        foe1.setValue(10);
        foe1.setSortValue(2);
        weapon1.setType("Horse");
        weapon1.setValue(10);
        weapon1.setSortValue(13);
        foe2.setType("Foe");
        foe2.setValue(15);
        foe2.setSortValue(3);
        weapon2.setType("Lance");
        weapon2.setValue(20);
        weapon2.setSortValue(15);
        weapon3.setType("Battle-Axe");
        weapon3.setValue(15);
        weapon3.setSortValue(14);
        questCard.setType("Quest");
        questCard.setValue(2);
        sponsor.setNumPlayer(1);
        player1.setNumPlayer(2);
        player2.setNumPlayer(3);
        player3.setNumPlayer(4);
        List<Player> participants = List.of(player1, player2, player3);
        ArrayList<Stage> stages = new ArrayList<>();
        Stage stage1 = new Stage(List.of(foe1, weapon1));
        Stage stage2 = new Stage(List.of(foe2,weapon2));
        stages.add(stage1);
        stages.add(stage2);
        Quest quest = new Quest(stages, sponsor, participants);
        Decks deck = new Decks();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        player1.setHand(deck.player2Hand);
        player2.setHand(deck.player3Hand);
        player3.setHand(deck.player4Hand);
        quest.promptParticipation(1, player1, "continue");
        quest.promptParticipation(1, player2, "continue");
        quest.promptParticipation(1, player3, "continue");
        List<Player> remainingPlayers = quest.getEligibleParticipants(1);
        player1.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        player2.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        player3.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        player1.getHand().set(0,weapon1);
        player1.getHand().set(1, weapon2);
        player1.getHand().set(2, weapon3);
        player2.getHand().set(0,weapon1);
        player2.getHand().set(1,weapon3);
        player3.getHand().set(0,weapon1);
        System.out.println(player1.getHand());
        System.out.println(player2.getHand());
        System.out.println(player3.getHand());
        int player1handsize = 12;
        int player2handsize = 12;
        int player3handsize = 12;
        Attack attack1 = new Attack(player1);
        Attack attack2 = new Attack(player2);
        Attack attack3 = new Attack(player3);
        quest.promptPlayerForAttack(player1,"0", attack1);
        quest.promptPlayerForAttack(player1, "0",attack1);
        quest.promptPlayerForAttack(player2, "0", attack2);
        quest.promptPlayerForAttack(player2, "0", attack2);
        quest.promptPlayerForAttack(player3, "0", attack3);
        System.out.println(player2.getHand().size());
        quest.resolveStage(stage1, List.of(attack1, attack2,attack3), remainingPlayers);
        assertEquals(10, player1.getHand().size());
        assertEquals(10, player2.getHand().size());
        assertEquals(11,player3.getHand().size());
        attack1.clearAttack();
        attack2.clearAttack();
        player1.getHand().set(0,weapon1);
        player1.getHand().set(1, weapon2);
        player1.getHand().set(2, weapon3);
        player2.getHand().set(0,weapon1);
        player2.getHand().set(1,weapon3);
        quest.promptPlayerForAttack(player1,"0", attack1);
        quest.promptPlayerForAttack(player1, "0",attack1);
        quest.promptPlayerForAttack(player1, "0", attack1);
        quest.promptPlayerForAttack(player2, "0", attack2);
        quest.promptPlayerForAttack(player2, "0", attack2);
        quest.resolveStage(stage2, List.of(attack1,attack2), remainingPlayers);
        assertEquals(7, player1.getHand().size());
        assertEquals(8, player2.getHand().size());
    }
}