package test;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class SnakeApp extends Application {
	
    boolean fast = false;
    
    @Override
    public void start(Stage stage) throws Exception {
        SnakeControl customControl = new SnakeControl();
        //customControl.setText("Hello!");
        Scene scene = new Scene(customControl, 1440, 900);
        stage.setScene(scene);
        stage.setTitle("SnakeGame");
        //stage.setWidth(1440);
        //stage.setHeight(900);
        
        
        Snake snake = new Snake("src/test/trump.png");
        
        
        customControl.setSnake(snake);
        customControl.setSpeed(1);
        
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W){
            	snake.setDirection(Direction.UP);
                System.out.println("going up");
                    //mediaController.playJumpMusic();
                    //effectPlaying = false;
            } 
            else if (event.getCode() == KeyCode.S) {
            	snake.setDirection(Direction.DOWN);
                System.out.println("going down");
            } 
            else if (event.getCode() == KeyCode.A) {
            	snake.setDirection(Direction.LEFT);
                System.out.println("going left");
            }
            else if (event.getCode() == KeyCode.D) {
            	snake.setDirection(Direction.RIGHT);
                System.out.println("going right");
            } else if(event.getCode() == KeyCode.SPACE) {
            	if(!this.fast) {
            		snake.setSpeed(10);
            		this.fast = true;
            	} else {
            		snake.setSpeed(1);
            		this.fast = false;
            	}
            	
            } else if (event.getCode() == KeyCode.Q) {
            	snake.addSnakePiece();
            }
        });

        
        
        stage.show();
        
        
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	for (int i = 0; i < snake.getSpeed(); i++) {
//            		snake.move();
//            		//System.out.println(snake.checkRunIntoSelf());
            		if (snake.checkRunIntoSelf() || snake.checkRunIntoWall()) {
            			System.out.println("collision");
            			System.out.println("You lost :)");
            			customControl.stop();
            		}
            		snake.move();
            		try {
            		Thread.sleep(20);
            		} catch(Exception e) {
            			
            		}
            	}
            	//snake.move();
                
                MediaPlayer player = customControl.getMediaPlayer();
                //System.out.println(player.getCurrentTime().toSeconds());
                if (player.getCurrentTime().toSeconds() == 25.039637188) {
                	//snake.setSpeed(15);
                	//snake.addSnakePiece();
                }
                //player.play();
            }
        };
        customControl.setTimer(timer);

        //timer.start();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
