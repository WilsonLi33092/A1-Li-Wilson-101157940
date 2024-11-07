package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RESP_14_Test_1 {
    @Test
    public void testAttack() {
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
        Stage stage1 = new Stage(List.of(foe1, weapon1));
        stages.add(stage1);
        Quest quest = new Quest(stages, sponsor, participants);
        Decks deck = new Decks();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        player1.setHand(deck.player2Hand);
        player2.setHand(deck.player3Hand);
        player3.setHand(deck.player4Hand);
        player1.getHand().set(0, weapon1);
        player1.getHand().set(1,weapon2);
        player1.getHand().set(2,weapon2);
        quest.promptParticipation(1, player1, "continue");
        quest.promptParticipation(1, player2, "withdraw");
        quest.promptParticipation(1, player3, "withdraw");
        List<Player> remainingPlayers = quest.getEligibleParticipants(1);
        Attack attack = new Attack(player1);
        String chooseCardOne = "0";
        String chooseCardTwo = "1";
        String chooseRepeatedCard = "2";
        String quit = "quit";
        boolean result = quest.promptPlayerForAttack(player1, chooseCardOne, attack);
        assertTrue(result);
        player1.getHand().set(0, weapon1);
        player1.getHand().set(1,weapon2);
        player1.getHand().set(2,weapon2);
        List<Card> attackCards = attack.getAttackCards();
        assertEquals(1, attackCards.size());
        assertEquals("Horse", attackCards.get(0).getCardType());
        result = quest.promptPlayerForAttack(player1, chooseCardTwo, attack);
        assertTrue(result);
        player1.getHand().set(0, weapon1);
        player1.getHand().set(1,weapon2);
        player1.getHand().set(2,weapon2);
        attackCards = attack.getAttackCards();
        assertEquals(2, attackCards.size());
        assertEquals("Lance", attackCards.get(1).getCardType());
        result = quest.promptPlayerForAttack(player1, chooseRepeatedCard, attack);
        assertFalse(result);
        attackCards = attack.getAttackCards();
        assertEquals(2,attackCards.size());
        result = quest.promptPlayerForAttack(player1, quit, attack);
        assertFalse(result);


    }
}