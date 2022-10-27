import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Chicken {

	//attributes
	private int originalX, originalY;
	private int x,y;
	private int width, height;
	private double xScale = 0.1, yScale = 0.1;
	private boolean flat = false;
	
	//for image
	private Image img; 	
	private AffineTransform tx;
	
	//create a new chicken object with x and y coordinate input, set the originalX, originalY, x and y variables to these inputs and set image to chicken image
	public Chicken(int xVal, int yVal) {
		originalX = xVal;
		originalY = yVal;
		x = xVal;
		y = yVal;
				
		img = getImage("/imgs/pixil-frame-0.png");
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
									//use your variables
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		//call update to update the actualy picture location
		update();
		
		g2.drawImage(img, tx, null);
		
		//g.drawLine(0, 365, 600, 520); //region of water1
		//g.drawLine(0, 460, 600, 615); //region of water1
		
	}
	
	/* update the picture variable location */
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(xScale, yScale);
	}
	
	//set the chicken location to the new location by setting the x and y to the inputs and set the scale to the initial values 0.1 for both x and y
	public void chickenReset(int chickenXParam, int chickenYParam) {
		x = chickenXParam;
		y = chickenYParam;
		yScale = 0.1;
		xScale = 0.1;
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(xScale, yScale);
	}
	
	//when chickenFlat is called, the scales are changed to appear squished and the boolean flat is set to true
	public void chickenFlat() {
		xScale = 0.15;
		yScale = 0.05;
		flat = true;
	}
	
	//increase chicken x by 25, decrease chicken y by 25 so it appears that the chicken is moving
	public void chickenMove() {
		x += 25;
		y -= 25;
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	//GETTERS FOR IMPORTANT VARIABLES
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getOriginalX() {
		return originalX;
	}
	
	public int getOriginalY() {
		return originalY;
	}
	
	public boolean getFlat() {
		return flat;
	}
	
	public int returnWidth() {
		return width;
	}
	
	public int returnHeight() {
		return height;
	}
	
	//SETTERS FOR VARIABLES CHANGED THROUGHOUT GAME
	public void setX(int newX) {
		x = newX;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	
	public void setFlat(boolean b) {
		flat = b;
	}
}
