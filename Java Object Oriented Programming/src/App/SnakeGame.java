package App;

import javafx.scene.paint.Color;

public class SnakeGame {

    private Snake snake;
    private int score;
    public Apple apple;
    public SnakeController snakeController;

    public SnakeGame(SnakeController controller) {
        this.snakeController = controller;
/*         this.snake = new Snake();
        this.snake.setFill(Color.RED); */

    }

    /**
     * @return the snake
     */
    public Snake getSnake() {
        return snake;
    }

    /**
     * @param snake the snake to set
     */
    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    public void newGame() {
        this.snake = new Snake();
        this.apple = new Apple(snake);
        this.apple.placeOnScreen();
        this.snakeController.pane.getChildren().add(this.apple);
        this.score = 0;
        this.apple.toFront();
        
    }

    public boolean update() {
        if (snake.checkRunIntoSelf() || snake.checkRunIntoWall()) {
            			
            System.out.println("You lost :)");
            return false;
        }
        
        if(apple.checkEaten()) {
            System.out.println("eaten");
            snake.addSnakePiece();
            apple.placeOnScreen();
            score += 100;
        }
        

        snake.move();
        return true;
        
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    public Apple getApple() {
        return this.apple;
    }

}