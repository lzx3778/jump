package jump;

import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class jpanel extends JPanel implements KeyListener,Runnable{
	//initialize
	//create two storage for the blocks
	private static int[] groundOne = new int[2];
	private static int[] groundtwo = new int[2];
	
	//record the ground level
	private static int groundLevel = 0;
	
	//plater's height
	private static int Height = 400;
	
	//the speed that the player falls
	private static float downspeed = 0;
	
	//is the player in the air?
	private static boolean jumped = false;
	
	//build the panel
	public jpanel(){
		
		//must exist
		setFocusable(true);
		addKeyListener(this);
		
		//new and start a thread
		Thread thread = new Thread(this);
		thread.start();
		
	}
	
	//do the process in the game
	@Override
	public void run() {
		
		//keep the process repeating every 0.02s
		while(true){
			
			//wait for 0.02s to refresh
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//check if groundOne isn't exist
			if (!BlockExist(groundOne)) {
				
				//initialize a new groundOne
				groundOne = generateBlock();
				
			//check if groundtwo isn't exist
			}else if (!BlockExist(groundtwo)) {
				
				//initialize a new groundtwo
				groundtwo = generateBlock();
				
			}
			
			//gravity
			if(Height < 400){
				
				//falls down
				Height += downspeed;
				
				//acceleration speed
				downspeed += 0.1;
				
			//is the player still alive?
			}else if(Height > 500){
				
				//get out!
				System.exit(0);
			
			//on the ground
			}else {
				
				//initialize for on the ground
				downspeed = 0;
				jumped = false;
			}
			
			//refresh the screen
			repaint();
		}
	}
	
	//paint items on the screen
	public void paint(Graphics g){
		super.paint(g);
		
		//paint the player
		g.fillRect(100, Height, 10, 10);
		
		//paint ground one
		//x, y, width, height
		g.fillRect(groundOne[0], groundOne[1], 500, 10);
		
		//paint ground two
		//x, y, width, height
		g.fillRect(groundtwo[0], groundtwo[1], 500, 10);
	
	}
	
	//receive key press
	@Override
	public void keyPressed(KeyEvent e) {
		
		int k = e.getKeyCode();
		
		//left
		if((k == 65)|(k == 37)){
		
		//up
		}else if((k == 87)|(k == 38)) {
			
			//jumping
			if(jumped){
				
			}else{
				
				Height -= 100;
				jumped = true;
			
			}
		
		//right
		}else if((k == 68)|(k == 39)){
			
		//down
		}else if((k == 83)|(k == 40)){
			
		//stop
		}else {
		}
	}
	
	//no use
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
	//no use
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
	//generate a new block
	private static int[] generateBlock(){
		//declare a new random
		Random random = new Random();
		
		// x of the block , y of the block
		int[] back = {600,random.nextInt(100)};
		return back;
	}
	
	//check if the block is still in the panel
	private static boolean BlockExist(int[] i){
		
		if (i[0] <= -500) {
			return false;
		}
		return true;
	}
	
	//check how high is the ground level
	private static int level(){
		
		//check if x = 100 is ground one
		if (100 >= groundOne[0] & -400 <= groundOne[1]) {
			
		}
		return Height;
		
	}
	
	//end of the code
}