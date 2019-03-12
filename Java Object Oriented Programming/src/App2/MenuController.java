package App;

//Fikse animasjon: sette en rektangel boks i hjørnet der man svinger

import java.io.File;
import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
import javafx.stage.Stage;

public class MenuController extends GridPane {

    public SnakeController snakeController;
    public ViewController viewController;

    @FXML public Button startButton;
    @FXML public Button option;
    @FXML public GridPane menu;
    @FXML public Button memeButton;
	
    Rectangle background = new Rectangle(1440, 900);

	
    public MenuController() {
 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        
        
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.setStyle("-fx-background-color: #000000;");

    }
        
    @FXML
    protected void startGame() {
        this.viewController.changeSceneToGame();
        this.snakeController.newGame();
        
    }

    @FXML
    protected void meme() {
        this.snakeController.meme = true;
    }

    public void setSnakeController(SnakeController snakeController) {
        this.snakeController = snakeController;

    }

    public void setViewController(ViewController view) {
        this.viewController = view;
        viewController.menuController = this;
    }
    
}
