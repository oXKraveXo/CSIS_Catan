package catan;

import javax.swing.JFrame;

public class Catan {
	
	/*
	 * this class is just to create the MVC components
	 *  and then launch the application
	 */

	public static void main(String[] args) {
		
		//creating the model, view, and controller components of the system
		CatanView view = new CatanView();
		CatanModel model = new CatanModel();
		CatanController controller = new CatanController(model, view);
		
		//make the controller listen to the view for inputs
		view.registerListener(controller);
		
		
		/*
		* the following code loads the gui using the view
		*/
		JFrame f = new JFrame();

        f.setContentPane(view);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

	}

}
