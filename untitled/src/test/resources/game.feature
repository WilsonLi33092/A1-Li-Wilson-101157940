Feature: Adventure game
  Scenario: A1_Scenario
    Given A rigged deck for A1 scenario has started
    When Player 1 has drawn a 4 stage quest and says "N"
    And Player 2 sponsors the 4 stage quest and says "Y"
    And Player 2 chooses indices "0" for stage 1
    And Player 2 chooses indices "7" for stage 1
    And Player 2 chooses indices "2" for stage 2
    And Player 2 chooses indices "6" for stage 2
    And Player 2 chooses indices "3" for stage 3
    And Player 2 chooses indices "5" for stage 3
    And Player 2 chooses indices "8" for stage 3
    And Player 2 chooses indices "4" for stage 4
    And Player 2 chooses indices "9" for stage 4
    And Player 1 "participates" in stage 1
    And Player 1 draws a card
    And Player 1 trims their hand by choosing index "1" to discard
    And Player 3 "participates" in stage 1
    And Player 3 draws a card
    And Player 3 trims their hand by choosing index "1" to discard
    And Player 4 "participates" in stage 1
    And Player 4 draws a card
    And Player 4 trims their hand by choosing index "1" to discard
    And Player 1 builds their attack by choosing "4"
    And Player 1 builds their attack by choosing "5"
    And Player 3 builds their attack by choosing "4"
    And Player 3 builds their attack by choosing "3"
    And Player 4 builds their attack by choosing "3"
    And Player 4 builds their attack by choosing "5"
    And Stage 1 is resolved
    And Eligible players move onto the next stage
    And Player 1 "participates" in stage 2
    And Player 1 draws a card
    And Player 3 "participates" in stage 2
    And Player 3 draws a card
    And Player 4 "participates" in stage 2
    And Player 4 draws a card
    And Player 1 builds their attack by choosing "6"
    And Player 1 builds their attack by choosing "5"
    And Player 3 builds their attack by choosing "8"
    And Player 3 builds their attack by choosing "3"
    And Player 4 builds their attack by choosing "5"
    And Player 4 builds their attack by choosing "5"
    And Stage 2 is resolved
    And Eligible players move onto the next stage
    And Player 1 has 0 shields
    And Player 1 has 9 cards
    And Player 3 "participates" in stage 3
    And Player 3 draws a card
    And Player 4 "participates" in stage 3
    And Player 4 draws a card
    And Player 3 builds their attack by choosing "8"
    And Player 3 builds their attack by choosing "5"
    And Player 3 builds their attack by choosing "3"
    And Player 4 builds their attack by choosing "6"
    And Player 4 builds their attack by choosing "4"
    And Player 4 builds their attack by choosing "5"
    And Stage 3 is resolved
    And Eligible players move onto the next stage
    And Player 3 "participates" in stage 4
    And Player 3 draws a card
    And Player 4 "participates" in stage 4
    And Player 4 draws a card
    And Player 3 builds their attack by choosing "6"
    And Player 3 builds their attack by choosing "5"
    And Player 3 builds their attack by choosing "5"
    And Player 4 builds their attack by choosing "3"
    And Player 4 builds their attack by choosing "3"
    And Player 4 builds their attack by choosing "3"
    And Player 4 builds their attack by choosing "4"
    And Stage 4 is resolved
    And Player 3 has 0 shields
    And Player 3 has 5 cards
    And Player 4 has 4 shields
    And Player 4 has 4 cards
    And Player 2 discards the amount of cards used for the quest and redraws the same amount
    And Player 2 has 12 cards

  Scenario: 2 winner quest with events
    Given A rigged deck for 1 winner quest has started
    When Player 1 has drawn a 4 stage quest and says "Y"
    And Player 1 chooses indices "2" for stage 1
    And Player 1 chooses indices "0" for stage 2
    And Player 1 chooses indices "10" for stage 2
    And Player 1 chooses indices "1" for stage 3
    And Player 1 chooses indices "5" for stage 3
    And Player 1 chooses indices "7" for stage 3
    And Player 1 chooses indices "3" for stage 4
    And Player 1 chooses indices "9" for stage 4
    And Player 2 "participates" in stage 1
    And Player 3 "participates" in stage 1
    And Player 4 "participates" in stage 1
    And Player 2 draws a card
    And Player 2 trims their hand by choosing index "1" to discard
    And Player 2 builds their attack by choosing "4"
    And Player 2 builds their attack by choosing "4"
    And Player 3 draws a card
    And Player 3 trims their hand by choosing index "7" to discard
    And Player 3 builds their attack by choosing "5"
    And Player 4 draws a card
    And Player 4 trims their hand by choosing index "0" to discard
    And Player 4 builds their attack by choosing "3"
    And Player 4 builds their attack by choosing "4"
    And Stage 1 is resolved
    And Eligible players move onto the next stage
    And Player 2 "participates" in stage 2
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "4"
    And Player 2 builds their attack by choosing "5"
    And Player 4 "participates" in stage 2
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "3"
    And Player 4 builds their attack by choosing "5"
    And Stage 2 is resolved
    And Eligible players move onto the next stage
    And Player 2 "participates" in stage 3
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "4"
    And Player 2 builds their attack by choosing "5"
    And Player 4 "participates" in stage 3
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "3"
    And Player 4 builds their attack by choosing "5"
    And Stage 3 is resolved
    And Eligible players move onto the next stage
    And Player 2 "participates" in stage 4
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "4"
    And Player 2 builds their attack by choosing "6"
    And Player 4 "participates" in stage 4
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "5"
    And Player 4 builds their attack by choosing "5"
    And Stage 4 is resolved
    Then Player 1 discards the amount of cards used for the quest and redraws the same amount
    And Player 2 has drawn a 4 stage quest and says "N"
    And Player 3 sponsors the 4 stage quest and says "Y"
    And Player 3 chooses indices "0" for stage 1
    And Player 3 chooses indices "1" for stage 2
    And Player 3 chooses indices "4" for stage 2
    And Player 3 chooses indices "3" for stage 3
    And Player 1 "withdraws" in stage 1
    And Player 2 "participates" in stage 1
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "5"
    And Player 4 "participates" in stage 1
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "4"
    And Stage 1 is resolved
    And Eligible players move onto the next stage
    And Player 2 "participates" in stage 2
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "6"
    And Player 4 "participates" in stage 2
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "6"
    And Stage 2 is resolved
    And Eligible players move onto the next stage
    And Player 2 "participates" in stage 3
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "7"
    And Player 4 "participates" in stage 3
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "7"
    And Stage 3 is resolved
    And Player 2 wins the game
    And Player 4 wins the game
    And Player 2 has 7 shields
    And Player 4 has 7 shields



  Scenario: 0 winner quest
    Given A new game has started
    When Player 1 has drawn a 2 stage quest and says "Y"
    Then Player 1 chooses indices "2" for stage 1
    And Player 1 chooses indices "4" for stage 1
    And Player 1 chooses indices "3" for stage 2
    And Player 1 chooses indices "9" for stage 2
    And Player 2 "participates" in stage 1
    And Player 3 "participates" in stage 1
    And Player 4 "participates" in stage 1
    And Player 2 draws a card
    And Player 2 trims their hand by choosing index "1" to discard
    And Player 2 builds their attack by choosing "5"
    And Player 3 draws a card
    And Player 3 trims their hand by choosing index "1" to discard
    And Player 3 builds their attack by choosing "5"
    And Player 4 draws a card
    And Player 4 trims their hand by choosing index "1" to discard
    And Player 4 builds their attack by choosing "4"
    And Stage 1 is resolved
    And There is no winner
    And Player 1 discards the amount of cards used for the quest and redraws the same amount
    And Player 1 has 0 shields
    And Player 2 has 0 shields
    And Player 3 has 0 shields
    And Player 4 has 0 shields
    And Player 1 has 12 cards
    And Player 2 has 11 cards
    And Player 3 has 11 cards
    And Player 4 has 11 cards

  Scenario: 1 winner quest with events
    Given A rigged deck for 1 winner quest has started
    When Player 1 has drawn a 4 stage quest and says "Y"
    And Player 1 chooses indices "0" for stage 1
    And Player 1 chooses indices "1" for stage 2
    And Player 1 chooses indices "4" for stage 2
    And Player 1 chooses indices "2" for stage 3
    And Player 1 chooses indices "3" for stage 4
    And Player 1 chooses indices "5" for stage 4
    And Player 2 "participates" in stage 1
    And Player 3 "participates" in stage 1
    And Player 4 "participates" in stage 1
    And Player 2 draws a card
    And Player 2 trims their hand by choosing index "1" to discard
    And Player 2 builds their attack by choosing "4"
    And Player 3 draws a card
    And Player 3 trims their hand by choosing index "1" to discard
    And Player 3 builds their attack by choosing "3"
    And Player 4 draws a card
    And Player 4 trims their hand by choosing index "0" to discard
    And Player 4 builds their attack by choosing "3"
    And Stage 1 is resolved
    And Eligible players move onto the next stage
    And Player 2 "participates" in stage 2
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "4"
    And Player 3 "participates" in stage 2
    And Player 3 draws a card
    And Player 3 builds their attack by choosing "4"
    And Player 4 "participates" in stage 2
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "4"
    And Stage 2 is resolved
    And Eligible players move onto the next stage
    And Player 2 "participates" in stage 3
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "7"
    And Player 3 "participates" in stage 3
    And Player 3 draws a card
    And Player 3 builds their attack by choosing "8"
    And Player 4 "participates" in stage 3
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "8"
    And Stage 3 is resolved
    And Eligible players move onto the next stage
    And Player 2 "participates" in stage 4
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "4"
    And Player 2 builds their attack by choosing "8"
    And Player 3 "participates" in stage 4
    And Player 3 draws a card
    And Player 3 builds their attack by choosing "3"
    And Player 3 builds their attack by choosing "8"
    And Player 4 "participates" in stage 4
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "4"
    And Player 4 builds their attack by choosing "8"
    And Stage 4 is resolved
    Then Player 1 discards the amount of cards used for the quest and redraws the same amount
    And Player 2 draws plague card and loses 2 shields
    And Player 3 draws prosperity making all players draw 2 adventure cards
    And Player 1 trims their hand by choosing index "7" to discard
    And Player 1 trims their hand by choosing index "12" to discard
    And Player 4 draws queens favour and draws 2 adventure cards
    And Player 4 trims their hand by choosing index "0" to discard
    And Player 4 trims their hand by choosing index "1" to discard
    And Player 1 has drawn a 3 stage quest and says "Y"
    And Player 1 chooses indices "0" for stage 1
    And Player 1 chooses indices "4" for stage 1
    And Player 1 chooses indices "1" for stage 2
    And Player 1 chooses indices "7" for stage 2
    And Player 1 chooses indices "2" for stage 3
    And Player 1 chooses indices "5" for stage 3
    And Player 2 "participates" in stage 1
    And Player 3 "participates" in stage 1
    And Player 4 "participates" in stage 1
    And Player 2 draws a card
    And Player 2 trims their hand by choosing index "0" to discard
    And Player 2 builds their attack by choosing "5"
    And Player 3 draws a card
    And Player 3 trims their hand by choosing index "0" to discard
    And Player 3 builds their attack by choosing "3"
    And Player 4 draws a card
    And Player 4 trims their hand by choosing index "0" to discard
    And Player 4 builds their attack by choosing "1"
    And Stage 1 is resolved
    And Eligible players move onto the next stage
    And Player 2 "participates" in stage 2
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "10"
    And Player 2 builds their attack by choosing "7"
    And Player 3 "participates" in stage 2
    And Player 3 draws a card
    And Player 3 builds their attack by choosing "4"
    And Player 3 builds their attack by choosing "7"
    And Stage 2 is resolved
    And Eligible players move onto the next stage
    And Player 2 "participates" in stage 3
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "10"
    And Player 3 "participates" in stage 3
    And Player 3 draws a card
    And Player 3 builds their attack by choosing "5"
    And Player 3 builds their attack by choosing "8"
    And Stage 3 is resolved
    And Player 1 discards the amount of cards used for the quest and redraws the same amount
    And Player 3 wins the game
    And Player 3 has 7 shields
    And Player 2 has 5 shields
    And Player 4 has 4 shields
