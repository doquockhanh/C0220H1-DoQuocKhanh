const MOVE_LEFT = 0;
const MOVE_RIGHT = 1;
let score = 0;
let hightScore = 0;

class Car {
    constructor() {
        this.x = 120;
        this.y = 300;
        this.width = 10;
        this.height = 20;
        this.direction = null;

        this.update = function () {
            // Khong che toa do
            if (this.direction === MOVE_LEFT) {
                if (this.x > 1) {
                    this.x -= 2;
                    this.width = 8.5;
                }
            } else if (this.direction === MOVE_RIGHT) {
                if (this.x < 240) {
                    this.x += 2;
                    this.width = 8.5;
                }
            }else if (this.direction === null){
                this.width = 10;
            }
        }
    }
}

class Rock {
    constructor(x, speed) {
        this.x = x;
        this.y = (Math.random() * 100) - 150;
        this.width = Math.random() * 10 + 5;
        this.height = Math.random() * 10 + 5;
        this.speed = speed;
        //  Cap nhat lai vi tri cua rock khi vuot qua man hinh
        this.update = function () {
            if (this.y < 350) {
                this.y += this.speed;
            } else {
                this.x = Math.random() * 240;
                this.y = -50;
                score++;
                if (hightScore < score) {
                    hightScore = score;
                }
            }
            if (this.speed - speed < 3) {
                this.speed += 0.0005;
            }
        }
    }
}

const GAME_STATUS_PLAYING = 1;
const GAME_STATUS_OVER = 2;


class Game {
    constructor() {
        this.size = {width: 250, height: 350};
        this.car = new Car();
        this.rocks = [
            new Rock(Math.random() * 240, 1),
            new Rock(Math.random() * 240, 1.2),
            new Rock(Math.random() * 240, 2),
            new Rock(Math.random() * 240, 1.4),
            new Rock(Math.random() * 240, 1.6),
            new Rock(Math.random() * 240, 1.8),
            new Rock(Math.random() * 240, 1.3),
            new Rock(Math.random() * 240, 1.5),
            new Rock(Math.random() * 240, 2.5),
            new Rock(Math.random() * 240, 4),
        ];
        this.status = GAME_STATUS_OVER;

        this.update = function () {
            if (this.status === GAME_STATUS_PLAYING) {
                this.car.update();
                for (let i = 0; i < this.rocks.length; i++) {
                    this.rocks[i].update();
                }
                this.check();
            }
        };

        //check lose
        this.check = function () {
            for (let i = 0; i < this.rocks.length; i++) {
                if (this.rocks[i].y >= (300 - this.rocks[i].height) && this.rocks[i].y <= 320) {
                    if ((this.rocks[i].x + this.rocks[i].width) >= this.car.x - 1 && this.rocks[i].x <= (this.car.x + this.car.width)) {
                        this.status = GAME_STATUS_OVER;
                    }
                }
            }
        };
//  Chinh huong car
        this.onLeftArrowPressed = function () {
            this.car.direction = MOVE_LEFT;
        };

        this.onRightArrowPressed = function () {
            this.car.direction = MOVE_RIGHT;
        };

        this.onLeftArrowUp = function () {
            this.car.direction = null;
        };

        this.onRightArrowUp = function () {
            this.car.direction = null;
        };

        this.onEnterButtonPressed = function () {
            if (game.status === GAME_STATUS_OVER) {
                score = 0;
                game = new Game();
                game.status = GAME_STATUS_PLAYING;
            }
        }
    }
}

let game = new Game();




