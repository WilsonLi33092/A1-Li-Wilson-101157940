
const { Builder, By, until } = require('selenium-webdriver');

async function runRiggedDeck1Winner() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await driver.get('http://127.0.0.1:8081');
        await driver.sleep(1000);
        let startButton = await driver.findElement(By.xpath("//button[contains(text(), 'RiggedDeck1W')]"));
        await startButton.click();
//        await driver.sleep(1000);
        let drawButton = await driver.findElement(By.xpath("//button[contains(text(), 'RiggedDrawCard')]"));
        await drawButton.click();
//        await driver.sleep(1000);
        let inputField = await driver.findElement(By.xpath("//input[@placeholder='Enter command here...']"));
        await inputField.sendKeys("yes");
//        await driver.sleep(1000);
        let submitButton = await driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("2");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("4");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("6");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("2");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("2");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("3");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("5");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("5");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("6");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("7");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("7");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("8");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("9");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("9");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("10");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("1");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("1");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await drawButton.click();
//        await driver.sleep(1000);
        await drawButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000)
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000)
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000)
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000)
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000)
        await submitButton.click();
//        await driver.sleep(1000);
        await drawButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("1");
//        await driver.sleep(1000);
        await submitButton.click()
//        await driver.sleep(1000);
        await inputField.sendKeys("3");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await drawButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("yes");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("1,8");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("5,9");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("8");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("8");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("9");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("9,7");
//        await driver.sleep(1000);
        await submitButton.click()
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("9,4");
//        await driver.sleep(1000);
        await submitButton.click()
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("9,4");
//        await driver.sleep(1000);
        await submitButton.click()
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("10");
//        await driver.sleep(1000);
        await submitButton.click()
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click()
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
        await driver.sleep(1000);
        console.log("1 Winner Game With Events: ")
        let winners = await driver.findElement(By.id('winners')).getAttribute('value');
        let playerOneHand = await driver.findElement(By.id('player-one-hand')).getText();
        let playerTwoHand = await driver.findElement(By.id('player-two-hand')).getText();
        let playerThreeHand = await driver.findElement(By.id('player-three-hand')).getText();
        let playerFourHand = await driver.findElement(By.id('player-four-hand')).getText();
        if(playerOneHand.includes("Foe 25, Foe 25, Foe 35, Dagger 5, Dagger 5, Sword 10, Sword 10, Sword 10, Sword 10, Horse 10, Horse 10, Horse 10")) {
            console.log("Player One Hand Result Passed");
        }
        if(playerTwoHand.includes("Foe 15, Foe 25, Foe 30, Foe 40, Sword 10, Sword 10, Sword 10, Horse 10, Excalibur 50")){
            console.log("Player Two Hand Result Passed");
        }
        if(playerThreeHand.includes("Foe 10, Foe 25, Foe 30, Foe 40, Foe 50, Sword 10, Sword 10, Horse 10, Horse 10, Lance 20")) {
            console.log("Player Three Hand Result Passed");
        }
        if(playerFourHand.includes("Foe 25, Foe 25, Foe 30, Foe 50, Foe 70, Dagger 5, Dagger 5, Sword 10, Sword 10, Battle-Axe 15, Lance 20")){
            console.log("Player Four Hand Result Passed");
        }
        if(winners.includes("Player 3") && !winners.includes("Player 1")&& !winners.includes("Player 2") && !winners.includes("Player 4")){
            console.log("Winners Result Passed : \n Player 3 Winner Passed \n Player 1 Non-winner passed \n Player 2 Non-winner passed \n Player 4 Non-winner passed");
        }

    } catch (error) {
        console.error("Test encountered an error:", error);
    } finally {
        await driver.quit();
    }
}
async function runRiggedDeck0Winner() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await driver.get('http://127.0.0.1:8081');
        await driver.sleep(1000);
        let startButton = await driver.findElement(By.xpath("//button[contains(text(), 'RiggedDeck0W')]"));
        await startButton.click();
//        await driver.sleep(1000);
        let drawButton = await driver.findElement(By.xpath("//button[contains(text(), 'RiggedDrawCard')]"));
        await drawButton.click();
//        await driver.sleep(1000);
        let inputField = await driver.findElement(By.xpath("//input[@placeholder='Enter command here...']"));
        await inputField.sendKeys("yes");
