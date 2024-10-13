package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RESP_17_Test_1 {
    @Test
    public void checkWinners() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();
        player1.setShields(5);
        player2.setShields(7);
        player3.setShields(6);
        player4.setShields(8);
        List<Player> winners = player1.checkForWinner(player1,player2,player3,player4);
        assertTrue(winners.contains(player2));
        assertTrue(winners.contains(player4));
        assertFalse(winners.contains(player1));
        assertFalse(winners.contains(player3));
        assertEquals(2, winners.size());
    }
}