import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.CardLayout;
public class MainGame  extends JPanel implements ActionListener  {
	private JButton Card1Button;//Go to Instructions
	private JButton DropBall;
	private int y=0,yinc=2,y2=0,yinc2;
	private int x = 0;
	private int x1=1;// X coordinate of the image
	private int xinc = 2;
	private int bucket2inc=0;
	private int bucket3inc=0;
	private int xinc2 = 2;// Increment step for x coordinate
	private boolean decision;
	private boolean showball = true;
	private boolean repaintball = true;
	private boolean CorrectAwns;
	private boolean Bucket1Awns=false;
	private boolean Bucket2Awns=false;
	private boolean Bucket3Awns=false;
	private Image image; // Image object
	private Image image2;//Buckets
	private Image image3;//Buckets
	private Image image4;//Buckets
	private Image bg;
	
	private Image BallImage;
	private Image InstructionsIMG;
	private Image BucketBackground;
	private Image BallIMG;
	private Graphics g;
	private Timer tm;
	private Timer tmBall;
	private JPanel K;
	private int whichbucket;
	private int counter=0;
	private int randomnum;
	private int randomnum2;
	private int randomansw1;
	private int randomansw2;
	private int randomansw3;
	private int levelcount=1;
	private int speed=10;
	private JPanel cards;
	private boolean BallDropping=false;
	private boolean SwitchPanelSize;
	JPanel card1,card2,card3;
	boolean inBucket = false;
	boolean inBucket1 = false;
	boolean inBucket2= false;
	boolean inBucket3 = false;
	boolean DrawX = true;
	boolean DrawX2 = true;
	boolean DrawX3 = true;
	boolean GameOver = false;
	boolean keepquestions = false;
	private GameOver go;
	
	JLabel l;
	JLabel l2;
	JLabel l3;
	JLabel question;
	JLabel level;
	JLabel NumberOfLives;
	private int NumLoss=3;
	private Image RedX,RedX2,RedX3;// Red x for keeping the number of losses
	public MainGame() {
		// Load the image
		ImageIcon i = new ImageIcon("src/Bucket6.png");
		ImageIcon i2 = new ImageIcon("src/Bucket10.png");
		ImageIcon i4 = new ImageIcon("src/Bucket10.png");
		ImageIcon i3 = new ImageIcon("src/Bucket10.png");
		ImageIcon Instructions = new ImageIcon("src/better instructions3.png");
		ImageIcon Ball= new ImageIcon("src/Ball.png");
		
		ImageIcon RedXImage = new ImageIcon("src/Red-X-PNG-Photos.png");
		ImageIcon RedXImage2 = new ImageIcon("src/Red-X-PNG-Photos.png");
		ImageIcon RedXImage3 = new ImageIcon("src/Red-X-PNG-Photos.png");
		InstructionsIMG = Instructions.getImage();
		//image = i.getImage();
		BallIMG = Ball.getImage();
		image2 = i2.getImage();
		image3 = i3.getImage();
		image4 = i4.getImage();
		RedX = RedXImage.getImage();
		RedX2 = RedXImage2.getImage();
		RedX3 = RedXImage3.getImage();
		 bg = i.getImage();
		//Image 2 is the moving bucket
		// Creates a timer that calls actionPerformed every 10 ms
		tm = new Timer(speed, this);
		tm.start();
		tmBall=new Timer (10,this);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image2, x, 350, 200,250, this);
		g.drawImage(image3, bucket2inc,350, 200,250,this);
		g.drawImage(image4, bucket3inc,350, 200,250,this);
		if(DrawX)
		g.drawImage(RedX,1050,50,20,20,this);
		if(DrawX2)
		g.drawImage(RedX2,1100,50,20,20,this);
		if(DrawX3)
		g.drawImage(RedX3,1150,50,20,20,this);
	
