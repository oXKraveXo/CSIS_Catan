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
	private int NumPlayers;
	private String Condiction;
	private String [] PlayersNames = new String[4];
	private String [] PlayersColors = new String[4];
	private int [] Order = new int[4];
	
	
	// GUI variables
	private JTextField [] Players = new JTextField[4];
	private String [] Colors = {"B","O","W","R"};
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
		
		// Implementation action listener 
		processButtonHandler processBHandler = new processButtonHandler();
		build.addActionListener(processBHandler);
		
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
		NewColor[1].addActionListener(controller);
		NewColor[2].addActionListener(controller);
		NewColor[3].addActionListener(controller);
		Players[0].addActionListener(controller);
		Players[1].addActionListener(controller);
		Players[2].addActionListener(controller);
		Players[3].addActionListener(controller);
				
	}
	
	// Class to handle event listener for testing
	private class processButtonHandler implements ActionListener{//class to handle the Button
		@Override
		public void actionPerformed(ActionEvent arg0) {// the method of the button controls
		boolean test = true;
		// After the catch throw return test 	
		if (test) {
			// Code to bring values from the view to model to intiate the users 
				
			}		
		}
		}
    }
