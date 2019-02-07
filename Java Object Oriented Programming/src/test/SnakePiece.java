package test;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class SnakePiece extends Pane {
	
    /** Width of the ship. */
    public static int width = 20;

    /** Height of the ship. */
    public static int height = 20;

    /** Velocity of the ship. */
    public Point2D velocity;
    Rectangle rect;
    //Circle rect;
    public Direction dir;
    
    
    private Direction prevDir;
    private boolean reversed = false;
    private int speed = 1;
    private List<double[]> changeDirection = new ArrayList<double[]>();
    private List<Direction> directions = new ArrayList<Direction>();
    
    public SnakePiece(int x, int y, String path) {
    	this.rect = new Rectangle(width, height);
    	//this.rect = new Circle(width);
    	setTranslateX(x);
    	setTranslateY(y);
    	getChildren().add(rect);
    	//rect.setScaleX(10);
    	//rect.setScaleY(10);
    	//setImage(path);
    	//rect.contains hjørne punktene til hodet? 
    	rect.setFill(Color.RED);
    	
    	//setImage()
    	
    }
    
    public void setImage(String filePath) {
		File file = new File(filePath);
		
		Image img = new Image(file.toURI().toString());
		
    	this.rect.setFill(new ImagePattern(img, 0, 0, 1, 1, true));
    }
    
    public void move() {
//    	if (this.dir != null) {
//    	switch(this.dir) {
//    	
//    		case UP: setTranslateY(getTranslateY()-1);
//    		case DOWN: setTranslateY(getTranslateY()+1);
//    		case LEFT: setTranslateX(getTranslateX()-1);
//    		case RIGHT: setTranslateX(getTranslateX()+1);
//
//    	} smh not working
    	//passe på farten her.. Når den skal teste om den skal følge etter så kan 
    	// jeg ikke skippe over 20 steg om gangen som jeg gjør her. 
    	
//    	}
    	if (this.dir == Direction.UP) {
    		setTranslateY(getTranslateY() - 20);
    		
    	} else if (this.dir == Direction.DOWN) {
    		setTranslateY(getTranslateY() + 20);

    		
    	} else if (this.dir == Direction.LEFT) {
    		setTranslateX(getTranslateX() - 20);
    		
    	} else if (this.dir == Direction.RIGHT) {
    		setTranslateX(getTranslateX() + 20);
    	}
    	
    	//System.out.println("moving");
    }
    
    public void setDirection(Direction dir) {
    	this.dir = dir;
    	

    	
    	
    	if (this.dir == Direction.UP) {
    		//setRotate(0);
    		if (this.reversed) {
    			this.rect.setRotate(90);
    		} else {
    		this.rect.setRotate(-90);
    		}
    	} else if (this.dir == Direction.DOWN) {
    		//setRotate(0);
    		if (this.reversed) {
    			this.rect.setRotate(-90);
    		} else {
    			this.rect.setRotate(90);
    		}
    		
    	} else if (this.dir == Direction.LEFT) {
    		this.reversed = true;
    		this.rect.setRotate(0);
    		//this.setImage("src/test/smorc_reversed.png");
    		//this.setImage("src/test/trump.png");
    		
    	} else if (this.dir == Direction.RIGHT) {
        	//this.setImage("src/test/smorc.png");
    		//wthis.setImage("src/test/trump.png");
        	this.reversed = false;
    		this.rect.setRotate(0);
    	}
    }
    
    public SnakePiece getSnake() {
    	return this;
    }
    
    public void setSpeed(int number) {
    	this.speed = number;
    }
    
    public int getSpeed() {
    	return this.speed;
    }
    
    public void rotate(int degrees) {
    	
    }
    
	public void setPosition(int x, int y) {
		setTranslateX(x);
		setTranslateY(y);
	}
    
	public Rectangle getRect() {
		return this.rect;
	}
//	public Circle getRect() {
//		return this.rect;
//	}
	
	public void addDirectionChange(double[] coordinates) {
		this.changeDirection.add(coordinates);
	}
	
	public List<double[]> getDirectionChange() {
		return this.changeDirection;
	}
	
	public void addDirection(Direction dir) {
		this.directions.add(dir);
	}
	
	public List<Direction> getDirections() {
		return this.directions;
	}
	
	public Direction getDirection() {
		Direction direction = this.directions.get(0);
		this.prevDir = direction;
		this.directions.remove(0);
		return direction;
	}
	
	public Direction getThisDirection() {
		return this.dir;
	}
	
	public void setDirections(List<Direction> listDir) {
		//this.directions = listDir;
		listDir.stream().forEach(direction -> this.directions.add(direction));
		//this.dir = this.directions.get(0);

		
	}
	
	public void setDirectionChange(List<double[]> listCoords) {
		//this.changeDirection = listCoords;
		listCoords.stream().forEach(snake -> this.changeDirection.add(snake));
	}
	
	public Direction getPrevDir() {
		return this.prevDir;
	}
	
	public void setPrevDir(Direction direction) {
		this.prevDir = direction;
	}
}
	
