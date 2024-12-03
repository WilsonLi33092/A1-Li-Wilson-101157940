package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
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
    List<Integer> usedCardIndices = new ArrayList<>();
    ArrayList<Stage> stagesForQuest = new ArrayList<>();
    int previousStageValue = 0;
    Quest quest = new Quest(new ArrayList<>(), null, new ArrayList<>());

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
        playerOne.setNumPlayer(1);
        playerTwo.setNumPlayer(2);
        playerThree.setNumPlayer(3);
        playerFour.setNumPlayer(4);
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
    @PostMapping("startQuest")
    public ResponseEntity<?> startQuest(@RequestBody Map<String, Object> request) {
        int sponsorPlayerIndex = (int) request.get("sponsorPlayerIndex");
        Player sponsorPlayer = playerList.get(sponsorPlayerIndex);
        usedCardIndices.clear();
        stagesForQuest.clear();
        previousStageValue = 0;
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Quest intiated for Player" + (sponsorPlayerIndex + 1));
        response.put("playerHand", sponsorPlayer.getHand().stream().map(Card::toString).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }
    @PostMapping("addStage")
    public ResponseEntity<?> addStage(@RequestBody Map<String, Object> request) {
        Integer sponsorPlayerIndex = (int) request.get("sponsorPlayerIndex");
        List<Integer> selectedIndices = (List<Integer>) request.get("selectedIndices");
        if(sponsorPlayerIndex == null || selectedIndices == null) {
            return ResponseEntity.badRequest().body("Missed fields");
        }
        Player sponsorPlayer = playerList.get(sponsorPlayerIndex);
        int currentStageValue = selectedIndices.stream().map(index -> sponsorPlayer.getHand().get(index).value).reduce(0, Integer::sum);
        if(currentStageValue <= previousStageValue) {
            return ResponseEntity.badRequest().body("Stage value must be greater than previous stage value");
        }
        previousStageValue = currentStageValue;
        usedCardIndices.addAll(selectedIndices);
        List<Card> stageCards = selectedIndices.stream().map(index -> sponsorPlayer.getHand().get(index)).collect(Collectors.toList());
        Stage stage = new Stage(stageCards);
        stagesForQuest.add(stage);
        return ResponseEntity.ok("Stage added");
    }
    @PostMapping("makeQuest")
    public ResponseEntity<?> makeQuest(@RequestBody Map<String, Object> request) {
        int sponsorPlayerIndex = (int) request.get("sponsorPlayerIndex");
        Player sponsorPlayer = playerList.get(sponsorPlayerIndex);

        Quest questPlacholder = new Quest(stagesForQuest, sponsorPlayer, getNonSponsorPlayers(sponsorPlayer));
        quest = questPlacholder;
        System.out.println(quest.getActiveParticipants().get(0).numPlayer);
        System.out.println(quest.getActiveParticipants().get(1).numPlayer);
        System.out.println(quest.getActiveParticipants().get(2).numPlayer);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Quest created successfully!");
        response.put("questStages", stagesForQuest.stream()
                .map(stage -> stage.getCards().stream().map(Card::toString).collect(Collectors.toList()))
                .collect(Collectors.toList()));
        System.out.println(quest);
        System.out.println(quest.getStages());
        for(int i =0;i<quest.getStages().size();i++){
            System.out.println(quest.getStages().get(i).getCards());
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getQuest")
    public ResponseEntity<?> getQuest() {
        System.out.println("It gets to here");
        System.out.println(quest);
        System.out.println(quest.getStages());
        if (quest == null || quest.getStages().isEmpty()) {
            return ResponseEntity.badRequest().body("No active quest found.");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("sponsorPlayer", quest.sponsor != null ? quest.sponsor.toString() : "Unknown");
        response.put("stages", quest.getStages().stream()
                .map(stage -> stage.getCards().stream().map(Card::toString).collect(Collectors.toList()))
                .collect(Collectors.toList()));
        response.put("participants", quest.getActiveParticipants().stream()
                .map(Player::toString)
                .collect(Collectors.toList()));

        return ResponseEntity.ok(response);
    }
    public List<Player> getNonSponsorPlayers(Player sponsorPlayer) {
        return playerList.stream().filter(player -> !player.equals(sponsorPlayer)).collect(Collectors.toList());
    }
    @PostMapping("updateParticipation")
    public String updateParticipation(@RequestBody Map<String, Object> request) {
        System.out.println(request);
        int playerIndex = ((Number) request.get("playerIndex")).intValue();
        int stageIndex = ((Number) request.get("stageIndex")).intValue();
        String decision = (String) request.get("decision");
        Player player = playerList.get(playerIndex);
        quest.promptParticipation(stageIndex,player,decision);
        return "Participation updated for player " + player.numPlayer;
    }
    @PostMapping("/submitAttack")
    public ResponseEntity<String> submitAttack(@RequestBody Map<String, Object> request) {
        int playerIndex = (int) request.get("playerIndex");
        int stageIndex = (int) request.get("stageIndex");
        List<Integer> selectedCardIndices = (List<Integer>) request.get("selectedCardIndices");
        Player player = quest.getActiveParticipants().get(playerIndex);
        Stage currentStage = quest.getStages().get(stageIndex);
        List<Card> playerHand = player.getHand();
        List<Card> selectedCards = new ArrayList<>();

        for (int index : selectedCardIndices) {
            if (index >= 0 && index < playerHand.size()) {
                selectedCards.add(playerHand.get(index));
            }
        }
        Attack attack = new Attack(player);
        for (Card card : selectedCards) {
            attack.addCardToAttack(card);
        }
        List<Attack> attacks = new ArrayList<>();
        attacks.add(attack);
        List<Player> remainingPlayers = quest.getActiveParticipants();
        List<Player> playersRemainingAfterStage = quest.resolveStage(currentStage, attacks, remainingPlayers);
        if (playersRemainingAfterStage.contains(player)) {
            return ResponseEntity.ok("Attack successful! You move on to the next stage.");
        } else {
            return ResponseEntity.ok("Your attack failed. You have been eliminated from this stage.");
        }
    }

}