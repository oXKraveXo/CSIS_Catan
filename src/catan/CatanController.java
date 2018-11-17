package catan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class CatanController implements ActionListener{
	
	private CatanController controller;
	
	//to connect the M, V, and C together
	private CatanModel model;
	private StartGUI view;
	
	/**
	 * This saves the model and and view.
	 * 
	 * model is a Model for the functions of the game and the inputs
	 * from the user
	 * 
	 * view is a View for what should be displayed in the GUI
	 */
	public CatanController(CatanModel model, StartGUI view) {
		
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		System.out.println(command);
		
		if(command.equals("Build")) {
			System.out.println("the controller then tells the board to build itself");
			CatanView view = new CatanView();
			view.registerListener(controller);
			JFrame f = new JFrame();
	        f.setContentPane(view);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.pack();
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
		}else if(command.equals("comboBoxChanged")) {
			System.out.println("tell the model to update players color");
		}else {
			System.out.println("tell the model to update players name");
		}
		
		
		
		
		
	}

	

}//end class
