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
        return 0;
    }
}
