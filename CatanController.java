package catan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


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
	public CatanController(CatanModel model, CatanView view)throws IOException {
		
		this.model = model;
		this.view = view;
		processButtonHandler processBHandler = new processButtonHandler();
		view.getStartGUI().getBuild().addActionListener(processBHandler);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		/*
		 * this is the end of the code example for sprint zero
		 * in here we will have to put all the different actions that can be taken
		 * in the game and then from here it will tell the model what to do
		 */
	}
	private class processButtonHandler implements ActionListener{//class to handle the Button
		@Override
		public void actionPerformed(ActionEvent e) {// the method of the button controls
		//boolean test = true;
		// After the catch throw return test
//		for(int i =0; i<startGUI.getPlayers().length; i++) {
//			System.out.println("Players" + startGUI.getPlayers()[i].getText());	
//			System.out.println("Color " + startGUI.getNewColor()[i].getSelectedItem());	
//		}
//		for (int i=0; i<startGUI.getBooleanStatements().length; i++) {
//			System.out.println("Boolean " + startGUI.getBoolean2Statements()[i].getSelectedItem());
//		}
//		System.out.print("Condiction " + startGUI.getCondictionField().getText());
		User [] userModel = new User[view.getStartGUI().getPlayers().length];
		Cards [] usersCards = new Cards [0];
		for(int i=0; i<usersCards.length; i++)
			usersCards[i] = new Cards();
		int [] resorces = new int [5]; 
		for (int i=0; i<resorces.length; i++) 
			resorces[i] = 0;
		for (int i=0; i<userModel.length; i++) {
			//public User (String name, String color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces ) {
			userModel[i] = new User(view.getStartGUI().getPlayers()[i].getText(), String.valueOf(view.getStartGUI().getNewColor()[i].getSelectedItem()), i, 5, 4, 15, usersCards, i, resorces );
		}
			for (int i = 0; i< view.getStartGUI().getPlayers().length ; i++ ) {
			System.out.println("Test this shit " + userModel[i]);
		}
			//System.out.println("Should work");
			//setUserView(1);
			view.getUserInGUI().pane.setBackground(view.getUserInGUI().getColor("White"));
			view.getUserInGUI().getPane().validate();
		//userInGUI.updateUser(userModel[1]);
		}
		}
	public void setUserView(int num) {
		//view.getUserInGUI().setName(model.getUsersModel()[num].getColor());
		//view.getUserInGUI().pane.setBackground(view.getUserInGUI().getColor("White"));
		//model.getUsersModel()[0].setColor("Orange");
		//view.getUserInGUI().pane.setBackground(view.getUserInGUI().getColor(model.getUsersModel()[0].getColor()));
		//System.out.println(model.getUsersModel()[0].getColor());
	}
	public void startSetUserModel() {
		for (int i =0; i<model.getUsersModel().length; i++) {
			//String name, String color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces 
		model.getUsersModel()[i].setName(String.valueOf(view.getStartGUI().getPlayers()[i]));
		model.getUsersModel()[i].setColor(String.valueOf(view.getStartGUI().getNewColor()[i]));
		//model.getUsersModel()[i].setName(String.valueOf(view.getStartGUI().getPlayers()[i])); this should be for place 
		model.getUsersModel()[i].setCondiction(view.getUserInGUI().getCondiction());
	}
		//model.getUserInGUI().getPane().validate();
	}
}//end class
