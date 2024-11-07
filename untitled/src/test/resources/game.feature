Feature: Adventure game
  Scenario:
    Given
  Scenario: 0 winner quest
    Given A new game has started
    When Player 1 has drawn a 2 stage quest and says "Y"
    Then Player 1 chooses indices "2" for stage 1
    And Player 1 chooses indices "4" for stage 1
    And Player 1 chooses indices "3" for stage 2
    And Player 1 chooses indices "9" for stage 2
    And Player 2 participates in stage 1
    And Player 3 participates in stage 1
    And Player 4 participates in stage 1
    And Player 2 draws a card
    And Player 2 trims their hand by choosing index "1" to discard
    And Player 2 builds their attack by choosing "5"
    And Player 3 draws a card
    And Player 3 trims their hand by choosing index "1" to discard
    And Player 3 builds their attack by choosing "5"
    And Player 4 draws a card
    And Player 4 trims their hand by choosing index "1" to discard
    And Player 4 builds their attack by choosing "4"
    And Player 2 "loses" stage 1
    And Player 3 "loses" stage 1
    And Player 4 "loses" stage 1
    And There is no winner
    And Player 1 discards the amount of cards used for the quest and redraws the same amount

  Scenario: 1 winner quest
    Given A rigged deck for 1 winner quest has started
    When Player 1 has drawn a 4 stage quest and says "Y"
    And Player 1 chooses indices "0" for stage 1
    And Player 1 chooses indices "1" for stage 2
    And Player 1 chooses indices "4" for stage 2
    And Player 1 chooses indices "2" for stage 3
    And Player 1 chooses indices "3" for stage 4
    And Player 1 chooses indices "5" for stage 4
    And Player 2 participates in stage 1
    And Player 3 participates in stage 1
    And Player 4 participates in stage 1
    And Player 2 draws a card
    And Player 2 trims their hand by choosing index "1" to discard
    And Player 2 builds their attack by choosing "4"
    And Player 3 draws a card
    And Player 3 trims their hand by choosing index "1" to discard
    And Player 3 builds their attack by choosing "3"
    And Player 4 draws a card
    And Player 4 trims their hand by choosing index "0" to discard
    And Player 4 builds their attack by choosing "3"
    And Player 2 "wins" stage 1
    And Player 3 "wins" stage 1
    And Player 4 "wins" stage 1
    And Eligible players move onto the next stage
    And Player 2 participates in stage 2
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "4"
    And Player 3 participates in stage 2
    And Player 3 draws a card
    And Player 3 builds their attack by choosing "4"
    And Player 4 participates in stage 2
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "4"
    And Player 2 "wins" stage 2
    And Player 3 "wins" stage 2
    And Player 4 "wins" stage 2
    And Eligible players move onto the next stage
    And Player 2 participates in stage 3
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "7"
    And Player 3 participates in stage 3
    And Player 3 draws a card
    And Player 3 builds their attack by choosing "8"
    And Player 4 participates in stage 3
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "8"
    And Player 2 "wins" stage 3
    And Player 3 "wins" stage 3
    And Player 4 "wins" stage 3
    And Eligible players move onto the next stage
    And Player 2 participates in stage 4
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "4"
    And Player 2 builds their attack by choosing "8"
    And Player 3 participates in stage 4
    And Player 3 draws a card
    And Player 3 builds their attack by choosing "3"
    And Player 3 builds their attack by choosing "8"
    And Player 4 participates in stage 4
    And Player 4 draws a card
    And Player 4 builds their attack by choosing "4"
    And Player 4 builds their attack by choosing "8"
    And Player 2 "wins" stage 4
    And Player 3 "wins" stage 4
    And Player 4 "wins" stage 4
    Then Player 2 earns shields
    And Player 3 earns shields
    And Player 4 earns shields
    And Player 1 discards the amount of cards used for the quest and redraws the same amount
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
    And Player 2 participates in stage 1
    And Player 3 participates in stage 1
    And Player 4 participates in stage 1
    And Player 2 draws a card
    And Player 2 trims their hand by choosing index "0" to discard
    And Player 2 builds their attack by choosing "5"
    And Player 3 draws a card
    And Player 3 trims their hand by choosing index "0" to discard
    And Player 3 builds their attack by choosing "3"
    And Player 4 draws a card
    And Player 4 trims their hand by choosing index "0" to discard
    And Player 4 builds their attack by choosing "1"
    And Player 2 "wins" stage 1
    And Player 3 "wins" stage 1
    And Player 4 "loses" stage 1
    And Eligible players move onto the next stage
    And Player 2 participates in stage 2
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "10"
    And Player 2 builds their attack by choosing "7"
    And Player 3 participates in stage 2
    And Player 3 draws a card
    And Player 3 builds their attack by choosing "4"
    And Player 3 builds their attack by choosing "7"
    And Player 2 "wins" stage 2
    And Player 3 "wins" stage 2
    And Eligible players move onto the next stage
    And Player 2 participates in stage 3
    And Player 2 draws a card
    And Player 2 builds their attack by choosing "10"
    And Player 3 participates in stage 3
    And Player 3 draws a card
    And Player 3 builds their attack by choosing "4"
    And Player 3 builds their attack by choosing "8"
    And Player 2 "wins" stage 3
    And Player 3 "wins" stage 3
    And Player 2 earns shields
    And Player 3 earns shields
    And Player 3 wins the game
