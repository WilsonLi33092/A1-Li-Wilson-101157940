package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RESP_10_Test_1 {
    @Test
    public void testValidQuest() {
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
        assertEquals(20, stage1.getTotalValue(), "Stage 1 value should be 20.");

        Stage stage2 = new Stage(List.of(foe2, weapon2));
        assertEquals(35, stage2.getTotalValue(), "Stage 2 value should be 35.");

        // Building the quest
        Quest quest = new Quest(List.of());  // Empty quest to start
        quest = quest.addStage(stage1);  // Add stage 1
        quest = quest.addStage(stage2);  // Add stage 2

        assertEquals(2, quest.getStages().size(), "The quest should have 2 stages.");
    }
}