package App;

import java.util.List;
import java.util.Random;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Apple extends Pane {
    public Rectangle rectangle;
    private Snake snake;

    public Apple(Snake snake) {
        this.rectangle = new Rectangle(SnakePiece.width, SnakePiece.height);
        //this.rectangle.setFill(Color.AQUA);
        this.getChildren().add(rectangle);
        this.snake = snake;
    }

    public void setPosition(int x, int y) {
        setTranslateX(x);
        setTranslateY(y);
    }

    public void placeOnScreen() {
        Random random = new Random();
        int x = random.nextInt(72)*SnakePiece.height;
        int y = random.nextInt(45)*SnakePiece.width;
        Point2D point = new Point2D((double) x, (double) y);

        List<SnakePiece> snakePieces = snake.getSnakePieces();
        if (snakePieces.stream().anyMatch(piece -> piece.getRectangle().contains(point))) {
            placeOnScreen();
        }
        
        setPosition(x, y);
    }

    public boolean checkEaten() {
        List<SnakePiece> snakePieces = snake.getSnakePieces();
/*         Bounds bounds = this.rectangle.localToScene(this.rectangle.getBoundsInLocal());
        if (snakePieces.get(0).getRectangle().localToScene(snakePieces.get(0).getBoundsInLocal()).intersects(bounds)) {
            return true;
        }
        return false; */

        Bounds bound = snakePieces.get(0).getRectangle().localToScene(snakePieces.get(0).getBoundsInLocal());

		Point2D point1 = new Point2D(bound.getMaxX(), bound.getMaxY());
		Point2D point2 = new Point2D(bound.getMinX(), bound.getMinY());

		Bounds appleBound = this.rectangle.localToScene(this.rectangle.getBoundsInLocal());
		if (appleBound.contains(point1) && appleBound.contains(point2)) {
			return true;
			}
		return false;
    }

    public void setFill(Paint paint) {
        this.rectangle.setFill(paint);
    }
}