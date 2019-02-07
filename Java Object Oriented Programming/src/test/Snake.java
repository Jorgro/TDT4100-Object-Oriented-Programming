package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Snake extends Pane {
	
	private Direction dir;
	private List<SnakePiece> snake;
	
	double maxX;
	double maxY;
	double minX;
	double minY;
	
	private String path;
	
	public Snake(String path) {
		this.snake = new ArrayList<SnakePiece>();
		SnakePiece head = new SnakePiece(680, 300, path);
		head.setPrevDir(head.dir);
		this.snake.add(head);
		this.getChildren().add(head);
		//head.setScaleX(10);
		//head.setScaleY(10);
		this.path = path;
		//addSnakePiece();
		
		
	}
	
	//lagre maxX, minX, maxY, minY til hodet og når andre matcher disse koordinate 
	//så skal de også skifte retning
	
	
	public void move() {
		
		//problem: retning blir skiftet før bakerste del kommer fram? -> den skifter feil
		//Løsning: Dynamisk Liste med array av koordinater som sammenlignes med og fjerner fra
		
		for (SnakePiece piece : this.snake) {
			piece.move();
			Bounds bounds = piece.localToScene(piece.getBoundsInLocal());
			//piece.setDirection(dir);
			double maxX = bounds.getMaxX();
			double maxY = bounds.getMaxY();
			double minX = bounds.getMinX();
			double minY = bounds.getMinY();
			
			List<double[]> coordinates = piece.getDirectionChange();
			
			if (coordinates.size() > 0) {
				double[] coordinate =  coordinates.get(0);

				if (coordinate[0]== maxX && coordinate[2] == maxY && 
						coordinate[1] == minX && coordinate[3] == minY) {
						piece.setDirection(piece.getDirection());
						coordinates.remove(0);
					}
			}
			
			
		}
		//System.out.println("moving piece");
		
	}
	
	public void setDirection(Direction dir) {
		SnakePiece head = this.snake.get(0);
		Bounds bounds = head.localToScene(head.getBoundsInLocal());

		double[] coordinates = {bounds.getMaxX(), bounds.getMinX(), bounds.getMaxY(), bounds.getMinY()};
		head.setDirection(dir);
		this.dir = dir;
		this.snake.stream().filter(snake -> !snake.equals(this.snake.get(0)))
		.forEach(snake -> snake.addDirectionChange(coordinates));
		this.snake.stream().filter(snake -> !snake.equals(this.snake.get(0)))
		.forEach(snake -> snake.addDirection(dir));
		
	}
	
	
	
	
	public void setImage(String path) {
		//this.snake.get(0).setImage(path);
		
		this.snake.stream().forEach(snake -> snake.setImage(path));
	}
	
	public void setSpeed(int number) {
		this.snake.stream().forEach(snake -> snake.setSpeed(number));
	}
	
	public void addSnakePiece() {
		SnakePiece tail = this.snake.get(this.snake.size()-1);
		Bounds bounds = tail.localToScene(tail.getBoundsInLocal());

		double minX = bounds.getMinX();
		double minY = bounds.getMinY();
		
		Direction direction = tail.getThisDirection();
		
		SnakePiece newPiece;
		
		if (direction == Direction.UP) {
			newPiece = new SnakePiece((int) minX, (int) minY+20, path);
		} 
		else if (direction == Direction.DOWN) {
			newPiece = new SnakePiece((int) minX, (int) minY-20, path);
		}
		else if (direction == Direction.RIGHT) {
			newPiece = new SnakePiece((int) minX-20, (int) minY, path);
		}
		else {
			newPiece = new SnakePiece((int) minX+20, (int) minY, path);
		}
		
		
		if (tail.getDirections().size() > 0) {
			newPiece.setDirections(tail.getDirections());
			newPiece.setDirectionChange(tail.getDirectionChange());
			newPiece.setDirection(tail.getThisDirection());
		} else {
			newPiece.setDirection(tail.getThisDirection());
		}
		//samme arraylist linkes til flere pieces: trøbbel
		this.snake.add(newPiece);
		this.getChildren().add(newPiece);
		//newPiece.setScaleX(10);
		//newPiece.setScaleY(10);
		
	}
	
	public int getSpeed() {
		return this.snake.get(0).getSpeed();
	}
	
	public boolean checkRunIntoSelf() {
		try {
			Bounds bound = this.snake.get(0).getRect().localToScene(this.snake.get(0).getBoundsInLocal());
			boolean runIntoSelf = this.snake.stream().anyMatch(snakePiece -> (snakePiece.getRect().localToScene(snakePiece.getBoundsInLocal()).intersects(bound) 
					&& !snakePiece.equals(this.snake.get(0)) && !snakePiece.equals(this.snake.get(1)) && !snakePiece.equals(this.snake.get(2)) ));
			
			
			return runIntoSelf;
		} catch (Exception e) {
			return false;
		}
	
		
		//sjekke opp mot max/min koordinater istedenfor? 
	}
	
	public boolean checkRunIntoWall() {
		boolean runIntoWall;
		
		SnakePiece head = this.snake.get(0);
		Bounds bounds = head.getRect().localToScene(head.getBoundsInLocal());
		
		runIntoWall = (bounds.getMaxX() == 1440 || bounds.getMaxY() == 900 || bounds.getMinX() == 0 || bounds.getMinY() ==0);
		
		return runIntoWall;
	}

}
