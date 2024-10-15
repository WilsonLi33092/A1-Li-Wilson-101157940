package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Decks deck = new Decks();
        EventCard event = new EventCard();
        deck.intializeAdventureDeck();
        deck.intializeEventDeck();
        deck.dealPlayersHands();
        Player playerOne = new Player();
        Player playerTwo = new Player();
        Player playerThree = new Player();
        Player playerFour = new Player();
        playerOne.setHand(deck.player1Hand);
        playerTwo.setHand(deck.player2Hand);
        playerThree.setHand(deck.player3Hand);
        playerFour.setHand(deck.player4Hand);
        playerOne.setNumPlayer(1);
        playerTwo.setNumPlayer(2);
        playerThree.setNumPlayer(3);
        playerFour.setNumPlayer(4);
        playerOne.setShields(6);
        playerTwo.setShields(6);
        playerThree.setShields(6);
        playerFour.setShields(6);
        String moveOn;
        List<Player> playerList = new ArrayList<>(List.of(playerOne,playerTwo,playerThree,playerFour));
        List<Player> allPlayers = playerList;
        int trimAmount = 0;
        Boolean winner = false;
        int turnCounter = 0;
        Player currentPlayer = new Player();
        while (winner == false) {
            if(turnCounter % 4 == 0) {
                currentPlayer = playerOne;
            }
            else if(turnCounter % 4 == 1) {
                currentPlayer = playerTwo;
            }
            else if(turnCounter % 4 == 2) {
                currentPlayer = playerThree;
            }
            else if(turnCounter % 4 == 3) {
                currentPlayer = playerFour;
            }
            Scanner scanner = new Scanner(System.in);
            playerOne.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
            playerTwo.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
            playerThree.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
            playerFour.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
            System.out.println("Hello Player " + currentPlayer.numPlayer + " it is currently your turn.");
            String drawCard = deck.drawEventCard();
            System.out.println("You have drawn the card " + drawCard);
            if(drawCard.equals("Prosperity")) {
                System.out.println("The prosperity card has been drawn, every player draws two cards");
                event.drawProsperity(playerOne.getHand(), playerTwo.getHand(),playerThree.getHand(),playerFour.getHand(), deck.adventureDeck);
                for(Player prosPlayer : allPlayers){
                    while(prosPlayer.getHand().size() > 12) {
                        trimAmount = prosPlayer.calculateTrimHand(prosPlayer.getHand());
                        for(int i = 0; i < trimAmount; i++) {
                            System.out.println("Player number: " + prosPlayer.numPlayer);
                            System.out.println("Your hand has exceeded max value");
                            System.out.println("This is your current hand " + "\n" + prosPlayer.getHand());
                            System.out.println("Choose an index from 1 to " + prosPlayer.getHand().size() + " to remove");
                            String removeCard = scanner.nextLine();
                            prosPlayer.getHand().remove(prosPlayer.trimHand(prosPlayer.getHand(), Integer.parseInt(removeCard)));
                        }
                    }
                }
                playerOne.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
                playerTwo.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
                playerThree.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
                playerFour.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
            }
            else if(drawCard.equals("Plague")) {
                event.drawPlagueCard(currentPlayer.shields);
            }
            else if(drawCard.equals("Queen's favor")) {
                event.drawQueensFavorCard(currentPlayer.getHand(), deck.adventureDeck);
                while(currentPlayer.getHand().size() > 12) {
                    trimAmount = currentPlayer.calculateTrimHand(currentPlayer.getHand());
                    for(int i = 0; i < trimAmount; i++) {
                        System.out.println("Your hand has exceeded max value");
                        System.out.println("This is your current hand " + "\n" + currentPlayer.getHand());
                        System.out.println("Choose an index from 1 to " + currentPlayer.getHand().size() + " to remove");
                        String removeCard = scanner.nextLine();
                        currentPlayer.getHand().remove(currentPlayer.trimHand(currentPlayer.getHand(), Integer.parseInt(removeCard)));
                    }
                }
            }
            else {
                int stageNumber = 0;
                while(!playerList.get(0).equals(currentPlayer)) {
                    playerList.addLast(playerList.get(0));
                    playerList.remove(0);
                }
                for(Player sponsorPlayer : playerList){
                    System.out.println("This is your current hand");
                    System.out.println(sponsorPlayer.getHand());
                    System.out.println("Player number: " + sponsorPlayer.numPlayer);
                    System.out.println("Would you like to sponsor " + drawCard);
                    String questSponsor = scanner.nextLine();
                    if(questSponsor.equalsIgnoreCase("yes")){
                        List<Player> nonSponsorPlayers = new ArrayList<>(playerList);
                        nonSponsorPlayers.remove(sponsorPlayer);
                        List<Card> sponsorCardList = new ArrayList<>();
                        if(drawCard.equals("Quest 2")) {
                            stageNumber =2;
                        }
                        else if(drawCard.equals("Quest 3")) {
                            stageNumber = 3;
                        }
                        else if(drawCard.equals("Quest 4")) {
                            stageNumber = 4;
                        }
                        else {
                            stageNumber =5;
                        }
                        ArrayList<Stage> stagesForQuest = new ArrayList<>();
                        Set<Integer> usedCardIndices = new HashSet<>();
                        for(int i=0;i<stageNumber;i++){
                            ArrayList<Integer> sponsorQuestIndexs = new ArrayList<>();
                            System.out.println("This is your current hand");
                            System.out.println("Hello player " + sponsorPlayer.numPlayer);
                            System.out.println(sponsorPlayer.getHand());
                            System.out.println("Please choose the indexs of the cards you would like to sponsor for stage " + (i+1));
                            System.out.println("Enter 'quit' when you are done choosing");
                            String sponsorIndex = scanner.nextLine();
                            while(!sponsorIndex.equals("quit")){
                                int cardChosenIndex = Integer.parseInt(sponsorIndex);
                                if(usedCardIndices.contains(cardChosenIndex)) {
                                    System.out.println("Card at index " + cardChosenIndex + " has already been used. Choose a different card");
                                } else {
                                    sponsorQuestIndexs.add(cardChosenIndex);
                                    usedCardIndices.add(cardChosenIndex);
                                }
                                System.out.println("Please choose another index or type 'quit'");
                                sponsorIndex = scanner.nextLine();
                            }
                            List<Card> stageList = new ArrayList<>();
                            for (Integer sponsorQuestIndex : sponsorQuestIndexs) {
                                stageList.add(sponsorPlayer.getHand().get(sponsorQuestIndex));
                            }
                            for (Card card : stageList) {
                                sponsorCardList.add(card);
                            }
                            Stage stage = new Stage(stageList);
                            stagesForQuest.add(stage);
                        }
                        Quest quest = new Quest(stagesForQuest,sponsorPlayer,nonSponsorPlayers);
                        clearScreen();
                        List<Player> remainingPlayer = new ArrayList<>();
                        remainingPlayer = nonSponsorPlayers;
                        System.out.println("Type in anything and press enter when the next player is ready");
                        moveOn = scanner.nextLine();

                        for(int k =0;k<quest.stages.size();k++) {
                            for(Player stagePlayer : remainingPlayer){
                                System.out.println("Player number " + stagePlayer.numPlayer);
                                System.out.println("Type in anything and press enter you are ready to take your turn");
                                moveOn = scanner.nextLine();
                                System.out.println("This is your current hand: ");
                                System.out.println(stagePlayer.getHand());
                                System.out.println("Would you like to participate in this stage?");
                                System.out.println("Please type 'continue' or 'withdraw'");
                                String choice = scanner.nextLine();
                                quest.promptParticipation(k,stagePlayer,choice);
                                System.out.println("Type in anything and press enter when you are ready to move onto the next player");
                                moveOn = scanner.nextLine();
                                clearScreen();
                            }
                            System.out.println("For stage " + (k+1) + " the players who have chosen to tackle this stage are");
                            remainingPlayer = quest.getEligibleParticipants(k);
                            for(Player eligiblePlayer : remainingPlayer) {
                                System.out.println("Player number: " + eligiblePlayer.numPlayer);
                            }
                            List<Attack> playerAttacks = new ArrayList<>();
                            for(Player continuingPlayers: remainingPlayer) {
                                Card drawnCard = deck.drawCard();
                                System.out.println("Player " + continuingPlayers.numPlayer + " you have drawn the card " + drawnCard);
                                continuingPlayers.getHand().add(drawnCard);
                                continuingPlayers.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
                                while(continuingPlayers.getHand().size() > 12) {
                                    trimAmount = continuingPlayers.calculateTrimHand(continuingPlayers.getHand());
                                    for(int i = 0; i < trimAmount; i++) {
                                        System.out.println("Your hand has exceeded max value");
                                        System.out.println("This is your current hand " + "\n" + continuingPlayers.getHand());
                                        System.out.println("Choose an index from 1 to " + continuingPlayers.getHand().size() + " to remove");
                                        String removeCard = scanner.nextLine();
                                        continuingPlayers.getHand().remove(continuingPlayers.trimHand(continuingPlayers.getHand(), Integer.parseInt(removeCard)));
                                    }
                                }
                                Attack newAttack = new Attack(continuingPlayers);
                                System.out.println("Player number " + continuingPlayers.numPlayer);
                                System.out.println("You have chosen to continue tackling this stage");
                                System.out.println("Type in anything and press enter you are ready to take your turn");
                                moveOn = scanner.nextLine();
                                Set<Integer> selectedCardIndices = new HashSet<>();
                                System.out.println("This is your current hand");
                                System.out.println(continuingPlayers.getHand());
                                System.out.println("Please choose the index of the card (Ranging from 0 to " + continuingPlayers.getHand().size() + ") you would like to add to your attack");
                                System.out.println("and type 'quit' when you are done adding");
                                String attacks = scanner.nextLine();
                                while(!attacks.equals("quit")) {
                                    try {
                                        int attackIndex = Integer.parseInt(attacks);
                                        if(attackIndex >= 0 && attackIndex < continuingPlayers.getHand().size()) {
                                            if(!selectedCardIndices.contains(attackIndex)) {
                                                quest.promptPlayerForAttack(continuingPlayers,attacks , newAttack);
                                                selectedCardIndices.add(attackIndex);
                                            } else {
                                                System.out.println("You have already used this card. Please choose a different card");
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Please enter a valid number or 'quit' to stop");
                                    }
                                    //quest.promptPlayerForAttack(continuingPlayers,attacks , newAttack);
                                    System.out.println("This is your current hand");
                                    System.out.println(continuingPlayers.getHand());
                                    System.out.println("Would you like to choose another weapon to add to the attack?");
                                    System.out.println("Please type another index or 'quit'");
                                    attacks = scanner.nextLine();
                                }
                                System.out.println("Type in anything and press enter when you are ready to move onto the next player");
                                moveOn = scanner.nextLine();
                                clearScreen();
                                playerAttacks.add(newAttack);
                            }
                            remainingPlayer = quest.getEligibleParticipants(k);
                            quest.resolveStage(quest.getStages().get(k),playerAttacks,remainingPlayer);
                            System.out.println("For stage " + (k+1) + " the following players have moved on");
                            for(Player validPlayer : remainingPlayer) {
                                System.out.println("Player " + validPlayer.numPlayer);
                            }
                            System.out.println("Type in anything and press enter when the first player is ready");
                            moveOn = scanner.nextLine();
                        }
                        if(!remainingPlayer.isEmpty()) {
                            System.out.println("The following players have won the quest!");
                            for(int w =0; w < remainingPlayer.size();w++) {
                                System.out.println("Player number: " + remainingPlayer.get(w).numPlayer + " and their current shields is: " + remainingPlayer.get(w).getShields());
                            }
                            if(!playerOne.checkForWinner(playerOne,playerTwo,playerThree,playerFour).isEmpty()) {
                                List<Player> winnerList = new ArrayList<>();
                                winnerList = playerOne.checkForWinner(playerOne,playerTwo,playerThree,playerFour);
                                if(winnerList.size() == 1) {
                                    System.out.println("We have a winner!");
                                    System.out.println("Player number : " + winnerList.get(0).numPlayer + " has won the game!");
                                    System.out.println("Congratulations!!!!!");
                                }
                                else if(winnerList.size() > 1) {
                                    System.out.println("We have multiple winners!");
                                    for(int z = 0; z<winnerList.size();z++) {
                                        System.out.println("Player number : " + winnerList.get(z).numPlayer + " has won the game!");
                                    }
                                    System.out.println("Congratulations!!!!!");
                                }
                                winner = true;
                                break;
                            }

                            else {
                                System.out.println("The quest has been completed");
                                System.out.println("Player " + sponsorPlayer.numPlayer + " you have sponsored the quest and you are now discarding the cards and drawing cards");
                                System.out.println("Type in anything and press enter when you are ready");
                                moveOn = scanner.nextLine();
                                for(Card sponsoredCard : sponsorCardList) {
                                    sponsorPlayer.getHand().remove(sponsoredCard);
                                    sponsorPlayer.getHand().add(deck.drawCard());
                                    sponsorPlayer.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
                                }
                                for(int s =0;s<stageNumber;s++){
                                    sponsorPlayer.getHand().add(deck.drawCard());
                                    sponsorPlayer.getHand().sort(Comparator.comparingInt(card -> card.sortValue));
                                }
                                while(sponsorPlayer.getHand().size() > 12) {
                                    System.out.println("Player " + sponsorPlayer.numPlayer);
                                    trimAmount = sponsorPlayer.calculateTrimHand(sponsorPlayer.getHand());
                                    for(int i = 0; i < trimAmount; i++) {
                                        System.out.println("Your hand has exceeded max value");
                                        System.out.println("This is your current hand " + "\n" + sponsorPlayer.getHand());
                                        System.out.println("Choose an index from 1 to " + sponsorPlayer.getHand().size() + " to remove");
                                        String removeCard = scanner.nextLine();
                                        sponsorPlayer.getHand().remove(sponsorPlayer.trimHand(sponsorPlayer.getHand(), Integer.parseInt(removeCard)));
                                    }
                                }
                            }
                            break;
                        }
                        else {
                            System.out.println("No one has won");
                            System.out.println("The quest has been completed");
                            System.out.println("Player " + sponsorPlayer.numPlayer + " you have sponsored the quest and you are now discarding the cards and drawing cards");
                            System.out.println("Type in anything and press enter when you are ready");
                            moveOn = scanner.nextLine();
                            for(Card sponsoredCard : sponsorCardList) {
                                sponsorPlayer.getHand().remove(sponsoredCard);
                                sponsorPlayer.getHand().add(deck.drawCard());
                            }
                            for(int s =0;s<stageNumber;s++){
                                sponsorPlayer.getHand().add(deck.drawCard());
                            }

                            while(sponsorPlayer.getHand().size() > 12) {
                                trimAmount = sponsorPlayer.calculateTrimHand(sponsorPlayer.getHand());
                                for(int i = 0; i < trimAmount; i++) {
                                    System.out.println("Your hand has exceeded max value");
                                    System.out.println("This is your current hand " + "\n" + sponsorPlayer.getHand());
                                    System.out.println("Choose an index from 1 to " + sponsorPlayer.getHand().size() + " to remove");
                                    String removeCard = scanner.nextLine();
                                    sponsorPlayer.getHand().remove(sponsorPlayer.trimHand(sponsorPlayer.getHand(), Integer.parseInt(removeCard)));
                                }
                            }
                            break;
                        }
                    }
                    else {
                        continue;
                    }
                }
            }
            System.out.println("The game will now proceed to the next player's turn");
            System.out.println("Type anything and press enter when you are ready");
            moveOn = scanner.nextLine();
            clearScreen();
            turnCounter += 1;
            if(playerOne.getShields() >= 7 || playerTwo.getShields() >= 7 || playerThree.getShields() >= 7 || playerFour.getShields() >= 7) {
                winner = true;
            }
        }

    }
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println(); // Print multiple empty lines
        }
    }




}