//        await driver.sleep(1000);
        let submitButton = await driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0,2,4,6,8,10");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("1,3,5,7,9,11");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("11");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("3");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("2");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
        await driver.sleep(1000);

        console.log("0 Winner Quest: ")
        let winners = await driver.findElement(By.id('winners')).getAttribute('value');
                let playerOneHand = await driver.findElement(By.id('player-one-hand')).getText();
                let playerTwoHand = await driver.findElement(By.id('player-two-hand')).getText();
                let playerThreeHand = await driver.findElement(By.id('player-three-hand')).getText();
                let playerFourHand = await driver.findElement(By.id('player-four-hand')).getText();
                if(playerOneHand.includes("Foe 15, Dagger 5, Dagger 5, Dagger 5, Dagger 5, Sword 10, Sword 10, Sword 10, Horse 10, Horse 10, Horse 10, Horse 10")) {
                    console.log("Player One Hand Result Passed");
                }
                if(playerTwoHand.includes("Foe 5, Foe 5, Foe 10, Foe 15, Foe 15, Foe 20, Foe 20, Foe 25, Foe 30, Foe 30, Foe 40")){
                    console.log("Player Two Hand Result Passed");
                }
                if(playerThreeHand.includes("Foe 5, Foe 5, Foe 10, Foe 15, Foe 15, Foe 20, Foe 20, Foe 25, Foe 25, Foe 30, Foe 40, Lance 20")) {
                    console.log("Player Three Hand Result Passed");
                }
                if(playerFourHand.includes("Foe 5, Foe 5, Foe 10, Foe 15, Foe 15, Foe 20, Foe 20, Foe 25, Foe 25, Foe 30, Foe 50, Excalibur 50")){
                    console.log("Player Four Hand Result Passed");
                }
                if(!winners.includes("Player 3") && !winners.includes("Player 1")&& !winners.includes("Player 2") && !winners.includes("Player 4")){
                    console.log("Winners Result Passed : \n No one won passed");
                }
    } catch (error) {
        console.error("Test encountered an error:", error);
    } finally {
        await driver.quit();
    }
}
async function runRiggedDeck2Winner() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await driver.get('http://127.0.0.1:8081');
        await driver.sleep(1000);
        let startButton = await driver.findElement(By.xpath("//button[contains(text(), 'RiggedDeck2W')]"));
        await startButton.click();
//        await driver.sleep(1000);
        let drawButton = await driver.findElement(By.xpath("//button[contains(text(), 'RiggedDrawCard')]"));
        await drawButton.click();
//        await driver.sleep(1000);
        let inputField = await driver.findElement(By.xpath("//input[@placeholder='Enter command here...']"));
        await inputField.sendKeys("yes");
//        await driver.sleep(1000);
        let submitButton = await driver.findElement(By.xpath("//button[contains(text(), 'Submit')]"));
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("1");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("1,6");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("2,7");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("3,9");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("5");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("5");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("3");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("3");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("6,4");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("6,4");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("5,6");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("5,6");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await drawButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("no");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
await inputField.sendKeys("yes");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("1,4");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("2,7");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("withdraw");
//        await driver.sleep(1000)
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000)
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("5");
//        await driver.sleep(1000)
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000)
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("5");
//        await driver.sleep(1000)
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click()
//        await driver.sleep(1000);
        await inputField.sendKeys("6");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("6");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("9");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("continue");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("9");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("0");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("1");
//        await driver.sleep(1000);
        await submitButton.click();
//        await driver.sleep(1000);
        await inputField.sendKeys("1");
//        await driver.sleep(1000);
        await submitButton.click();
        await driver.sleep(1000);
        console.log("2 Winner Game 2 Winner Quest: ")
        let winners = await driver.findElement(By.id('winners')).getAttribute('value');
                        let playerOneHand = await driver.findElement(By.id('player-one-hand')).getText();
                        let playerTwoHand = await driver.findElement(By.id('player-two-hand')).getText();
                        let playerThreeHand = await driver.findElement(By.id('player-three-hand')).getText();
                        let playerFourHand = await driver.findElement(By.id('player-four-hand')).getText();
                        if(playerOneHand.includes("Foe 15, Foe 15, Foe 20, Foe 20, Foe 20, Foe 20, Foe 25, Foe 25, Foe 30, Horse 10, Battle-Axe 15, Lance 20")) {
                            console.log("Player One Hand Result Passed");
                        }
                        if(playerTwoHand.includes("Foe 10, Foe 15, Foe 15, Foe 25, Foe 30, Foe 40, Foe 50, Lance 20, Lance 20")){
                            console.log("Player Two Hand Result Passed");
                        }
                        if(playerThreeHand.includes("Foe 20, Foe 40, Dagger 5, Dagger 5, Sword 10, Horse 10, Horse 10, Horse 10, Horse 10, Battle-Axe 15, Battle-Axe 15, Lance 20")) {
                            console.log("Player Three Hand Result Passed");
                        }
                        if(playerFourHand.includes("Foe 15, Foe 15, Foe 20, Foe 25, Foe 30, Foe 50, Foe 70, Lance 20, Lance 20")){
                            console.log("Player Four Hand Result Passed");
                        }
                        if(!winners.includes("Player 3") && !winners.includes("Player 1")&& winners.includes("Player 2") && winners.includes("Player 4")){
                            console.log("Winners Result Passed : \n Player 1 Non-winner Passed \n Player 2 winner passed \n Player 3 Non-winner passed \n Player 4 winner passed");
                        }
    } catch (error) {
        console.error("Test encountered an error:", error);
    } finally {
        await driver.quit();
    }
}
async function runAllTests() {
    let driver = await new Builder().forBrowser('chrome').build();
    try {
        await runRiggedDeck2Winner(driver);
        await runRiggedDeck1Winner(driver);
        await runRiggedDeck0Winner(driver);
    } catch (error) {
        console.error("Error running tests:", error);
    } finally {
        await driver.quit();
    }
}

runAllTests();
//runRiggedDeck2Winner();