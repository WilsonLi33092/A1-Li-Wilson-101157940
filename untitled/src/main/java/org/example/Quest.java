package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quest {
    ArrayList<Stage> stages;
    Player sponsor;
    List<Player> participants;
    List<Player> withdrawnParticipants;
    boolean questEnded;
    public Quest(ArrayList<Stage> newStages, Player newSponsor, List<Player> newParticipants){
        stages = newStages;
        sponsor = newSponsor;
        participants = new ArrayList<>(newParticipants);
        withdrawnParticipants = new ArrayList<>();
    }
    public Quest addStage(Stage newStage ){
        stages.add(newStage);
        return new Quest(stages, sponsor, participants);
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
        if(withdrawnParticipants.size() == 3) {
            questEnded = true;
        }
    }
    public void withdraw(Player player) {
        if(!withdrawnParticipants.contains(player)) {
            withdrawnParticipants.add(player);
        }
    }
    public boolean isQuestEnded() {
        return questEnded;
    }
    public boolean promptPlayerForAttack(Player player, String action, Attack attack) {
        if(action.equalsIgnoreCase("quit")){
            if(attack.getAttackCards().size() > 0) {
                displayAttackCards(attack);
                return false;
            }
            else {
                return true;
            }
        }
        else {
            int index = Integer.parseInt(action);
            if (index >= 0 && index < player.getHand().size()) {
                Card selectedCard = player.getHand().get(index);
                if (isValidWeaponCard(selectedCard, attack)) {
                    attack.addCardToAttack(selectedCard);
                    player.getHand().remove(selectedCard);
                    System.out.println("Card " + selectedCard.getCardType() + " with a value of " + selectedCard.getCardValue() + " added to the attack");
                } else {
                    System.out.println("Invalid card selection. Repeated weapon card");
                    return false;
                }
            } else {
                System.out.println("Invalid card selection");
            }
            return true;
        }
    }
    public boolean isValidWeaponCard(Card newCard, Attack attack) {
        List<String> validWeapons = Arrays.asList("Dagger", "Horse", "Sword", "Battle-Axe", "Lance", "Excalibur");
        if(validWeapons.contains(newCard.getCardType())){
            for(Card card : attack.getAttackCards()) {
                if(card.equals(newCard)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public void displayAttackCards(Attack attack) {
        List<Card> attackCards = attack.getAttackCards();
        for(Card card: attackCards) {
            System.out.println(card.getCardType() + " with a value of " + card.getCardValue() + " is the attack card");
        }
    }
    public void resolveStage(Stage stage, List<Attack> attacks, List<Player> remainingPlayers) {

    }

}
