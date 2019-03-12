package App;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaController {

    private String filePath;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;

    public MediaController() {

    }

    public void play() {
        this.mediaPlayer.play();
    }

    public void pause() {
        this.mediaPlayer.pause();
    }


    /**
     * @return the mediaPlayer
     */
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
        this.media = new Media(this.file.toURI().toString());
        this.mediaPlayer = new MediaPlayer(this.media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

    }

    /**
     * @return the media
     */
    public Media getMedia() {
        return media;
    }


    /**
     * @return the mediaView
     */
    public MediaView getMediaView() {
        return mediaView;
    }



}