 const apiBaseUrl = "http://localhost:8080";
 let currentPhase = "startedGame"
 const playerList = [0,1,2,3];
 let currentPlayerIndex = 0;
 let isSponsoring = false
 let lastCardDrawn = null;


 async function processUserInput() {
     const inputField = document.getElementById("user-input");
     const command = inputField.value.trim().toLowerCase();
    if(currentPhase === "selectSponsor"){
        if(command === "yes" || command === "no") {
            console.log("Handling Sponsorship in processUserInput")
            await determineSponsorResponse(command);
        } else {
            updateGameDisplay("Invalid input type yes or no")
            return;
        }
     } else if (currentPhase === "buildQuest") {

     }
     inputField.value = "";
 }
 async function determineSponsorResponse(response) {
    console.log("In determineSponsor")
     if (response === "yes") {
         appendToGameDisplay(`Player ${currentPlayerIndex + 1} has chosen to sponsor ${lastCardDrawn}`);
         await handleSponsorship(lastCardDrawn);
     } else {
         currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
         if (currentPlayerIndex === 0) {
             appendToGameDisplay("All players have declined to sponsor the quest. The quest is not sponsored.");
             currentPhase = "startedGame";
             updateTurnDisplay(currentPlayerIndex + 1);
         } else {
             const nextPlayer = playerList[currentPlayerIndex];
             const lastCard = lastCardDrawn;
             updateGameDisplay(`Player ${nextPlayer + 1}, would you like to sponsor the quest card: ${lastCard}? (yes/no)`);
         }
     }
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
         lastCardDrawn = result.card;
         updateGameDisplay(`Drawn Card: ${result.card}`)
         if (result.card === "Prosperity") {
            await handleProsperity();
         } else if (result.card === "Queen's favor") {
            await handleQueensFavor();
         } else if (result.card === "Plague") {
            await handlePlague();
         } else {
            currentPhase = "selectSponsor";
            let card = result.card
            await determineSponsor(card);
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
async function handleQueensFavor() {
    try {
        const response = await fetch(`${apiBaseUrl}/drawQueensFavor`, {method: "POST" });
        const result = await response.json();
        console.log("Queen's favor Response:", result);
        updatePlayerHands(result);
        document.getElementById("event-message").innerText = "Event: Queen's Favor! The current player has drawn 2 new cards.";
    } catch(error) {
        console.error("Error in handleQueensFavour:", error);
        updateGameDisplay("Error: Failed to handle Queen's Favor");
    }
}
async function handlePlague() {
    try {
        const response = await fetch (`${apiBaseUrl}/drawPlague`, {method: "POST"});
        const result = await response.json();
        console.log("Plague's response", result);
        updatePlayerHands(result);
        document.getElementById("event-message").innerText = "Event: Plague. The current player has lost 2 shields.";
    } catch(error) {
        console.error("Error in handlePlague:", error);
        updateGameDisplay("Error: Failed to handle plague");
    }
}
function appendToGameDisplay(message) {
    const gameDisplay = document.getElementById("game-display");
    gameDisplay.value += message + "\n";
    gameDisplay.scrollTop = gameDisplay.scrollHeight;
}
async function determineSponsor(card) {
    let sponsorFound = false;
    let playerIndex = currentPlayerIndex;
    let attempts = 0;
    const userInputField = document.getElementById("user-input");
    while (attempts < playerList.length && !sponsorFound) {
        const player = playerList[playerIndex];
        console.log("Prompting Player")
        updateGameDisplay(`Player ${player + 1}, would you like to sponsor the quest card: ${card}? (yes/no)`);
        const response = await askPlayerForSponsorship(card);
        console.log("Player response", response)
        if (response.toLowerCase() === "yes") {
            sponsorFound = true;
            appendToGameDisplay(`Player ${player + 1} has chosen to sponsor the quest card: ${card}`);
            handleSponsorship(card);
        } else {
            appendToGameDisplay(`Player ${player + 1} has declined to sponsor the quest.`);
            playerIndex = (playerIndex + 1) % playerList.length;
            attempts++;
        }
    }
    if (!sponsorFound) {
        appendToGameDisplay("All players have declined to sponsor the quest. The quest is not sponsored.");
        currentPhase = "startedGame";
        updateTurnDisplay(currentPlayerIndex + 1);
    }
}

function askPlayerForSponsorship(card) {
    return new Promise(resolve => {
        const userInputField = document.getElementById("user-input");
        const promptMessage = `Player ${playerList[currentPlayerIndex] + 1}, would you like to sponsor the quest card: ${card}? (yes/no)`;
        updateGameDisplay(promptMessage);
        userInputField.value = "";
        userInputField.focus();
        function handleKeyDown(event) {
        if(event.key === "Enter") {
            const playerChoice = userInputField.value.trim().toLowerCase();
            resolve(playerChoice);
            userInputField.removeEventListener("keydown", handleKeyDown);
        }
        }
        userInputField.addEventListener("keydown", handleKeyDown);
    });
}

async function handleSponsorship(card) {
    appendToGameDisplay(`Sponsorship for ${card} has been processed.`);
    const stageNumbers = getStageNumber(card);
    let stages = [];
    const userInputField = document.getElementById("user-input");
    userInputField.value = "";
    for(let i =0; i< stageNumbers; i++) {
        updateGameDisplay(`Choose the indices of cards you would like to sponsor for stage ${i + 1}. Enter indices separated by commas (e.g., "3,5")`);
        const response = await getUserInput();
        const indices = response.split(",").map((index) => parseInt(index.trim())).filter((num) => !isNaN(num));
        if (indices.length === 0) {
            appendToGameDisplay("Invalid input. Please enter valid card indices.");
            i--;
            continue;
        }
        stages.push(indices);
        console.log(indices);
        console.log(stages);
    }
    const questData ={
        sponsorPlayer: currentPlayerIndex,
        stages: stages
    };
    try {
        const response = await fetch (`${apiBaseUrl}/createQuest`, {method: "POST"});
        const result = await response;
    } catch (error) {
        console.error("Error creating quest", error);
    }
    currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
    updateTurnDisplay(currentPlayerIndex + 1);

}
function getStageNumber(card) {
    const questMatch = card.match(/^Quest (\d+)$/);
    if(questMatch) {
        return parseInt(questMatch[1],10)
    }
    return null;
}
function getUserInput() {
    return new Promise((resolve) => {
        const inputField = document.getElementById("user-input");
        const submitButton = document.getElementById("submit-command");
        const handleInput = () => {
         const inputValue = inputField.value.trim()
         inputField.value = "";
         submitButton.removeEventListener("click", handleInput);
         resolve(inputValue);
        };
        submitButton.addEventListener("click",handleInput);
    });

}
