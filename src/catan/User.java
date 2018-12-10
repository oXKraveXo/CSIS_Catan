package catan;

import java.util.Arrays;

public class User {
	
	// Class variables 
	String name;
	String color;
	int orderNum;
	int settlements;
	int cities;
	int roads;
	int cards;
	Cards [] usersCards; 
	int condiction;
	int [] resorces; 
	int resourceCounter = 0;

	// Initialization of object
	public User () {
		
	}
	public User (String name, String color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces) {
		this.name = name;
		this.color = color;
		this.orderNum = orderNum;
		this.settlements = settlements;
		this.cities = cities;
		this.roads = roads;
		this.usersCards = usersCards;
		this.condiction = condiction;
		this.resorces = resorces;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getSettlements() {
		return settlements;
	}
	public void setSettlements(int settlements) {
		this.settlements = settlements;
	}
	public int getCities() {
		return cities;
	}
	public void setCities(int cities) {
		this.cities = cities;
	}
	public int getRoads() {
		return roads;
	}
	public void setRoads(int roads) {
		this.roads = roads;
	}
	public int getCondiction() {
		return condiction;
	}
	public void setCondiction(int condiction) {
		this.condiction = condiction;
	}
	public int[] getResorces() {
		return resorces;
	}
	public void setResorces(int[] resorces) {
		this.resorces = resorces;
	}
	
	public void addResources(int type) {
		resorces[resourceCounter] = type;
		resourceCounter++;
	}
	
	public boolean hasResource(int type, int amount) {
		int counter = 0;
		for(int i = 0; i < resorces.length; i++) {
			if(resorces[i] == type) {
				counter++;
				if(counter == amount) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void addVP(int amount) {
		condiction+= amount;
	}
	
	public void removeResources(int type, int amount) {

	}

	public void addSettlements() {
		settlements++;
	}

	public void addCities() {
		cities++;
	}

	public void addRoads() {
		roads++;
	}
	
	public void addCards() {
		cards++;
	}
	
	public int getCards() {
		return cards;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", color=" + color + ", orderNum=" + orderNum + ", settlements=" + settlements
				+ ", cities=" + cities + ", roads=" + roads + ", usersCards=" + Arrays.toString(usersCards)
				+ ", condiction=" + condiction + ", resorces=" + Arrays.toString(resorces) + "]";
	}
	

}
