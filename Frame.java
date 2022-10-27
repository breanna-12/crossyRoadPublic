import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	/* CREATE THE OBJECTS by either inputting a parameter of its coordinates or declaring arrays of each object class. 
	 * If arrays were made for multiple objects of one kind, the actual objects are later initialized in the 
	 * Frame constructor with the appropriate starting coordinates as the parameter
	 */
	Background 	bg 	= new Background(0, 0);
	Chicken chicken = new Chicken(15,520);
	Building building = new Building();		//not used
	Log log = new Log();					//not used
	Tree[] trees = new Tree[4];
	Truck[] trucks = new Truck[2];
	PoliceCar[] policeCars = new PoliceCar[2];
	RaceCar[] racecars = new RaceCar[2];
	GreenCar topGreenCar = new GreenCar (1000, 240); 
	Coin[] money = new Coin[2];
	YouMadeIt_GIF winGIF = new YouMadeIt_GIF(40,250);
	
	//Setting some basic variables to be printed later or used in the code 
	boolean win = false;
	int level = 1;
	int previousLevel = 1;
	int moneyInt = 0;

	// Paint all objects initialized in the Frame constructor using the index of arrays and the .paint(g) method
	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
		trucks[0].paint(g);
		policeCars[1].paint(g);
		chicken.paint(g);
		trucks[1].paint(g);
		policeCars[0].paint(g);
		topGreenCar.paint(g);
		racecars[1].paint(g);
		racecars[0].paint(g);
		money[0].paint(g);
		money[1].paint(g);
		trees[0].paint(g);
		trees[1].paint(g);
		trees[2].paint(g);
		trees[3].paint(g);

		
		//setting different velocities of some objects. This will cause the objects displayed to move because the code in their class says "x += vx" and "y += vy"
		money[1].setVX(-2);
		money[1].setVY(-0.5);
		policeCars[1].setVX(8);
		policeCars[1].setVY(2);
		trucks[0].setVX(8);
		trucks[0].setVY(2);
		
		//drawing rectangles around the objects for visualization and to get accurate coordinates of location
		/*g.drawRect(topTruck.getX(), topTruck.getY() + 35, 100, 10);				//position of topTruck
		* g.drawRect(trucks[1].getX(), trucks[1].getY() + 35, 100, 10);				//position of trucks[1]
		* g.drawRect(bottomCar.getX(), bottomCar.getY() + 12, 50, 12); 				//position of policeCars[1]
		* g.drawRect(chicken.getX(), chicken.getY() + 10, 20, 20);					//chicken
		* g.drawRect(policeCars[0].getX(), policeCars[0].getY() + 12, 50, 12);		//position of policeCars[0]
		* g.drawRect(racecars[1].getX(), racecars[1].getY() + 12, 60, 15);			//position of racecars[1]
		* g.drawRect(racecars[0].getX(), racecars[0].getY() + 12, 60, 15);			//position of bottomRacecar
		* g.drawRect(topGreenCar.getX(), topGreenCar.getY() + 12, 55, 15);
		*/
		
		//create and set new font and color for string printing level and money count
		Color moneyGreen = new Color(12,140,10);
		Font moneyCount = new Font("font", Font.BOLD,16);
		g.setFont(moneyCount);
		g.setColor(moneyGreen);
		
		//print 2 strings displaying the moneyInt and level variables previously created
		g.drawString("money: $" + moneyInt, 480, 530);
		g.drawString("level: " + level, 480, 560);
		
		/* IF STATEMENTS FOR COLLISION
		 * These statements work by checking for different point whether the x value of the chicken is between the start and end x-values of object2 AND 
		 * the y value of the chicken is between the start and end y-values of object2. The range considered collision is actually greater than the length/width of object2 
		 * for more accurate results since the objects are moving at high speeds. If the chicken has collided with object2 (if statement is true) and object2 is any object
		 * other than money, then the chickenFlat method is called (sets chicken velocities to 0 and stretches x scale). If the chicken collided with a money object, the
		 * moneyInt variable is incremented by 100 and its x location is set to 700 so it resets
		 */
		if ((chicken.getX() >= trucks[0].getX() && chicken.getX() <= trucks[0].getX() + 100) && (chicken.getY() >= trucks[0].getY() + 35 && chicken.getY() <= trucks[0].getY() + 45)) {
			chicken.chickenFlat();
		}
		
		if ((chicken.getX() + 20 >= trucks[1].getX() && chicken.getX() + 20 <= trucks[1].getX() + 100) && (chicken.getY() >= trucks[1].getY() + 35 && chicken.getY() <= trucks[1].getY() + 45)) {
			chicken.chickenFlat();
		}
		
		if ((chicken.getX() >= policeCars[0].getX() - 10 && chicken.getX() + 20 <= policeCars[0].getX() + 110) && (chicken.getY() >= policeCars[0].getY() && chicken.getY() + 20 <= policeCars[0].getY() + 60)) {
			chicken.chickenFlat();
		}
		
		if ((chicken.getX() >= policeCars[1].getX() && chicken.getX() + 20 <= policeCars[1].getX() + 50) && (chicken.getY() + 20 >= policeCars[1].getY() && chicken.getY() + 20 <= policeCars[1].getY() + 10)) {
			chicken.chickenFlat();
		}
		if ((chicken.getX() >= topGreenCar.getX() && chicken.getX() + 20 <= topGreenCar.getX() + 65) && (chicken.getY() + 20 >= topGreenCar.getY() && chicken.getY() + 20 <= topGreenCar.getY() + 30)) {
			chicken.chickenFlat();
		}
		
		if ((chicken.getX() >= racecars[1].getX() && chicken.getX() + 20 <= racecars[1].getX() + 70) && (chicken.getY() + 20 >= racecars[1].getY() && chicken.getY() + 20 <= racecars[1].getY() + 30)) {
			chicken.chickenFlat();
		}
		
		if ((chicken.getX() >= racecars[1].getX() && chicken.getX() + 20 <= racecars[1].getX() + 70) && (chicken.getY() >= racecars[1].getY() && chicken.getY() <= racecars[1].getY() + 30)) {
			chicken.chickenFlat();
		}
		
		if ((chicken.getX() >= racecars[0].getX() && chicken.getX() + 20 <= racecars[0].getX() + 70) && (chicken.getY() + 20 >= racecars[0].getY() && chicken.getY() + 20 <= racecars[0].getY() + 30)) {
			chicken.chickenFlat();
		}
		
		if ((chicken.getX() >= money[0].getX() && chicken.getX() <= money[0].getX() + 50) && (chicken.getY() >= money[0].getY() && chicken.getY() <= money[0].getY() + 40)
			|| (chicken.getX() + 35 >= money[0].getX() && chicken.getX() + 35 <= money[0].getX() + 50) && (chicken.getY() + 48 >= money[0].getY() && chicken.getY() + 48 <= money[0].getY() + 40)) {
			moneyInt += 100;
			money[0].setX(700);
		}
		
		if ((chicken.getX() >= money[1].getX() && chicken.getX() <= money[1].getX() + 50) && (chicken.getY() >= money[1].getY() && chicken.getY() <= money[1].getY() + 40)
				|| (chicken.getX() + 35 >= money[1].getX() && chicken.getX() + 35 <= money[1].getX() + 50) && (chicken.getY() + 48 >= money[1].getY() && chicken.getY() + 48 <= money[1].getY() + 40)) {
			moneyInt += 100;	
			money[1].setX(700);
			}
		
		/* IF STATEMENTS FOR RESET
		 * check if the x-value of each object is less than or greater than a specific value (this means that the object is off the screen that is 600x600). If the statement 
		 * is true, then use the rest methods of each class to reset the x-value and y-value to the initial values inputed when creating the object
		 */
		if (trucks[0].getX() > 650) {
			trucks[0].truckReset(trucks[0].getOriginalX(), trucks[0].getOriginalY());
		}
		
		if (trucks[1].getX() > 650) {
			trucks[1].truckReset(trucks[1].getOriginalX(), trucks[1].getOriginalY());
		}
		
		if (policeCars[0].getX() < -80) {
			policeCars[0].carReset(policeCars[0].getOriginalX(), policeCars[0].getOriginalY());
		}
		
		if (policeCars[1].getX() < -80) {
			policeCars[1].carReset(policeCars[1].getOriginalX(), policeCars[1].getOriginalY());
		}
		
		if (topGreenCar.getX() < -80) {
			topGreenCar.carReset(topGreenCar.getOriginalX(), topGreenCar.getOriginalY());
		}
		
		if (racecars[1].getX() < -100) {
			racecars[1].carReset(racecars[1].getOriginalX(), racecars[1].getOriginalY());
		}
		
		if (racecars[0].getX() < -100) {
			racecars[0].carReset(racecars[0].getOriginalX(), racecars[0].getOriginalY());
		}
		
		if (money[0].getX() > 640) {
			money[0].coinReset(money[0].getOriginalX());
		}
		
		if (money[1].getX() < -40) {
			money[1].coinReset(money[1].getOriginalX());
		}
		
		//Create and set new fonts and colors to print the game over and note strings
		Color blueGray = new Color(61,61,92);
		g.setColor(blueGray);
		Font gameOver = new Font("font", Font.BOLD,50);
		Font note = new Font("font", Font.PLAIN,20);
		g.setFont(gameOver);
		
		/*if chickenFlat method return true (this means the chicken is flat because it got run over), then it draws the game over string, 
		 * changes the font to note and prints a note asking the player to press space to restart. The moneyInt is also reset to 0
		 */
		if (chicken.getFlat() == true) {
			g.drawString("GAME OVER", 130, 520);
			g.setFont(note);
			g.drawString("press space to restart", 190, 560);
			moneyInt = 0;
		}
		
		/* if the chicken x and y values are between the values in the if condition, it means it's at the finishing point. If this is true, then it sets a boolean 
		 * win to true, resets the location of the chicken to its original coordinate, and calls the levelUp method which increments the level variable by 1
		 */
		if (chicken.getX() >= 400 && chicken.getY() + 20 <= 40) {
			win = true;
			chicken.chickenReset(chicken.getOriginalX(), chicken.getOriginalY());
			levelUp();
		}
		
		// if the boolean win is true, the font is set to note, prints a string asking the player to press space, and paints the win GIF
		if (win == true) {
			g.setFont(note);
			g.drawString("press space to continue", 190, 560);
			winGIF.paint(g);
		}
		
		// if the level variable has a value [1, 5), the velocities are set to the initial velocities 
		if (level >= 1 && level < 5) {
			trucks[0].resetVXVY();
			trucks[1].resetVXVY();
			policeCars[0].resetVXVY();
			policeCars[1].resetVXVY();
			topGreenCar.resetVXVY();
			racecars[1].resetVXVY();
			racecars[0].resetVXVY();

		}
		
		// if the level variable has a value [5, 10), the velocities are set to 2 times their initial velocities 
		if (level >= 5 && level < 10) {
			trucks[0].setVX(16);
			trucks[0].setVY(4);
			trucks[1].setVX(8);
			trucks[1].setVY(2);
			policeCars[0].setVX(8);
			policeCars[0].setVY(2);
			policeCars[1].setVX(16);
			policeCars[1].setVY(4);
			topGreenCar.setVX(8);
			topGreenCar.setVY(2);
			racecars[1].setVX(24);
			racecars[1].setVY(6);
			racecars[0].setVX(24);
			racecars[0].setVY(6);
			
		}
		
		// if the level variable has a value [10, infinity), the velocities are set to 2 times their previous velocities (4 times initial)
		if (level >= 10) {
			trucks[0].setVX(32);
			trucks[0].setVY(8);
			trucks[1].setVX(16);
			trucks[1].setVY(4);
			policeCars[0].setVX(16);
			policeCars[0].setVY(4);
			policeCars[1].setVX(32);
			policeCars[1].setVY(8);
			topGreenCar.setVX(16);
			topGreenCar.setVY(4);
			racecars[1].setVX(48);;
			racecars[1].setVY(12);
			racecars[0].setVX(48);
			racecars[0].setVY(12);
			
		}
		
		/* if the level is not currently 10 and win boolean is false and chickenFlat is false, then create and set a new font called smallNote and 
		 * print a string saying that the player can jump to level 10 by pressing i and  return back with r
		 */
		if (level != 10 && win == false && chicken.getFlat() == false) {
			Font smallNote = new Font("smallNote", Font.PLAIN,14);
			g.setFont(smallNote);
			g.drawString("press 'i' if you would like to attempt level 10", 150, 535);
			g.drawString("press 'r' to return to your previous level", 160, 560);
		}
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	//the constructor actually initialized the objects in the arrays first declared
	public Frame() {
		JFrame f = new JFrame("Crossy Road");
		f.setSize(new Dimension(600, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		trees[0] = new Tree(50,90);
		trees[1] = new Tree(160,120);
		trees[2] = new Tree(400,180);
		trees[3] = new Tree(120,500);
		
		trucks[0] = new Truck(-100,8);				//topTruck
		trucks[1] = new Truck(-400,200);			//middleTruck
		
		policeCars[0] = new PoliceCar (700,170);	//topPoliceCar
		policeCars[1] = new PoliceCar (1000,530);	//bottomPoliceCar
		
		racecars[0] = new RaceCar (760, 336);		//midRacecar
		racecars[1] = new RaceCar (1000, 190);		//topRacecar
		
		money[0] = new Coin(-80,80);				//money1
		money[1] = new Coin(660,500);				//money2
	}
	
	/* this method simply increments the level variable (what is displayed on screen) and the previousLevel variable (this is used for when the player
	 * wants to return to their previous level after trying level 10) by 1 each time the method is called
	 */
	public void levelUp() {
			level++;
			previousLevel++;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println(arg0.getKeyCode());
		
		/* if win is false and chickenFlat is false and keycode 38 is released (the up arrow), then the chickenMove method is called, which
		 * increases the x-val of chicken by 25 and decreases the y-val by 25 so the chicken moves
		 */
		if (win == false && chicken.getFlat() == false && arg0.getKeyCode() == 38) {
			chicken.chickenMove();
		}
		
		/* if chickenFlat is true and keycode 32 is released (the space bar), then the chickenReset method is called which resets its location to initial values,
		 * resets the level and previousLevel to 1 and sets the chickenFlat boolean to false. This is used when the chicken gets hit and the player restarts
		 */
		if (chicken.getFlat() && arg0.getKeyCode() == 32) {				//if chickenFlat and space pressed
			chicken.chickenReset(chicken.getOriginalX(), chicken.getOriginalY());
			level = 1;
			previousLevel = 1;
			chicken.setFlat(false);
		}
		
		/* if win is true and keycode 32 is released (the space bar), then the chickenReset method is called and win is reset to false.
		 * This is used when the chicken is at the finishing point and the player pressed space to continue
		 */
		if (win == true && arg0.getKeyCode() == 32) {
			chicken.chickenReset(chicken.getOriginalX(), chicken.getOriginalY());
			win = false;
		}
		
		/* if the current x and y values of the chicken are the same as the initial values (this means its at its original coordinate) and keycode 73 is released
		 * (the i key), then the level is set to 10
		 */
		if (chicken.getX() == chicken.getOriginalX() && chicken.getY() == chicken.getOriginalY() && arg0.getKeyCode() == 73) {				//skip to level 10
			level = 10;
		}
		
		//if keycode 82 is released (the r key), then the level displayed is set to the previousLevel (the level before jumping to level 10)
		if (arg0.getKeyCode() == 82) {				//return to previousLevel, set level to previousLevel
			level = previousLevel;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
