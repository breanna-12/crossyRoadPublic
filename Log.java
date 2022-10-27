import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Log {

	//attributes
			private int x,y;
			private int width, height;
			private String fileName; // image
			
			//for image
			private Image img; 	
			private AffineTransform tx;
			private double scaleW = 1.0, scaleH = 1.0;
			
			public Log() {
				x = 10;
				y = 500;
				width = 100;
				height = 100;
			}
			
			public Log(int xVal, int yVal, int widthVal, int heightVal) {
				x = xVal;
				y = yVal;
				width = widthVal;
				height = heightVal;
				
				String fn = "chicken.png"; //add later
				
				img = getImage("/imgs/bg.png"); //load the image for Tree
				tx = AffineTransform.getTranslateInstance(x, y );
				init(x, y); 				//initialize the location of the image
											//use your variables
			}
			
			private void init(double a, double b) {
				tx.setToTranslation(a, b);
				tx.scale(2.7, 2.5);
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
