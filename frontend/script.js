 const apiBaseUrl = "http://localhost:8080";

 async function startGame() {
     try {
         const response = await fetch(`${apiBaseUrl}/start`);
         if (!response.ok) {
             throw new Error('Failed to start the game');
         }

         const result = await response.json();
         console.log("Start Game Response:", result);

         document.getElementById("turn-indicator").innerText =
             `It is currently Player ${result.currentTurn}'s turn`;

         document.getElementById("event-message").innerText = `Event: ${result.eventMessage}`;

         updatePlayerHands(result);

         displayShields(result);

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
         const result = await response.json();
         console.log("Draw Card Response:", result);

         document.getElementById("drawn-card").innerText =
             `Drawn Card: ${result.card}`;

         if (result.card === "Prosperity") {
             handleProsperity(result);
         } else if (result.card === "Queen's Favor") {
             handleQueensFavor(result);
         } else if (result.card === "Plague") {
             handlePlague(result);
         }

     } catch (error) {
         console.error("Error in drawCard:", error);
     }
 }

 function handleProsperity(result) {
     document.getElementById("event-message").innerText = `Event: Prosperity! Each player gets a card.`;
 }

 function handleQueensFavor(result) {
     document.getElementById("event-message").innerText = `Event: Queen's Favor! You gain 2 cards.`;
 }

 function handlePlague(result) {
     document.getElementById("event-message").innerText = `Event: Plague! Reduce shields.`;
 }