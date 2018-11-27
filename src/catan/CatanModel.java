package catan;

public class CatanModel {
	User [] users = new User[4];
	Cards [] usersCards = new Cards [0];
	// Constructor for this class
	
	public CatanModel() {
		
		// create the users in the program 
		for(int i=0; i<usersCards.length; i++)
			usersCards[i] = new Cards();
		int [] resorces = new int [5]; 
		for (int i=0; i<resorces.length; i++) 
			resorces[i] = 0;
		for (int i=0; i<users.length; i++) {
			//public User (String name, String color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces ) {
			users[i] = new User(" ", " ", i, 5, 4, 15, usersCards, i, resorces );
		}
	}
	
	public void setUserOneColor(String color) {

		users[0].setColor(color);
		System.out.println("user 1 color now " + color);
	}
	public void setUserTwoColor(String color) {

		users[1].setColor(color);
		System.out.println("user 2 color now " + color);
	}
	public void setUserThreeColor(String color) {

		users[2].setColor(color);
		System.out.println("user 3 color now " + color);
	}
	public void setUserFourColor(String color) {

		users[3].setColor(color);
		System.out.println("user 4 color now " + color);
	}
	public void setNameOne(String name) {
		users[0].setName(name);
		System.out.println("user 1 renamed to " + name);
	}
	public void setNameTwo(String name) {
		users[0].setName(name);
		System.out.println("user 2 renamed to " + name);
	}
	public void setNameThree(String name) {
		users[0].setName(name);
		System.out.println("user 3 renamed to " + name);
	}
	public void setNameFour(String name) {
		users[0].setName(name);
		System.out.println("user 4 renamed to " + name);
	}

	/**
	 *  this is the model of the MVC systemm
	 * 
	 *  we  will be storing the data of the game here in variables for the appropiate
	 *  pieces and also be defining the methods that will be the behavior of the game
	 * 
	 */

}
