import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
 
public class Drawing extends JPanel {
	public void paint(Graphics g) {
		Color brown = new Color (50,30,0);
		
		g.setColor(Color.red);
		g.fillOval(200, 50, 50, 300);
		g.fillOval(230, 50, 50, 300);
		g.fillOval(260, 50, 50, 300);
		g.fillOval(290, 50, 50, 300);
		g.fillOval(320, 50, 50, 300);
		g.fillOval(350, 50, 50, 300);
		g.fillOval(380, 50, 50, 300);
		g.fillOval(410, 50, 50, 300);
		g.fillOval(440, 50, 50, 300);
		
		g.setColor(Color.orange);
		g.fillOval(230, 75, 50, 200);
		g.fillOval(260, 75, 50, 200);
		g.fillOval(290, 75, 50, 200);
		g.fillOval(320, 75, 50, 200);
		g.fillOval(350, 75, 50, 200);
		g.fillOval(380, 75, 50, 200);
		g.fillOval(410, 75, 50, 200);
		
		g.fillRect(300, 370, 20, 40);
		g.fillRect(380, 370, 20, 40);
		g.fillOval(375, 400, 30, 20);
		g.fillOval(295, 400, 30, 20);
		
		g.setColor(Color.yellow);
		g.fillOval(260, 100, 50, 200);
		g.fillOval(290, 100, 50, 200);
		g.fillOval(320, 100, 50, 200);
		g.fillOval(350, 100, 50, 200);
		g.fillOval(380, 100, 50, 200);
		
		
		g.setColor(brown);
		g.fillOval(200, 200, 300, 200);
		g.fillOval(310, 120, 60, 200);
		g.fillOval(290, 100, 100, 80);
		
		g.setColor(Color.black);
		g.fillOval(300, 125, 25, 25);
		g.fillOval(350, 125, 25, 25);
		
		g.setColor(Color.white);
		g.fillOval(310, 130, 10, 10);
		g.fillOval(360, 130, 10, 10);
		
		g.setColor(Color.ORANGE);
		g.fillOval(323, 140, 30, 15);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(580, 315, 120, 85);
		g.fillOval(560, 390, 160, 50);
		
		g.setColor(Color.black);
		g.fillOval(580, 300, 120, 30);
		g.fillRect(580, 380, 120, 15);
		
		g.setColor(Color.YELLOW);
		g.drawRect(625, 375, 25, 25);
		g.drawRect(626, 376, 25, 25);
		
		Font big = new Font("font", Font.BOLD, 20);
		g.setFont(big);
		g.setColor(Color.DARK_GRAY);
 		g.drawString("I am thankful for my friends and family", 175, 500);
 
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Drawing d = new Drawing();
	}
 
	public Drawing() {
		JFrame f = new JFrame("Have a restful break!");
		f.setSize(800,600);
		f.setResizable(false);
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
 
}
