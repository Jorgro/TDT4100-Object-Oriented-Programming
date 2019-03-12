package App;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class SnakePiece extends Pane{

    /** Setting size of a SnakePiece */
    public static int width = 20;
    public static int height = 20;

    /** Rectangle which shows the piece on the screen */
    private Rectangle rectangle;

    /** Previous direction */
    private Direction previousDirection;

    /** Current direction */
    private Direction direction;

    /** List of coordinates when piece should change direction */
    private List<double[]> coordinatesForChangingDirection = new ArrayList<double[]>();

    /** List of directions piece should change to */
    private List<Direction> directionsToChange = new ArrayList<Direction>();

    public SnakePiece(int x, int y) {
        // Initializing instance to show
        this.rectangle = new Rectangle(width, height);


        //Setting position on screen
        setTranslateX(x);
        setTranslateY(y);

        //Adding rectangle to pane
        getChildren().add(this.rectangle);

        
    }

    /** Chose color for SnakePiece */
    public void setFill(Paint paint) {
        this.rectangle.setFill(paint);
    }

    public void setScale(int n) {
        setScaleX(n);
        setScaleY(n);
    }
    
    /** Can also chooose an image as fill */
    public void setImage(Image image) {
        this.rectangle.setFill(new ImagePattern(image, 0, 0, 1, 1, true));
    }

    /** Moves the SnakePiece in a direction */
    public void move() {

        if (this.direction == Direction.UP) {
    		setTranslateY(getTranslateY() - height);
    		
    	} else if (this.direction == Direction.DOWN) {
    		setTranslateY(getTranslateY() + height);

    		
    	} else if (this.direction == Direction.LEFT) {
    		setTranslateX(getTranslateX() - width);
    		
    	} else if (this.direction == Direction.RIGHT) {
    		setTranslateX(getTranslateX() + width);
    	}
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public void setPosition(int x, int y) {
        setTranslateX(x);
        setTranslateY(y);
    }

    public void addCoordinates(double[] coordinates) {
        this.coordinatesForChangingDirection.add(coordinates);
    }

    public List<double[]> getCoordinatesForChangingDirection() {
        return this.coordinatesForChangingDirection;
    }

    public void addDirection(Direction dir) {
		this.directionsToChange.add(dir);
	}
	
	public List<Direction> getDirectionsToChange() {
		return this.directionsToChange;
    }
    
    public Direction getDirection() {
		Direction direction = this.directionsToChange.get(0);
		this.previousDirection = direction;
		this.directionsToChange.remove(0);
		return direction;
    }
    
    public Direction getCurrentDirection() {
        return this.direction;
    }

    public void setDirectionsToChange(List<Direction> listDir) {
        listDir.stream().forEach(direction -> this.directionsToChange.add(direction));
    }

    public void setCoordinatesForChangingDirection(List<double[]> listCoords) {
        listCoords.stream().forEach(snake -> this.coordinatesForChangingDirection.add(snake));
    }
    
    public Direction getPreviousDirection() {
        return this.previousDirection;
    }

    public void setPreviousDirection(Direction dir) {
        this.previousDirection = dir;
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }
}