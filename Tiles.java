package catan;

import java.util.Arrays;

public class Tiles {
	int [] roadSlots = new int[6]; 
	int [] citySlots = new int[6]; 
	int chit;
	int tile;
	
	
	public Tiles(int chit, int tile) {
		for (int i =0; i<6; i++) {
			roadSlots[i] = 1;
			citySlots[i] = 1;
		}
		this.chit = chit;
		this.tile = tile;
	}
	public int[] getRoadSlots() {
		return roadSlots;
	}
	public void setRoadSlots(int[] roadSlots) {
		this.roadSlots = roadSlots;
	}
	public int[] getCitySlots() {
		return citySlots;
	}
	public void setCitySlots(int[] citySlots) {
		this.citySlots = citySlots;
	}
	public int getChit() {
		return chit;
	}
	public void setChit(int chit) {
		this.chit = chit;
	}
	public int getTile() {
		return tile;
	}
	public void setTile(int tile) {
		this.tile = tile;
	}
	@Override
	public String toString() {
		return "Tiles [roadSlots=" + Arrays.toString(roadSlots) + ", citySlots=" + Arrays.toString(citySlots)
				+ ", chit=" + chit + ", tile=" + tile + "]";
	} 

}
