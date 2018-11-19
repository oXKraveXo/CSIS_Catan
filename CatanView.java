package catan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;


public class CatanView extends JPanel{
	
//-------------------------start board creation-----------------------------------------
	  private static final long serialVersionUID = 1L;
	    private final int WIDTH = 1200;
	    private final int HEIGHT = 800;

	    private Font font = new Font("Arial", Font.BOLD, 18);
	    FontMetrics metrics;
	    StartGUI startGUI;
	    UserGUI userInGUI;
	    CatanView test;
	   public CatanView() throws IOException{
		   startGUI = new StartGUI();
		   userInGUI = new UserGUI();
	        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
	   public CatanView(int num, User object) {
		   userInGUI.updateUser(object);  
	   }

	    @Override
	    public void paintComponent(Graphics g) {
	        Graphics2D g2d = (Graphics2D) g;
	        Point origin = new Point(WIDTH / 2, HEIGHT / 2);

	        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
	        g2d.setFont(font);
	        metrics = g.getFontMetrics();

	        drawCircle(g2d, origin, 300, true, true, 0x4488FF, 0);//300
	        drawHexGridLoop(g2d, origin, 5, 50, 8); //5, 50, 8 for standard board
	    }

	    private void drawHexGridLoop(Graphics g, Point origin, int size, int radius, int padding) {
	        double ang30 = Math.toRadians(30);
	        double xOff = Math.cos(ang30) * (radius + padding);
	        double yOff = Math.sin(ang30) * (radius + padding);
	        int half = size / 2;

	        for (int row = 0; row < size; row++) {
	            int cols = size - java.lang.Math.abs(row - half);

	            for (int col = 0; col < cols; col++) {
	                int xLbl = row < half ? col - row : col - half;
	                int yLbl = row - half;
	                int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
	                int y = (int) (origin.y + yOff * (row - half) * 3);

	                drawHex(g, xLbl, yLbl, x, y, radius);
	            }
	        }
	    }

	    private void drawHex(Graphics g, int posX, int posY, int x, int y, int r) {
	        Graphics2D g2d = (Graphics2D) g;

	        Hexagon hex = new Hexagon(x, y, r);
	        String text = String.format("%s : %s", coord(posX), coord(posY));
	        int w = metrics.stringWidth(text);
	        int h = metrics.getHeight();

	        hex.draw(g2d, x, y, 0, 0x008844, true);
	        hex.draw(g2d, x, y, 4, 0xFFDD88, false);

	        g.setColor(new Color(0xFFFFFF));
	        g.drawString(text, x - w/2, y + h/2);
	    }

	    private String coord(int value) {
	        return (value > 0 ? "+" : "") + Integer.toString(value);
	    }

	    public void drawCircle(Graphics2D g, Point origin, int radius,
	            boolean centered, boolean filled, int colorValue, int lineThickness) {
	        // Store before changing.
	        Stroke tmpS = g.getStroke();
	        Color tmpC = g.getColor();

	        g.setColor(new Color(colorValue));
	        g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_ROUND,
	                BasicStroke.JOIN_ROUND));

	        int diameter = radius * 2;
	        int x2 = centered ? origin.x - radius : origin.x;
	        int y2 = centered ? origin.y - radius : origin.y;

	        if (filled)
	            g.fillOval(x2, y2, diameter, diameter);
	        else
	            g.drawOval(x2, y2, diameter, diameter);

	        // Set values to previous when done.
	        g.setColor(tmpC);
	        g.setStroke(tmpS);
	    }
 //-----------------------------end board creation----------------------------------------
	
	    
	    
	/**
	 * Register the controller as the listener to the inputs from players
	 * 
	 * controller is The event handler for the game
	 */
	public void registerListener(CatanController controller) {
		
		/*
		 *  this method is where we will add action listeners for any buttons
		 *  or other input devices from the view
		 *  
		 *  button.addActionListener(controller); would be how you do that for a button
		 *  
		 *  we dont have the gui coded yet for sprint zero but this is where 
		 *  it would go in our architecture
		 *  
		 */
		
	}
	/**
	 *  the rest of these are just some shell examples of a few methods we would use
	 *  to build the gui
	 */
	public void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	public void setSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
//	private class processButtonHandler implements ActionListener{//class to handle the Button
//		@Override
//		public void actionPerformed(ActionEvent e) {// the method of the button controls
		//boolean test = true;
		// After the catch throw return test
//		for(int i =0; i<startGUI.getPlayers().length; i++) {
//			System.out.println("Players" + startGUI.getPlayers()[i].getText());	
//			System.out.println("Color " + startGUI.getNewColor()[i].getSelectedItem());	
//		}
//		for (int i=0; i<startGUI.getBooleanStatements().length; i++) {
//			System.out.println("Boolean " + startGUI.getBoolean2Statements()[i].getSelectedItem());
//		}
//		System.out.print("Condiction " + startGUI.getCondictionField().getText());
//		User [] userModel = new User[startGUI.getPlayers().length];
//		Cards [] usersCards = new Cards [0];
//		for(int i=0; i<usersCards.length; i++)
//			usersCards[i] = new Cards();
//		int [] resorces = new int [5]; 
//		for (int i=0; i<resorces.length; i++) 
//			resorces[i] = 0;
//		for (int i=0; i<userModel.length; i++) {
//			//public User (String name, String color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces ) {
//			userModel[i] = new User(startGUI.getPlayers()[i].getText(), String.valueOf(startGUI.getNewColor()[i].getSelectedItem()), i, 5, 4, 15, usersCards, i, resorces );
//		}
//			for (int i = 0; i< startGUI.getPlayers().length ; i++ ) {
//			System.out.println("Test this shit " + userModel[i]);
//		}
//			userInGUI.pane.setBackground(userInGUI.getColor("White"));
//			userInGUI.getPane().validate();
//		//userInGUI.updateUser(userModel[1]);
//		}
//		}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public FontMetrics getMetrics() {
		return metrics;
	}
	public void setMetrics(FontMetrics metrics) {
		this.metrics = metrics;
	}
	public StartGUI getStartGUI() {
		return startGUI;
	}
	public void setStartGUI(StartGUI startGUI) {
		this.startGUI = startGUI;
	}
	public UserGUI getUserInGUI() {
		return userInGUI;
	}
	public void setUserInGUI(UserGUI userInGUI) {
		this.userInGUI = userInGUI;
	}
	public CatanView getTest() {
		return test;
	}
	public void setTest(CatanView test) {
		this.test = test;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getWIDTH() {
		return WIDTH;
	}
	public int getHEIGHT() {
		return HEIGHT;
	}
	
}
