package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RESP_10_Test_1 {
    @Test
    public void testValidQuest() {
        Player sponsor = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
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
        List<Player> participants = List.of(player2, player3, player4);

        ArrayList<Stage> stages = new ArrayList<>();
        Stage stage1 = new Stage(List.of(foe1, weapon1));
        assertEquals(20, stage1.getTotalValue(), "Stage 1 value should be 20.");

        Stage stage2 = new Stage(List.of(foe2, weapon2));
        assertEquals(35, stage2.getTotalValue(), "Stage 2 value should be 35.");
        stages.add(stage1);
        stages.add(stage2);
        Quest quest = new Quest(stages, sponsor, participants);
        quest = quest.addStage(stage1);
        quest = quest.addStage(stage2);

        assertEquals(2, quest.getStages().size(), "The quest should have 2 stages.");
    }
}