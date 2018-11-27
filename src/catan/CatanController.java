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
			System.out.println("the controller then tells the board to build itself");
			CatanView view = new CatanView();
			view.registerListener(controller);
			JFrame f = new JFrame();
	        f.setContentPane(view);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.pack();
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
	     
	        //color selection sdf
		} else if(command.equals("p1color")) {
			System.out.println("updating player 1 color to " + view.getColorOne());
			model.setUserOneColor(view.getColorOne());
		} else if(command.equals("p2color")) {
			System.out.println("updating player 2 color to " + view.getColorTwo());
			model.setUserTwoColor(view.getColorTwo());
		} else if(command.equals("p3color")) {
			System.out.println("updating player 3 color to " + view.getColorThree());
			model.setUserThreeColor(view.getColorThree());
		} else if(command.equals("p4color")) {
			System.out.println("updating player 4 color to " + view.getColorFour());
			model.setUserFourColor(view.getColorFour());
		}
		
			
	}

	

}//end class
