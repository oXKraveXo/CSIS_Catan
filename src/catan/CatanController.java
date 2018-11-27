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

		if(command.equals("Build")) {
			//builds the board
			System.out.println("building board");
			CatanView view = new CatanView();
			view.registerListener(controller);
			JFrame f = new JFrame();
	        f.setContentPane(view);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.pack();
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
	     
	        //color selection
		} else if(command.equals("p1color")) {
			model.setUserOneColor(view.getColorOne());
		} else if(command.equals("p2color")) {
			model.setUserTwoColor(view.getColorTwo());
		} else if(command.equals("p3color")) {
			model.setUserThreeColor(view.getColorThree());
		} else if(command.equals("p4color")) {
			model.setUserFourColor(view.getColorFour());
		} else if(command.equals("p1name")) {
			model.setNameOne(view.getNameOne());
		} else if(command.equals("p2name")) {
			model.setNameTwo(view.getNameTwo());
		} else if(command.equals("p3name")) {
			model.setNameThree(view.getNameThree());
		} else if(command.equals("p4name")) {
			model.setNameFour(view.getNameFour());
		}
		
			
	}

	

}//end class
