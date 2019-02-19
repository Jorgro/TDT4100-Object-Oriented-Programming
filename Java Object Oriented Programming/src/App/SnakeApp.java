package App;

import java.io.File;
import java.io.IOError;
import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
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


public class SnakeApp extends Application {
    public Stage primaryStage;
    public Scene scene;
    public ViewController viewController;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.viewController = new ViewController(stage);
        SnakeController snakeController = new SnakeController();
        MenuController menuController = new MenuController();
        snakeController.setMenuController(menuController);
        menuController.setSnakeController(snakeController);
        snakeController.setViewController(viewController);
        menuController.setViewController(viewController);
      


        this.scene = new Scene(menuController, 1440, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SnakeGame");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("smorc.png")));
        SnakeGame game = snakeController.game;
        
        scene.setOnKeyPressed(event -> {
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
                snakeController.pane.getChildren().remove(0);
                snakeController.pane.getChildren().remove(0);
            }
        });

        
        
        stage.show();
        
        
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long arg0) {
                if (!snakeController.game.update()) {
                    snakeController.timer.stop();
                }
                try {
                    Thread.sleep(15);
            		} catch(Exception e) {}


            }
        };
        snakeController.setTimer(timer);

    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
