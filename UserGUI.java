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

public class UserGUI extends JFrame {
	private static int WIDTH = 2200;
	private static int HEIGHT = 550;
	
	// Class variables 
	User user = getUser();
	
	// Class variables for use in GUI
	String name = user.getName();
	char color = user.getColor();
	int orderNum = user.getOrderNum();
	int settlements = user.getSettlements();
	int cities = user.getCities();
	int roads = user.getRoads();
	//Cards [] usersCards; 
	int condiction = user.getCondiction();
	int [] resorces = user.getResorces(); 
	int c = 0;
	
	// GUI variables
	private JTextArea errorArea;
	private JLabel nameLabel;
	private JLabel colorLabel;
	private JLabel orderNumLabel;
	private JLabel settlementsLabel;
	private JLabel citiesLabel;
	private JLabel roadsLabel;
	private JLabel condictionLabel;
	private JLabel resorcesLabel;
	private JButton Task_1;
	private JLabel Task_1_Notes;
	private JLabel Roll;
	private JButton Task_2A;
	private JButton Task_2B;
	private JButton Task_2C;
	private JLabel Task_2_Notes;
	private JButton Task_3;
	private JLabel Task_3_Notes;
	private String [] Task_1_Choices = {"1","2","3","......"};
	private JComboBox<String> Task_1_Box = new JComboBox<String>(Task_1_Choices);
	private String [] Task_2A_Choices = {"Player 1","Player 2","Player 3","......"};
	private JComboBox<String> Task_2A_Box = new JComboBox<String>(Task_2A_Choices);
	private String [] Task_2B_Choices = {"Play Card 1","Play Card 2","Play Card 3","......"};
	private JComboBox<String> Task_2B_Box = new JComboBox<String>(Task_2B_Choices);
	private String [] Task_2C_Choices = {"Settlement","City","Card","Road"};
	private JComboBox<String> Task_2C_Box = new JComboBox<String>(Task_2C_Choices);
	private JButton ChangeCard;
	
	private JLabel card_Num;
	private JLabel knight_Image;
	private JLabel uw_Image;
	private JLabel road_Image;
	
