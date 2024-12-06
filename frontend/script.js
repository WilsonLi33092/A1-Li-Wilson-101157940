 const apiBaseUrl = "http://localhost:8080";
 let currentPhase = "startedGame"
 const playerList = [0,1,2,3];
 let currentPlayerIndex = 0;
 let isSponsoring = false
 let lastCardDrawn = null;
 let firstAskedIndex = null;
 window.winnerList = [];
 let otherPhase = "otherPhase";
 let rigged = false;



 async function processUserInput() {
     const inputField = document.getElementById("user-input");
     const command = inputField.value.trim().toLowerCase();
    if(currentPhase === "selectSponsor"){
        if(command === "yes" || command === "no") {
            await determineSponsorResponse(command);
        } else {
            return;
        }
     }
     //inputField.value = "";
 }
 async function determineSponsorResponse(response) {
    const inputField = document.getElementById("user-input");
    inputField.value = "";
     if (response === "yes") {
         appendToGameDisplay(`Player ${currentPlayerIndex + 1} has chosen to sponsor ${lastCardDrawn}`);
         await handleSponsorship(lastCardDrawn);
         firstAskedIndex = null;
     } else {
        if(firstAskedIndex === null) {
            firstAskedIndex = currentPlayerIndex;
        }
         currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
         if (currentPlayerIndex === firstAskedIndex) {
             appendToGameDisplay("All players have declined to sponsor the quest. The quest is not sponsored.");
             //currentPhase = "startedGame";
             await fetch(`${apiBaseUrl}/nextPlayerTurn`, { method: "POST" });
             firstAskedIndex = null;
             currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
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
                  updateGameDisplay(`Game Started! It is currently Player ${result.currentTurn}'s turn.`);
                  updateTurnDisplay(result.currentTurn);
                  updatePlayerHands(result);
     } catch (error) {
         console.error("Error in startGame:", error);
     }
 }
 async function startRigged1WinnerGame() {
      rigged = true;
      try {
          const response = await fetch(`${apiBaseUrl}/startRiggedDeck1winner`);
          if (!response.ok) {
              throw new Error('Failed to start the game');
          }
          const result = await response.json();
                   updateGameDisplay(`Game Started! It is currently Player ${result.currentTurn}'s turn.`);
                   updateTurnDisplay(result.currentTurn);
                   updatePlayerHands(result);
      } catch (error) {
          console.error("Error in startGame:", error);
      }
  }
  async function startRigged0WinnerGame() {
        rigged = true;
        try {
            const response = await fetch(`${apiBaseUrl}/startRiggedDeck0winner`);
            if (!response.ok) {
                throw new Error('Failed to start the game');
            }
            const result = await response.json();
                     updateGameDisplay(`Game Started! It is currently Player ${result.currentTurn}'s turn.`);
                     updateTurnDisplay(result.currentTurn);
                     updatePlayerHands(result);
        } catch (error) {
            console.error("Error in startGame:", error);
        }
    }
  async function startRigged2WinnerGame() {
        rigged = true;
        try {
            const response = await fetch(`${apiBaseUrl}/startRiggedDeck2winner`);
            if (!response.ok) {
                throw new Error('Failed to start the game');
            }
            const result = await response.json();
                     updateGameDisplay(`Game Started! It is currently Player ${result.currentTurn}'s turn.`);
                     updateTurnDisplay(result.currentTurn);
                     updatePlayerHands(result);
        } catch (error) {
            console.error("Error in startGame:", error);
        }
    }
    async function startRiggedJPDeck() {
          rigged = true;
          try {
              const response = await fetch(`${apiBaseUrl}/startRiggedJPDeck`);
              if (!response.ok) {
                  throw new Error('Failed to start the game');
              }
              const result = await response.json();
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
         lastCardDrawn = result.card;
         updateGameDisplay(`Drawn Card: ${result.card}`)
         if (result.card === "Prosperity") {
            if(rigged) {
                await handleRiggedProsperity();
            }
            else {
                await handleProsperity();
            }
            await trimHands();
            currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
            updateTurnDisplay(currentPlayerIndex + 1)

         } else if (result.card === "Queen's favor") {
            if(currentPhase != "startedGame"){
                currentPhase = "startedGame";
            }
            if(rigged) {
                await handleRiggedQueensFavor();
            } else {
                await handleQueensFavor();
            }
            await trimHands();
            currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
            updateTurnDisplay(currentPlayerIndex + 1)

         } else if (result.card === "Plague") {
            await handlePlague();
            currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
            updateTurnDisplay(currentPlayerIndex + 1)

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
 async function riggedDrawCard() {
      try {
          const response = await fetch(`${apiBaseUrl}/riggedDrawCard`, { method: "POST" });
          if(!response.ok) {
             throw new Error("Failed to draw card")
          }
          const result = await response.json();
          lastCardDrawn = result.card;
          updateGameDisplay(`Drawn Card: ${result.card}`)
          if (result.card === "Prosperity") {
             await handleRiggedProsperity();
             await trimHands();
             currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
             updateTurnDisplay(currentPlayerIndex + 1)

          } else if (result.card === "Queen's favor") {
             if(currentPhase != "startedGame"){
                 currentPhase = "startedGame";
             }
             await handleRiggedQueensFavor();
             await trimHands();
             currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
             updateTurnDisplay(currentPlayerIndex + 1)

          } else if (result.card === "Plague") {
             await handlePlague();
             currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
             updateTurnDisplay(currentPlayerIndex + 1)

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
async function trimHands() {
    try{
                    const trim = await fetch(`${apiBaseUrl}/checkTrim`, {method: "POST"});
                    const trimResult = await trim.json();
                    if (trimResult.playerOne) {
                            for(let j =0; j<trimResult.playerOneAmount;j++) {
                                appendToGameDisplay(`\n`);
                                appendToGameDisplay(`Player One, you must trim your hand, choose the index of the card you would like to discard.`);
                                const userResponse = await getUserInput();
                                let trimIndex = parseInt(userResponse, 10);
                                let playerOne = "playerOne";
                                await fetch(`${apiBaseUrl}/trimHand`, {method:"POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({index:trimIndex,player:playerOne}),});
                                const finalTrim = await fetch(`${apiBaseUrl}/finishQuest`, { method: "POST" });
                                            const trimmedResult = await finalTrim.json();
                                            updatePlayerHands(trimmedResult);
                            }
                    }
                    if (trimResult.playerTwo) {
                                                for(let j =0; j<trimResult.playerTwoAmount;j++) {
                                                    appendToGameDisplay(`\n`);
                                                    appendToGameDisplay(`Player Two, you must trim your hand, choose the index of the card you would like to discard.`);
                                                    const userResponse = await getUserInput();
                                                    let trimIndex = parseInt(userResponse, 10);
                                                    let playerTwo = "playerTwo";
                                                    await fetch(`${apiBaseUrl}/trimHand`, {method:"POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({index:trimIndex,player:playerTwo}),});
                                                    const finalTrim = await fetch(`${apiBaseUrl}/finishQuest`, { method: "POST" });
                                                                const trimmedResult = await finalTrim.json();
                                                                updatePlayerHands(trimmedResult);
                                                }
                                        }
                    if (trimResult.playerThree) {

                                                                    for(let j =0; j<trimResult.playerThreeAmount;j++) {
                                                                        appendToGameDisplay(`\n`);
                                                                        appendToGameDisplay(`Player Three, you must trim your hand, choose the index of the card you would like to discard.`);
                                                                        const userResponse = await getUserInput();
                                                                        let trimIndex = parseInt(userResponse, 10);
                                                                        let playerThree = "playerThree";
                                                                        await fetch(`${apiBaseUrl}/trimHand`, {method:"POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({index:trimIndex,player:playerThree}),});
                                                                        const finalTrim = await fetch(`${apiBaseUrl}/finishQuest`, { method: "POST" });
                                                                                    const trimmedResult = await finalTrim.json();
                                                                                    updatePlayerHands(trimmedResult);
                                                                    }
                                                            }
                   if (trimResult.playerFour) {

                                                                   for(let j =0; j<trimResult.playerFourAmount;j++) {
                                                                       appendToGameDisplay(`\n`);
                                                                       appendToGameDisplay(`Player Four, you must trim your hand, choose the index of the card you would like to discard.`);
                                                                       const userResponse = await getUserInput();
                                                                       let trimIndex = parseInt(userResponse, 10);
                                                                       let playerFour = "playerFour";
                                                                       await fetch(`${apiBaseUrl}/trimHand`, {method:"POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({index:trimIndex,player:playerFour}),});
                                                                       const finalTrim = await fetch(`${apiBaseUrl}/finishQuest`, { method: "POST" });
                                                                                   const trimmedResult = await finalTrim.json();
                                                                                   updatePlayerHands(trimmedResult);
                                                                   }
                                                           }
                    appendToGameDisplay(`\n Trimming is done. You may continue`);
                } catch (error) {
                    console.error("Error in trimhand", error);
                }
}
function updateGameDisplay(message) {
    const gameDisplay = document.getElementById("game-display");
    gameDisplay.value = message;
    gameDisplay.scrollTop = gameDisplay.scrollHeight;
}
function updateWinnerDisplay(message) {
    const winnerDisplay = document.getElementById("winners");
    winnerDisplay.value = message;
    winnerDisplay.scrollTop = winnerDisplay.scrollHeight;
}

function updateTurnDisplay(currentTurn) {
    const turnDisplay = document.getElementById("current-turn");
    turnDisplay.innerText = `It is Player ${currentTurn}'s turn.`;
}

function updatePlayerHands(result) {

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
        updatePlayerHands(result);
        document.getElementById("event-message").innerText =
            "Event: Prosperity! Each player has drawn 2 new cards.";

    } catch (error) {
        console.error("Error in handleProsperity:", error);
        updateGameDisplay("Error: Failed to handle Prosperity event.");
    }
}
async function handleRiggedProsperity() {
    try {
        const response = await fetch(`${apiBaseUrl}/drawRiggedProsperity`, { method: "POST" });
        const result = await response.json();
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
        updatePlayerHands(result);
        document.getElementById("event-message").innerText = "Event: Queen's Favor! The current player has drawn 2 new cards.";
    } catch(error) {
        console.error("Error in handleQueensFavour:", error);
        updateGameDisplay("Error: Failed to handle Queen's Favor");
    }
}
async function handleRiggedQueensFavor() {
    try {
        const response = await fetch(`${apiBaseUrl}/drawRiggedQueensFavor`, {method: "POST" });
        const result = await response.json();
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
function appendToWinnerDisplay(message) {
    const winnerDisplay = document.getElementById("winners");
    winnerDisplay.value += message;
    winnerDisplay.scrollTop = winnerDisplay.scrollHeight;
}
async function determineSponsor(card) {
    let sponsorFound = false;
    let playerIndex = currentPlayerIndex;
    let attempts = 0;
    const userInputField = document.getElementById("user-input");
    while (attempts < playerList.length && !sponsorFound) {
        const player = playerList[playerIndex];
        updateGameDisplay(`Player ${player + 1}, would you like to sponsor the quest card: ${card}? (yes/no)`);
        const response = await askPlayerForSponsorship(card);
        if (response.toLowerCase() === "yes") {
            sponsorFound = true;
            appendToGameDisplay(`Player ${player + 1} has chosen to sponsor the quest card: ${card}`);
            handleSponsorship(card,player);
        } else {
            appendToGameDisplay(`Player ${player + 1} has declined to sponsor the quest.`);
            playerIndex = (playerIndex + 1) % playerList.length;
            attempts++;
        }
    }
    if (!sponsorFound) {
        appendToGameDisplay("All players have declined to sponsor the quest. The quest is not sponsored.");
        currentPhase = "startedGame";
        await fetch(`${apiBaseUrl}/nextPlayerTurn`, { method: "POST" });
        currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
        updateTurnDisplay(currentPlayerIndex + 1)
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

async function handleSponsorship(card, player) {
    appendToGameDisplay(`Sponsorship for ${card} has been processed.`);
    let playerIndexPlaceholder = 0;
    let selectedSponsorIndices = [];
    let selectedAttackIndices = [];
    for(let i =0; i<playerList.length;i++){
        if(player === playerList[i]){
            playerIndexPlaceholder = i;
        }
    }
    try{
        const response = await fetch (`${apiBaseUrl}/startQuest`, {method: "POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({sponsorPlayerIndex: playerIndexPlaceholder}), });
        if(!response.ok){
            const errorMessage = await response.text();
            throw new Error("Failed to make quest");
        }
    const stageNumbers = getStageNumber(card);
    let stages = [];
    const userInputField = document.getElementById("user-input");
    userInputField.value = "";
    updateGameDisplay("");
    for(let i =0; i< stageNumbers; i++) {
        appendToGameDisplay(`Choose the indices of cards you would like to sponsor for stage ${i + 1}. Enter indices separated by commas (e.g., "3,5")`);
        const userResponse = await getUserInput();
        const indices = userResponse.split(",").map((index) => parseInt(index.trim())).filter((num) => !isNaN(num));
        if (indices.length === 0) {
            appendToGameDisplay("Invalid input. Please enter valid card indices.");
            i--;
            continue;
        }
        selectedSponsorIndices.push(indices);
        try {
            const addStageResponse = await fetch(`${apiBaseUrl}/addStage`, {method:"POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({
                    sponsorPlayerIndex:currentPlayerIndex,selectedIndices: indices,}),});
                    if(!addStageResponse.ok) {
                        const errorMessage = await addStageResponse.text();
                        appendToGameDisplay(`Error adding stage ${i+1}: ${errorMessage}`);
                        i--;
                    }
                    appendToGameDisplay(`Stage ${i+1} added successfully`);
                    stages.push(indices);
        } catch (error) {
            appendToGameDisplay(`Unexpected error adding stage ${i + 1}`);
            console.error("Error adding stage:", error);
            i--;
        }
    }
    try {
        const makeResponse = await fetch(`${apiBaseUrl}/makeQuest`, {method:"POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({
                    sponsorPlayerIndex:currentPlayerIndex}),});
            if(!makeResponse.ok){
                const errorMessage = await makeResponse.text();
                console.error("Error while making quest")
                throw new Error("Failed to make quest");
            }
            const makeResult = await makeResponse.json();
            appendToGameDisplay("Quest made successfully");
            const questResponse = await fetch (`${apiBaseUrl}/getQuest`);
            if(questResponse.ok){
                const quest = await questResponse.json();
                await handleQuestParticipation(quest);
            } else {
                console.error("failed to fetch quest");
            }
    const checkForWinners = await fetch(`${apiBaseUrl}/checkWinners`, {method: "POST"});
    const checkWinnersJson = await checkForWinners.json();
    if(checkWinnersJson.playerOne || checkWinnersJson.playerTwo || checkWinnersJson.playerThree || checkWinnersJson.playerFour) {
        if(checkWinnersJson.playerOne){
                                        if(!winnerList.includes(1)){
                                          winnerList.push(1);
                                        }
                                    }
                                    if(checkWinnersJson.playerTwo){
                                        if(!winnerList.includes(2)){
                                                                          winnerList.push(2);
                                                                        }
                                    }
                                    if(checkWinnersJson.playerThree){
                                        if(!winnerList.includes(3)){
                                                                          winnerList.push(3);
                                                                        }
                                    }
                                    if(checkWinnersJson.playerFour){
                                        if(!winnerList.includes(4)){
                                                                          winnerList.push(4);
                                                                        }
                                    }
                                    for(let i =0; i<winnerList.length;i++) {
                                        appendToGameDisplay(`\n Player ${winnerList[i]} has won the game. Congratulations.`);
                                        appendToWinnerDisplay(`Player ${winnerList[i]} `)
                                    }
    }
    appendToGameDisplay(`The quest has finished and the sponsor player ${currentPlayerIndex + 1} is discarding cards and drawing cards`);
    let allIndices = selectedSponsorIndices.flat();
    if(rigged) {
        await fetch(`${apiBaseUrl}/useRiggedSponsorIndices`, {method: "POST", headers: {"Content-Type": "application/json"},body: JSON.stringify({indices:allIndices, player: currentPlayerIndex}),});
        await fetch(`${apiBaseUrl}/useRiggedStageDraw`, {method: "POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({number: stageNumbers, player: currentPlayerIndex}),});
    } else {
        await fetch(`${apiBaseUrl}/useSponsorIndices`, {method: "POST", headers: {"Content-Type": "application/json"},body: JSON.stringify({indices:allIndices, player: currentPlayerIndex}),});
        await fetch(`${apiBaseUrl}/useStageDraw`, {method: "POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({number: stageNumbers, player: currentPlayerIndex}),});

    }
    const updateHandResponseAfterQuest = await fetch(`${apiBaseUrl}/finishQuest`, { method: "POST" });
    const handResultAfterQuest = await updateHandResponseAfterQuest.json();
    updatePlayerHands(handResultAfterQuest);
    await trimHands();
    const updateHandResponse = await fetch(`${apiBaseUrl}/finishQuest`, { method: "POST" });
    const handResult = await updateHandResponse.json();
    await fetch(`${apiBaseUrl}/nextPlayerTurn`, { method: "POST" });
    updatePlayerHands(handResult);
    currentPlayerIndex = (currentPlayerIndex + 1) % playerList.length;
    updateTurnDisplay(currentPlayerIndex + 1);

    }catch(error) {
        console.erroor("Error making quest")
    }
    } catch (error) {
        console.error("Error during quest sponsorship");
    }



}

async function handleQuestParticipation(quest) {
    const withdrawnPlayers = new Set();
    const playerSuccess ={};
    for (let stageIndex = 0; stageIndex < quest.stages.length; stageIndex++) {
        const currentStage = quest.stages[stageIndex];
        appendToGameDisplay(`Stage ${stageIndex + 1}: Do you want to participate in this stage?`);
        const sponsorIndex = playerList.indexOf(quest.sponsor);
        let startIndex = (sponsorIndex + 1) % playerList.length;
        for (let i = 0; i < playerList.length; i++) {
            let startPlayerIndex = (startIndex + i) % playerList.length;
            if (startPlayerIndex === currentPlayerIndex || withdrawnPlayers.has(startPlayerIndex)) continue;
            const player = playerList[startPlayerIndex];
            appendToGameDisplay(`Player ${startPlayerIndex + 1}, do you want to participate in Stage ${stageIndex + 1}? (Continue/Withdraw)`);
            const userResponse = await getUserInput();
            if (!playerSuccess[startPlayerIndex]) {
                playerSuccess[startPlayerIndex] = [];
            }
            if (userResponse.toLowerCase() === "continue") {
                appendToGameDisplay(`Player ${startPlayerIndex + 1} has chosen to participate in Stage ${stageIndex + 1}.`);
                let placeholder = "";
                if(startPlayerIndex === 0){
                    placeholder = "playerOne";
                } else if(startPlayerIndex === 1) {
                    placeholder = "playerTwo";
                } else if(startPlayerIndex === 2) {
                    placeholder = "playerThree";
                } else if(startPlayerIndex === 3) {
                    placeholder = "playerFour"
                }
                appendToGameDisplay(`Player ${startPlayerIndex + 1} has drawn a card`);
                if(rigged){
                    await fetch(`${apiBaseUrl}/riggedDrawAdventureCard`, {method:"POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({player:placeholder}),});

                } else {
                    await fetch(`${apiBaseUrl}/drawAdventureCard`, {method:"POST", headers: {"Content-Type": "application/json"}, body: JSON.stringify({player:placeholder}),});

                }
                const updateHandResponse = await fetch(`${apiBaseUrl}/finishQuest`, { method: "POST" });
                            const handResult = await updateHandResponse.json();
                            updatePlayerHands(handResult);
                await trimHands();
                await updateParticipation(startPlayerIndex, stageIndex, "continue");
                appendToGameDisplay(`Player ${startPlayerIndex +1} please choose the indices of cards you would like to use for your attack separted by a comma. E.g(3,5)`);
                const attackResponse = await getUserInput();
                const indices = attackResponse.split(",").map((index) => parseInt(index.trim())).filter((num) => !isNaN(num));
                //selectedAttackIndices.push(indices);
                //let allAttackIndices = selectedAttackIndices.flat();

                const response = await fetch(`${apiBaseUrl}/submitAttack`, {method: 'POST',headers: {'Content-Type': 'application/json'},body: JSON.stringify({playerIndex: startPlayerIndex,stageIndex: stageIndex,selectedCardIndices: indices})});
                    if (response.ok) {
                        const result = await response.text();
                        appendToGameDisplay(result);
                        if (result.includes("failed")) {
                            withdrawnPlayers.add(startPlayerIndex);
                            appendToGameDisplay(result);
                            playerSuccess[startPlayerIndex][stageIndex] = false;
                            //await updateParticipation(startPlayerIndex, stageIndex, "withdraw");
                        } else {
                            playerSuccess[startPlayerIndex][stageIndex] = true;
                        }
                        //await fetch(`${apiBaseUrl}/useAttackIndices`, {method: "POST", headers: {"Content-Type": "application/json"},body: JSON.stringify({indices:allAttackIndices, player: startPlayerIndex}),});
                        //const updateHandResponse = await fetch(`${apiBaseUrl}/finishQuest`, { method: "POST" });
                        //const handResult = await updateHandResponse.json();
                        //selectedAttackIndices.length = 0;
                    }else {
                        playerSuccess[startPlayerIndex][stageIndex] = false;
                    }
                /////UPDATE HANDS
                const updateHandAttackResponse = await fetch(`${apiBaseUrl}/finishQuest`, { method: "POST" });
                const handAttackResult = await updateHandAttackResponse.json();
                updatePlayerHands(handAttackResult)
            } else if(userResponse.toLowerCase() === "withdraw"){
                appendToGameDisplay(`Player ${startPlayerIndex + 1} has chosen not to participate in Stage ${stageIndex + 1}.`);
                withdrawnPlayers.add(startPlayerIndex);
                playerSuccess[startPlayerIndex][stageIndex] = false;
                await updateParticipation(startPlayerIndex, stageIndex, "withdraw");
            }

        }

    }
    const winningPlayers = [];
        for (let playerIndex in playerSuccess) {
            if (playerSuccess[playerIndex].every(success => success === true)) {
                winningPlayers.push(`Player ${parseInt(playerIndex) + 1}`);
            }
        }

        appendToGameDisplay(`The players who won the quest are: ${winningPlayers.join(', ')}`);
        appendToGameDisplay("All players have decided whether to participate in the stages.");
    try {
            const response = await fetch(`${apiBaseUrl}/finishQuest`, { method: "POST" });
            const result = await response.json();
            updatePlayerHands(result);
            document.getElementById("event-message").innerText ="Event: Quest Finished! Shields awarded to the winning players!";

        } catch (error) {
            console.error("Error in finishQuest:", error);
            updateGameDisplay("Error: Failed to handle finished quest event.");
        }


}
function getStageNumber(card) {
    const questMatch = card.match(/^Quest (\d+)$/);
    if(questMatch) {
        return parseInt(questMatch[1],10)
    }
    return null;
}
async function getUserInput() {
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
async function updateParticipation(playerIndex, stageIndex, decision){
    const response = await fetch(`${apiBaseUrl}/updateParticipation`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ playerIndex: playerIndex, stageIndex: stageIndex, decision: decision }),
        });
        if (!response.ok) {
            console.error("Failed to update player participation");
        }
}
