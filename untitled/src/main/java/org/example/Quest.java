package org.example;

import java.util.ArrayList;
import java.util.List;

public class Quest {
    List<Stage> stages;
    Player sponsor;
    List<Player> participants;
    List<Player> withdrawnParticipants;
    public Quest(List<Stage> newStages, Player newSponsor, List<Player> newParticipants){
        stages = newStages;
        sponsor = newSponsor;
        participants = new ArrayList<>(newParticipants);
        withdrawnParticipants = new ArrayList<>();
    }
    public Quest addStage(Stage newStage ){
        List<Stage> newStages = new ArrayList<>(stages);
        newStages.add(newStage);
        return new Quest(newStages, sponsor, participants);
    }
    public List<Stage> getStages() {
        return stages;
    }
    public List<Player> getEligibleParticipants(int stageIndex) {
        return null;
    }
    public void promptParticipation(int stageIndex, Player player, String action) {

    }
    public void withdraw(Player player) {

    }
}
