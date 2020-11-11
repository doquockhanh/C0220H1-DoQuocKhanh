class Map {
    constructor(x, y, width, height) {
        this.createBrick = function () {
            this.brick = [];
            for (let i = x; i < x + width; i += 5) {
                this.brick[i] = [];
                for (let j = y; j < y + height; j += 5) {
                    this.brick[i][j] = {x: 0, y: 0};
                    this.brick[i][j].x = i;
                    this.brick[i][j].y = j;
                    this.brick[i][j].width = 10;
                    this.brick[i][j].height = 10;
                    this.brick[i][j].value = 1;
                }
            }
        };

        this.checkCollision = function () {
            for (let i = x; i < x + width; i += 10) {
                for (let j = y; j < y + height; j += 10) {
                    if (game.bullet !== null) {
                        if (game.bullet.x + game.bullet.width >= this.brick[i][j].x && game.bullet.x <= this.brick[i][j].x + this.brick[i][j].width) {
                            if (game.bullet.y + game.bullet.height >= this.brick[i][j].y && game.bullet.y <= this.brick[i][j].y + this.brick[i][j].height) {
                                this.brick[i][j] = 0;
                                flag3 = false;
                            }
                        }
                    }
                }
            }
        };

        this.draw = function () {
            for (let i = x; i < x + width; i += 10) {
                for (let j = y; j < y + height; j += 10) {
                    if (this.brick[i][j].value === 1) {
                        context.beginPath();
                        context.fillStyle = "gray";
                        context.fillRect(this.brick[i][j].x, this.brick[i][j].y, this.brick[i][j].width, this.brick[i][j].height);
                        context.stroke();
                    }
                }
            }
            context.fillStyle = "black";
        }
    }
}

class NewBullet {
    constructor(angle, bulletpower, x, y) {
        this.power = bulletpower;
        this.angle = angle;
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;
        this.gravity = 0.1;

        this.vY = -this.power * 60 / 1000 * Math.sin(Math.PI * this.angle / 180);
        this.vX = this.power * 60 / 1000 * Math.cos(Math.PI * this.angle / 180);
        this.update = function () {
            time += 60 / 1000;
            this.x += this.vX;
            this.y += this.vY;
            this.vY += this.gravity;
            this.vX -= time * windPower;
        };

        this.draw = function (context) {
            if (flag3 === true) {
                context.beginPath();
                context.rect(this.x + 5, this.y, this.width, this.height);
                context.stroke();
            }
        }
    }
}

class Character {
    constructor(x, y, name, angle) {
        this.x = x;
        this.y = y - 10;
        this.width = 15;
        this.height = 35;
        this.name = name;
        this.lastConfig = {
            power: 0,
            angle: angle
        };
        this.power = function () {
            if (this.lastConfig.power > 299) {
                flag2 = false;
            } else if (this.lastConfig.power === 0) {
                flag2 = true;
            }
            if (flag2 === true) {
                this.lastConfig.power += 2;
            } else {
                this.lastConfig.power -= 2;
            }
        };
        this.moveLeft = function () {
            if (flag5 === false) {
                this.lastConfig.angle = 90 + (90 - angle);
            }
            flag5 = true;

            if (this.x + this.width > 600 && this.x < 675) {
                this.x = 670;
            } else {
                if (this.x > 0) {
                    this.x -=2;
                }
            }
        };
        this.moveRight = function () {
            if (flag5 === true) {
                this.lastConfig.angle = 90 - (90 - angle)
            }
            flag5 = false;

            if (this.x + this.width > 600 && this.x < 675) {
                this.x = 585;
            } else {
                if (this.x < 1490 - this.width) {
                    this.x +=2;
                }
            }
        };

        this.draw = function (context) {
            context.beginPath();
            //ve nhan vat
            context.rect(this.x, this.y, this.width, this.height);
            context.rect(500, 650, 300, 20);

            //ve ten
            context.fillText(this.name, this.x + this.width / 2 - context.measureText(this.name).width / 2, this.y - this.height );

            //ve ra thang luc
            context.fillText("POWER ", 450, 665);
            context.fillRect(500, 650, this.lastConfig.power, 20);
            context.moveTo(500 + recentPower, 650);
            context.lineTo(500 + recentPower, 670);

            //ve ra sung
            context.moveTo(this.x + this.width / 2, this.y + 7);
            context.lineTo(this.x + this.width / 2 + 30 * Math.cos(-Math.PI * this.lastConfig.angle / 180), this.y + 7 + 30 * Math.sin(-Math.PI * this.lastConfig.angle / 180));
            context.stroke();

            //xac dinh nguoi thang
            if (game.status === GAME_OVER) {
                if (flag4) {
                    context.fillText(game.characters[1].name + " WIN", 500, 300,)
                } else {
                    context.fillText(game.characters[0].name + " WIN", 500, 300,)
                }
            }
        }
    }
}

const GAME_PLAYING = 0;
const GAME_OVER = 1;

