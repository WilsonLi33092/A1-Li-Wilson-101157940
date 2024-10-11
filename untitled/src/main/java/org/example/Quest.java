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
        List<Player> eligibleParticipants = new ArrayList<>();
        for(Player player : participants) {
            if(!player.equals(sponsor) && !withdrawnParticipants.contains(player)) {
                eligibleParticipants.add(player);
            }
        }
        return eligibleParticipants;
    }
    public void promptParticipation(int stageIndex, Player player, String action) {
        if (action.equalsIgnoreCase("withdraw")) {
            withdraw(player);
            System.out.println(player.numPlayer + " has withdrawn from the quest.");
        } else {
            System.out.println(player.numPlayer + " is continuing to tackle the current stage.");
        }
    }
    public void withdraw(Player player) {
        if(!withdrawnParticipants.contains(player)) {
            withdrawnParticipants.add(player);
        }
    }
    public boolean isQuestEnded() {
        return false;
    }

}
