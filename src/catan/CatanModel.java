package catan;

import java.util.*;



public class CatanModel {
	User [] users = new User[4];
	Cards [] usersCards = new Cards [100];
	private Deck deck = new Deck();
	Scanner sc = new Scanner(System.in);
	int [] resources = new int [100];
	private final int WOOD = 1;
	private final int SHEEP = 2;
	private final int WHEAT = 3;
	private final int BRICK = 4;
	private final int STONE = 5;
	private int winAmount;
	
	
	//this tracks whose turn it is, 0 is user1, 1 is user2 etc..
	private int whoseTurn = 0;
	// Constructor for this class
	
	public CatanModel() {
		
		// create the users in the program 
		for(int i=0; i<usersCards.length; i++)
			usersCards[i] = new Cards(); 
		for (int i=0; i<resources.length; i++) 
			resources[i] = 0;
		for (int i=0; i<users.length; i++) {
			//public User (String name, String color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces ) {
			users[i] = new User(" ", " ", i, 0, 0, 0, usersCards, 0, resources );
		}
	}
	
	public void setWinCon(int num) {
		winAmount = num;
	}
	
	public void checkForWin() {
		if(users[whoseTurn].getCondiction() == winAmount) {
			System.out.println("user " + whoseTurn + " has won the game!!");
		}
	}
	
	public int rollDice() {
		int redNum;
		int yellowNum;
		do {  
			Random temp = new Random();
			redNum = temp.nextInt(7);
			yellowNum = temp.nextInt(7);
			}	
			while (redNum <= 0 || yellowNum <=0);
		return redNum+yellowNum;
	}
	
	public void giveResources(int roll) {
		if(roll == 6) {
			//test case for building a settlement
			users[whoseTurn].addResources(WOOD);
			users[whoseTurn].addResources(SHEEP);
			users[whoseTurn].addResources(WHEAT);
			users[whoseTurn].addResources(BRICK);
			System.out.println("you hit the roll to build a settlement (this is for testing only)");
			
		} else if(roll == 8) {
			//test case for building a city
			users[whoseTurn].addResources(WHEAT);
			users[whoseTurn].addResources(WHEAT);
			users[whoseTurn].addResources(WHEAT);
			users[whoseTurn].addResources(STONE);
			users[whoseTurn].addResources(STONE);
			System.out.println("you hit the roll to build a city (this is for testing only)");
		} else if(roll == 9) {
			//test case for building a road
			users[whoseTurn].addResources(WOOD);
			users[whoseTurn].addResources(BRICK);
		} else if(roll == 10) {
			//test case for dev card
			users[whoseTurn].addResources(WHEAT);
			users[whoseTurn].addResources(STONE);
			users[whoseTurn].addResources(SHEEP);
			System.out.println("you hit the roll to buy a card (this is for testing only)");
		}
	}
	
	public void build(String item) {
		if(item.equals("Settlement")) {
			if(users[whoseTurn].hasResource(WOOD, 1) && users[whoseTurn].hasResource(SHEEP,1) && users[whoseTurn].hasResource(WHEAT,1) && users[whoseTurn].hasResource(BRICK,1)) {
				users[whoseTurn].addSettlements();
				System.out.println("what location do you want to place the settlement?");
				int location = sc.nextInt();
				System.out.println("Placing settlement on location " + location);
				System.out.println("removing resources needed to build settlement");
				users[whoseTurn].addVP(1);
				
			}
		} else if(item.equals("City")) {
			if(users[whoseTurn].hasResource(STONE, 2) && users[whoseTurn].hasResource(WHEAT, 3)) {
				users[whoseTurn].addCities();;
				System.out.println("what location do you want to place the city");
				int location = sc.nextInt();
				System.out.println("Placing city on location " + location);
				System.out.println("removing resources needed to build city");
				users[whoseTurn].addVP(2);
			}
		} else if(item.equals("Road")) {
			if(users[whoseTurn].hasResource(WOOD, 1) && users[whoseTurn].hasResource(BRICK, 1)) {
				users[whoseTurn].addRoads();
				System.out.println("what location do you want to place the road");
				int location = sc.nextInt();
				System.out.println("Placing road on location " + location);
				System.out.println("removing resources needed to build road");
			}
		} else if(item.equals("Card")) {
			if(users[whoseTurn].hasResource(WHEAT, 1) && users[whoseTurn].hasResource(SHEEP, 1) && users[whoseTurn].hasResource(STONE, 1)) {
				System.out.println("drawing card");
				int cardNum = deck.drawCard();
				users[whoseTurn].addCards();
				if (cardNum <= 13)
					System.out.println("you drew a knight");
				if (cardNum >= 14 && cardNum < 17)
					System.out.println("you drew a road builder");
				if (cardNum > 17 && cardNum < 20)
					System.out.println("you drew a monopoly");
				if (cardNum >= 20 && cardNum < 25)
					System.out.println("you drew a victory point card");
					users[whoseTurn].addVP(1);
				
			}
		}
		
	}
	
	public void nextTurn() {
		
		whoseTurn++;
		if(whoseTurn == 1) {
			System.out.println("It is now User 2 turn");
		} else if(whoseTurn == 2) {
			System.out.println("It is now user 3 turn");
		} else if(whoseTurn == 3) {
			System.out.println("It is now user 4 turn");
		} else if(whoseTurn > 3) {
			whoseTurn = 0;
			System.out.println("It is now user 1 turn");
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
		users[1].setName(name);
		System.out.println("user 2 renamed to " + name);
	}
	public void setNameThree(String name) {
		users[2].setName(name);
		System.out.println("user 3 renamed to " + name);
	}
	public void setNameFour(String name) {
		users[3].setName(name);
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
	
	public int getWhoseTurn() {
		return whoseTurn;
	}
	
	public String getCurrentName() {
		return users[whoseTurn].getName();
	}
	
	public String getCurrentColor() {
		return users[whoseTurn].getColor();
	}
	
	public int getCurrentSettlements() {
		return users[whoseTurn].getSettlements();
	}
	
	public int getCurrentCities() {
		return users[whoseTurn].getCities();
	}
	
	public int getCurrentVP() {
		return users[whoseTurn].getCondiction();
	}
	
	public int getCurrentRoads() {
		return users[whoseTurn].getRoads();
	}

	/**
	 *  this is the model of the MVC systemm
	 * 
	 *  we  will be storing the data of the game here in variables for the appropiate
	 *  pieces and also be defining the methods that will be the behavior of the game
	 * 
	 */

}
