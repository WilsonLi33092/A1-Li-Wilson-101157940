package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RESP_15_Test_1 {
    @Test
    public void testAttackOnStageLessThan() {
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
        weapon1.setType("Horse");
        weapon1.setValue(10);
        foe2.setType("Foe");
        foe2.setValue(15);
        weapon2.setType("Lance");
        weapon2.setValue(20);
        weapon3.setType("Battle-Axe");
        weapon3.setValue(15);
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
        Attack attack1 = new Attack(player1);
        attack1.addCardToAttack(weapon1);
        attack1.addCardToAttack(weapon2);
        Attack attack2 = new Attack(player2);
        attack2.addCardToAttack(weapon1);
        attack2.addCardToAttack(weapon3);
        Attack attack3 = new Attack(player3);
        attack3.addCardToAttack(weapon1);
        List<Player> newRemainingPlayers = quest.resolveStage(stage1, List.of(attack1, attack2,attack3), remainingPlayers);
        assertTrue(newRemainingPlayers.contains(player1));
        assertTrue(newRemainingPlayers.contains(player2));
        assertFalse(newRemainingPlayers.contains(player3));
        attack1.clearAttack();
        attack2.clearAttack();
        attack1.addCardToAttack(weapon1);
        attack1.addCardToAttack(weapon2);
        attack1.addCardToAttack(weapon3);
        attack2.addCardToAttack(weapon1);
        attack2.addCardToAttack(weapon3);
        newRemainingPlayers = quest.resolveStage(stage2, List.of(attack1,attack2), remainingPlayers);
        assertTrue(newRemainingPlayers.contains(player1));
        assertFalse(newRemainingPlayers.contains(player2));
        assertEquals(2, (player1.getShields()));

    }
}