	Container pane = getContentPane();
	public UserGUI()  throws IOException{// the constructor for the GUI
		setTitle("Hello Welcome to User Interface");		
		setSize(WIDTH, HEIGHT);
//		
		pane.setLayout(null); 
		pane.setBackground(getColor());
		//Instantiate objects of GUI components
		
		errorArea = new JTextArea("Message If You Fuck Up"); 
		nameLabel = new JLabel("This is the name "+ name);
		colorLabel = new JLabel("This is the color "+ color);
		orderNumLabel = new JLabel("This is the orderNum "+ orderNum);
		settlementsLabel = new JLabel("This is the settlements "+ settlements);
		citiesLabel = new JLabel("This is the cities "+ cities);
		roadsLabel = new JLabel("This is the roads "+ roads);
		condictionLabel = new JLabel ("This is the users condiction poiint "+ condiction);
		resorcesLabel = new JLabel ("Wheet "+resorces[0]+ " Stone " +resorces[1]+ " Clay " +resorces[2] + " Sheep " + resorces[3] + " Wood " + resorces[4] );
		Task_1 = new JButton("Roll");
		Task_1_Notes = new JLabel("<html>You will need to select on the phase one button to start your round <BR> If you Roll a 7 please use the drop down box below to move the Robber<html>");
		Roll = new JLabel("");
		Roll.setFont(new Font("Courier", Font.BOLD,75));
		Task_2A = new JButton("Trade");
		Task_2B = new JButton("Card");
		Task_2C = new JButton("Build");
		Task_2_Notes = new JLabel("<html>In Phase two you can select three diffrent things you can do. <BR>1.  First you can trade. <BR>2.  Secound you can play a Deployment Card. <BR>3.  Third you can build <html>");
		Task_3 = new JButton("End Turn");
		Task_3_Notes = new JLabel("<html>When you select on the end phase your points will be celculated<BR> and the next players turn will start.<html>");
		ChangeCard = new JButton("Deck");
		card_Num = new JLabel("This is the num of ");
		processButtonHandler processBHandler = new processButtonHandler();
		Task_1.addActionListener(processBHandler);
		Task_2A.addActionListener(processBHandler);
		Task_2B.addActionListener(processBHandler);
		Task_2C.addActionListener(processBHandler);
		Task_3.addActionListener(processBHandler);
		ChangeCard.addActionListener(processBHandler);
		
		
		// Method for location and size of objects
		nameLabel.setLocation(440,200);
		nameLabel.setSize(200,20);
		colorLabel.setLocation(440,220);
		colorLabel.setSize(200,20);
		orderNumLabel.setLocation(440,240);
		orderNumLabel.setSize(200,20);
		settlementsLabel.setLocation(440,260);
		settlementsLabel.setSize(200,20);
		citiesLabel.setLocation(440,280);
		citiesLabel.setSize(200,20);
		roadsLabel.setLocation(440,300);
		roadsLabel.setSize(200,20);
		condictionLabel.setLocation(440,320);
		condictionLabel.setSize(400,20);
		resorcesLabel.setLocation(440,340);
		resorcesLabel.setSize(400,20);
		errorArea.setLocation(440,10);
		errorArea.setSize(470,180);
		Task_1.setLocation(1000,40);
		Task_1.setSize(100,20);
		Task_1_Notes.setLocation(1000,0);
		Task_1_Notes.setSize(400,40);
		Task_1_Box.setLocation(1000,60);
		Task_1_Box.setSize(100,20);
		Roll.setLocation(1150,80);
		Roll.setSize(100,100);
		Task_2A.setLocation(1000,260);
		Task_2A.setSize(100,20);
		Task_2B.setLocation(1200,260);
		Task_2B.setSize(100,20);
		Task_2C.setLocation(1400,260);
		Task_2C.setSize(100,20);
		Task_2_Notes.setLocation(1000,200);
		Task_2_Notes.setSize(400,60);
		Task_2A_Box.setLocation(1000,280);
		Task_2A_Box.setSize(100,20);
		Task_2B_Box.setLocation(1200,280);
		Task_2B_Box.setSize(100,20);
		Task_2C_Box.setLocation(1400,280);
		Task_2C_Box.setSize(100,20);
		Task_3.setLocation(1000,400);
		Task_3.setSize(100,20);
		Task_3_Notes.setLocation(1000,420);
		Task_3_Notes.setSize(400,40);
		ChangeCard.setLocation(1645,470);
		ChangeCard.setSize(110,20);
		card_Num.setLocation(1645,0);
		card_Num.setSize(110,20);
		
		// Adding objects to container
		BufferedImage Help_Image = ImageIO.read(new File("C:\\Capture.PNG"));
		JLabel help_Image = new JLabel(new ImageIcon(Help_Image));
		BufferedImage UW_Image = ImageIO.read(new File("C:\\UW.PNG"));
		uw_Image = new JLabel(new ImageIcon(UW_Image));
		BufferedImage Knight_Image = ImageIO.read(new File("C:\\Knight.PNG"));
		knight_Image = new JLabel(new ImageIcon(Knight_Image));
		BufferedImage Road_Image = ImageIO.read(new File("C:\\RoadBuilding.PNG"));
		road_Image = new JLabel(new ImageIcon(Road_Image));
		
		uw_Image.setVisible(false);
		knight_Image.setVisible(false);
		road_Image.setVisible(false);
		
		help_Image.setLocation(0,0);
		help_Image.setSize(400,500);
		
		knight_Image.setLocation(1500,0);
		knight_Image.setSize(400,500);
		uw_Image.setLocation(1500,0);
		uw_Image.setSize(400,500);
		road_Image.setLocation(1500,0);
		road_Image.setSize(400,500);
		pane.add(help_Image);
		pane.add(knight_Image);
		pane.add(uw_Image);
		pane.add(road_Image);
		pane.add(errorArea);
		pane.add(nameLabel);
		pane.add(colorLabel);
		pane.add(orderNumLabel);
		pane.add(settlementsLabel);
		pane.add(citiesLabel);
		pane.add(roadsLabel);
		pane.add(condictionLabel);
		pane.add(resorcesLabel);
		pane.add(Task_1);
		pane.add(Task_1_Notes);
		pane.add(Task_1_Box);
		pane.add(Roll);
		pane.add(Task_2A);
		pane.add(Task_2B);
		pane.add(Task_2C);
		pane.add(Task_2_Notes);
		pane.add(Task_2A_Box);
		pane.add(Task_2B_Box);
		pane.add(Task_2C_Box);
		pane.add(Task_3);
		pane.add(Task_3_Notes);
		pane.add(ChangeCard);
		pane.add(card_Num);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	// Class to handle event listener for testing
	private class processButtonHandler implements ActionListener{//class to handle the Button
		@Override
		public void actionPerformed(ActionEvent e) {// the method of the button controls
			if(e.getActionCommand().contains("Roll")) 
				Roll.setText(""+ Roll());
		    else if (e.getActionCommand().contains("Trade")) {
		    	//"Player 1","Player 2","Player 3","......"
		    	if (Task_2A_Box.getSelectedItem() == "Player 1")
					System.out.println("Player 1");
				else if (Task_2A_Box.getSelectedItem() == "Player 2")
					System.out.println("Player 2");
				else if (Task_2A_Box.getSelectedItem() == "Player 3")
					System.out.println("Player 3");
				else if (Task_2A_Box.getSelectedItem() == "......")
					System.out.println("Player 4");
		    	System.out.println("Trade");}
		    else if (e.getActionCommand().contains("Card")) 
		    	System.out.println("Card");
		    else if (e.getActionCommand().contains("Build")) {
				if (Task_2C_Box.getSelectedItem() == "Settlement")
					System.out.println("Settlement");
				else if (Task_2C_Box.getSelectedItem() == "City")
					System.out.println("City");
				else if (Task_2C_Box.getSelectedItem() == "Card")
					System.out.println("Card");
				else if (Task_2C_Box.getSelectedItem() == "Road")
					System.out.println("Road");
		    	System.out.println("Build");
		    }
		    else if (e.getActionCommand().contains("End Turn")) 
		    	System.out.println("Ended turn");
		    else if (e.getActionCommand().contains("Deck")) {
		    	c++;
		    	if (c ==1) {
			    	uw_Image.setVisible(true);
					knight_Image.setVisible(false);
					road_Image.setVisible(false);
					card_Num.setText("This is the num of "+c);}
		    	else if (c==2) {
		    		uw_Image.setVisible(false);
					knight_Image.setVisible(true);
					road_Image.setVisible(false);
					card_Num.setText("This is the num of "+c);}
		    	else if (c==3) {
		    		uw_Image.setVisible(false);
					knight_Image.setVisible(false);
					road_Image.setVisible(true);
					card_Num.setText("This is the num of "+c);}
		    	System.out.println("Shit");
		    }
			pane.validate();
	    }
	}
	public User getUser() {
		String name = "TestName";
		char color = 'B';
		int orderNum = 1;
		int settlements = 5;
		int cities = 4;
		int roads = 15;
		Cards [] usersCards = new Cards [20];
		for (int i = 0; i< 10; i++)
			usersCards[i] = new Cards("temp", 5);
		int condiction = 10;
		int [] resorces = new int [5]; 
		for (int i = 0; i<resorces.length; i++)
			resorces[i] = i;
		User object = new User(name, color, orderNum, settlements, cities, roads, usersCards, condiction, resorces);
		return object;
	}
	public Color getColor() {
		Color temp = Color.BLACK;
		if (user.getColor()=='B')
			temp = new Color(158,202,225);
		else if (user.getColor()=='O')
			temp =new Color(253,174,107);
		else if (user.getColor()=='W')
			temp =new Color(240,240,240);
		else if (user.getColor()=='R')
			temp =new Color(252,146,114);
		else
			temp = Color.GRAY;
		return temp; 
	}
	public int Roll() {
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
}
