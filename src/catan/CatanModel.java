package catan;

import java.util.*;



public class CatanModel {
	User [] users = new User[4];
	Cards [] usersCards = new Cards [100];
	Scanner sc = new Scanner(System.in);
	int [] resources = new int [100];
	private final int WOOD = 1;
	private final int SHEEP = 2;
	private final int WHEAT = 3;
	private final int BRICK = 4;
	private final int STONE = 5;
	// Constructor for this class
	
	public CatanModel() {
		
		// create the users in the program 
		for(int i=0; i<usersCards.length; i++)
			usersCards[i] = new Cards(); 
		for (int i=0; i<resources.length; i++) 
			resources[i] = 0;
		for (int i=0; i<users.length; i++) {
			//public User (String name, String color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces ) {
			users[i] = new User(" ", " ", i, 5, 4, 15, usersCards, i, resources );
		}
	}
	
	public int rollDice() {
		int roll = (int )(Math.random() * 11 + 2);
		return roll;
	}
	
	public void giveResources(int roll) {
		if(roll == 6) {
			users[0].addResources(WOOD);
			System.out.println(users[0].getName() + " gets wood");
			users[0].addResources(SHEEP);
			System.out.println(users[0].getName() + " gets sheep");
			users[0].addResources(WHEAT);
			System.out.println(users[0].getName() + " gets wheat");
			users[0].addResources(BRICK);
			System.out.println(users[0].getName() + " gets brick");
		}
	}
	
	public void build(String item) {
		if(item.equals("Settlement")) {
			if(users[0].hasResource(WOOD) && users[0].hasResource(SHEEP) && users[0].hasResource(WHEAT) && users[0].hasResource(BRICK)) {
				System.out.println("what location do you want to place the settlement?");
				int location = sc.nextInt();
				System.out.println("Placing settlement on location " + location);
				System.out.println("removing resources needed to build settlement");
				
			}
		}
	}
	
	
	public void setUserOneColor(String color) {

		users[0].setColor(color);
	}
	public void setUserTwoColor(String color) {

		users[1].setColor(color);
	}
	public void setUserThreeColor(String color) {

		users[2].setColor(color);
	}
	public void setUserFourColor(String color) {

		users[3].setColor(color);
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
	
	public User getUserOne() {
		return users[0];
	}
	
	public User getUserTwo() {
		return users[1];
	}
	
	public User getUserThree() {
		return users[2];
	}
	
	public User getUserFour() {
		return users[3];
	}
	

	/**
	 *  this is the model of the MVC systemm
	 * 
	 *  we  will be storing the data of the game here in variables for the appropiate
	 *  pieces and also be defining the methods that will be the behavior of the game
	 * 
	 */

}
