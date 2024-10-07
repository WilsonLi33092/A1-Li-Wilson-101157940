package org.example;

import java.util.List;

class QuestCard {
    String type;
    int value;
    public void setType(String newType) {
        type = newType;
    }
    public void setValue(int newValue){
        value = newValue;
    }
    public String toString(){
        return type + " " + value;
    }
    public int questCardDrawn(int currentPlayerTurn, List<String> playerDecisions){
        boolean questDeclined = true;
        int startingPlayer = currentPlayerTurn;
        int decisionIndex = 0;

        while (questDeclined && decisionIndex < playerDecisions.size()) {
            String player = Integer.toString(currentPlayerTurn);
            String option = playerDecisions.get(decisionIndex).toUpperCase().trim();
            decisionIndex++;

            if (option.equals("Y")) {
                questDeclined = false;
                System.out.println("Player " + player + " will sponsor the quest.");
                return currentPlayerTurn;
            } else if (option.equals("N")) {
                currentPlayerTurn++;
                if (currentPlayerTurn == 5) {
                    currentPlayerTurn = 1;
                }

                if (currentPlayerTurn == startingPlayer) {
                    currentPlayerTurn++;
                    return currentPlayerTurn;
                }
            }
        }

        return currentPlayerTurn;
    }
}
