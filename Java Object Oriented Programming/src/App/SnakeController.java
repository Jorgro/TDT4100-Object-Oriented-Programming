package App;

//Fikse animasjon: sette en rektangel boks i hjørnet der man svinger


import java.io.File;
import java.io.IOException;


import javafx.animation.AnimationTimer;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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

	public SnakeGame game;
    public AnimationTimer timer;
    public ViewController viewController;
    public MediaController mediaController;
    public SnakeGame snakeGame;

    public boolean meme = false;

/*     String path = "src/test/gas.mp3";
    File music = new File(path);
    Media media = new Media(music.toURI().toString());
    MediaPlayer player = new MediaPlayer(media); */
    Rectangle background = new Rectangle(1440, 900);
	
	private Snake snake;
	
    public SnakeController() {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SnakeGame.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        
        
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.pane.setStyle("-fx-background-color: #000000;");
        this.game = new SnakeGame(this);
       // this.background.setFill(Color.BLACK);
        //this.background.toFront();
       // this.getChildren().add(this.background);
     //   this.background.toBack();
	    

	     // Create the player and set to play automatically.
/* 	    MediaPlayer mediaPlayer = new MediaPlayer(media2);
	    mediaPlayer.setAutoPlay(true);
	    mediaPlayer.play();
	    mediaPlayer.stop();
	    mediaPlayer.play();
	    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); */

	    // Create the view and add it to the Scene.
/* 	    MediaView mediaView = new MediaView(mediaPlayer);
	    mediaView.setFitHeight(900);
	    mediaView.setFitWidth(1440); */
	    //((Group) scene.getRoot()).getChildren().add(mediaView);
        //this.pane.getChildren().add(this.background);
 /*        this.pane.getChildren().add(mediaView); */
        //mediaView.toFront();
/*         menu.toFront();
        button.toFront();
        button.getStylesheets().add(this.getClass()
        		.getResource("imagebutton.css").toExternalForm()); */
        //button.setMinSize(148, 148); button.setMaxSize(148, 148);
        //this.background.setFill(new ImagePattern(img, 0, 0, 1, 1, true));

        //this.sound = new Media(new File(musicFile).toURI().toString());
    }

    public void newGame() {
        game.newGame();
        this.snake = game.getSnake();
        this.pane.getChildren().add(snake);
        snake.toFront();
        if (this.meme) {
            this.meme();
        } else {
            this.defaultGame();
        }
        timer.start();
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

        File file2 = new File("src/App/trump.png");
        Image img2 = new Image(file2.toURI().toString());
        System.out.println(file2);
        System.out.println(img2);
        System.out.println(this.snake);
        //this.snake.setScale(5);
        this.snake.setFill(new ImagePattern(img2, 0, 0, 1, 1, true));
        //this.game.getSnake().toFront();

    }

    public void defaultGame() {
        System.out.println("Hello?");
        this.game.getSnake().setFill(Color.GREEN);
        this.game.getApple().setFill(Color.RED);
    }
    
}
