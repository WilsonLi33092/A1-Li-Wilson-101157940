import io.cucumber.java.en.*;
import org.example.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class gamestep {
    private Decks deck;
    EventCard event = new EventCard();
    QuestCard questCard = new QuestCard();
    Player playerOne = new Player(1);
    Player playerTwo = new Player(2);
    Player playerThree = new Player(3);
    Player playerFour = new Player(4);
    Player placeholder = new Player(0);
    Quest quest;
    Attack playerOneAttack = new Attack(playerOne);
    Attack playerTwoAttack = new Attack(playerTwo);
    Attack playerThreeAttack = new Attack(playerThree);
    Attack playerFourAttack = new Attack(playerFour);
    List<Player> allPlayers = List.of(playerOne, playerTwo, playerThree, playerFour);
    @Given("A new game has started")
    public void a_new_game_has_started() {
        deck = new Decks();
        deck.intializeAdventureDeck();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        Card foe1Player1 = new Card();
        Card foe2Player1 = new Card();
        Card weapon1Player1 = new Card();
        Card weapon2Player1 = new Card();
        Card weapon3Player1 = new Card();
        Card weapon4Player1 = new Card();
        Card weapon5Player1 = new Card();
        foe1Player1.setType("Foe");
        foe1Player1.setValue(5);
        foe1Player1.setSortValue(1);
        foe2Player1.setType("Foe");
        foe2Player1.setValue(15);
        foe2Player1.setSortValue(3);
        weapon1Player1.setType("Dagger");
        weapon1Player1.setValue(5);
        weapon1Player1.setSortValue(11);
        weapon2Player1.setType("Sword");
        weapon2Player1.setValue(10);
        weapon2Player1.setSortValue(12);
        weapon3Player1.setType("Horse");
        weapon3Player1.setValue(10);
        weapon3Player1.setSortValue(13);
        weapon4Player1.setType("Battle-Axe");
        weapon4Player1.setValue(15);
        weapon4Player1.setSortValue(14);
        weapon5Player1.setType("Lance");
        weapon5Player1.setValue(20);
        weapon5Player1.setSortValue(15);
        Card foe3Player2 = new Card();
        Card weapon5Player2 = new Card();
        foe3Player2.setType("Foe");
        foe3Player2.setValue(40);
        foe3Player2.setSortValue(8);
        weapon5Player2.setType("Excalibur");
        weapon5Player2.setValue(50);
        weapon5Player2.setSortValue(16);
        ArrayList<Card> riggedPlayer1Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer2Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer3Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer4Hand = new ArrayList<>();
        riggedPlayer1Hand.add(foe1Player1);
        riggedPlayer1Hand.add(foe1Player1);
        riggedPlayer1Hand.add(foe2Player1);
        riggedPlayer1Hand.add(foe2Player1);
        riggedPlayer1Hand.add(weapon1Player1);
        riggedPlayer1Hand.add(weapon2Player1);
        riggedPlayer1Hand.add(weapon2Player1);
        riggedPlayer1Hand.add(weapon3Player1);
        riggedPlayer1Hand.add(weapon3Player1);
        riggedPlayer1Hand.add(weapon4Player1);
        riggedPlayer1Hand.add(weapon4Player1);
        riggedPlayer1Hand.add(weapon5Player1);
        playerOne.setHand(riggedPlayer1Hand);
        riggedPlayer2Hand.add(foe1Player1);
        riggedPlayer2Hand.add(foe1Player1);
        riggedPlayer2Hand.add(foe2Player1);
        riggedPlayer2Hand.add(foe2Player1);
        riggedPlayer2Hand.add(foe3Player2);
        riggedPlayer2Hand.add(weapon1Player1);
        riggedPlayer2Hand.add(weapon2Player1);
        riggedPlayer2Hand.add(weapon3Player1);
        riggedPlayer2Hand.add(weapon3Player1);
        riggedPlayer2Hand.add(weapon4Player1);
        riggedPlayer2Hand.add(weapon4Player1);
        riggedPlayer2Hand.add(weapon5Player2);
        playerTwo.setHand(riggedPlayer2Hand);
        riggedPlayer3Hand.add(foe1Player1);
        riggedPlayer3Hand.add(foe1Player1);
        riggedPlayer3Hand.add(foe1Player1);
        riggedPlayer3Hand.add(foe2Player1);
        riggedPlayer3Hand.add(weapon1Player1);
        riggedPlayer3Hand.add(weapon2Player1);
        riggedPlayer3Hand.add(weapon2Player1);
        riggedPlayer3Hand.add(weapon2Player1);
        riggedPlayer3Hand.add(weapon3Player1);
        riggedPlayer3Hand.add(weapon3Player1);
        riggedPlayer3Hand.add(weapon4Player1);
        riggedPlayer3Hand.add(weapon5Player1);
        playerThree.setHand(riggedPlayer3Hand);
        riggedPlayer4Hand.add(foe1Player1);
        riggedPlayer4Hand.add(foe2Player1);
        riggedPlayer4Hand.add(foe2Player1);
        riggedPlayer4Hand.add(foe3Player2);
        riggedPlayer4Hand.add(weapon1Player1);
        riggedPlayer4Hand.add(weapon1Player1);
        riggedPlayer4Hand.add(weapon2Player1);
        riggedPlayer4Hand.add(weapon3Player1);
        riggedPlayer4Hand.add(weapon3Player1);
        riggedPlayer4Hand.add(weapon4Player1);
        riggedPlayer4Hand.add(weapon5Player1);
        riggedPlayer4Hand.add(weapon5Player2);
        playerFour.setHand(riggedPlayer4Hand);
    }
    @Given("A rigged deck for 1 winner quest has started")
    public void a_rigged_deck_for_1_winner_quest_has_started() {
        deck = new Decks();
        deck.intializeAdventureDeck();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        Card foe1Player1 = new Card();
        Card foe2Player1 = new Card();
        Card weapon1Player1 = new Card();
        Card weapon2Player1 = new Card();
        Card weapon3Player1 = new Card();
        Card weapon4Player1 = new Card();
        Card weapon5Player1 = new Card();
        foe1Player1.setType("Foe");
        foe1Player1.setValue(5);
        foe1Player1.setSortValue(1);
        foe2Player1.setType("Foe");
        foe2Player1.setValue(15);
        foe2Player1.setSortValue(3);
        weapon1Player1.setType("Dagger");
        weapon1Player1.setValue(5);
        weapon1Player1.setSortValue(11);
        weapon2Player1.setType("Sword");
        weapon2Player1.setValue(10);
        weapon2Player1.setSortValue(12);
        weapon3Player1.setType("Horse");
        weapon3Player1.setValue(10);
        weapon3Player1.setSortValue(13);
        weapon4Player1.setType("Battle-Axe");
        weapon4Player1.setValue(15);
        weapon4Player1.setSortValue(14);
        weapon5Player1.setType("Lance");
        weapon5Player1.setValue(20);
        weapon5Player1.setSortValue(15);
        Card foe3Player2 = new Card();
        Card weapon5Player2 = new Card();
        foe3Player2.setType("Foe");
        foe3Player2.setValue(40);
        foe3Player2.setSortValue(8);
        weapon5Player2.setType("Excalibur");
        weapon5Player2.setValue(50);
        weapon5Player2.setSortValue(16);
        ArrayList<Card> riggedPlayer1Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer2Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer3Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer4Hand = new ArrayList<>();
        riggedPlayer1Hand.add(foe1Player1);
        riggedPlayer1Hand.add(foe1Player1);
        riggedPlayer1Hand.add(foe2Player1);
        riggedPlayer1Hand.add(foe2Player1);
        riggedPlayer1Hand.add(weapon1Player1);
        riggedPlayer1Hand.add(weapon2Player1);
        riggedPlayer1Hand.add(weapon2Player1);
        riggedPlayer1Hand.add(weapon3Player1);
        riggedPlayer1Hand.add(weapon3Player1);
        riggedPlayer1Hand.add(weapon4Player1);
        riggedPlayer1Hand.add(weapon4Player1);
        riggedPlayer1Hand.add(weapon5Player1);
        playerOne.setHand(riggedPlayer1Hand);
        riggedPlayer2Hand.add(foe1Player1);
        riggedPlayer2Hand.add(foe1Player1);
        riggedPlayer2Hand.add(foe2Player1);
        riggedPlayer2Hand.add(foe2Player1);
        riggedPlayer2Hand.add(foe3Player2);
        riggedPlayer2Hand.add(weapon1Player1);
        riggedPlayer2Hand.add(weapon2Player1);
        riggedPlayer2Hand.add(weapon3Player1);
        riggedPlayer2Hand.add(weapon3Player1);
        riggedPlayer2Hand.add(weapon4Player1);
        riggedPlayer2Hand.add(weapon4Player1);
        riggedPlayer2Hand.add(weapon5Player2);
        playerTwo.setHand(riggedPlayer2Hand);
        riggedPlayer3Hand.add(foe1Player1);
        riggedPlayer3Hand.add(foe1Player1);
        riggedPlayer3Hand.add(foe1Player1);
        riggedPlayer3Hand.add(foe2Player1);
        riggedPlayer3Hand.add(weapon1Player1);
        riggedPlayer3Hand.add(weapon2Player1);
        riggedPlayer3Hand.add(weapon2Player1);
        riggedPlayer3Hand.add(weapon2Player1);
        riggedPlayer3Hand.add(weapon3Player1);
        riggedPlayer3Hand.add(weapon3Player1);
        riggedPlayer3Hand.add(weapon4Player1);
        riggedPlayer3Hand.add(weapon5Player1);
        playerThree.setHand(riggedPlayer3Hand);
        riggedPlayer4Hand.add(foe1Player1);
        riggedPlayer4Hand.add(foe2Player1);
        riggedPlayer4Hand.add(foe2Player1);
        riggedPlayer4Hand.add(foe3Player2);
        riggedPlayer4Hand.add(weapon1Player1);
        riggedPlayer4Hand.add(weapon1Player1);
        riggedPlayer4Hand.add(weapon2Player1);
        riggedPlayer4Hand.add(weapon3Player1);
        riggedPlayer4Hand.add(weapon3Player1);
        riggedPlayer4Hand.add(weapon4Player1);
        riggedPlayer4Hand.add(weapon5Player1);
        riggedPlayer4Hand.add(weapon5Player2);
        playerFour.setHand(riggedPlayer4Hand);
        deck.getAdventureDeck().set(0, weapon5Player1);
        deck.getAdventureDeck().set(1,weapon5Player1);
        deck.getAdventureDeck().set(2,weapon5Player1);
        deck.getAdventureDeck().set(3,weapon4Player1);
        deck.getAdventureDeck().set(4,weapon4Player1);
        deck.getAdventureDeck().set(5, weapon3Player1);
        deck.getAdventureDeck().set(6, weapon3Player1);
        deck.getAdventureDeck().set(7,weapon3Player1);
        deck.getAdventureDeck().set(8,weapon3Player1);
        deck.getAdventureDeck().set(9,weapon3Player1);
        deck.getAdventureDeck().set(10,weapon3Player1);
        deck.getAdventureDeck().set(11,weapon2Player1);
        deck.getAdventureDeck().set(12,foe1Player1);
        deck.getAdventureDeck().set(13,foe1Player1);
        deck.getAdventureDeck().set(14,foe2Player1);
        deck.getAdventureDeck().set(15,foe2Player1);
        deck.getAdventureDeck().set(16,weapon1Player1);
        deck.getAdventureDeck().set(17,weapon1Player1);
        deck.getAdventureDeck().set(18,weapon1Player1);
        deck.getAdventureDeck().set(19,weapon2Player1);
        deck.getAdventureDeck().set(20,weapon2Player1);
        deck.getAdventureDeck().set(21,weapon2Player1);
        deck.getAdventureDeck().set(22,weapon2Player1);
        deck.getAdventureDeck().set(23,weapon2Player1);
        deck.getAdventureDeck().set(24,weapon1Player1);
        deck.getAdventureDeck().set(25,weapon1Player1);
        deck.getAdventureDeck().set(26, foe1Player1);
        deck.getAdventureDeck().set(27, foe1Player1);
        deck.getAdventureDeck().set(28, foe1Player1);
        deck.getAdventureDeck().set(29, foe2Player1);
        deck.getAdventureDeck().set(30, foe2Player1);
        deck.getAdventureDeck().set(31, foe1Player1);
        deck.getAdventureDeck().set(32, foe1Player1);
        deck.getAdventureDeck().set(33,foe1Player1);
        deck.getAdventureDeck().set(34, weapon1Player1);
        deck.getAdventureDeck().set(35, weapon1Player1);
        deck.getAdventureDeck().set(36, weapon1Player1);
    }
    @Given("A rigged deck for A1 scenario has started")
    public void a_rigged_deck_for_A1_scenario_has_started() {
        deck = new Decks();
        deck.intializeAdventureDeck();
        deck.intializeEventDeck();
        deck.intializeAdventureDeck();
        deck.dealPlayersHands();
        Card foe1Player1 = new Card();
        Card foe2Player1 = new Card();
        Card weapon1Player1 = new Card();
        Card weapon2Player1 = new Card();
        Card weapon3Player1 = new Card();
        Card weapon4Player1 = new Card();
        Card weapon5Player1 = new Card();
        foe1Player1.setType("Foe");
        foe1Player1.setValue(5);
        foe1Player1.setSortValue(1);
        foe2Player1.setType("Foe");
        foe2Player1.setValue(15);
        foe2Player1.setSortValue(3);
        weapon1Player1.setType("Dagger");
        weapon1Player1.setValue(5);
        weapon1Player1.setSortValue(11);
        weapon2Player1.setType("Sword");
        weapon2Player1.setValue(10);
        weapon2Player1.setSortValue(12);
        weapon3Player1.setType("Horse");
        weapon3Player1.setValue(10);
        weapon3Player1.setSortValue(13);
        weapon4Player1.setType("Battle-Axe");
        weapon4Player1.setValue(15);
        weapon4Player1.setSortValue(14);
        weapon5Player1.setType("Lance");
        weapon5Player1.setValue(20);
        weapon5Player1.setSortValue(15);
        Card foe3Player2 = new Card();
        Card weapon5Player2 = new Card();
        foe3Player2.setType("Foe");
        foe3Player2.setValue(40);
        foe3Player2.setSortValue(8);
        weapon5Player2.setType("Excalibur");
        weapon5Player2.setValue(50);
        weapon5Player2.setSortValue(16);
        ArrayList<Card> riggedPlayer1Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer2Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer3Hand = new ArrayList<>();
        ArrayList<Card> riggedPlayer4Hand = new ArrayList<>();
        riggedPlayer1Hand.add(foe1Player1);
        riggedPlayer1Hand.add(foe1Player1);
        riggedPlayer1Hand.add(foe2Player1);
        riggedPlayer1Hand.add(foe2Player1);
        riggedPlayer1Hand.add(weapon1Player1);
        riggedPlayer1Hand.add(weapon2Player1);
        riggedPlayer1Hand.add(weapon2Player1);
        riggedPlayer1Hand.add(weapon3Player1);
        riggedPlayer1Hand.add(weapon3Player1);
        riggedPlayer1Hand.add(weapon4Player1);
        riggedPlayer1Hand.add(weapon4Player1);
        riggedPlayer1Hand.add(weapon5Player1);
        playerOne.setHand(riggedPlayer1Hand);
        riggedPlayer2Hand.add(foe1Player1);
        riggedPlayer2Hand.add(foe1Player1);
        riggedPlayer2Hand.add(foe2Player1);
        riggedPlayer2Hand.add(foe2Player1);
        riggedPlayer2Hand.add(foe3Player2);
        riggedPlayer2Hand.add(weapon1Player1);
        riggedPlayer2Hand.add(weapon2Player1);
        riggedPlayer2Hand.add(weapon3Player1);
        riggedPlayer2Hand.add(weapon3Player1);
        riggedPlayer2Hand.add(weapon4Player1);
        riggedPlayer2Hand.add(weapon4Player1);
        riggedPlayer2Hand.add(weapon5Player2);
        playerTwo.setHand(riggedPlayer2Hand);
        riggedPlayer3Hand.add(foe1Player1);
        riggedPlayer3Hand.add(foe1Player1);
        riggedPlayer3Hand.add(foe1Player1);
        riggedPlayer3Hand.add(foe2Player1);
        riggedPlayer3Hand.add(weapon1Player1);
        riggedPlayer3Hand.add(weapon2Player1);
        riggedPlayer3Hand.add(weapon2Player1);
        riggedPlayer3Hand.add(weapon2Player1);
        riggedPlayer3Hand.add(weapon3Player1);
        riggedPlayer3Hand.add(weapon3Player1);
        riggedPlayer3Hand.add(weapon4Player1);
        riggedPlayer3Hand.add(weapon5Player1);
        playerThree.setHand(riggedPlayer3Hand);
        riggedPlayer4Hand.add(foe1Player1);
        riggedPlayer4Hand.add(foe2Player1);
        riggedPlayer4Hand.add(foe2Player1);
        riggedPlayer4Hand.add(foe3Player2);
        riggedPlayer4Hand.add(weapon1Player1);
        riggedPlayer4Hand.add(weapon1Player1);
        riggedPlayer4Hand.add(weapon2Player1);
        riggedPlayer4Hand.add(weapon3Player1);
        riggedPlayer4Hand.add(weapon3Player1);
        riggedPlayer4Hand.add(weapon4Player1);
        riggedPlayer4Hand.add(weapon5Player1);
        riggedPlayer4Hand.add(weapon5Player2);
        playerFour.setHand(riggedPlayer4Hand);
        Card player1DrawCardStage1 = deck.getAdventureDeck().get(0);
        player1DrawCardStage1.setType("Foe");
        player1DrawCardStage1.setValue(30);
        player1DrawCardStage1.setSortValue(6);
        Card player1DrawCardStage2 = deck.getAdventureDeck().get(0);
        player1DrawCardStage2.setType("Foe");
        player1DrawCardStage2.setValue(10);
        player1DrawCardStage2.setSortValue(2);
        deck.getAdventureDeck().set(0, player1DrawCardStage1);
        deck.getAdventureDeck().set(1,weapon2Player1);
        deck.getAdventureDeck().set(2,weapon4Player1);
        deck.getAdventureDeck().set(3,player1DrawCardStage2);
        deck.getAdventureDeck().set(4,weapon5Player1);
        deck.getAdventureDeck().set(5, weapon5Player1);
        deck.getAdventureDeck().set(6, weapon4Player1);
        deck.getAdventureDeck().set(7,weapon2Player1);
        deck.getAdventureDeck().set(8,player1DrawCardStage1);
        deck.getAdventureDeck().set(9,weapon5Player1);
    }

    @When("Player {int} has drawn a {int} stage quest and says {string}")
    public void player_has_drawn_a_stage_quest_and_says(Integer int1, Integer int2, String choice) {
        Player placeholder = new Player(0);
        int intialEventDeckSize = deck.getEventDeckSize();
        if(int2 == 2) {
            deck.getEventDeck().set(0, "Quest 2");
            deck.drawEventCard();
            assertEquals(intialEventDeckSize-1, deck.getEventDeckSize());
        }
        if(int2 == 3) {
            deck.getEventDeck().set(0, "Quest 3");
            deck.drawEventCard();
            assertEquals(intialEventDeckSize-1, deck.getEventDeckSize());
        }
        if(int2 == 4) {
            deck.getEventDeck().set(0, "Quest 4");
            deck.drawEventCard();
            assertEquals(intialEventDeckSize-1, deck.getEventDeckSize());
        }
        if(int2 == 5) {
            deck.getEventDeck().set(0, "Quest 5");
            deck.drawEventCard();
            assertEquals(intialEventDeckSize-1, deck.getEventDeckSize());
        }
        if(int1 == 1) {
            if(choice.equalsIgnoreCase("Y")) {
                List<String> decisions = Arrays.asList(choice, "N", "N", "N");
                placeholder = playerOne;
                List<Player> participants = List.of(playerTwo, playerThree, playerFour);
                quest = new Quest(null, playerOne, participants);
                assertTrue(!quest.getEligibleParticipants(0).contains(playerOne));
            }
        }
        if(int1 == 2) {
            if(choice.equalsIgnoreCase("Y")) {
                List<String> decisions = Arrays.asList("N", choice, "N", "N");
                placeholder = playerTwo;
                List<Player> participants = List.of(playerOne, playerThree, playerFour);
                quest = new Quest(null, playerTwo, participants);
                assertTrue(!quest.getEligibleParticipants(0).contains(playerTwo));
            }
        }
        if(int1 == 3) {
            if(choice.equalsIgnoreCase("Y")) {
                List<String> decisions = Arrays.asList("N", "N", choice, "N");
                placeholder = playerThree;
                List<Player> participants = List.of(playerOne, playerTwo, playerFour);
                quest = new Quest(null, playerThree, participants);
                assertTrue(!quest.getEligibleParticipants(0).contains(playerThree));
            }
        }
        if(int1 == 4) {
            if(choice.equalsIgnoreCase("Y")) {
                List<String> decisions = Arrays.asList("N", "N", "N", choice);
                placeholder = playerFour;
                List<Player> participants = List.of(playerOne, playerTwo, playerThree);
                quest = new Quest(null, playerFour, participants);
                assertTrue(!quest.getEligibleParticipants(0).contains(playerFour));
            }
        }
    }
    @And("Player {int} sponsors the {int} stage quest and says {string}")
    public void player_sponsors_the_stage_quest_and_says(Integer int1, Integer int2, String choice) {
        Player placeholder = new Player(0);
        int intialEventDeckSize = deck.getEventDeckSize();
        if(int2 == 2) {
            deck.getEventDeck().set(0, "Quest 2");
            deck.drawEventCard();
            assertEquals(intialEventDeckSize-1, deck.getEventDeckSize());
        }
        if(int2 == 3) {
            deck.getEventDeck().set(0, "Quest 3");
            deck.drawEventCard();
            assertEquals(intialEventDeckSize-1, deck.getEventDeckSize());
        }
        if(int2 == 4) {
            deck.getEventDeck().set(0, "Quest 4");
            deck.drawEventCard();
            assertEquals(intialEventDeckSize-1, deck.getEventDeckSize());
        }
        if(int2 == 5) {
            deck.getEventDeck().set(0, "Quest 5");
            deck.drawEventCard();
            assertEquals(intialEventDeckSize-1, deck.getEventDeckSize());
        }
        if(int1 == 1) {
            if(choice.equalsIgnoreCase("Y")) {
                List<String> decisions = Arrays.asList(choice, "N", "N", "N");
                placeholder = playerOne;
                List<Player> participants = List.of(playerTwo, playerThree, playerFour);
                quest = new Quest(null, playerOne, participants);
                assertTrue(!quest.getEligibleParticipants(0).contains(playerOne));
            }
        }
        if(int1 == 2) {
            if(choice.equalsIgnoreCase("Y")) {
                List<String> decisions = Arrays.asList("N", choice, "N", "N");
                placeholder = playerTwo;
                List<Player> participants = List.of(playerOne, playerThree, playerFour);
                quest = new Quest(null, playerTwo, participants);
                assertTrue(!quest.getEligibleParticipants(0).contains(playerTwo));
            }
        }
        if(int1 == 3) {
            if(choice.equalsIgnoreCase("Y")) {
                List<String> decisions = Arrays.asList("N", "N", choice, "N");
                placeholder = playerThree;
                List<Player> participants = List.of(playerOne, playerTwo, playerFour);
                quest = new Quest(null, playerThree, participants);
                assertTrue(!quest.getEligibleParticipants(0).contains(playerThree));
            }
        }
        if(int1 == 4) {
            if(choice.equalsIgnoreCase("Y")) {
                List<String> decisions = Arrays.asList("N", "N", "N", choice);
                placeholder = playerFour;
                List<Player> participants = List.of(playerOne, playerTwo, playerThree);
                quest = new Quest(null, playerFour, participants);
                assertTrue(!quest.getEligibleParticipants(0).contains(playerFour));
            }
        }
    }
    @And("Player 1 draws a 3 stage quest and decides to sponsor it")
    public void player_draws_a_stage_quest_and_decides_to_sponsor_it() {
        deck.getEventDeck().set(0,"Quest 2");
        deck.drawEventCard();
        int currentPlayerTurn = deck.getCurrentPlayerTurn();
        List<String> decisions = Arrays.asList("Y", "N", "N", "N");
        Stage stage1 = new Stage(List.of(playerOne.getHand().get(2), playerOne.getHand().get(4)));
        Stage stage2 = new Stage(List.of(playerOne.getHand().get(3), playerOne.getHand().get(9)));
        Stage stage3 = new Stage(List.of(playerOne.getHand().get(1), playerOne.getHand().get(5), playerOne.getHand().get(10)));
        ArrayList<Stage> stages = new ArrayList<>();
        stages.add(stage1);
        stages.add(stage2);
        stages.add(stage3);
        List<Player> participants = List.of(playerTwo, playerThree, playerFour);
        quest = new Quest(stages, playerOne, participants);
        assertTrue(!quest.getEligibleParticipants(0).contains(playerThree));
    }
    @Then ("Player {int} chooses indices {string} for stage {int}")
    public void player_chooses_indices_for_stage(Integer int1, String string1, Integer int2) {
        int stagesize = 0;
        if(quest.getStages() != null) {
            stagesize = quest.getStages().size();
        }
        ArrayList<Card> cardChoices = new ArrayList<>();
        if(int1 == 1) {
            placeholder = playerOne;
        }
        if(int1 ==2) {
            placeholder = playerTwo;
        }
        if(int1 == 3) {
            placeholder = playerThree;
        }
        if(int1 == 4) {
            placeholder = playerFour;
        }
        if(quest.getStages().size() < int2) {
            cardChoices.add(placeholder.getHand().get(Integer.parseInt(string1)));
            Stage stage = new Stage(cardChoices);
            quest.addStage(stage);
            quest.setIndices(string1);
            assertEquals((stagesize + 1), quest.getStages().size());
        }
        else {
            quest.getStages().get(int2-1).getCards().add(placeholder.getHand().get(Integer.parseInt(string1)));
        }

    }
    @And ("Player {int} {string} in stage {int}")
    public void player_in_stage(Integer int1, String string1, Integer int2) {
        List<Player> remainingPlayer = quest.getEligibleParticipants(0);
        if(int1 == 1) {
            if(string1.equalsIgnoreCase("participates")) {
                quest.promptParticipation(int2, playerOne, "continue");
                assertTrue(remainingPlayer.contains(playerOne));
            }
        }
        if(int1 == 2){
            if(string1.equalsIgnoreCase("participates")) {
                quest.promptParticipation(int2, playerTwo, "continue");
                assertTrue(remainingPlayer.contains(playerTwo));
            }
        }
        if(int1 == 3) {
            if(string1.equalsIgnoreCase("participates")) {
                quest.promptParticipation(int2, playerThree, "continue");
                assertTrue(remainingPlayer.contains(playerThree));
            }
        }
        if(int1 == 4 ) {
            if(string1.equalsIgnoreCase("participates")) {
                quest.promptParticipation(int2, playerFour, "continue");
                assertTrue(remainingPlayer.contains(playerFour));
            }
        }
    }
    @And ("Player {int} builds their attack by choosing {string}")
    public void player_builds_their_attack(Integer int1, String string1) {
        int initialAttackSize = 0;
        if(int1 == 1) {
            initialAttackSize = playerOneAttack.getAttackCards().size();
            quest.promptPlayerForAttack(playerOne, string1, playerOneAttack);
            assertEquals(initialAttackSize+1, playerOneAttack.getAttackCards().size());
        }
        if(int1 ==2) {
            initialAttackSize = playerTwoAttack.getAttackCards().size();
            quest.promptPlayerForAttack(playerTwo, string1, playerTwoAttack);
            assertEquals(initialAttackSize + 1, playerTwoAttack.getAttackCards().size());
        }
        if(int1 == 3) {
            initialAttackSize = playerThreeAttack.getAttackCards().size();
            quest.promptPlayerForAttack(playerThree, string1, playerThreeAttack);
            assertEquals(initialAttackSize + 1, playerThreeAttack.getAttackCards().size());
        }
        if(int1 == 4) {
            initialAttackSize = playerFourAttack.getAttackCards().size();
            quest.promptPlayerForAttack(playerFour, string1, playerFourAttack);
            assertEquals(initialAttackSize + 1, playerFourAttack.getAttackCards().size());
        }
    }
    @And("Eligible players move onto the next stage")
    public void eligible_players_move_onto_the_next_stage() {
        playerOneAttack.clearAttack();
        playerTwoAttack.clearAttack();
        playerThreeAttack.clearAttack();
        playerFourAttack.clearAttack();
        assertTrue(playerOneAttack.getAttackCards().isEmpty());
        assertTrue(playerTwoAttack.getAttackCards().isEmpty());
        assertTrue(playerThreeAttack.getAttackCards().isEmpty());
        assertTrue(playerFourAttack.getAttackCards().isEmpty());
    }
    @And("Player {int} draws a card")
    public void player_draws_a_card(Integer int1) {
        int initialPlayerOneHandSize = playerOne.getHand().size();
        int initialPlayerTwoHandSize = playerTwo.getHand().size();
        int initialPlayerThreeHandSize = playerThree.getHand().size();
        int initialPlayerFourHandSize = playerFour.getHand().size();
        int deckIntialSize = deck.getAdventureDeckSize();
        if(int1 == 1) {
            playerOne.getHand().add(deck.drawRiggedCard());
            playerOne.getHand().sort(Comparator.comparingInt(card -> card.getSortValue()));
            assertEquals(initialPlayerOneHandSize+1, playerOne.getHand().size());

        }
        if(int1 == 2) {
            playerTwo.getHand().add(deck.drawRiggedCard());
            playerTwo.getHand().sort(Comparator.comparingInt(card -> card.getSortValue()));
            assertEquals(initialPlayerTwoHandSize+1, playerTwo.getHand().size());
        }
        if(int1 == 3) {
            playerThree.getHand().add(deck.drawRiggedCard());
            playerThree.getHand().sort(Comparator.comparingInt(card -> card.getSortValue()));
            assertEquals(initialPlayerThreeHandSize+1, playerThree.getHand().size());
        }
        if(int1 == 4) {
            playerFour.getHand().add(deck.drawRiggedCard());
            playerFour.getHand().sort(Comparator.comparingInt(card -> card.getSortValue()));
            assertEquals(initialPlayerFourHandSize+1, playerFour.getHand().size());
        }
        assertEquals(deckIntialSize-1, deck.getAdventureDeckSize());
    }
    @And("Player {int} trims their hand by choosing index {string} to discard")
    public void player_trims_their_hand_by_choosing_index_to_discard(Integer int1, String string2) {
        int p1handsize = playerOne.getHand().size();
        int p2handsize = playerTwo.getHand().size();
        int p3handsize = playerThree.getHand().size();
        int p4handsize = playerFour.getHand().size();
        if(int1 == 1) {
            playerOne.removeTrimHand(playerOne.getHand(), Integer.parseInt(string2));
            assertEquals(p1handsize-1, playerOne.getHand().size());
        }
        if(int1 == 2) {
            playerTwo.removeTrimHand(playerTwo.getHand(),Integer.parseInt(string2));
            assertEquals(p2handsize-1, playerTwo.getHand().size());
        }
        if(int1 == 3) {
            playerThree.removeTrimHand(playerThree.getHand(),Integer.parseInt(string2));
            assertEquals(p3handsize-1, playerThree.getHand().size());
        }
        if(int1 == 4) {
            playerFour.removeTrimHand(playerFour.getHand(), Integer.parseInt(string2));
            assertEquals(p4handsize-1, playerFour.getHand().size());
        }
    }
    @And("Stage {int} is resolved")
    public void stage_is_resolved(Integer int1) {
        List<Player> remainingPlayers;
        remainingPlayers = quest.getEligibleParticipants(int1-1);
        remainingPlayers = quest.resolveStage(quest.getStages().get(int1-1), List.of(playerOneAttack,playerTwoAttack,playerThreeAttack,playerFourAttack),remainingPlayers);
    }

    @And("There is no winner")
    public void there_is_no_winner() {
        List<Player> remainingPlayers = quest.getEligibleParticipants(-1);
        assertTrue(remainingPlayers.isEmpty());
    }
    @And("Player {int} discards the amount of cards used for the quest and redraws the same amount")
    public void player_discards_the_amount_of_cards_used_for_the_quest_and_redraws_the_same_amount(Integer int1) {
        Player placeholder = playerOne;
        if(int1 ==1) {
            placeholder = playerOne;
        } else if (int1 == 2) {
            placeholder = playerTwo;
        } else if(int1 == 3) {
            placeholder = playerThree;
        } else if(int1 == 4) {
            placeholder = playerFour;
        }
        int initialHandSize = placeholder.getHand().size();
        String newString ="";
        for(int i =0; i<quest.getIndices().size();i++) {
            newString += quest.getIndices().get(i);
        }
        for(int j=0; j<newString.length();j++){
            placeholder.getHand().remove(Integer.parseInt(String.valueOf(newString.charAt(j))));
            placeholder.getHand().add(deck.drawRiggedCard());
            placeholder.getHand().sort(Comparator.comparingInt(card -> card.getSortValue()));
        }
        quest.getStages().clear();
        playerOneAttack.clearAttack();
        playerTwoAttack.clearAttack();
        playerThreeAttack.clearAttack();
        playerFourAttack.clearAttack();
        assertEquals(initialHandSize,placeholder.getHand().size());
    }
    @Then("Player {int} earns shields")
    public void player_earns_shields(Integer int1) {
        int intialShield = 0;
        int shieldsToGain = quest.getStages().size();
        int newShields = 0;
        if(int1 == 1){
            intialShield = playerOne.getShields();
            newShields = intialShield + shieldsToGain;
            playerOne.setShields(newShields);
            assertEquals(newShields, playerOne.getShields());
        }
        if(int1 == 2) {
            intialShield = playerTwo.getShields();
            newShields = intialShield + shieldsToGain;
            playerTwo.setShields(newShields);
            assertEquals(newShields, playerTwo.getShields());
        }
        if(int1 == 3) {
            intialShield = playerThree.getShields();
            newShields = intialShield + shieldsToGain;
            playerThree.setShields(newShields);
            assertEquals(newShields, playerThree.getShields());
        }
        if(int1 == 4) {
            intialShield = playerFour.getShields();
            newShields = intialShield + shieldsToGain;
            playerFour.setShields(newShields);
            assertEquals(newShields, playerFour.getShields());
        }
    }
    @And ("Player {int} draws plague card and loses 2 shields")
    public void player_draws_plague_card_and_loses_2_shields(Integer int1) {
        int intialShields = 0;
        if(int1 == 1) {
            intialShields = playerOne.getShields();
            event.drawPlagueCard(playerOne);
            if(intialShields > 2) {
                assertEquals(intialShields-2, playerOne.getShields());
            }
            else {
                assertEquals(0, playerOne.getShields());
            }
        }
        if(int1 == 2) {
            intialShields = playerTwo.getShields();
            event.drawPlagueCard(playerTwo);
            if(intialShields > 2) {
                assertEquals(intialShields-2, playerTwo.getShields());
            }
            else {
                assertEquals(0, playerTwo.getShields());
            }
        }
        if(int1 == 3) {
            intialShields = playerThree.getShields();
            event.drawPlagueCard(playerThree);
            if(intialShields > 2) {
                assertEquals(intialShields-2, playerThree.getShields());
            }
            else {
                assertEquals(0, playerThree.getShields());
            }
        }
        if(int1 == 4) {
            intialShields = playerFour.getShields();
            event.drawPlagueCard(playerFour);
            if(intialShields > 2) {
                assertEquals(intialShields-2, playerFour.getShields());
            }
            else {
                assertEquals(0, playerFour.getShields());
            }
        }
    }
    @And("Player {int} draws prosperity making all players draw 2 adventure cards")
    public void player_draws_prosperity_making_all_players_draw_2_adventure_cards(Integer int1) {
        int intialHand1 = playerOne.getHand().size();
        int intialHand2 = playerTwo.getHand().size();
        int intialHand3 = playerThree.getHand().size();
        int intialHand4 = playerFour.getHand().size();
        int intialAdventureDeckSize = deck.getAdventureDeckSize();
        event.drawProsperityRiggedDeck(playerOne,playerTwo,playerThree,playerFour, deck.getAdventureDeck());
        assertEquals(intialHand1+2, playerOne.getHand().size());
        assertEquals(intialHand2+2, playerTwo.getHand().size());
        assertEquals(intialHand3+2,playerThree.getHand().size());
        assertEquals(intialHand4+2,playerFour.getHand().size());
        assertEquals(intialAdventureDeckSize-8, deck.getAdventureDeckSize());
    }
    @And("Player {int} draws queens favour and draws 2 adventure cards")
    public void player_draws_queens_favour_and_draws_2_adventure_cards(Integer int1) {
        int intialHand1 = playerOne.getHand().size();
        int intialHand2 = playerTwo.getHand().size();
        int intialHand3 = playerThree.getHand().size();
        int intialHand4 = playerFour.getHand().size();
        int intialAdventureDeck = deck.getAdventureDeckSize();
        if(int1 == 1) {
            event.drawQueensFavourCardRiggedDeck(playerOne,deck.getAdventureDeck());
            assertEquals(intialHand1+2, playerOne.getHand().size());
        }
        if(int1 == 2) {
            event.drawQueensFavourCardRiggedDeck(playerTwo,deck.getAdventureDeck());
            assertEquals(intialHand2+2, playerTwo.getHand().size());
        }
        if(int1 == 3) {
            event.drawQueensFavourCardRiggedDeck(playerThree,deck.getAdventureDeck());
            assertEquals(intialHand3+2,playerThree.getHand().size());
        }
        if(int1 == 4) {
            event.drawQueensFavourCardRiggedDeck(playerFour,deck.getAdventureDeck());
            assertEquals(intialHand4+2,playerFour.getHand().size());
        }
        assertEquals(intialAdventureDeck-2,deck.getAdventureDeckSize());
    }
    @And("Player {int} {string} stage {int}")
    public void player_stage(Integer int1, String string1, Integer int2) {
        List<Player> remainingPlayers = quest.getEligibleParticipants(int2-1);
        if(int1 == 1){
            remainingPlayers = quest.resolveStage(quest.getStages().get(int2-1), List.of(playerOneAttack),remainingPlayers);
            if(string1.equalsIgnoreCase("wins")) {
                assertTrue(remainingPlayers.contains(playerOne));
            }
            else {
                assertTrue(!remainingPlayers.contains(playerOne));
            }
        }
        if(int1 == 2) {
            remainingPlayers = quest.resolveStage(quest.getStages().get(int2-1), List.of(playerTwoAttack),remainingPlayers);
            if(string1.equalsIgnoreCase("wins")) {
                assertTrue(remainingPlayers.contains(playerTwo));
            }
            else {
                assertTrue(!remainingPlayers.contains(playerTwo));
            }
        }
        if(int1 == 3) {
            remainingPlayers = quest.resolveStage(quest.getStages().get(int2-1), List.of(playerThreeAttack),remainingPlayers);
            if(string1.equalsIgnoreCase("wins")) {
                assertTrue(remainingPlayers.contains(playerThree));
            }
            else {
                assertTrue(!remainingPlayers.contains(playerThree));
            }
        }
        if(int1 == 4) {
            remainingPlayers = quest.resolveStage(quest.getStages().get(int2-1), List.of(playerFourAttack),remainingPlayers);
            if(string1.equalsIgnoreCase("wins")) {
                assertTrue(remainingPlayers.contains(playerFour));
            }
            else {
                assertTrue(!remainingPlayers.contains(playerFour));
            }
        }
    }
    @And("Player {int} wins the game")
    public void player_wins_the_game(Integer int1) {
        List<Player> winners;
        winners = playerOne.checkForWinner(playerOne,playerTwo,playerThree,playerFour);
        if(int1 == 1) {
            assertTrue(winners.contains(playerOne));
        }
        if(int1 == 2) {
            assertTrue(winners.contains(playerTwo));
        }
        if(int1 == 3) {
            assertTrue(winners.contains(playerThree));
        }
        if(int1 == 4) {
            assertTrue(winners.contains(playerFour));
        }
    }
}
