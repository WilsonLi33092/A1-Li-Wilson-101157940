package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RESP_3_Test_1 {
        private final ByteArrayOutputStream outputStreamCap = new ByteArrayOutputStream();
        private PrintStream oringinalOutput;
        @BeforeEach
        public void setUp(){
            oringinalOutput = System.out;
            System.setOut(new PrintStream(outputStreamCap));
        }
        @Test
        public void testEventDisplay() {
            MessagePrinter printer = new MessagePrinter();
            Main game = new Main();
            printer.printMessage(game.drawEventCard());

            String output = outputStreamCap.toString().trim();
            List<String> validOutputs = Arrays.asList("Quest 2", "Quest 3", "Quest 4", "Quest 5", "Plague", "Queen's favor", "Prosperity");
            assertTrue(validOutputs.contains(output), "Output did not match valid outputs");
        }
        @AfterEach
        public void tearDown() {
            System.setOut(oringinalOutput);
        }

    @Test
    void testEventDraw() {
        Main game = new Main();
        game.intializeEventDeck();
        game.intializeAdventureDeck();
        game.dealPlayersHands();
        game.drawEventCard();
        int deckSize = game.getEventDeckSize();
        assertEquals(16, deckSize);

    }
}