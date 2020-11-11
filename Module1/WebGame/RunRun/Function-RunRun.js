function randomMap(map, i) {
    let a = map[i].x + 230;
    let b = Math.random() * 370 + 300;
    if (a !== map.forEach(map => map.x) && b !== map.forEach(map => map.y)) {
        game.map.push(new Map(a, b));
    }
}

function mapAndRunman_collision(runMan, map) {
    if (runMan.x + runMan.width > map.x && runMan.x < map.x + map.width) {
        if (runMan.y + runMan.height > map.y && runMan.y + runMan.height < map.y + map.height) {
            runMan.direction = RUNMAN_IN_LAND;
        } // code bi sai sai o 3 dong tren
    } else {
        if (runMan.y + runMan.height > map.y && runMan.y + runMan.height < map.y + map.height) {
            if (runMan.direction === RUNMAN_IN_LAND) {
                runMan.direction = RUNMAN_IN_AIR;
                runMan.time = 0;
            }
        }
    }
}

//khi đụng phải quà thì random ra quà
// và đây là biến
let secretGift = 0;

function runManAndPresent_colission(runMan, present) {
    if (runMan.x + runMan.width > present.x && runMan.x < present.x + present.width) {
        if (runMan.y + runMan.height > present.y && runMan.y < present.y + present.height) {
            game.boxExist = null;
            secretGift = parseInt(Math.random()*2.99 + 1+"");
            boxInstace = true;
            doSecretPresent(secretGift);
        }
    }
}

function timeJump() {
    if (game.runMan.energy >= 10) {
        game.runMan.energy -= 10;
        game.runMan.energy += 1;
    } else {
        game.runMan.energy += 1;
    }
}

function createGift() {
    game.presentBox = new Present();
    game.boxExist = BOX_EXIST;
    setTimeout(createGift, 10000);
}

let score = 0;

function gameScore() {
    if (game.status === GAME_PLAYING) {
        score += 50;
    }
    setTimeout(gameScore, 1000)
}

function doSecretPresent(typePresent) {
    switch (typePresent) {
        case 1:
            coinPresent();
            break;
        case 2:
            bigCointPresent();
            break;
        case 3:
            giftFromJoker();
            break;
    }
}

//tao bien giu lai gia tri random vua tao
let giftValue = 0;

function coinPresent() {
    giftValue = parseInt(Math.random() * 1500 + 500 + "");
    score += giftValue;
    game.presentBox.type = GIFT_RANDOM_COINT;
}

function bigCointPresent() {
    giftValue = parseInt(Math.random() * 5000 + 500 + "");
    score+= giftValue;
    game.presentBox.type = GIFT_RANDOM_BIG_COINT;
}

function giftFromJoker() {
    game.presentBox.type = SECRECT_GIFT_FROM_JOKER;
// tao ra doi tuong qua rieng cua joker
}