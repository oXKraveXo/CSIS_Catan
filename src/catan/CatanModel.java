package catan;

public class CatanModel {
	// Constructor for this class
	public CatanModel() {
		
	}
	public CatanModel(int num, String values[]) {
		
		// create the users in the program 
		User [] userModel = new User[num];
		Cards [] usersCards = new Cards [0];
		for(int i=0; i<usersCards.length; i++)
			usersCards[i] = new Cards();
		int [] resorces = new int [5]; 
		for (int i=0; i<resorces.length; i++) 
			resorces[i] = 0;
		for (int i=0; i<userModel.length; i++) {
			//public User (String name, String color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces ) {
			userModel[i] = new User(values [i], values[i+4], i, 5, 4, 15, usersCards, i, resorces );
		}
	}

	/**
	 *  this is the model of the MVC system
	 * 
	 *  we  will be storing the data of the game here in variables for the appropiate
	 *  pieces and also be defining the methods that will be the behavior of the game
	 * 
	 */

}
