import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GameOver extends JPanel implements ActionListener {
	private Image bg; // holds the background image
	private int bg_width; // width of the background
	private int bg_height; // height of the background
	private int bg_x=0; // x location of where to draw background
	private int speed = 8; // speed to set the timer
	private int direction = -1; // -1 is left, 1 is right...
	private JButton Retry;
	private JButton Exit;
	private ImageIcon i;
	private int whichImage = 0;
	 boolean inBucket1 = false;
	 boolean inBucket2 = false;
	 boolean inBucket3 = false;
	
	
	JPanel cards;
	Timer tm;

public GameOver (JPanel cards) {
		this.cards=cards;
		ImageIcon i = new ImageIcon("src/Lose.jpeg");
		bg = i.getImage();
		bg_width = bg.getWidth(null);
		bg_height = bg.getHeight(null);
		
		Retry = new JButton("Retry");
		Retry.addActionListener(this);
		add(Retry);
		Exit = new JButton("Exit");
		Exit.addActionListener(this);
		add(Exit);
		
		//start the timer and set the speed
		
	}
	
			
	public int getWidth () {
		return bg_width;
	}
	public int getHeight () {
		return bg_height;
	}
	public void actionPerformed (ActionEvent e) {
		
	
		
		 if(e.getSource()==Exit) {
			System.exit(0);
		}
		 if(e.getSource()== Retry) {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, "C1");
				
				
			}
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// Draw the image once in the new location,
		// but some of the window will be empty
		
		if (whichImage == 0)
		g2d.drawImage(bg, bg_x, 0, null);
		else if (whichImage == 1)
			g2d.drawImage(bg, bg_x, 0, null);
		// Now draw the background a second time to fill
		//the empty part of the window
		
		
		
	
	}
}

