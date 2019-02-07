package test;

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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class SnakeControl extends VBox {
    //@FXML private TextField textField;
	@FXML private Button button;
	@FXML private StackPane pane;
	@FXML private VBox box;
	
	AnimationTimer timer;
    String path = "src/test/running.mp3";
    File music = new File(path);
    Media media = new Media(music.toURI().toString());
    MediaPlayer player = new MediaPlayer(media);
    Rectangle background = new Rectangle(1440, 900);
	
	private Snake snake;
	
    public SnakeControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SnakeGame.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        
        
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.pane.setStyle("-fx-background-color: #000000;");
        
		File file = new File("src/test/america.jpeg");
		
		Image img = new Image(file.toURI().toString());
		
        this.pane.getChildren().add(this.background);
        button.toFront();
        //this.background.setFill(new ImagePattern(img, 0, 0, 1, 1, true));

        //this.sound = new Media(new File(musicFile).toURI().toString());
    }
    
    public void setSnake(Snake snake) {
    	this.snake = snake;
    }
    
    public void setTimer(AnimationTimer timer) {
    	this.timer = timer;
    }
    
    public void setSpeed(int number) {
    	this.snake.setSpeed(number);
    }
    
    public MediaPlayer getMediaPlayer() {
    	return this.player;
    }
    
    public void stop() {
    	this.timer.stop();
    }
    
        
    @FXML
    protected void startGame() {
        this.pane.getChildren().add(snake);
        System.out.println(this.pane.getChildren());
        this.button.setVisible(false);
        //System.out.println(player.getStatus());
        player.setAutoPlay(true);
        player.play();
        player.stop();
       // System.out.println(player.getStatus());
        player.play();
       // player.setOnError(() -> 
        //System.out.println("media error" + player.getError().toString()));
        //System.out.println(player.getStatus());
       //player.setVolume(0.9); 
        //System.out.println(player.getStatus());
        
        timer.start();
        

        
    }
    
}
