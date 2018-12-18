package catan;

public class HexData {
	private boolean robber = false;
    private int resource;
    private int chit;
    
    public HexData(boolean robber, int resource, int chit) {
    	this.robber = robber;
    	this.resource = resource;
    	this.chit = chit;
    }
    
    public boolean getRobber() {
    	return robber;
    }
    
    public void setRobber(boolean rob) {
    	this.robber = rob;
    }
    
    public int getResource() {
    	return resource;
    }
    
    public void setResource(int resource) {
    	this.resource = resource;
    }
    
    public int getChit() {
    	return chit;
    }
    
    public void setChit(int chit) {
    	this.chit = chit;
    }
}
