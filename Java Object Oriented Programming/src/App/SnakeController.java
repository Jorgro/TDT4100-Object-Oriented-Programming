package App;

//Fikse animasjon: sette en rektangel boks i hjørnet der man svinger

import java.io.File;
import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class SnakeController extends VBox {


    public MenuController menuController;

	@FXML public StackPane pane;
    @FXML public VBox box;
    @FXML public Label gameScore;

	public SnakeGame game;
    public AnimationTimer timer;
    public ViewController viewController;
    public MediaController mediaController;
    public SnakeGame snakeGame;
    public Timeline gameLoop;
    
    public boolean meme = false;

/*     String path = "src/test/gas.mp3";
    File music = new File(path);
    Media media = new Media(music.toURI().toString());
    MediaPlayer player = new MediaPlayer(media); */
    Rectangle background = new Rectangle(1440, 900);
	
	private Snake snake;
	
    public SnakeController() {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SnakeGame2.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        
        
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.pane.setStyle("-fx-background-color: #000000;");
        this.game = new SnakeGame(this);
        this.gameScore.toFront();
    }

    public void newGame() {
        game.newGame();
        this.snake = game.getSnake();
        this.pane.getChildren().add(snake);
        gameScore.toFront();
        snake.toFront(); 
        if (this.meme) {
            this.meme();
            this.meme = false;
        } else {
            this.defaultGame();
        }
        //timer.start();
        gameLoop.play();
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }


    
    public void setSnake(Snake snake) {
    	this.snake = snake;
    }

    public Snake getSnake() {
        return this.snake;
    }

    public void setGameLoop(Timeline gameLoop) {
        this.gameLoop = gameLoop;
    }
    
    public void setTimer(AnimationTimer timer) {
    	this.timer = timer;
    }
    
    public void stop() {
    	this.timer.stop();
    }
    

	public StackPane getPane() {
		return pane;
    }
    
    public void setViewController(ViewController view) {
        this.viewController = view;
        viewController.snakeController = this;
    }

    public Rectangle getBackgroundRectangle() {
        return this.background;
    }

    public void meme() {
/*         this.getChildren().add(this.background);
        File file1 = new File("src/App/america.jpeg");
        Image img1 = new Image(file1.toURI().toString());
        this.background.setFill(new ImagePattern(img1, 0, 0, 1, 1, true)); */
        //this.background.toBack();
        mediaController.setFilePath("src/App/ricardo.mp4");
        MediaView mediaView = new MediaView(mediaController.getMediaPlayer());
        mediaController.getMediaPlayer().play();
	    mediaView.setFitHeight(900);
        mediaView.setFitWidth(1680);
        pane.getChildren().add(mediaView);
        mediaView.toBack();
        viewController.mediaView = mediaView;
        File file2 = new File("src/App/PepePls.gif");
        Image img2 = new Image(file2.toURI().toString());
        File file3 = new File("src/App/PepePls.gif");
        Image img3 = new Image(file3.toURI().toString());
        System.out.println(file2);
        System.out.println(img2);
        System.out.println(this.snake);
        //this.snake.setScale(5);
        game.apple.setFill(new ImagePattern(img3, 0, 0, 1, 1, true));
        this.snake.setFill(new ImagePattern(img2, 0, 0, 1, 1, true));
        //this.game.getSnake().toFront();

    }

    public void defaultGame() {
        this.game.getSnake().setFill(Color.GREEN);
        this.game.getApple().setFill(Color.RED);
    }
    
}
