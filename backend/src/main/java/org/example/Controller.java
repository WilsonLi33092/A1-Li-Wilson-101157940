package org.example;

import org.apache.coyote.Response;
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
    ArrayList<Player> winners = new ArrayList<>();

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
        playerOne.shields = 6;
        playerTwo.shields = 6;
        playerThree.shields = 6;
        playerFour.shields = 6;

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
    @GetMapping("/startRiggedDeck1")
    public Map<String, Object> startGameRiggedDeck1() {
        rigDeck1();
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
        playerOne.shields = 6;
        playerTwo.shields = 6;
        playerThree.shields = 6;
        playerFour.shields = 6;

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
    @PostMapping("/nextPlayerTurn")
    public ResponseEntity<?> nextPlayerTurn() {
        //currentPlayerTurn = (currentPlayerTurn % playerList.size()) + 1;
        deck.currentPlayerTurn =(deck.currentPlayerTurn % 4) + 1;
        return ResponseEntity.ok("Next Player Turn");
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
        //deck.currentPlayerTurn += 1;
        deck.currentPlayerTurn =(deck.currentPlayerTurn % 4) + 1;
        return response;

    }
    @PostMapping("drawQueensFavor")
    public Map<String, Object> drawQueensFavor() {
        System.out.println(deck.getCurrentPlayerTurn()% 4);
        if((deck.getCurrentPlayerTurn()-1) % 4 == 0) {
            event.drawQueensFavorCard(playerOne.getHand(), deck.adventureDeck);
        } else if((deck.getCurrentPlayerTurn()-1) % 4 == 1) {
            event.drawQueensFavorCard(playerTwo.getHand(), deck.adventureDeck);
        } else if((deck.getCurrentPlayerTurn()-1) % 4 == 2) {
            event.drawQueensFavorCard(playerThree.getHand(), deck.adventureDeck);
        } else if((deck.getCurrentPlayerTurn()-1) % 4 == 3){
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
        //deck.currentPlayerTurn += 1;
        deck.currentPlayerTurn =(deck.currentPlayerTurn % 4) + 1;
        return response;
    }
    @PostMapping("drawPlague")
    public Map<String, Object> drawPlague() {
        if((deck.getCurrentPlayerTurn()-1) % 4 == 0) {
            System.out.println(playerOne.getShields());
            playerOne.setShields(event.drawPlagueCard(playerOne.getShields()));
            System.out.println(playerOne.getShields());
        } else if((deck.getCurrentPlayerTurn()-1) % 4 == 1) {
            playerTwo.setShields(event.drawPlagueCard(playerTwo.getShields()));
        } else if((deck.getCurrentPlayerTurn()-1) % 4 == 2) {
            playerThree.setShields(event.drawPlagueCard(playerThree.getShields()));
        } else if((deck.getCurrentPlayerTurn()-1) % 4 == 3){
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
        deck.currentPlayerTurn =(deck.currentPlayerTurn % 4) + 1;
        return response;
    }
    @PostMapping("checkTrim")
    public Map<String, Object> checkTrim() {
        Map<String, Object> response = new HashMap<>();
        if(playerOne.getHand().size() > 12) {
            response.put("playerOne", true);
            int trimAmountOne = playerOne.getHand().size() - 12;
            response.put("playerOneAmount", trimAmountOne);
        }
        if(playerTwo.getHand().size() > 12) {
            response.put("playerTwo", true);
            int trimAmountTwo = playerTwo.getHand().size() - 12;
            response.put("playerTwoAmount", trimAmountTwo);
        }
        if(playerThree.getHand().size() > 12) {
            response.put("playerThree", true);
            int trimAmountThree = playerThree.getHand().size() - 12;
            response.put("playerThreeAmount", trimAmountThree);
        }
        if(playerFour.getHand().size() > 12) {
            response.put("playerFour", true);
            int trimAmountFour = playerFour.getHand().size() - 12;
            response.put("playerFourAmount", trimAmountFour);
        }
        return response;
    }

    private void resetGame() {
        deck = new Decks();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
    }
    private void rigDeck1() {
        deck = new Decks();
        deck.intializeAdventureDeck();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        Card cardFoe5 = new Card();
        cardFoe5.setType("Foe");
        cardFoe5.setValue(5);
        cardFoe5.setSortValue(1);
        Card cardFoe10 = new Card();
        cardFoe10.setValue(10);
        cardFoe10.setType("Foe");
        cardFoe10.setSortValue(2);
        Card cardFoe15 = new Card();
        cardFoe15.setValue(15);
        cardFoe15.setType("Foe");
        cardFoe15.setSortValue(3);
        Card cardFoe20 = new Card();
        cardFoe20.setValue(20);
        cardFoe20.setSortValue(4);
        Card cardFoe25 = new Card();
        cardFoe25.setValue(25);
        cardFoe25.setType("Foe");
        cardFoe25.setSortValue(5);
        Card cardFoe30 = new Card();
        cardFoe30.setValue(30);
        cardFoe30.setType("Foe");
        cardFoe30.setSortValue(6);
        Card cardFoe35 = new Card();
        cardFoe35.setType("Foe");
        cardFoe35.value = 35;
        cardFoe35.sortValue = 7;
        Card cardFoe40 = new Card();
        cardFoe40.setType("Foe");
        cardFoe40.value = 40;
        cardFoe40.sortValue = 8;
        Card cardFoe50 = new Card();
        cardFoe50.setType("Foe");
        cardFoe50.value = 50;
        cardFoe50.sortValue = 9;
        Card cardFoe70 = new Card();
        cardFoe70.setType("Foe");
        cardFoe70.value = 70;
        cardFoe70.sortValue = 10;
        Card cardDagger = new Card();
        cardDagger.type = "Dagger";
        cardDagger.value = 5;
        cardDagger.sortValue = 11;
        Card cardSword = new Card();
        cardSword.type = "Sword";
        cardSword.value = 10;
        cardSword.sortValue = 12;
        Card cardHorse = new Card();
        cardHorse.type = "Horse";
        cardHorse.value = 10;
        cardHorse.sortValue = 13;
        Card cardBattleAxe = new Card();
        cardBattleAxe.type = "Battle-Axe";
        cardBattleAxe.value = 15;
        cardBattleAxe.sortValue = 14;
        Card cardLance = new Card();
        cardLance.type = "Lance";
        cardLance.value = 20;
        cardLance.sortValue = 15;
        Card cardEx = new Card();
        cardEx.type = "Excalibur";
        cardEx.value = 50;
        cardEx.sortValue = 16;
        ArrayList<Card> riggedPlayer1Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer2Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer3Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer4Hand = new ArrayList<>();
        riggedPlayer1Hand.add(cardFoe5);
        riggedPlayer1Hand.add(cardFoe5);
        riggedPlayer1Hand.add(cardFoe10);
        riggedPlayer1Hand.add(cardFoe10);
        riggedPlayer1Hand.add(cardFoe15);
        riggedPlayer1Hand.add(cardFoe15);
        riggedPlayer1Hand.add(cardFoe20);
        riggedPlayer1Hand.add(cardFoe20);
        riggedPlayer1Hand.add(cardDagger);
        riggedPlayer1Hand.add(cardDagger);
        riggedPlayer1Hand.add(cardDagger);
        riggedPlayer1Hand.add(cardDagger);
        playerOne.setHand(riggedPlayer1Hand);
        riggedPlayer2Hand.add(cardFoe25);
        riggedPlayer2Hand.add(cardFoe30);
        riggedPlayer2Hand.add(cardHorse);
        riggedPlayer2Hand.add(cardHorse);
        riggedPlayer2Hand.add(cardSword);
        riggedPlayer2Hand.add(cardSword);
        riggedPlayer2Hand.add(cardSword);
        riggedPlayer2Hand.add(cardBattleAxe);
        riggedPlayer2Hand.add(cardBattleAxe);
        riggedPlayer2Hand.add(cardLance);
        riggedPlayer2Hand.add(cardLance);
        riggedPlayer2Hand.add(cardEx);
        playerTwo.setHand(riggedPlayer2Hand);
        riggedPlayer3Hand.add(cardFoe25);
        riggedPlayer3Hand.add(cardFoe30);
        riggedPlayer3Hand.add(cardHorse);
        riggedPlayer3Hand.add(cardHorse);
        riggedPlayer3Hand.add(cardSword);
        riggedPlayer3Hand.add(cardSword);
        riggedPlayer3Hand.add(cardSword);
        riggedPlayer3Hand.add(cardBattleAxe);
        riggedPlayer3Hand.add(cardBattleAxe);
        riggedPlayer3Hand.add(cardLance);
        riggedPlayer3Hand.add(cardLance);
        riggedPlayer3Hand.add(cardEx);
        playerThree.setHand(riggedPlayer3Hand);
        riggedPlayer4Hand.add(cardFoe25);
        riggedPlayer4Hand.add(cardFoe30);
        riggedPlayer4Hand.add(cardFoe70);
        riggedPlayer4Hand.add(cardHorse);
        riggedPlayer4Hand.add(cardHorse);
        riggedPlayer4Hand.add(cardSword);
        riggedPlayer4Hand.add(cardSword);
        riggedPlayer4Hand.add(cardSword);
        riggedPlayer4Hand.add(cardBattleAxe);
        riggedPlayer4Hand.add(cardBattleAxe);
        riggedPlayer4Hand.add(cardLance);
        riggedPlayer4Hand.add(cardLance);
        playerFour.setHand(riggedPlayer4Hand);
        deck.getAdventureDeck().set(0, cardFoe5);
        deck.getAdventureDeck().set(1,cardFoe10);
        deck.getAdventureDeck().set(2,cardFoe20);
        deck.getAdventureDeck().set(3,cardFoe15);
        deck.getAdventureDeck().set(4,cardFoe5);
        deck.getAdventureDeck().set(5, cardFoe25);
        deck.getAdventureDeck().set(6, cardFoe5);
        deck.getAdventureDeck().set(7,cardFoe10);
        deck.getAdventureDeck().set(8,cardFoe20);
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
    @PostMapping("checkWinners")
    public Map<String, Object> checkWinners(){
        Map<String, Object> response = new HashMap<>();
        if(playerOne.shields >= 7) {
            response.put("playerOne", true);
        } else {
            response.put("playerOne", false);
        }
        if(playerTwo.shields >= 7) {
            response.put("playerTwo", true);
        }else {
            response.put("playerTwo", false);
        }
        if(playerThree.shields >= 7) {
            response.put("playerThree", true);
        } else {
            response.put("playerThree", false);
        }
        if(playerFour.shields >= 7) {
            response.put("playerFour", true);
        } else {
            response.put("playerFour", false);
        }
        return response;
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
    @PostMapping("trimHand")
    public ResponseEntity<?> trimHand(@RequestBody Map<String, Object> request) {
        System.out.println("It gets to here");
        int trimIndex = ((Number) request.get("index")).intValue();
        if("playerOne".equals(request.get("player"))){
            playerOne.getHand().remove(trimIndex);
        }
        if("playerTwo".equals(request.get("player"))){
            playerTwo.getHand().remove(trimIndex);
        }
        if("playerThree".equals(request.get("player"))){
            playerThree.getHand().remove(trimIndex);
        }
        if("playerFour".equals(request.get("player"))){
            playerFour.getHand().remove(trimIndex);
        }
        playerOne.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerTwo.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerThree.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerFour.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        return ResponseEntity.ok("Hand Trimmed");
    }
    @PostMapping("drawAdventureCard")
    public ResponseEntity<?> drawAdventureCard(@RequestBody Map<String, Object> request){
        Card drawnCard = deck.drawCard();
        if("playerOne".equals(request.get("player"))){
            playerOne.hand.add(drawnCard);
        }
        if("playerTwo".equals(request.get("player"))){
            playerTwo.hand.add(drawnCard);
        }
        if("playerThree".equals(request.get("player"))){
            playerThree.hand.add(drawnCard);
        }
        if("playerFour".equals(request.get("player"))){
            playerFour.hand.add(drawnCard);
        }
        playerOne.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerTwo.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerThree.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        playerFour.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
        return ResponseEntity.ok("Card Drawn");
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
    @PostMapping("useStageDraw")
    public ResponseEntity<?> useStageDraw(@RequestBody Map<String, Object> request) {
        int numDraws = (int) request.get("number");
        int sponsorPlayerIndex = (int) request.get("player");
        for(int i= 0; i< numDraws;i++){
            if(sponsorPlayerIndex % 4 == 0){
                Card drawnCard = deck.drawCard();
                playerOne.hand.add(drawnCard);
            }else if (sponsorPlayerIndex % 4== 1) {
                Card drawnCard = deck.drawCard();
                playerTwo.hand.add(drawnCard);
            }else if (sponsorPlayerIndex % 4== 2) {
                Card drawnCard = deck.drawCard();
                playerThree.hand.add(drawnCard);
            }else if(sponsorPlayerIndex % 4== 3){
                Card drawnCard = deck.drawCard();
                playerFour.hand.add(drawnCard);
            }
        }
        return ResponseEntity.ok("Used stage draw");
    }
    @PostMapping("useSponsorIndices")
    public ResponseEntity<?> useSponsorIndices(@RequestBody Map<String, Object> request) {
        int sponsorPlayerIndex = (int) request.get("player");
        List<?> rawIndices = (List<?>) request.get("indices");
        List<Integer> indices = rawIndices.stream()
                .map(index -> ((Number) index).intValue())
                .toList();
        System.out.println("THIS IS THE PLAYER");
        System.out.println(sponsorPlayerIndex);
        for(int index : indices) {
            if(sponsorPlayerIndex % 4 == 0){
                System.out.println("IT IS HERE WOOOOOOOOO");
                playerOne.hand.remove(index);
                Card drawnCard = deck.drawCard();
                playerOne.hand.add(drawnCard);
            }else if (sponsorPlayerIndex % 4== 1) {
                playerTwo.hand.remove(index);
                Card drawnCard = deck.drawCard();
                playerTwo.hand.add(drawnCard);
            }else if (sponsorPlayerIndex % 4== 2) {
                playerThree.hand.remove(index);
                Card drawnCard = deck.drawCard();
                playerThree.hand.add(drawnCard);
            }else if(sponsorPlayerIndex % 4== 3){
                playerFour.hand.remove(index);
                Card drawnCard = deck.drawCard();
                playerFour.hand.add(drawnCard);
            }
        }

        return ResponseEntity.ok("Used sponsor indices");
    }
    @PostMapping("useAttackIndices")
    public ResponseEntity<?> useAttackIndices(@RequestBody Map<String, Object> request) {
        int sponsorPlayerIndex = (int) request.get("player");
        List<?> rawIndices = (List<?>) request.get("indices");
        List<Integer> indices = rawIndices.stream()
                .map(index -> ((Number) index).intValue())
                .toList();
        System.out.println("THIS IS THE PLAYER");
        System.out.println(sponsorPlayerIndex);
        for(int index : indices) {
            if(sponsorPlayerIndex % 4 == 0){
                System.out.println("IT IS HERE WOOOOOOOOO");
                playerOne.hand.remove(index);
            }else if (sponsorPlayerIndex % 4== 1) {
                playerTwo.hand.remove(index);
            }else if (sponsorPlayerIndex % 4== 2) {
                playerThree.hand.remove(index);
            }else if(sponsorPlayerIndex % 4== 3){
                playerFour.hand.remove(index);
            }
        }

        return ResponseEntity.ok("Used sponsor indices");
    }
    @PostMapping("/submitAttack")
    public ResponseEntity<String> submitAttack(@RequestBody Map<String, Object> request) {
        int playerIndex = (int) request.get("playerIndex");
        int stageIndex = (int) request.get("stageIndex");
        placeholder = playerList.get(playerIndex);
        List<Integer> selectedCardIndices = (List<Integer>) request.get("selectedCardIndices");
        if (stageIndex < 0 || stageIndex >= quest.getStages().size()) {
            return ResponseEntity.ok("STAGE INDEX OUT OF BOUNDS");
        }
        List<Player> activeParticipants = quest.getActiveParticipants();
        System.out.println("Active Participants: " + activeParticipants.size());
        for (Player p : activeParticipants) {
            System.out.println("Player: " + p.numPlayer);  // Assuming Player has a getName() method
        }
        //if (playerIndex < 0 || playerIndex >= activeParticipants.size()) {
        //    return ResponseEntity.ok("PLAYER INDEX OUT OF BOUNDS");
        //}
        System.out.println(("Size of quest participants" + quest.getActiveParticipants()));
        Player player = playerList.get(playerIndex);
        Stage currentStage = quest.getStages().get(stageIndex);
        List<Card> playerHand = player.getHand();
        List<Card> selectedCards = new ArrayList<>();

        for (int index : selectedCardIndices) {
            if (index >= 0 && index < playerHand.size()) {
                selectedCards.add(playerHand.get(index));
                System.out.println(selectedCards);
            }
        }
        Attack attack = new Attack(player);
        for (Card card : selectedCards) {
            attack.addCardToAttack(card);
        }
        List<Attack> attacks = new ArrayList<>();
        attacks.add(attack);
        List<Player> remainingPlayers = quest.getActiveParticipants();
        System.out.println(remainingPlayers);
        List<Player> playersRemainingAfterStage = quest.resolveStage(currentStage, attacks, remainingPlayers);
        System.out.println(playersRemainingAfterStage);
        for(Card card: selectedCards){
            player.hand.remove(card);
            System.out.println(player.hand.toString());

        }
        if (playersRemainingAfterStage.contains(player)) {
            return ResponseEntity.ok("Attack successful! You move on to the next stage.");
        } else {
            return ResponseEntity.ok("Your attack failed. You have been eliminated from this stage.");
        }
    }
    @PostMapping("finishQuest")
    public Map<String, Object> finishQuest(){
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

}