			g.drawImage(BallIMG,500,y2,100,100,this);
			 g.drawImage(bg, 0, 0, null);
			l.setBounds(x+60, 400, 40, 50);
			l2.setBounds(bucket2inc+60,400,40,50);
			l3.setBounds(bucket3inc+60,400,40,50);
			question.setBounds(600,0,100,100);
			level.setBounds(700,0,100,100);
			NumberOfLives.setBounds(850,10,200,100);
			
				
		//g.drawImage(BucketBackground,0,0,this);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == tm) {
			y+=yinc;
			y2 += yinc2;
			// Assuming the image width is 100, adjust as necessary
			if (e.getSource()==tm) {
				x=x+xinc;
				//System.out.println("x is: " + x);
				//x1=x1+xinc2;// Update the x coordinate
				if ((bucket3inc+200)>=1400)
					xinc = -1;
				else if(x<=0)
					xinc+=+1;
			}
			
			
			/*
			 *
			 * 			s
			 * 			s
			 * 			s
			 * 			s
			 *
			 * 			s
			 * 			vvv	bbb
			 *
			 */
			
			
			
			
			bucket2inc = x+200;
			bucket3inc = bucket2inc+200;
			repaint();
		}
		else if (e.getSource()==tmBall) {
			if(BallDropping) {
				y2+=4;
				// check to see if it is at the bottom
				if (y2>= 350) {
					System.out.println("Checking...");
					showball=false;
					tmBall.stop();
					System.out.println("x: " + x);
					// check where x is
					
					
					if (x>=350 && x<=550) {
						System.out.println("Bucket 1");
						inBucket1=true;
						
					
				}
					else if (x<=349 && x>=140) {
						System.out.println("Bucket 2");
						inBucket2=true;
						
					}
					else if (x<=139 && x>=17) {
						System.out.println("Bucket 3");
						inBucket3=true;
					
					}
					
					
					if(whichbucket==1) {
						if(inBucket1) {
							System.out.println("Correct Answer");
							MakeQuestionandAnswers();
							levelcount++;
							
							
							
						}
						else if(inBucket2 || inBucket3) {
							System.out.println("Wrong Answer");
						NumLoss--;
						}
						
					}
					else if(whichbucket==2) {
						if(inBucket2) {
							System.out.println("Correct Answer");
							MakeQuestionandAnswers();
							levelcount++;
							
						}
						else if(inBucket1 || inBucket3) {
							System.out.println("Wrong Answer");
						NumLoss--;
						}
					}
					else if(whichbucket==3) {
						if(inBucket3) {
							System.out.println("Correct Answer");
							MakeQuestionandAnswers();
							levelcount++;
							
						}
						else if(inBucket1 || inBucket2) {
							System.out.println("Wrong Answer");
						NumLoss--;
						}
					}
					if(NumLoss == 2)
						DrawX = false;
					if(NumLoss == 1)
						DrawX2 = false;
					
					if(NumLoss == 0) {
						
						resetvals();
						keepquestions = false;
						CardLayout cl = (CardLayout)(cards.getLayout());
						cl.show(cards, "C3");
						
					}
					
					
					
					
					
					
					y2=0;
					
					
					
				}
			}
			level.setText("Level: "+levelcount);
			if(levelcount%5 ==0 && speed>=3) {
				speed--;
				System.out.println("here "+levelcount+" h "+speed);
				tm.setDelay(speed);
			}
			repaint();
			
		}
		else if(e.getSource()== Card1Button) {
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, "C1");
		}
		else if(e.getSource() == DropBall) {
			System.out.println("Button clicked");
			inBucket1=false;
			inBucket2=false;
			inBucket3=false;
			tmBall.start();
			BallDropping=true;
		}
		else if(e.getSource()==Card1Button)
			SwitchPanelSize =true;
		else if(y2==x|y2==bucket3inc||y2==bucket2inc)
			System.out.println("Hello");
	}
	public void resetvals() {
		speed = 10;
		DrawX = true;
		DrawX2 = true;
		DrawX3 = true;
		levelcount = 1;
		NumLoss = 3;
		if(keepquestions == false) {
			MakeQuestionandAnswers();
		}
		keepquestions = true;
		
	}
	public void MakeQuestionandAnswers() {
		/*
		int lm = levelcount/5;
		int v=(lm+1)*10;
		randomnum = (int)(Math.random()*v+(lm+1));
		randomnum2 = (int)(Math.random()*v+(lm+1));
		*/
	
		if(levelcount <5) {
		randomnum = (int)(Math.random()*10+1);
		randomnum2 = (int)(Math.random()*10+1);
		}
		else if(levelcount >=5 && levelcount <=10) {
			randomnum = (int)(Math.random()*100+10);
		randomnum2 = (int)(Math.random()*100+10);
		}
		
		
		whichbucket = (int)(Math.random()*3+1);
		if(whichbucket ==1) {
			Bucket1Awns =true;
			if(Bucket1Awns)
				CorrectAwns=true;
			if(CorrectAwns == true)
				randomansw1 = randomnum+randomnum2;
				randomansw2 = randomansw1+1;
				randomansw3 = randomansw1-1;
				question.setText("What is "+randomnum+"+"+randomnum2);
				if(levelcount >=10 && levelcount <=15) {
					randomansw1 = randomnum*randomnum2;
				randomansw2 = randomansw1+1;
				randomansw3 = randomansw1-1;
				question.setText("What is "+randomnum+"*"+randomnum2);
				}
				
					
			
			
			
		}
		else if(whichbucket ==2) {
			Bucket2Awns =true;
			if(Bucket2Awns)
				CorrectAwns=true;
			if(CorrectAwns == true)
			randomansw2 = randomnum+randomnum2;
			randomansw1= randomansw2+1;
			randomansw3 = randomansw2-1;
			question.setText("What is "+randomnum+"+"+randomnum2);
			
			if(levelcount >=10 && levelcount <=15) {
				randomansw2 = randomnum*randomnum2;
			randomansw1 = randomansw2+1;
			randomansw3 = randomansw2-1;
			question.setText("What is "+randomnum+"*"+randomnum2);
			}
				
			
			
			
		}
		else if(whichbucket ==3) {
			Bucket3Awns =true;
			if(Bucket3Awns)
				CorrectAwns=true;
			if(CorrectAwns == true)
				randomansw3 = randomnum+randomnum2;
				randomansw2 = randomansw3-1;
				randomansw1 = randomansw3+1;
				question.setText("What is "+randomnum+"+"+randomnum2);
				
				if(levelcount >=10 && levelcount <=15) {
					randomansw3 = randomnum*randomnum2;
				randomansw2 = randomansw3+1;
				randomansw1 = randomansw3-1;
				question.setText("What is "+randomnum+"*"+randomnum2);
				}
			
			
			
		}
	
	
		
		/*
		randomnum = (int)(Math.random()*9+2);
		randomnum2 = (int)(Math.random()*9+2);
		randomansw1 = randomnum+randomnum2-1;
		randomansw2 = randomnum+randomnum2;
		randomansw3 = randomnum+randomnum2+1;
		*/
		l.setText(""+randomansw1);
		l2.setText(""+randomansw2);
		l3.setText(""+randomansw3);
		NumberOfLives.setText("Number of Lives: ");
		//question.setText("What is "+randomnum+"+"+randomnum2);
		
	}
	public void setupWindow(MainGame p) {
		l = new JLabel("Original Text");
		l2 = new JLabel("Orginal Text");
		l3 = new JLabel("Origianl Text");
		level = new JLabel("Level: 1");
		question = new JLabel("Orginial Text");
		NumberOfLives = new JLabel("Number of Lives: ");
		JFrame f = new JFrame("Bucket Drop");
		cards = new JPanel(new CardLayout());
		
		p.setLayout(null);
		// set location of answer labels
		//l.setBounds(100, 400, 40, 50);
		
		MakeQuestionandAnswers();
		card1 = new GameInstructions(cards);
		card2 = p;
		Card1Button = new JButton("Go to Instructions");
		add(Card1Button);
		Card1Button.addActionListener(this);
		card1.add(Card1Button);
		DropBall = new JButton("Drop the Ball");
		DropBall.setBounds(0,0,100,50);
		Card1Button.setBounds(100,0,150,50);
		add(DropBall);
		DropBall.addActionListener(this);
		card2.add(DropBall);
		card2.add(Card1Button);
		go = new GameOver(cards);
		
		
		cards.add(card1, "C1");
		cards.add(card2, "C2");
		cards.add(go, "C3");
		
		/*
	if(decision == false) {
			f.setSize(InstructionsIMG.getWidth(null), InstructionsIMG.getHeight(null));
		}
		if(decision ==true) {
			f.setSize(image2.getWidth(null),image2.getHeight(null));
			f.add(DropBall);
		}
		 */
		card2.add(l);
		card2.add(l2);
		card2.add(l3);
		card2.add(question);
		card2.add(level);
		card2.add(NumberOfLives);
		f.setSize(1400,600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(cards);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		MainGame p = new MainGame();
		p.setupWindow(p);
		
	}
}
