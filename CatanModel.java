package catan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CatanModel {
	User [] usersModel;
	// Constructor for this class
	public CatanModel(int num) {
		usersModel = new User [4];
	}

	/**
	 *  this is the model of the MVC system
	 * 
	 *  we  will be storing the data of the game here in variables for the appropiate
	 *  pieces and also be defining the methods that will be the behavior of the game
	 * 
	 */
	// Class to handle event listener for testing
		private class processButtonHandler implements ActionListener{//class to handle the Button
			@Override
			public void actionPerformed(ActionEvent arg0) {// the method of the button controls
			boolean test = true;
			// After the catch throw return test
//			for(int i =0; i<startGUI.getPlayers().length; i++) {
//				System.out.println("Players" + startGUI.getPlayers()[i].getText());	
//				System.out.println("Color " + startGUI.getNewColor()[i].getSelectedItem());	
//			}
//			for (int i=0; i<startGUI.getBooleanStatements().length; i++) {
//				System.out.println("Boolean " + startGUI.getBoolean2Statements()[i].getSelectedItem());
//			}
//			System.out.print("Condiction " + startGUI.getCondictionField().getText());
//			User [] userModel = new User[startGUI.getPlayers().length];
//			Cards [] usersCards = new Cards [0];
//			for(int i=0; i<usersCards.length; i++)
//				usersCards[i] = new Cards();
//			int [] resorces = new int [5]; 
//			for (int i=0; i<resorces.length; i++) 
//				resorces[i] = 0;
//			for (int i=0; i<userModel.length; i++) {
//				//public User (String name, String color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces ) {
//				userModel[i] = new User(startGUI.getPlayers()[i].getText(), String.valueOf(startGUI.getNewColor()[i].getSelectedItem()), i, 5, 4, 15, usersCards, i, resorces );
//			}
//				for (int i = 0; i< startGUI.getPlayers().length ; i++ ) {
//				System.out.println("Test this shit " + userModel[i]);
//			}
//				for (int i =0; i<startGUI.getPlayers().length; i++) {
//					//usersGUI[i] = new UserGUI();
//					
//				}
			}
			}

	public User[] getUsersModel() {
		return usersModel;
	}

	public void setUsersModel(User[] usersModel) {
		this.usersModel = usersModel;
	}

}
