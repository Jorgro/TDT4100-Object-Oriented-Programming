package App;

import java.io.IOException;

import javax.management.RuntimeErrorException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
//https://stackoverflow.com/questions/37200845/how-to-switch-scenes-in-javafx
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ViewController {

    public VBox rootBox;
    public StackPane backgroundPane;
    public Snake snake; //? Skal jeg ha med denne her, eller kanskje SnakeGame? 
    public GridPane menu;
    public MediaController mediaController;
    public TableView<Integer> highscores;
    public MediaView mediaView;

    public Stage primaryStage;
    public MenuController menuController;
    public SnakeController snakeController;



    public ViewController(Stage stage) {
/*         this.setRootBox(rootBox);
        this.setBackgroundPane(backgroundPane);
        this.menu = menu; */
        this.primaryStage = stage;
        

        // Gridpane med knapper for options?
    }
    public void changeSceneToMenu(){
        primaryStage.getScene().setRoot(menuController);
        snakeController.pane.getChildren().remove(snakeController.game.getSnake());
        snakeController.pane.getChildren().remove(snakeController.game.getApple());
        try {
        mediaController.getMediaPlayer().pause();
        snakeController.pane.getChildren().remove(mediaView); } catch(Exception e) {}
    
    }
    public void changeSceneToGame(){
        primaryStage.getScene().setRoot(snakeController);
    
    }

    public void showMenu() {
        this.menu.setVisible(true);
        this.mediaController.getMediaPlayer().pause();

    }

    public void closeMenu() {
        this.menu.setVisible(false);
        this.mediaController.getMediaPlayer().play();
    }


    /**
     * @return the mediaController
     */
    public MediaController getMediaController() {
        return mediaController;
    }

    /**
     * @param mediaController the mediaController to set
     */
    public void setMediaController(MediaController mediaController) {
        this.mediaController = mediaController;
    }


    public void setMediaView() {
        this.mediaView = new MediaView(this.mediaController.getMediaPlayer());
        this.mediaView.setFitHeight(900);
        this.mediaView.setFitWidth(1440);
        this.snakeController.pane.getChildren().add(this.mediaView);
    }

    /**
     * @return the rootBox
     */
    public VBox getRootBox() {
        return rootBox;
    }

    /**
     * @param rootBox the rootBox to set
     */
    public void setRootBox(VBox rootBox) {
        this.rootBox = rootBox;
    }

    /**
     * @return the backgroundPane
     */
    public StackPane getBackgroundPane() {
        return backgroundPane;
    }

    /**
     * @param backgroundPane the backgroundPane to set
     */
    public void setBackgroundPane(StackPane backgroundPane) {
        this.backgroundPane = backgroundPane;
    }







}