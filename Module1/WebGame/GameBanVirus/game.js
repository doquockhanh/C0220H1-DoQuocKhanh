class Plane {
    constructor() {
        this.x = Math.random() * 600 - 15;
        this.y = 10;
        this.width = 15;
        this.height = 15;
        this.vX = Math.random() + 1;
        this.vY = Math.random()*2 + 2;
        this.update = function () {
            if (this.x < 0) {
                 this.vX = -this.vX;
            } else if (this.x > 580) {
                this.vX = -this.vX;
            } else if (this.y < 0) {
                this.vY = -this.vY;
            } else if (this.y > 390) {
                this.vY = -this.vY;
            }
            this.x += this.vX;
            this.y += this.vY;
        }
    }
}

const MOVE_LEFT = 0;
const MOVE_RIGHT = 1;

class Tank {
    constructor() {
        this.x = 50;
        this.y = 390;
        this.width = 20;
        this.height = 10;
        this.direction = null;

        this.update = function () {
            if (this.direction === MOVE_LEFT) {
                if (this.x > 1) {
                    this.x -= 4;
                }
            } else if (this.direction === MOVE_RIGHT) {
                if (this.x < 580) {
                    this.x += 4;
                }
            }
            // console.log("tank " + this.x + " " + this.direction);
        }
    }
}


class Bullet {
    constructor(x, y) {
        this.width = 5;
        this.height = 5;
        this.x = x + 10;
        this.y = y;
        this.updateBulletsRight = function () {
            if (this.y > -20) {
                this.y -= 4;
            }
            if ( this. x < 600){
                this.x += 6;
            }
        };

        this.updateBulletsLeft = function () {
            if (this.y > -20) {
                this.y -= 4;
            }
            if ( this. x > -20){
                this.x -= 6;
            }
        };

        this.updateBulletsMid = function () {
            if (this.y > -20) {
                this.y -= 5;
            }
        }
    }
}

const GAME_PLAYING = 0;
const GAME_OVER = 1;
let score = 0;
let hightScore = 0;
let dem = 0;

class Game {
    constructor() {
        this.tank = new Tank();
        this.planes = [
            new Plane(Math.random() * 2 + 2),
            new Plane(Math.random() * 2 + 2),
            new Plane(Math.random() * 2 + 2)
        ];
        this.bulletsRight = [];
        this.bulletsLeft = [];
        this.bulletsMid = [];
        this.status = GAME_PLAYING;

        this.update = function () {
            if (this.status === GAME_PLAYING) {
                this.tank.update();
                this.planes.forEach((plane) => plane.update());
                this.bulletsRight.forEach((bulletRight) => bulletRight.updateBulletsRight());
                this.bulletsLeft.forEach((bulletLeft) => bulletLeft.updateBulletsLeft());
                this.bulletsMid.forEach((bulletMid) => bulletMid.updateBulletsMid());
            }

        };

        this.checkLose = function () {
            for (let i = 0; i < this.planes.length; i++) {
                if (this.planes[i].y >= (400 - this.planes[i].height) && this.planes[i].y <= 400) {
                    if ((this.planes[i].x + this.planes[i].width) >= this.tank.x - 1 && this.planes[i].x <= (this.tank.x + this.tank.width)) {
                        this.status = GAME_OVER;
                    }
                }
                for (let j = 0; j < this.bulletsRight.length; j++) {

                    if (this.planes[i].y >= (this.bulletsRight[j].y - this.planes[i].height) && this.planes[i].y <= (this.bulletsRight[j].y)) {
                        if ((this.planes[i].x + this.planes[i].width) >= this.bulletsRight[j].x - 1 && this.planes[i].x <= (this.bulletsRight[j].x + this.bulletsRight[j].width)) {
                            this.planes.splice(i, 1);
                            dem += 1;
                            this.bulletsRight.splice(j, 1);
                            this.planes.push(new Plane);
                            this.planes.push(new Plane);
                            score += 1;
                            if (hightScore < score) {
                                hightScore = score;
                            }
                        }
                    }
                }

                for (let j = 0; j < this.bulletsLeft.length; j++) {
                    if (this.planes[i].y >= (this.bulletsLeft[j].y - this.planes[i].height) && this.planes[i].y <= (this.bulletsLeft[j].y)) {
                        if ((this.planes[i].x + this.planes[i].width) >= this.bulletsLeft[j].x - 1 && this.planes[i].x <= (this.bulletsLeft[j].x + this.bulletsLeft[j].width)) {
                            this.planes.splice(i, 1);
                            dem += 1;
                            this.bulletsLeft.splice(j, 1);
                            this.planes.push(new Plane);
                            this.planes.push(new Plane);
                            score += 1;
                            if (hightScore < score) {
                                hightScore = score;
                            }
                        }
                    }
                }

                for (let j = 0; j < this.bulletsMid.length; j++) {
                    if (this.planes[i].y >= (this.bulletsMid[j].y - this.planes[i].height) && this.planes[i].y <= (this.bulletsMid[j].y)) {
                        if ((this.planes[i].x + this.planes[i].width) >= this.bulletsMid[j].x - 1 && this.planes[i].x <= (this.bulletsMid[j].x + this.bulletsMid[j].width)) {
                            this.planes.splice(i, 1);
                            dem += 1;
                            this.bulletsMid.splice(j, 1);
                            this.planes.push(new Plane);
                            this.planes.push(new Plane);
                            score += 1;
                            if (hightScore < score) {
                                hightScore = score;
                            }
                        }
                    }
                }
            }
        };
        this.onLeftArrowPressed = function () {
            this.tank.direction = MOVE_LEFT;
        };

        this.onRightArrowPressed = function () {
            this.tank.direction = MOVE_RIGHT;
        };

        this.onSpaceButtonPressed = function () {
            this.bulletsRight.push(new Bullet(this.tank.x, this.tank.y));
            this.bulletsLeft.push(new Bullet(this.tank.x, this.tank.y));
            this.bulletsMid.push(new Bullet(this.tank.x, this.tank.y));
        };
        this.onEnterButtonPressed = function () {
            if (game.status === GAME_OVER) {
                score = 0;
                game = new Game();
                this.status = GAME_PLAYING;
            }
        };
        this.onLeftArrowUp = function () {
            if (game.tank.direction === MOVE_LEFT) {
                game.tank.direction = null;
            }
        };
        this.onRightArrowUp = function () {
            if (game.tank.direction === MOVE_RIGHT) {
                game.tank.direction = null;
            }
        }
    }
}

let game = new Game();
