import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class RaceCar {
	
			//attributes
			private int originalY;
			private int originalX;
			private int x,y;
			private int width, height;
			
			//for image
			private Image img; 	
			private AffineTransform tx;
			//velocities (current and initial)
			private double vx = 12, vy = 3;
			private double originalVX = 4.0, originalVY = 1.0;
			
			//create a new RaceCar object with x and y coordinate input, set the originalX, originalY, x and y variables to these inputs and set image to race car image
			public RaceCar(int xVal, int yVal) {
				originalX = xVal;
				originalY = yVal;
				x = xVal;
				y = yVal;
				
				img = getImage("/imgs/race car.png"); //load the image for Tree
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
			
			//update by making "x -= vx" and "y -= vy" so the car moves northwest and set scale to 0.18 for both x and y
			private void update() {
				x -= vx;
				y -= vy;
				tx.setToTranslation(x, y);
				tx.scale(0.18, 0.18);
			}
			
			//set the policeCar location to new location by setting the x and y to the inputs
			public void carReset(int carXParam, int carYParam) {
				x = carXParam;
				y = carYParam;
			}
			
			private void init(double a, double b) {
				tx.setToTranslation(a, b);
				tx.scale(0.18, 0.18);
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
			
			public int getWidth() {
				return width;
			}
			
			public int getHeight() {
				return height;
			}
			
			public int getOriginalX() {
				return originalX;
			}
			
			public int getOriginalY() {
				return originalY;
			}
			
			//SETTERS FOR VARIABLES CHANGED THROUGHOUT GAME
			public void setX(int newX) {
				x = newX;
			}
			
			public void setY(int newY) {
				y = newY;
			}
			
			public void setVX(double newVX) {
				vx = newVX;
			}
			
			public void setVY(double newVY) {
				vy = newVY;
			}
			
			public void resetVXVY() {
				vx = originalVX;
				vy = originalVY;
			}
			
			public void setWidth(int newWidth) {
				width = newWidth;
			}
			
			public void setHeight(int newHeight) {
				height = newHeight;
			}

}
