package App;

import java.io.File;
import java.io.IOError;
import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.ActionEvent;


public class SnakeApp extends Application {
    public Stage primaryStage;
    public Scene scene;
    public ViewController viewController;
    public MediaController mediaController;
    private boolean keyPressed = false;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.viewController = new ViewController(stage);
        this.mediaController = new MediaController();
        SnakeController snakeController = new SnakeController();
        MenuController menuController = new MenuController();
        snakeController.setMenuController(menuController);
        menuController.setSnakeController(snakeController);
        snakeController.setViewController(viewController);
        menuController.setViewController(viewController);
        snakeController.mediaController = mediaController;
        viewController.mediaController = mediaController;
        FileHandler fileHandler = new FileHandler("src/App/highscores.txt");
        
      


        this.scene = new Scene(menuController, 1680, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SnakeGame");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("PepePls.gif")));
        SnakeGame game = snakeController.game;
        

        //må fikse så den bare tar inn et KeyEvent


        scene.setOnKeyPressed(event -> {
            if (getKeyPressed()) {
                return;
            }
            setKeyPressed();
            if (event.getCode() == KeyCode.W){
                if (game.getSnake().getSnakePieces().get(0).getCurrentDirection() != Direction.DOWN || game.getSnake().getSnakePieces().size() == 1) {
                    game.getSnake().setDirection(Direction.UP);
                   
                } 
                

            } 
            else if (event.getCode() == KeyCode.S) {
                if (game.getSnake().getSnakePieces().get(0).getCurrentDirection() != Direction.UP || game.getSnake().getSnakePieces().size() == 1) {
                    game.getSnake().setDirection(Direction.DOWN);
                    
                    
                } 

            } 
            else if (event.getCode() == KeyCode.A) {
                if (game.getSnake().getSnakePieces().get(0).getCurrentDirection() != Direction.RIGHT || game.getSnake().getSnakePieces().size() == 1) {
                    game.getSnake().setDirection(Direction.LEFT);
                    
                    
                } 

            }
            else if (event.getCode() == KeyCode.D) {
                if (game.getSnake().getSnakePieces().get(0).getCurrentDirection() != Direction.LEFT || game.getSnake().getSnakePieces().size() == 1) {
                    game.getSnake().setDirection(Direction.RIGHT);
                    
                } 

            	
            } else if (event.getCode() == KeyCode.Q) {
                System.out.println("Trying to add piece ");
            	game.getSnake().addSnakePiece();
            } else if (event.getCode() == KeyCode.SPACE) {
                viewController.changeSceneToMenu();
                
            }
        });
        
        
        
        stage.show();
        
/*         
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                try {
                wait(200); } catch (Exception e) {

                }
                snakeController.gameScore.setText("Score: " + game.getScore());
                if (!snakeController.game.update()) {
                    snakeController.timer.stop();
                }
                try {
                    Thread.sleep(20);
            		} catch(Exception e) {}


            }
        };
        snakeController.setTimer(timer); */

        //annen type animasjon: 
        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );
        
        //final long timeStart = System.currentTimeMillis();
        
        KeyFrame kf = new KeyFrame(
            Duration.seconds(0.030),                // 60 FPS
            new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent ae) 
                {
                    keyPressed = false;
                    snakeController.gameScore.setText("Score: " + game.getScore());
                    if (!snakeController.game.update()) {
                        boolean newHighscore = false;
                        //snakeController.timer.stop();
                        gameLoop.stop();
                        try {newHighscore = fileHandler.addNewHighScore(game.getScore());}
                        catch (Exception e) {
                            
                        }
                        try { 
                        Thread.sleep(1000); } catch (Exception e) {}
                        
                        System.out.println(newHighscore);
                        viewController.changeSceneToMenu();

                    }
                }
            });
        
        gameLoop.getKeyFrames().add(kf);
        snakeController.setGameLoop(gameLoop);


    }

    public void setKeyPressed() {
        keyPressed = true;
    }

    public boolean getKeyPressed() {
        return keyPressed;
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
