package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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
    List<Player> playerList = new ArrayList<>(List.of(playerOne,playerTwo,playerThree,playerFour));
    int currentPlayerIndex = 0;
    private List<String> playerDecisions = new ArrayList<>(Collections.nCopies(4, "N"));
    int currentPlayerTurn = 1;
    private final List<String> players = Arrays.asList("Player 1", "Player 2", "Player 3", "Player 4");


    public Controller() {
        resetGame();
    }

    @GetMapping("/start")
    public Map<String, Object> startGame() {
        resetGame();
        int currentPlayerTurn = deck.getCurrentPlayerTurn();

        String eventCard = deck.drawEventCard();
        playerOne.setHand(deck.player1Hand);
        playerTwo.setHand(deck.player2Hand);
        playerThree.setHand(deck.player3Hand);
        playerFour.setHand(deck.player4Hand);

        playerOne.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerTwo.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerThree.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerFour.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerOne.shields = 2;

        Map<String, Object> response = new HashMap<>();
        response.put("currentTurn", currentPlayerTurn);
        response.put("message", "Game started.");
        response.put("playerOneHand", playerOne.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerOneShields", playerOne.getShields());
        response.put("playerTwoHand", playerTwo.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerTwoShields", playerTwo.getShields());
        response.put("playerThreeHand", playerThree.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerThreeShields", playerThree.getShields());
        response.put("playerFourHand", playerFour.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerFourShields", playerFour.getShields());
        System.out.println("Player One Hand: " + playerOne.getHand());
        System.out.println("Player Two Hand: " + playerTwo.getHand());
        System.out.println("Player Three Hand: " + playerThree.getHand());
        System.out.println("Player Four Hand: " + playerFour.getHand());
        System.out.println("Player one shields" + playerOne.getShields());
        return response;
    }

    @PostMapping("/draw")
    public Map<String, String> drawCard() {
        String newCard = deck.drawEventCard();

        Map<String, String> response = new HashMap<>();
        response.put("card", newCard);
        return response;
    }
    @PostMapping("drawProsperity")
    public Map<String, Object> drawPropserity() {
        event.drawProsperity(playerOne.getHand(),playerTwo.getHand(),playerThree.getHand(),playerFour.getHand(),deck.adventureDeck);
        Map<String, Object> response = new HashMap<>();
        playerOne.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerTwo.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerThree.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerFour.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        response.put("playerOneHand", playerOne.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerOneShields", playerOne.getShields());
        response.put("playerTwoHand", playerTwo.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerTwoShields", playerTwo.getShields());
        response.put("playerThreeHand", playerThree.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerThreeShields", playerThree.getShields());
        response.put("playerFourHand", playerFour.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerFourShields", playerFour.getShields());
        return response;

    }
    @PostMapping("drawQueensFavor")
    public Map<String, Object> drawQueensFavor() {
        if(deck.getCurrentPlayerTurn() == 1) {
            event.drawQueensFavorCard(playerOne.getHand(), deck.adventureDeck);
        } else if(deck.getCurrentPlayerTurn() == 2) {
            event.drawQueensFavorCard(playerTwo.getHand(), deck.adventureDeck);
        } else if(deck.getCurrentPlayerTurn() == 3) {
            event.drawQueensFavorCard(playerThree.getHand(), deck.adventureDeck);
        } else {
            event.drawQueensFavorCard(playerFour.getHand(), deck.adventureDeck);
        }
        Map<String, Object> response = new HashMap<>();
        playerOne.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerTwo.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerThree.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerFour.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        response.put("playerOneHand", playerOne.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerOneShields", playerOne.getShields());
        response.put("playerTwoHand", playerTwo.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerTwoShields", playerTwo.getShields());
        response.put("playerThreeHand", playerThree.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerThreeShields", playerThree.getShields());
        response.put("playerFourHand", playerFour.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerFourShields", playerFour.getShields());
        return response;
    }
    @PostMapping("drawPlague")
    public Map<String, Object> drawPlague() {
        if(deck.getCurrentPlayerTurn() == 1) {
            System.out.println(playerOne.getShields());
            playerOne.setShields(event.drawPlagueCard(playerOne.getShields()));
            System.out.println(playerOne.getShields());
        } else if(deck.getCurrentPlayerTurn() == 2) {
            playerTwo.setShields(event.drawPlagueCard(playerTwo.getShields()));
        } else if(deck.getCurrentPlayerTurn() == 3) {
            playerThree.setShields(event.drawPlagueCard(playerThree.getShields()));
        } else {
            playerFour.setShields(event.drawPlagueCard(playerFour.getShields()));
        }
        Map<String, Object> response = new HashMap<>();
        response.put("playerOneHand", playerOne.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerOneShields", playerOne.getShields());
        response.put("playerTwoHand", playerTwo.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerTwoShields", playerTwo.getShields());
        response.put("playerThreeHand", playerThree.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerThreeShields", playerThree.getShields());
        response.put("playerFourHand", playerFour.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        response.put("playerFourShields", playerFour.getShields());
        return response;
    }

    private void resetGame() {
        deck = new Decks();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
    }

}