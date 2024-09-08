import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.CardLayout; 




public class GameInstructions extends JPanel implements ActionListener{
	private JButton SwitchPanel;
	private Image InstructionsIMG;
	private boolean decision;
	private int counter=0;
	private JPanel cards;
	
	public GameInstructions(JPanel cards) {
		this.cards = cards;
		ImageIcon Instructions = new ImageIcon("src/better instructions3.png");
		InstructionsIMG = Instructions.getImage(); 
		SwitchPanel = new JButton("Go to Game");
		SwitchPanel.addActionListener(this);
		add(SwitchPanel);


		
			}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(InstructionsIMG,0,0,1400,600,this);
	}
	
	/*
	public void setupWindow(Game p) {
		JFrame f = new JFrame("Instructions");
		JPanel m = new JPanel();
		SwitchPanel = new JButton("Go to Game");
		SwitchPanel.addActionListener(this);
		add(SwitchPanel);
		f.setSize(700,500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		f.setVisible(true);
		
	}
	*/
public void actionPerformed(ActionEvent e){
	System.out.println("Here");
		if(e.getSource()== SwitchPanel) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "C2");


			decision = true;
		counter++;
		}
		if(counter%2==0)
			decision = false;
		
	}
/*
	public static void main(String[] args) {
		Game p = new Game();
		p.setupWindow(p);
		
	}
	*/
	
}






























