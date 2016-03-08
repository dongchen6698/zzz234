package TD.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This is GUI class for Main Screen. It will show buttons(Start Game, Create Maps, EXIT GAME).
 * @author AlexChen
 */
public class MainScreen_View extends JFrame implements WindowListener{
	private JButton start,creat,exit;
	
	/**
	 * This method will initialize the windows size and other information.
	 */
	public MainScreen_View(){
		this.setSize(800,600);
		this.setTitle("Tower Defence for SOEN6441");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.GRAY);
		init();
	}
	
	/**
     * This method will initialize GUI components like button and Main Screen Panel.
     */
	public void init(){
		this.setLayout(null);
		creat = new JButton("Creat Maps");
		start = new JButton("Start Game");
		exit = new JButton("EXIT GAME");
		this.add(creat);
		this.add(start);
		this.add(exit);
		creat.setBounds(300, 100, 200,100);
		start.setBounds(300,250,200,100);
		exit.setBounds(300,400,200,100);
		
		this.addWindowListener(this);
	}
	
	/**
     * This method will add ActionListener to the buttons like Play, Create Map and Exit.
     * @param ListnerForButton ActionListner object.
     */
	public void addButtonClickListener(ActionListener ListenerButton){
		creat.addActionListener(ListenerButton);
		start.addActionListener(ListenerButton);
		exit.addActionListener(ListenerButton);	
	}

	/**
     * This method will set Main Screen on top.
     */
    public void setTopEnabled(){
        this.setAlwaysOnTop(true);
        this.setEnabled(true);
    }
    
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
