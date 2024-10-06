package org.example;

public class EventCard {
    public int drawPlagueCard(int playerShields) {
        if(playerShields <= 2) {
            return 0;
        }
        else {
            return playerShields-2;
        }
    }
}