class Game {
    constructor() {
        this.status = GAME_PLAYING;
        this.maps = [
            new Map(0, 575, 1490, 50),
            new Map(600, 395, 70, 175),
            new Map(Math.random() * 100 + 50, 200, 100, 25),
            new Map(Math.random() * 100 + 1000, 200, 100, 25),
            new Map(Math.random() * 100 + 250, 300, 100, 25),
            new Map(Math.random() * 100 + 800, 300, 100, 25)
        ];
        this.characters = [
            new Character(300, 550, "player1", 45),
            new Character(900, 550, "player2", 45)
        ];
        this.currentPlayer = this.characters[0];
        this.bullet = null;
        this.config = this.currentPlayer.lastConfig;
        this.maps.forEach((map) => map.createBrick());

        this.update = function () {
            if (this.status === GAME_PLAYING) {

                if (this.bullet) {
                    this.bullet.update();
                    if (flag3 === false) {
                        flag1 = true;
                        recentPower = this.config.power;
                        this.config.power = 0;
                        this.bullet = null;
                        this.switchPlayer();
                    }
                }
            }
        };

        this.checkCollision = function () {
            for (let j = 0; j < this.characters.length; j++) {
                if (game.bullet.x + game.bullet.width >= this.characters[j].x && game.bullet.x <= this.characters[j].x + this.characters[j].width/2) {
                    if (game.bullet.y + game.bullet.height >= this.characters[j].y && game.bullet.y <= this.characters[j].y + this.characters[j].height) {
                        if (j === 0) {
                            flag4 = true;
                        } else if (j === 1) {
                            flag4 = false;
                        }
                        this.status = GAME_OVER;
                    }
                }
            }
            this.maps.forEach((map) => map.checkCollision());

            if (this.bullet.y > 700) {
                flag3 = false;
            }

        };

        this.onKeyPress = function (keyCode) {
            if (keyCode === KEY_CODE_RIGHT) {
                this.currentPlayer.moveRight();
            } else if (keyCode === KEY_CODE_LEFT) {
                this.currentPlayer.moveLeft();
            } else if (keyCode === KEY_CODE_UP) {
                if (this.config.angle < 225) {
                    this.config.angle += 2;
                }
            } else if (keyCode === KEY_CODE_DOWN) {
                if (this.config.angle > -45) {
                    this.config.angle -= 2;
                }
            } else if (keyCode === KEY_CODE_SPACE) {
                if (flag1 === true) {
                    this.currentPlayer.power();
                }
            }
        };

        this.onKeyUp = function (keyCode) {
            if (keyCode === KEY_CODE_SPACE) {
                flag1 = false;
                this.fire();
                flag3 = true;
                check();
            }
        };

        this.fire = function () {
            if (this.bullet === null) {
                this.bullet = new NewBullet(
                    this.config.angle,
                    this.config.power,
                    this.currentPlayer.x + 30 * Math.cos(-Math.PI * this.currentPlayer.lastConfig.angle / 180),
                    this.currentPlayer.y + 30 * Math.sin(-Math.PI * this.currentPlayer.lastConfig.angle / 180)
                );
            }
        };

        this.switchPlayer = function () {
            this.currentPlayer.lastConfig = this.config;
            windPower = Math.random() * 0.015 - Math.random() * 0.015;
            time = 0;

            if (this.currentPlayer === this.characters[0]) {
                this.currentPlayer = this.characters[1];
            } else {
                this.currentPlayer = this.characters[0];
            }
            this.config = this.currentPlayer.lastConfig;
        };

        this.draw = function (context) {
            context.beginPath();
            context.clearRect(0, 0, 2000, 2000);
            context.drawImage(background,0,0,1490,700);
            this.maps.forEach((map) => map.draw());
            this.characters[0].draw(context);
            this.characters[1].draw(context);
            if (this.bullet) this.bullet.draw(context);
            context.fillText("Angle = " + this.config.angle, 20, 20);
            context.fillText("Power = " + this.config.power, 20, 40);
            context.fillText("Playing: " + this.currentPlayer.name, 1200, 25);

            context.font = "15px arial";
            context.fillText("windpower", 580, 25, 100);
            if (windPower > 0) {
                context.fillText("<<<<", 550, 50, 50);
                context.fillText("" + parseInt(windPower * 10000), 600, 50, 50);
            } else if (windPower < 0) {
                context.fillText(">>>>", 650, 50, 50);
                context.fillText("" + parseInt(windPower * -10000), 600, 50, 50);
            } else {
                context.fillText("" + parseInt(windPower * 10000), 600, 50, 50);
            }
            context.font = "12px arial"
        };
    }
}

const KEY_CODE_RIGHT = 39;
const KEY_CODE_LEFT = 37;
const KEY_CODE_UP = 38;
const KEY_CODE_DOWN = 40;
const KEY_CODE_SPACE = 32;
let recentPower;
let flag1 = true;
let flag2 = true;
let flag3 = true;
let flag4;
let flag5 = false;
let time = 0;
let windPower = Math.random() * 0.015 - Math.random() * 0.015;
