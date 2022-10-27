import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Tree {

	//attributes
		private int x,y;
		private int width, height;
		
		//for image
		private Image img; 	
		private AffineTransform tx;
		
		public Tree(int xVal, int yVal) {
			x = xVal;
			y = yVal;
						
			img = getImage("/imgs/tree.png");
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
			
			Color blueGray = new Color(61,61,92);
			g.setColor(blueGray);
			Font gameOver = new Font("font", Font.BOLD,50);
			Font note = new Font("font", Font.PLAIN,20);
			g.setFont(gameOver);
		}
		
		/* update the picture variable location */
		private void update() {
			tx.setToTranslation(x, y);
			tx.scale(0.2, 0.2);
		}
		
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(0.2, 0.2);
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
		
		//SETTERS
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
}
