<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>RanSanMoi</title>
</head>
<body style="background: black" onload="gamePlaying()" onkeydown="keyDown(event)">
<canvas id="canVas" width="700" height="700" style="background: darkgray"></canvas>

<script>
    let canvas = document.getElementById("canVas");
    let ctx = canvas.getContext("2d");

    function gamePlaying() {
        if(game.status === GAME_PLAYING) {
            game.draw();
            game.update();
            requestAnimationFrame(gamePlaying);
        }else {
            ctx.font = "25px arial";
            ctx.fillText("thua cmnr :))" , 250,300,150)
        }
    }

    function keyDown(event) {
        switch (event.keyCode) {
            case 37:
                if (game.snakeHead.direction !== SNAKE_MOVE_RIGHT) {
                    game.snakeHead.direction = SNAKE_MOVE_LEFT;
                }
                break;
            case 38:
                if (game.snakeHead.direction !== SNAKE_MOVE_DOWN) {
                    game.snakeHead.direction = SNAKE_MOVE_UP;
                }
                break;
            case 39:
                if (game.snakeHead.direction !== SNAKE_MOVE_LEFT) {
                    game.snakeHead.direction = SNAKE_MOVE_RIGHT;
                }
                break;
            case 40:
                if (game.snakeHead.direction !== SNAKE_MOVE_UP) {
                    game.snakeHead.direction = SNAKE_MOVE_DOWN;
                }
                break;
        }
    }

</script>

<script>const SNAKE_MOVE_RIGHT = 0;
const SNAKE_MOVE_LEFT = 1;
const SNAKE_MOVE_UP = 2;
const SNAKE_MOVE_DOWN = 3;
const CANVAS_WIDTH = 700;
const CANVAS_HEIGHT = 700;

class SnakeHead {
    constructor() {
        this.x = 100;
        this.y = 100;
        this.width = 20;
        this.height = 20;
        this.direction = null;
        this.update = function () {
            if (this.direction === SNAKE_MOVE_LEFT) {
                this.x -= this.width / 8;
            }
            if (this.direction === SNAKE_MOVE_RIGHT) {
                this.x += this.width / 8;
            }
            if (this.direction === SNAKE_MOVE_UP) {
                this.y -= this.height / 8;
            }
            if (this.direction === SNAKE_MOVE_DOWN) {
                this.y += this.height / 8;
            }
        };

        this.draw = function () {
            ctx.beginPath();
            ctx.fillRect(this.x, this.y, this.width, this.height);
        }
    }
}

class SnakeBody {
    constructor() {
    }
}

class Prey {
    constructor() {
        this.width = 20;
        this.height = 20;
        this.x = parseInt(Math.random() * (CANVAS_WIDTH - 20));
        this.y = parseInt(Math.random() * (CANVAS_HEIGHT - 20));
        this.update = function () {

        };

        this.draw = function () {
            ctx.fillRect(this.x, this.y, this.width, this.height);
        }
    }
}

const GAME_OVER = 0;
const GAME_PLAYING = 1;

class GamePlay {
    constructor() {
        this.status = GAME_PLAYING;
        this.snakeHead = new SnakeHead();

        this.prey = new Prey();

        this.update = function () {
            this.snakeHead.update();
            this.prey.update();
            this.collision();
        };

        this.draw = function () {
            ctx.beginPath();
            ctx.clearRect(0, 0, 1000, 1000);
            this.snakeHead.draw();
            this.prey.draw();
        };

        this.collision = function () {
            snakeAndPrey();
            snakeAndWall();
        }
    }
}

let game = new GamePlay();

function snakeAndPrey() {
    if (game.snakeHead.x + game.snakeHead.width >= game.prey.x && game.snakeHead.x <= game.prey.x + game.prey.width) {
        if (game.snakeHead.y + game.snakeHead.height >= game.prey.y && game.snakeHead.y <= game.prey.y + game.prey.height) {
            game.prey = new Prey();
        }
    }
}

function snakeAndWall() {
    if (
        game.snakeHead.x < 0
        || game.snakeHead.x > (CANVAS_WIDTH - game.snakeHead.width)
        || game.snakeHead.y < 0
        || game.snakeHead.y > (CANVAS_HEIGHT - game.snakeHead.height)
    )
    {
        game.status = GAME_OVER;
    }
}</script>
</body>
</html>