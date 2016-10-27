package jump;

import javax.swing.JFrame;

public class jump extends JFrame{
	static jpanel p = new jpanel();
	public static void main(String[] args){
		jump w = new jump();
		w.setVisible(true);
		w.setContentPane(p);
	}
	public jump(){
		setBounds(100,100,600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}	
}