package catan;

import java.util.Arrays;

public class User {
	
	// Class variables 
	String name;
	char color;
	int orderNum;
	int settlements;
	int cities;
	int roads;
	Cards [] usersCards; 
	int condiction;
	int [] resorces; 

	// Initialization of object
	public User () {
		
	}
	public User (String name, char color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces ) {
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
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
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
	@Override
	public String toString() {
		return "User [name=" + name + ", color=" + color + ", orderNum=" + orderNum + ", settlements=" + settlements
				+ ", cities=" + cities + ", roads=" + roads + ", usersCards=" + Arrays.toString(usersCards)
				+ ", condiction=" + condiction + ", resorces=" + Arrays.toString(resorces) + "]";
	}
	

}
