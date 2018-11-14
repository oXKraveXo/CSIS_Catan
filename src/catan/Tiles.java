package catan;

import java.util.Arrays;

public class Tiles {
	boolean rober;
	int [] roadSlots = new int[6]; 
	int [] citySlots = new int[6]; 
	int chit;
	int tile;
	
	
	public Tiles(int chit, int tile) {
		for (int i =0; i<6; i++) {
			roadSlots[i] = 1; //positions 0-5 are open
			citySlots[i] = 1; //positions 0-5 are open
		}
		this.chit = chit; //tile production #
		this.tile = tile; //tile production type
		this.rober = false; //state of production blocade
	}
	public int[] getRoadSlots() {
		return roadSlots; //returns open road slots
	}
	public void setRoadSlots(int[] roadSlots) {
		this.roadSlots = roadSlots; //sets the current open road slots
	}
	public int[] getCitySlots() {
		return citySlots; //returns open city slots
	}
	public void setCitySlots(int[] citySlots) {
		this.citySlots = citySlots; //sets current open city slots
	}
	public int getChit() {
		return chit; //returns tile production #
	}
	public void setChit(int chit) {
		this.chit = chit; //sets current production # (should this be avalible?)
	}
	public int getTile() {
		return tile; //returns tile production type
	}
	public void setTile(int tile) {
		this.tile = tile; //sets tile production type
	}
	public boolean getRober() {
		return rober; //returns state of production blocade
	}
	public void setRober(boolean rober) {
		this.rober = rober; //sets current state of blocade
	}
	@Override
	public String toString() {
		return "Tiles [roadSlots=" + Arrays.toString(roadSlots) + ", citySlots=" + Arrays.toString(citySlots)
				+ ", chit=" + chit + ", tile=" + tile + ", rober="+rober+"]";
	} 

}
