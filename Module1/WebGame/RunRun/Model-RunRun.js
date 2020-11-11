class Map {
    constructor(x, y) {
        this.x = x;
        this.y = y;
        this.width = 150;
        this.height = 30;

        this.update = function (map) {
            if (map.x > 0 - map.width) {
                map.x -= 2;
            } else map.x = 1000
        };

        this.draw = function (map) {
            ctx.beginPath();
            ctx.drawImage(bar, map.x, map.y, map.width, map.height);
        }
    }
}

const RUNMAN_IN_LAND = 0;
const RUNMAN_IN_AIR = 1;

class RunMan {
    constructor() {
        this.x = 200;
        this.y = 100;
        this.width = 40;
        this.height = 40;
        this.time = 0;
        this.vY = 20;
        this.jump = false;
        this.direction = null;
        this.energy = 30;

        let a = this.vY;
        this.update = function () {
            this.time += 30 / 1000;
            // dieu kien dau cua IF dang xai tam
            // xu li bay
            if (this.y < 800 - this.height && this.jump === false && this.direction !== RUNMAN_IN_LAND) {
                this.y += 5 * Math.abs(this.time);
            }

            if (this.y >= 700) {
                game.status = GAME_OVER;
            }

            //xu li roi cua nhan vat
            if (this.jump === true && this.vY > 0.5) {
                this.time += 30 / 1000;
                this.vY = a - 25 * this.time;
                this.y -= this.vY;
            } else {
                this.jump = false;
                game.runMan.vY = 50;
            }

            // xu li nang luong
            if (game.runMan.direction === RUNMAN_IN_LAND) {
                game.runMan.energy = 30;
            }
        };

        this.draw = function () {
            ctx.beginPath();
            ctx.drawImage(runMan, this.x, this.y, this.width + 5, this.height + 5);
            ctx.fillRect(this.x - 15, this.y - 20, this.energy * 3, this.height / 6);

        }
    }
}

const GIFT_RANDOM_COINT = 0;
const GIFT_RANDOM_BIG_COINT = 1;
const SECRECT_GIFT_FROM_JOKER = 2;

class Present {
    constructor() {
        this.x = 1000;
        this.y = Math.random() * 270 + 100;
        this.width = 50;
        this.height = 50;
        this.type = null;

        this.update = function () {
            if (this.x > 0 - game.presentBox.width) {
                this.x -= 5;
            } else game.boxExist = null;
        };

        this.draw = function () {
            if (game.boxExist === BOX_EXIST) {
                ctx.beginPath();
                ctx.drawImage(present, this.x, this.y, this.width, this.height);
            }
        }
    }
}

const GAME_PLAYING = 3;
const GAME_STOP = 4;
const GAME_OVER = 5;
const BOX_EXIST = 6;

//class BombBox

//minh can 1 bien de giu gia tri xuat hien cua box vi sau 10s box luon luon ton tai
//set true luc cham phai box lan dau
let boxInstace = false;

class Game {
    constructor() {
        this.status = GAME_PLAYING;
        this.presentBox = null;
        this.boxExist = null;

        this.map = [new Map(500, 500)];

        this.runMan = new RunMan();

        this.update = function () {
            if (game.status === GAME_PLAYING) {
                game.map.forEach(map => map.update(map));
                game.runMan.update();
                if (this.boxExist === BOX_EXIST) {
                    game.presentBox.update();
                }
            }
        };

        this.draw = function () {
            ctx.clearRect(0, 0, 1500, 1000);
            ctx.drawImage(backGround, 0, 0, 1000, 700);
            game.map.forEach(map => map.draw(map));
            game.runMan.draw();
            if (this.boxExist === BOX_EXIST) {
                game.presentBox.draw();
            }

            // ve diem
            ctx.beginPath();
            ctx.fillStyle = "black";
            ctx.font = "16px arial";
            ctx.fillText("score : " + score, 880, 20, 100);

            //ve vai hieu ung tang qua

            ctx.font = "18px arial";
            if (boxInstace === true) {
                if (game.presentBox.type === GIFT_RANDOM_COINT) {
                    for (let i = 0; i < 10; i++) {
                        ctx.fillText("quà bí ấn + " + giftValue + " coint", 400, 300);
                    }
                } else if (game.presentBox.type === GIFT_RANDOM_BIG_COINT) {
                    for (let i = 0; i < 10; i++) {
                        ctx.fillText("quà bí ấn + " + giftValue + " coint", 400, 300);
                    }
                } else if (game.presentBox.type === SECRECT_GIFT_FROM_JOKER) {
                    ctx.font = "22px arial";
                    ctx.fillText("quà từ joker", 400, 300);
                }
            }

            // game Over

            if(game.status === GAME_OVER){
                ctx.font = "26px arial";
                ctx.fillText("GAME OVER!", 400,250);
            }
        };

        this.checkCollision = function () {
            if (game.runMan.jump === false) {
                game.map.forEach(map => mapAndRunman_collision(game.runMan, map));
            }

            if (game.boxExist === BOX_EXIST) {
                runManAndPresent_colission(game.runMan, game.presentBox);
            }
        };

        this.onKeyUpDown = function () {
            if (game.runMan.energy >= 10) {
                game.runMan.time = 0;
                game.runMan.jump = true;
                game.runMan.direction = RUNMAN_IN_AIR;
            } else game.runMan.time = 0
        };
    }
}
