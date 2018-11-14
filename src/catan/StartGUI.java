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
	private String Chites,LandRandom;
	
	
	// GUI variables
	private JTextField [] Players = new JTextField[4];
	private String [] Colors = {"B","O","W","R"};
	private JComboBox NewColor[] = new JComboBox[4];
	private JLabel [] PlayersLabel= new JLabel[4];
	private JLabel [] ColorLabel= new JLabel[4];
	private JTextArea errorArea;
	private JLabel chitesLabel;
	private JTextField chitesField;
	private JLabel landLabel;
	private JTextField landField;
	private JLabel condictionLabel;
	private JTextField condictionField;
	private JButton build;
	
	public StartGUI(){// the constructor for the GUI
		setTitle("Hello Welcome to Catan");
		setSize(WIDTH, HEIGHT);
		
		Container pane = getContentPane();
		pane.setLayout(null); 
		
		//Instantiate objects of GUI components
		for (int i = 0; i<4; i++ ) {
			PlayersLabel [i]= new JLabel("Name of player " +i);
			Players[i] = new JTextField();
			ColorLabel[i] = new JLabel("Color of player " +i);
			NewColor[i] = new JComboBox <String>(Colors); ;
		}
//		private JComboBox<String> Task_1_Box = new JComboBox<String>(Task_1_Choices);
//		private String [] Task_2A_Choices = {"Player 1","Player 2","Player 3","......"};
		errorArea = new JTextArea("Message If You Fuck Up"); 
		chitesLabel = new JLabel("Do you want to randomize the chites");
		chitesField = new JTextField();
		landLabel = new JLabel("Do you want the land to be randomize");
		landField = new JTextField();
		condictionLabel = new JLabel("Win Condiction");
		condictionField = new JTextField();
		build = new JButton("Build");

		processButtonHandler processBHandler = new processButtonHandler();
		build.addActionListener(processBHandler);
		
		// Method for location and size of objects
		int counter = 1;
		for (int i = 0; i<4; i++ ) {
			int temp = counter * 20;
			int width = temp + 200;
			int width2 = temp + 300; 
			
			Players [i].setLocation(300,width);
			Players [i].setSize(200,20);
			PlayersLabel [i].setSize(200,20);
			PlayersLabel [i].setLocation(40,width);
			NewColor [i].setSize(200,20);
			NewColor [i].setLocation(300,80+width);
			ColorLabel [i].setSize(200,20);
			ColorLabel [i].setLocation(40,80+width);
			counter++;
		}
		
		chitesLabel.setLocation(40,380);
		chitesLabel.setSize(200,20);
		landLabel.setLocation(40,400);
		landLabel.setSize(200,20);
		condictionLabel.setLocation(40,420);
		condictionLabel.setSize(200,20);
		
		chitesField.setLocation(300,380);
		chitesField.setSize(200,20);
		landField.setLocation(300,400);
		landField.setSize(200,20);
		condictionField.setLocation(300,420);
		condictionField.setSize(200,20);
		
		errorArea.setLocation(40,10);
		errorArea.setSize(470,180);
		build.setLocation(200,440);
		build.setSize(100,20);
		
		
		// Adding objects to container
		for (int i = 0; i<4; i++) {
			pane.add(Players[i]);
			pane.add(PlayersLabel[i]);
			pane.add(ColorLabel[i]);
			pane.add(NewColor[i]);
		}
		pane.add(errorArea);
		pane.add(chitesLabel);
		pane.add(chitesField);
		pane.add(landLabel);
		pane.add(landField);
		pane.add(condictionLabel);
		pane.add(condictionField);
		pane.add(build);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	// Class to handle event listener for testing
	private class processButtonHandler implements ActionListener{//class to handle the Button
		@Override
		public void actionPerformed(ActionEvent arg0) {// the method of the button controls
			Chites = chitesField.getText();
			LandRandom = landField.getText();
			Condiction = condictionField.getText();
			
			for (int i = 0; i < 4; i++) {
			PlayersNames [i]= Players[i].getText(); 
			//PlayersColors [i] = Colors[i].getText();
			}
			for (int i = 0; i<4; i++) {
				System.out.println("Test Name " + PlayersNames [i] + " Test Color " + PlayersColors [i] + " Test Order " + i );
			}
			System.out.println("Chites " + Chites + " Land " + LandRandom + " Condiction " + Condiction);
				//errorArea.setText("This is the error area \n" +"You have to many mines in your Game \n"+ "Name : "+name + "\nBoxes :" +box + "\nMines :"+mine);
		}
		}
    }
