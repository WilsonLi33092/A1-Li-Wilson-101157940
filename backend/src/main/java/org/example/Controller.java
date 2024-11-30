package org.example;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081")
public class Controller {

    Decks deck;
    EventCard event = new EventCard();
    QuestCard questCard = new QuestCard();
    Player playerOne = new Player();
    Player playerTwo = new Player();
    Player playerThree = new Player();
    Player playerFour = new Player();
    Player placeholder = new Player();

    public Controller() {
        resetGame();
    }

    @GetMapping("/start")
    public Map<String, Object> startGame() {
        resetGame();
        int currentPlayerTurn = deck.getCurrentPlayerTurn();

        if (currentPlayerTurn == 1) {
            placeholder = playerOne;
        } else if (currentPlayerTurn == 2) {
            placeholder = playerTwo;
        } else if (currentPlayerTurn == 3) {
            placeholder = playerThree;
        } else if (currentPlayerTurn == 4) {
            placeholder = playerFour;
        }

        String eventCard = deck.drawEventCard();
        playerOne.setHand(deck.player1Hand);
        playerTwo.setHand(deck.player2Hand);
        playerThree.setHand(deck.player3Hand);
        playerFour.setHand(deck.player4Hand);

        playerOne.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerTwo.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerThree.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerFour.getHand().sort(Comparator.comparingInt(card -> card.sortValue));

        List<String> playerOneHand = playerOne.getHand().stream()
                .map(card -> card.toString())
                .collect(Collectors.toList());
        List<String> playerTwoHand = playerTwo.getHand().stream()
                .map(card -> card.toString())
                .collect(Collectors.toList());
        List<String> playerThreeHand = playerThree.getHand().stream()
                .map(card -> card.toString())
                .collect(Collectors.toList());
        List<String> playerFourHand = playerFour.getHand().stream()
                .map(card -> card.toString())
                .collect(Collectors.toList());

        System.out.println("Player 1 Hand: " + playerOneHand);
        System.out.println("Player 2 Hand: " + playerTwoHand);
        System.out.println("Player 3 Hand: " + playerThreeHand);
        System.out.println("Player 4 Hand: " + playerFourHand);

        Map<String, Object> response = new HashMap<>();
        response.put("currentTurn", currentPlayerTurn);
        response.put("message", "Game started.");
        response.put("playerOneHand", playerOneHand);
        response.put("playerOneShields", playerOne.getShields());
        response.put("playerTwoHand", playerTwoHand);
        response.put("playerTwoShields", playerTwo.getShields());
        response.put("playerThreeHand", playerThreeHand);
        response.put("playerThreeShields", playerThree.getShields());
        response.put("playerFourHand", playerFourHand);
        response.put("playerFourShields", playerFour.getShields());

        return response;
    }

    @PostMapping("/draw")
    public Map<String, String> drawCard() {
        String newCard = deck.drawEventCard();

        Map<String, String> response = new HashMap<>();
        response.put("card", newCard);
        return response;
    }

    private void resetGame() {
        deck = new Decks();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
    }
}