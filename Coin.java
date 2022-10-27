import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.Random;

public class Coin {

		//attributes
		private double originalX;
		private double x,y;
		private int width, height;
		private double vx = 1, vy = 0.25;	//velocities
		Random rnd = new Random(1234);
		
		//for image
		private Image img; 	
		private AffineTransform tx;	
		
		//create a new coin (money) object with x and y coordinate input, set the originalX, originalY, x and y variables to these inputs and set image to money image
		public Coin(int xVal, int yVal) {
			originalX = xVal;
			x = xVal;
			y = yVal;
						
			img = getImage("/imgs/finalMoney.gif"); 
			tx = AffineTransform.getTranslateInstance(x, y );
			init(x, y); 				//initialize the location of the image
										//use your variables
		}
		
		public void paint(Graphics g) {
			//these are the 2 lines of code needed draw an image on the screen
			Graphics2D g2 = (Graphics2D) g;
			
			//call update to update the actualy picture location
			update();
			
			g2.drawImage(img, tx, null);
		}
		
		// update the picture variable location by making "x += vx" and "y += vy". The scale is set to 0.6 for both x and y
		private void update() {
			x += vx;
			y += vy;
			tx.setToTranslation(x, y);
			tx.scale(0.6, 0.6);
		}
		
		//set the chicken location to the new location by setting the x to the x input and set the y to a random int from 20 to 580
		public void coinReset(double coinXParam) {
			x = coinXParam;
			y = rnd.nextInt(561) + 20;
		}
		
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(0.6, 0.6);
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
		public double getX() {
			return x;
		}
		
		public double getY() {
			return y;
		}
		
		public int getWidth() {
			return width;
		}
		
		public int getHeight() {
			return height;
		}
		
		public double getOriginalX() {
			return originalX;
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
		
		public void setVX(double newVX) {
			vx = newVX;
		}
		
		public void setVY(double newVY) {
			vy = newVY;
		}
		
}
