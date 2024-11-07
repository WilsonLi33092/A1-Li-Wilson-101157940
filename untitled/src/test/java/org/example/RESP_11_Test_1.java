package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class RESP_11_Test_1 {
    @Test
    public void testQuestParticipantWithdraw() {
        Player sponsor = new Player(1);
        Player player1 = new Player(2);
        Player player2 = new Player(3);
        Player player3 = new Player(4);
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
        Stage stage1 = new Stage(List.of(foe1, weapon1));
        Stage stage2 = new Stage(List.of(foe2, weapon2));
        ArrayList<Stage> stages = new ArrayList<>();
        stages.add(stage1);
        stages.add(stage2);
        List<Player> participants = List.of(player1, player2, player3);
        Quest quest = new Quest(stages, sponsor, participants);


        quest.promptParticipation(1, player1, "withdraw");
        quest.promptParticipation(1, player2, "continue");
        quest.promptParticipation(1, player3, "continue");

        List<Player> eligibleForStage2 = quest.getEligibleParticipants(2);
        assertFalse(eligibleForStage2.contains(player1));
        assertTrue(eligibleForStage2.contains(player2));
        assertTrue(eligibleForStage2.contains(player3));


        quest.promptParticipation(2, player2, "withdraw");
        quest.promptParticipation(2, player3, "continue");

        List<Player> eligibleForStage3 = quest.getEligibleParticipants(3);
        assertFalse(eligibleForStage3.contains(player2));
        assertTrue(eligibleForStage3.contains(player3));

    }
}