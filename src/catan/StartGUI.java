package catan;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.util.Random;

public class StartGUI extends JFrame{
	private static int WIDTH = 550;
	private static int HEIGHT = 550;
	
	// Class variables 
	String Options[] = new String [11];
	private int NumPlayers;
	private String Condiction;
	private String [] PlayersNames = new String[4];
	private String [] PlayersColors = new String[4];
	private int [] Order = new int[4];
	
	
	// GUI variables
	private JTextField [] Players = new JTextField[4];
	private String [] Colors = {"Blue","Orange","White","Red"};
	private JComboBox NewColor[] = new JComboBox[4];
	private JLabel [] PlayersLabel= new JLabel[4];
	private JLabel [] ColorLabel= new JLabel[4];
	private String [] BooleanStatements = {"YES", "No"};
	private JComboBox [] booleanStatements = new JComboBox[2];
	private JLabel [] BooleanLabel = new JLabel[2];
	private JTextArea errorArea;
	private JLabel condictionLabel;
	private JTextField condictionField;
	private JButton build;
	
	public StartGUI(){// the constructor for the GUI
		//Implementation action listener 
				
		setTitle("Hello Welcome to Catan");
		setSize(WIDTH, HEIGHT);
		
		Container pane = getContentPane();
		pane.setLayout(null); 
		
		//Instantiate objects of GUI components
		for (int i = 0; i<PlayersLabel.length; i++ ) {
			PlayersLabel [i]= new JLabel("Name of player " +i);
			Players[i] = new JTextField();
			ColorLabel[i] = new JLabel("Color of player " +i);
			NewColor[i] = new JComboBox <String>(Colors);
		}
		// Labels for Boolean Expressions 
		BooleanLabel [0] = new JLabel("Do you want to randomize the chites");
		BooleanLabel [1] = new JLabel("Do you want the land to be randomize");
		// Instantiate Boolean Objects for GUI
		for (int i = 0; i<BooleanLabel.length; i++) {
			booleanStatements[i] = new JComboBox <String>(BooleanStatements);
		}
		
		errorArea = new JTextArea("Message If You Fuck Up"); 
		condictionLabel = new JLabel("Win Condiction");
		condictionField = new JTextField();
		build = new JButton("Build");
//		processButtonHandler processBHandler = new processButtonHandler();
//		build.addActionListener(processBHandler);
	
	
		
		// Method for location and size of objects
		int counter = 1;
		int nextWidth = 200; 
		for (int i = 0; i<Players.length; i++ ) {
			int temp = counter * 20;
			int width = temp + 200;
			Players [i].setLocation(300,width);
			Players [i].setSize(200,20);
			PlayersLabel [i].setSize(200,20);
			PlayersLabel [i].setLocation(40,width);
			NewColor [i].setSize(200,20);
			NewColor [i].setLocation(300,80+width);
			ColorLabel [i].setSize(200,20);
			ColorLabel [i].setLocation(40,80+width);
			counter++;
			nextWidth = width;
		}
		for (int i= 0; i<booleanStatements.length; i++) {
			int temp = counter * 20;
			int width = temp + nextWidth;
			booleanStatements [i].setLocation(300,width);
			booleanStatements [i].setSize(200,20);
			BooleanLabel [i].setSize(200,20);
			BooleanLabel [i].setLocation(40,width);
			counter++;
		}
		
		condictionLabel.setLocation(40,420);
		condictionLabel.setSize(200,20);

		condictionField.setLocation(300,420);
		condictionField.setSize(200,20);
		
		errorArea.setLocation(40,10);
		errorArea.setSize(470,180);
		build.setLocation(200,440);
		build.setSize(100,20);
		
		
		// Adding objects to container
		for (int i = 0; i<Players.length; i++) {
			pane.add(Players[i]);
			pane.add(PlayersLabel[i]);
			pane.add(ColorLabel[i]);
			pane.add(NewColor[i]);
		}
		for (int i =0; i<booleanStatements.length; i++) {
			pane.add(booleanStatements[i]);
			pane.add(BooleanLabel[i]);
		}
		pane.add(errorArea);
		pane.add(condictionLabel);
		pane.add(condictionField);
		pane.add(build);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//registering the gui components to the controller
	public void registerListener(CatanController controller) {
		
		build.addActionListener(controller);
		
		NewColor[0].addActionListener(controller);
		NewColor[0].setActionCommand("p1color");
		
		NewColor[1].addActionListener(controller);
		NewColor[1].setActionCommand("p2color");
		
		NewColor[2].addActionListener(controller);
		NewColor[2].setActionCommand("p3color");
		
		NewColor[3].addActionListener(controller);
		NewColor[3].setActionCommand("p4color");
		
		
		Players[0].addActionListener(controller);
		Players[0].setActionCommand("p1name");
		
		Players[1].addActionListener(controller);
		Players[1].setActionCommand("p2name");
		
		Players[2].addActionListener(controller);
		Players[2].setActionCommand("p3name");
		
		Players[3].addActionListener(controller);
		Players[3].setActionCommand("p4name");
		
		condictionField.addActionListener(controller);
		condictionField.setActionCommand("winCondition");
				
	}
	
	
	
	//methods to send user info to controller
	public int getWinAmount() {
		int jml = Integer.parseInt(condictionField.getText());
		return jml;
	}
	public String getColorOne() {
		return NewColor[0].getSelectedItem().toString();
	}
	public String getColorTwo() {
		return NewColor[1].getSelectedItem().toString();
	}
	public String getColorThree() {
		return NewColor[2].getSelectedItem().toString();
	}
	public String getColorFour() {
		return NewColor[3].getSelectedItem().toString();
	}
	public String getNameOne() {
		return Players[0].getText();
	}
	public String getNameTwo() {
		return Players[1].getText();
	}
	public String getNameThree() {
		return Players[2].getText();
	}
	public String getNameFour() {
		return Players[3].getText();
	}
	// Class to handle event listener for testing
//	private class processButtonHandler implements ActionListener{//class to handle the Button
//		@Override
//		public void actionPerformed(ActionEvent arg0) {// the method of the button controls
//			if (arg0.getActionCommand().contains("Build")) {
//				int counter = 0;
//
//				for(int i =0; i<Players.length; i++) {
//					Options[counter] = Players[i].getText();	
//					counter++;}
//				for(int i =0; i<Players.length; i++) {
//					Options[counter] = NewColor[i].getSelectedItem().toString();
//					counter++;}
//				for (int i=0; i<BooleanStatements.length; i++) {
//					Options[counter] = booleanStatements[i].getSelectedItem().toString();
//					counter++;
//				}
//				Options[counter] = condictionField.getText();
//				}
//	}
	public String [] getValues() {
		String temp[] = new String [0];
		
		
		return temp;
	}
	
	
	
	
	public static int getWIDTH() {
		return WIDTH;
	}

	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public int getNumPlayers() {
		return NumPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		NumPlayers = numPlayers;
	}

	public String getCondiction() {
		return Condiction;
	}

	public void setCondiction(String condiction) {
		Condiction = condiction;
	}

	public String[] getPlayersNames() {
		return PlayersNames;
	}

	public void setPlayersNames(String[] playersNames) {
		PlayersNames = playersNames;
	}

	public String[] getPlayersColors() {
		return PlayersColors;
	}

	public void setPlayersColors(String[] playersColors) {
		PlayersColors = playersColors;
	}

	public int[] getOrder() {
		return Order;
	}

	public void setOrder(int[] order) {
		Order = order;
	}

	public JTextField[] getPlayers() {
		return Players;
	}

	public void setPlayers(JTextField[] players) {
		Players = players;
	}

	public String[] getColors() {
		return Colors;
	}

	public void setColors(String[] colors) {
		Colors = colors;
	}

	public JComboBox[] getNewColor() {
		return NewColor;
	}

	public void setNewColor(JComboBox[] newColor) {
		NewColor = newColor;
	}

	public JLabel[] getPlayersLabel() {
		return PlayersLabel;
	}

	public void setPlayersLabel(JLabel[] playersLabel) {
		PlayersLabel = playersLabel;
	}

	public JLabel[] getColorLabel() {
		return ColorLabel;
	}

	public void setColorLabel(JLabel[] colorLabel) {
		ColorLabel = colorLabel;
	}

//	public String[] getBooleanStatements() {
//		return BooleanStatements;
//	}

	public void setBooleanStatements(String[] booleanStatements) {
		BooleanStatements = booleanStatements;
	}

	public JComboBox[] getBooleanStatements() {
		return booleanStatements;
	}

	public void setBooleanStatements(JComboBox[] booleanStatements) {
		this.booleanStatements = booleanStatements;
	}

	public JLabel[] getBooleanLabel() {
		return BooleanLabel;
	}

	public void setBooleanLabel(JLabel[] booleanLabel) {
		BooleanLabel = booleanLabel;
	}

	public JTextArea getErrorArea() {
		return errorArea;
	}

	public void setErrorArea(JTextArea errorArea) {
		this.errorArea = errorArea;
	}

	public JLabel getCondictionLabel() {
		return condictionLabel;
	}

	public void setCondictionLabel(JLabel condictionLabel) {
		this.condictionLabel = condictionLabel;
	}

	public JTextField getCondictionField() {
		return condictionField;
	}

	public void setCondictionField(JTextField condictionField) {
		this.condictionField = condictionField;
	}

	public JButton getBuild() {
		return build;
	}

	public void setBuild(JButton build) {
		this.build = build;
	}

	// Interface methods
	public String logicOption(String input) {
		String temp = ""; 
		return temp;
	}
	public String StringOption(String input){
		String temp = ""; 
		return temp;
	}
	public String NumberOption(String input){
		String temp = ""; 
		return temp;
	}
	public String GeneralCatch(String input){
		String temp = "";
		return temp;
	}
	public String OutOfOrder(String input){
		String temp = ""; 
		return temp;
	}
	public String[] getOptions() {
		return Options;
	}

	public void setOptions(String[] options) {
		Options = options;
	}
	
}
