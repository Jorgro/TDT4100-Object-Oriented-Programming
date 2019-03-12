package App;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Snake extends Pane {

	public Color color;

	public Paint paint;
	/** Current direction of head */
	private Direction direction;

	/** All the SnakePieces in the Snake */
	private List<SnakePiece> snake;

	/** Image of SnakePieces */
	private Image image;
	private int scale = 1;

	public Snake() {
		this.snake = new ArrayList<SnakePiece>();

		SnakePiece head = new SnakePiece(680, 300);
		head.setPreviousDirection(head.getCurrentDirection());
		this.snake.add(head);
		getChildren().add(head);

	}

	public void setScale(int n) {
		this.snake.get(0).setScale(n);
		this.scale = n;
	}




	public void move() {

		for (SnakePiece piece : this.snake) {
			piece.move();
			Bounds bounds = piece.localToScene(piece.getBoundsInLocal());
			// piece.setDirection(dir);
			double maxX = bounds.getMaxX();
			double maxY = bounds.getMaxY();
			double minX = bounds.getMinX();
			double minY = bounds.getMinY();

			List<double[]> coordinates = piece.getCoordinatesForChangingDirection();

			if (coordinates.size() > 0) {
				double[] coordinate = coordinates.get(0);

				if (coordinate[0] == maxX && coordinate[2] == maxY && coordinate[1] == minX && coordinate[3] == minY) {
					piece.setDirection(piece.getDirection());
					coordinates.remove(0);
				}
			}
		}
	}

	public void setDirection(Direction dir) {
		SnakePiece head = this.snake.get(0);
		Bounds bounds = head.localToScene(head.getBoundsInLocal());

		double[] coordinates = { bounds.getMaxX(), bounds.getMinX(), bounds.getMaxY(), bounds.getMinY() };
		head.setDirection(dir);
		this.direction = dir;
		this.snake.stream().filter(snake -> !snake.equals(this.snake.get(0)))
				.forEach(snake -> snake.addCoordinates(coordinates));
		this.snake.stream().filter(snake -> !snake.equals(this.snake.get(0))).forEach(snake -> snake.addDirection(dir));

	}

	public void setImage() {

		this.snake.stream().forEach(snake -> snake.setImage(this.image));
	}

	public void setFill(Paint paint) {
		this.paint = paint;
		this.snake.get(0).setFill(this.paint);
	}



	public void addSnakePiece() {
		SnakePiece tail = this.snake.get(this.snake.size() - 1);
		Bounds bounds = tail.localToScene(tail.getBoundsInLocal());

		double minX = bounds.getMinX();
		double minY = bounds.getMinY();

		Direction direction = tail.getCurrentDirection();

		SnakePiece newPiece;

		if (direction == Direction.UP) {
			newPiece = new SnakePiece((int) minX, (int) minY + tail.height);
		} else if (direction == Direction.DOWN) {
			newPiece = new SnakePiece((int) minX, (int) minY - tail.height);
		} else if (direction == Direction.RIGHT) {
			newPiece = new SnakePiece((int) minX - tail.width, (int) minY);
		} else {
			newPiece = new SnakePiece((int) minX + tail.width, (int) minY);
		}

		if (tail.getDirectionsToChange().size() > 0) {
			newPiece.setDirectionsToChange(tail.getDirectionsToChange());
			newPiece.setCoordinatesForChangingDirection(tail.getCoordinatesForChangingDirection());
			newPiece.setDirection(tail.getCurrentDirection());
		} else {
			newPiece.setDirection(tail.getCurrentDirection());
		}
		newPiece.setFill(this.paint);
		newPiece.setScale(this.scale);
		this.snake.add(newPiece);
		this.getChildren().add(newPiece);

	}

	public boolean checkRunIntoSelf() {

		Bounds bound = this.snake.get(0).getRectangle().localToScene(this.snake.get(0).getBoundsInLocal());

		Point2D point1 = new Point2D(bound.getMaxX(), bound.getMaxY());
		Point2D point2 = new Point2D(bound.getMinX(), bound.getMinY());

		// System.out.println(point1);
		for (int i = 1; i < this.snake.size(); i++) {
			SnakePiece piece = this.snake.get(i);
			Bounds pieceBound = piece.getRectangle().localToScene(piece.getBoundsInLocal());
			if (pieceBound.contains(point1) && pieceBound.contains(point2)) {
				return true;
			}
		}
		return false;

	}

	public boolean checkRunIntoWall() {
		boolean runIntoWall;

		SnakePiece head = this.snake.get(0);
		//Bounds bounds = head.getRectangle().localToScene(head.getBoundsInLocal());

/* 		runIntoWall = (bounds.getMaxX() == 1440 || bounds.getMaxY() == 900 || bounds.getMinX() == 0
				|| bounds.getMinY() == 0); */
		runIntoWall = (head.getTranslateX() > 1440 || head.getTranslateY() > 900 || head.getTranslateX() < 0
				|| head.getTranslateY() < 0);
		//System.out.println("Koordinater:"+ head.getTranslateX() +","+ head.getTranslateX());
		return runIntoWall;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	public List<SnakePiece> getSnakePieces() {
		return this.snake;
	} 
}