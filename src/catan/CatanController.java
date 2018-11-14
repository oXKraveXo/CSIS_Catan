package catan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CatanController implements ActionListener{
	
	//to connect the M, V, and C together
	private CatanModel model;
	private CatanView view;
	
	/**
	 * This saves the model and and view.
	 * 
	 * model is a Model for the functions of the game and the inputs
	 * from the user
	 * 
	 * view is a View for what should be displayed in the GUI
	 */
	public CatanController(CatanModel model, CatanView view) {
		
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		/*
		 * this is the end of the code example for sprint zero
		 * in here we will have to put all the different actions that can be taken
		 * in the game and then from here it will tell the model what to do
		 */
	}

	

}//end class
