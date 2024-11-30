 const apiBaseUrl = "http://localhost:8080";
 async function processUserInput() {
     const inputField = document.getElementById("user-input");
     const command = inputField.value.trim().toLowerCase();

     if (command === "start") {
         await startGame();
     } else if (command === "draw") {
         await drawCard();
     } else {
         updateGameDisplay("Invalid command. Try 'start' or 'draw'.");
     }
     inputField.value = "";
 }
 async function startGame() {
     try {
         const response = await fetch(`${apiBaseUrl}/start`);
         if (!response.ok) {
             throw new Error('Failed to start the game');
         }

         const result = await response.json();
         console.log("API Response:", result);
                  console.log("Player Hands:", result.playerOneHand, result.playerTwoHand, result.playerThreeHand, result.playerFourHand);
                  updateGameDisplay(`Game Started! It is currently Player ${result.currentTurn}'s turn.`);
                  updateTurnDisplay(result.currentTurn);
                  updatePlayerHands(result);
     } catch (error) {
         console.error("Error in startGame:", error);
     }
 }

 function updatePlayerHands(result) {
     document.getElementById("player-one-hand").innerHTML = result.playerOneHand.join(', ');
     document.getElementById("player-two-hand").innerHTML = result.playerTwoHand.join(', ');
     document.getElementById("player-three-hand").innerHTML = result.playerThreeHand.join(', ');
     document.getElementById("player-four-hand").innerHTML = result.playerFourHand.join(', ');
 }

 function displayShields(result) {
     document.getElementById("player-one-name").innerText = `Player 1 (Shields: ${result.playerOneShields})`;
     document.getElementById("player-two-name").innerText = `Player 2 (Shields: ${result.playerTwoShields})`;
     document.getElementById("player-three-name").innerText = `Player 3 (Shields: ${result.playerThreeShields})`;
     document.getElementById("player-four-name").innerText = `Player 4 (Shields: ${result.playerFourShields})`;
 }

 async function drawCard() {
     try {
         const response = await fetch(`${apiBaseUrl}/draw`, { method: "POST" });
         if(!response.ok) {
            throw new Error("Failed to draw card")
         }
         const result = await response.json();
         console.log("Draw Card Response:", result);
         updateGameDisplay(`Drawn Card: ${result.card}`)
         if (result.card === "Prosperity") {
            await handleProsperity();
         } else if (result.card === "Queen's Favor") {
             document.getElementById("event-message").innerText = "Event: Queen's Favor! You have gained 2 cards.";
         } else if (result.card === "Plague") {
             document.getElementById("event-message").innerText = "Event: Plauge. You have lost 2 shields."
         }

     } catch (error) {
         console.error("Error in drawCard:", error);
         updateGameDisplay("Error: Failed to draw card")
     }
 }

function updateGameDisplay(message) {
    const gameDisplay = document.getElementById("game-display");
    gameDisplay.value = message;
    gameDisplay.scrollTop = gameDisplay.scrollHeight;
}

function updateTurnDisplay(currentTurn) {
    const turnDisplay = document.getElementById("current-turn");
    turnDisplay.innerText = `It is Player ${currentTurn}'s turn.`;
}

function updatePlayerHands(result) {
    console.log("Updating player hands with result:", result);

    document.getElementById("player-one-hand").innerText =
        `Player 1: ${result.playerOneHand.join(", ")} | Shields: ${result.playerOneShields}`;
    document.getElementById("player-two-hand").innerText =
        `Player 2: ${result.playerTwoHand.join(", ")} | Shields: ${result.playerTwoShields}`;
    document.getElementById("player-three-hand").innerText =
        `Player 3: ${result.playerThreeHand.join(", ")} | Shields: ${result.playerThreeShields}`;
    document.getElementById("player-four-hand").innerText =
        `Player 4: ${result.playerFourHand.join(", ")} | Shields: ${result.playerFourShields}`;
}
async function handleProsperity() {
    try {
        const response = await fetch(`${apiBaseUrl}/drawProsperity`, { method: "POST" });
        const result = await response.json();
        console.log("Prosperity Response:", result);
        updatePlayerHands(result);
        document.getElementById("event-message").innerText =
            "Event: Prosperity! Each player has drawn 2 new cards.";

    } catch (error) {
        console.error("Error in handleProsperity:", error);
        updateGameDisplay("Error: Failed to handle Prosperity event.");
    }
}