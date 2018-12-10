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
	private static int WIDTH = 500;
	private static int HEIGHT = 1000;
	
	// Class variables 
	
	User user = new User();
	
	// Class variables for use in GUI
	String name = user.getName();
	String color = user.getColor();
	int orderNum = user.getOrderNum();
	int settlements = user.getSettlements();
	int cities = user.getCities();
	int roads = user.getRoads();
	//Cards [] usersCards; 
	int condiction = user.getCondiction();
	int [] resorces = user.getResorces(); 
	
	//
	int width= 200;
	int height = 20; 
	int widthLocation = 20; 
	int heightLocation = 460; 
	// use to test the Cards in Deck 
	int c = 0;
	
	// Left Side GUI Objects
	private JTextArea errorArea;
	private JLabel nameLabel;
	private JLabel colorLabel;
	private JLabel orderNumLabel;
	private JLabel settlementsLabel;
	private JLabel citiesLabel;
	private JLabel roadsLabel;
	private JLabel condictionLabel;
	private JLabel resorcesLabel;
	
	// Center GUI 
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
	
	// Right Side of the GUI
	private JButton ChangeCard;
	private JLabel card_Num;
	private JLabel help_Image;
	private JLabel knight_Image;
	private JLabel uw_Image;
	private JLabel road_Image;
	
	Container pane = getContentPane();
	public UserGUI()  throws IOException{// the constructor for the GUI
		
		// Set the Defaults for Container 
		setTitle("Hello Welcome to User Interface");		
		setSize(WIDTH, HEIGHT);
		pane.setLayout(null); 
		pane.setBackground(getColor("Blue"));
		
		//Instantiate objects of GUI components
		errorArea = new JTextArea("Message If You Fuck Up"); 
		nameLabel = new JLabel("This is the name "+ name);
		colorLabel = new JLabel("This is the color "+ color);
		orderNumLabel = new JLabel("This is the orderNum "+ orderNum);
		settlementsLabel = new JLabel("This is the settlements "+ settlements);
		citiesLabel = new JLabel("This is the cities "+ cities);
		roadsLabel = new JLabel("This is the roads "+ roads);
		condictionLabel = new JLabel ("This is the users condiction poiint "+ condiction);
		//resorcesLabel = new JLabel ("Wheet "+resorces[0]+ " Stone " +resorces[1]+ " Clay " +resorces[2] + " Sheep " + resorces[3] + " Wood " + resorces[4] );
		Task_1 = new JButton("Roll");
		Task_1_Notes = new JLabel("<html>You will need to select on the phase one button to start your round <BR> If you Roll a 7 please use the drop down box below to move the Robber<html>");
		Roll = new JLabel("");
		Roll.setFont(new Font("Courier", Font.BOLD,75));
		Task_2A = new JButton("Trade");
		Task_2B = new JButton("Play Card");
		Task_2C = new JButton("Build");
		Task_2_Notes = new JLabel("<html>In Phase two you can select three diffrent things you can do. <BR>1.  First you can trade. <BR>2.  Secound you can play a Deployment Card. <BR>3.  Third you can build <html>");
		Task_3 = new JButton("End Turn");
		Task_3_Notes = new JLabel("<html>When you select on the end phase your points will be calculated<BR> and the next players turn will start.<html>");
		ChangeCard = new JButton("Deck");
		card_Num = new JLabel("This is the num of ");
		
		//Grouping the buttons together to implement the ActionListenber
		processButtonHandler processBHandler = new processButtonHandler();
		Task_1.addActionListener(processBHandler);
		Task_2A.addActionListener(processBHandler);
		Task_2B.addActionListener(processBHandler);
		Task_2C.addActionListener(processBHandler);
		Task_3.addActionListener(processBHandler);
		ChangeCard.addActionListener(processBHandler);
		
		
		// Method for location and size of objects of display 1
		nameLabel.setLocation(widthLocation,updateHeightLocation());
		nameLabel.setSize(width,height);
		colorLabel.setLocation(widthLocation,updateHeightLocation());
		colorLabel.setSize(width,height);
		orderNumLabel.setLocation(widthLocation,updateHeightLocation());
		orderNumLabel.setSize(width,height);
		settlementsLabel.setLocation(widthLocation,updateHeightLocation());
		settlementsLabel.setSize(width,height);
		citiesLabel.setLocation(widthLocation,updateHeightLocation());
		citiesLabel.setSize(width,height);
		roadsLabel.setLocation(widthLocation,updateHeightLocation());
		roadsLabel.setSize(width,height);
		condictionLabel.setLocation(widthLocation,updateHeightLocation());
		condictionLabel.setSize(width,height);
		//resorcesLabel.setLocation(440,340);
		//resorcesLabel.setSize(400,20);
		Task_1.setLocation(widthLocation,updateHeightLocation());
		Task_1.setSize(100,20);
		Task_1_Notes.setLocation(widthLocation,updateHeightLocation());
		Task_1_Notes.setSize(400,40);
		Task_1_Box.setLocation(widthLocation,updateHeightLocation()+20);
		Task_1_Box.setSize(100,20);
		Roll.setLocation(300,updateHeightLocation()-200);
		Roll.setSize(100,100);
		System.out.println(""+ heightLocation);
		
		// Method for location and size of objects of display 2
		Task_2A.setLocation(20,620);
		Task_2A.setSize(100,20);
		Task_2B.setLocation(200,640);
		Task_2B.setSize(100,20);
		Task_2C.setLocation(380,620);
		Task_2C.setSize(100,20);
		Task_2_Notes.setLocation(20,680);
		Task_2_Notes.setSize(400,60);
		Task_2A_Box.setLocation(20,640);
		Task_2A_Box.setSize(100,20);
		Task_2B_Box.setLocation(200,660);
		Task_2B_Box.setSize(100,20);
		Task_2C_Box.setLocation(380,640);
		Task_2C_Box.setSize(100,20);
		Task_3.setLocation(20,800);
		Task_3.setSize(100,20);
		Task_3_Notes.setLocation(20,820);
		Task_3_Notes.setSize(400,40);
		
		ChangeCard.setLocation(200,620);
		ChangeCard.setSize(100,20);
		card_Num.setLocation(20,0);
		card_Num.setSize(110,20);
		errorArea.setLocation(440,10);
		errorArea.setSize(470,180);
		// Add Images to the GUI
		BufferedImage Help_Image = ImageIO.read(new File("Capture.PNG"));
		help_Image = new JLabel(new ImageIcon(Help_Image));
		BufferedImage UW_Image = ImageIO.read(new File("UW.PNG"));
		uw_Image = new JLabel(new ImageIcon(UW_Image));
		BufferedImage Knight_Image = ImageIO.read(new File("Knight.PNG"));
		knight_Image = new JLabel(new ImageIcon(Knight_Image));
		BufferedImage Road_Image = ImageIO.read(new File("RoadBuilding.PNG"));
		road_Image = new JLabel(new ImageIcon(Road_Image));
		
		// Set the Images to not show
		uw_Image.setVisible(false);
		knight_Image.setVisible(false);
		road_Image.setVisible(false);
		
		// Set the size and locations for my images
		help_Image.setLocation(30,0);
		help_Image.setSize(400,500);
		knight_Image.setLocation(30,0);
		knight_Image.setSize(400,500);
		uw_Image.setLocation(30,0);
		uw_Image.setSize(400,500);
		road_Image.setLocation(30,0);
		road_Image.setSize(400,500);
		
		// Add images to my pane 
		pane.add(help_Image);
		pane.add(knight_Image);
		pane.add(uw_Image);
		pane.add(road_Image);
		
		// Add my Java objects to pane my container object
		pane.add(errorArea);
		pane.add(nameLabel);
		pane.add(colorLabel);
		pane.add(orderNumLabel);
		pane.add(settlementsLabel);
		pane.add(citiesLabel);
		pane.add(roadsLabel);
		pane.add(condictionLabel);
		//pane.add(resorcesLabel);
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
		Task_2A.setVisible(false);
		Task_2B.setVisible(false);
		Task_2C.setVisible(false);
		Task_2_Notes.setVisible(false);
		Task_2A_Box.setVisible(false);
		Task_2B_Box.setVisible(false);
		Task_2C_Box.setVisible(false);
		Task_3.setVisible(false);
		Task_3_Notes.setVisible(false);
		ChangeCard.setVisible(false);
		card_Num.setVisible(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// Class to handle event listener for testing
	private class processButtonHandler implements ActionListener{//class to handle the Button
		@Override
		public void actionPerformed(ActionEvent e) {// the method of the button controls
		    if (e.getActionCommand().contains("Trade")) {
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
		    else if (e.getActionCommand().contains("Deck")) {
		    	c++;
		    	if (c>=5)
		    		c=0;
		    	if (c ==0) {
		    		help_Image.setVisible(true);
			    	uw_Image.setVisible(false);
					knight_Image.setVisible(false);
					road_Image.setVisible(false);
					card_Num.setText("This is the num of "+c);}
		    	else if (c ==1) {
		    		help_Image.setVisible(false);
			    	uw_Image.setVisible(true);
					knight_Image.setVisible(false);
					road_Image.setVisible(false);
					card_Num.setText("This is the num of "+c);}
		    	else if (c==2) {
		    		help_Image.setVisible(false);
		    		uw_Image.setVisible(false);
					knight_Image.setVisible(true);
					road_Image.setVisible(false);
					card_Num.setText("This is the num of "+c);}
		    	else if (c==3) {
		    		help_Image.setVisible(false);
		    		uw_Image.setVisible(false);
					knight_Image.setVisible(false);
					road_Image.setVisible(true);
					card_Num.setText("This is the num of "+c);}
		    	System.out.println("Shit");
		    }
			pane.validate();
	    }
	}
	public void updateUser(User object) {
		//String name, String color, int orderNum, int settlements, int cities, int roads, Cards [] usersCards, int condiction, int [] resorces 
		user.setName(object.getName());
		user.setColor(object.getColor());
		user.setCities(object.getCities());
		user.setSettlements(object.getSettlements());
		user.setRoads(object.getRoads());
		user.setCondiction(object.getCondiction());
		user.setResorces(object.getResorces());
		pane.validate();
		//return object;
	}
	public Color getColor(String temp) {
		Color color = Color.BLACK;
		if (temp=="Blue")
			color = new Color(158,202,225);
		else if (temp=="Orange")
			color =new Color(253,174,107);
		else if (temp=="White")
			color =new Color(240,240,240);
		else if (temp=="Red")
			color =new Color(252,146,114);
		else
			color = Color.GRAY;
		
		return color; 
	}
	
	public void registerListener(CatanController controller) {
		
		Task_1.addActionListener(controller);
		Task_1.setActionCommand("rollDice");
		Task_2C.addActionListener(controller);
		Task_2C.setActionCommand("build");
		Task_3.addActionListener(controller);
		Task_3.setActionCommand("end");
		
	}
	
	//get what to build from Task_2C_Box
	public String getBuilding() {
		String value= Task_2C_Box.getSelectedItem().toString();
		return value;
	}

	public void setNameLabel(String name) {
		nameLabel.setText(name);
	}

	public void setColorLabel(String color) {
		colorLabel.setText(color);
	}

	public void setOrderLabel(int turnNum) {
		orderNumLabel.setText("order number: " + turnNum);
	}

	public void setSettlementsLabel(int settlements) {
		settlementsLabel.setText("total settlements placed: " + settlements);
	}

	public void setCitiesLabel(int cities) {
		citiesLabel.setText("total cities placed: " + settlements);
	}

	public void setRoadsLabel(int roads) {
		roadsLabel.setText("total roads placed: " + roads);
	}
	
	public void setVPLabel(int vp) {
		condictionLabel.setText("total victory points: " + vp);
	}
	
	public void changeColor(int turn) {
		if(turn == 0) {
			getContentPane().setBackground(Color.blue);
		} else if(turn == 1) {
			getContentPane().setBackground(Color.orange);
		} else if(turn == 2) {
			getContentPane().setBackground(Color.white);
		} else if(turn == 3) {
			getContentPane().setBackground(Color.red);
		}
	}
	
	public void clearRoll() {
		Roll.setText("");
	}
	
	public void displayRoll(int num) {
		Roll.setText("" + num);
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public JTextArea getErrorArea() {
		return errorArea;
	}
	public void setErrorArea(JTextArea errorArea) {
		this.errorArea = errorArea;
	}
	public JLabel getNameLabel() {
		return nameLabel;
	}
	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}
	public JLabel getColorLabel() {
		return colorLabel;
	}
	public void setColorLabel(JLabel colorLabel) {
		this.colorLabel = colorLabel;
	}
	public JLabel getOrderNumLabel() {
		return orderNumLabel;
	}
	public void setOrderNumLabel(JLabel orderNumLabel) {
		this.orderNumLabel = orderNumLabel;
	}
	public JLabel getSettlementsLabel() {
		return settlementsLabel;
	}
	public void setSettlementsLabel(JLabel settlementsLabel) {
		this.settlementsLabel = settlementsLabel;
	}
	public JLabel getCitiesLabel() {
		return citiesLabel;
	}
	public void setCitiesLabel(JLabel citiesLabel) {
		this.citiesLabel = citiesLabel;
	}
	public JLabel getRoadsLabel() {
		return roadsLabel;
	}
	public void setRoadsLabel(JLabel roadsLabel) {
		this.roadsLabel = roadsLabel;
	}
	public JLabel getCondictionLabel() {
		return condictionLabel;
	}
	public void setCondictionLabel(JLabel condictionLabel) {
		this.condictionLabel = condictionLabel;
	}
	public JLabel getResorcesLabel() {
		return resorcesLabel;
	}
	public void setResorcesLabel(JLabel resorcesLabel) {
		this.resorcesLabel = resorcesLabel;
	}
	public JButton getTask_1() {
		return Task_1;
	}
	public void setTask_1(JButton task_1) {
		Task_1 = task_1;
	}
	public JLabel getTask_1_Notes() {
		return Task_1_Notes;
	}
	public void setTask_1_Notes(JLabel task_1_Notes) {
		Task_1_Notes = task_1_Notes;
	}
	public JLabel getRoll() {
		return Roll;
	}
	public void setRoll(JLabel roll) {
		Roll = roll;
	}
	public JButton getTask_2A() {
		return Task_2A;
	}
	public void setTask_2A(JButton task_2a) {
		Task_2A = task_2a;
	}
	public JButton getTask_2B() {
		return Task_2B;
	}
	public void setTask_2B(JButton task_2b) {
		Task_2B = task_2b;
	}
	public JButton getTask_2C() {
		return Task_2C;
	}
	public void setTask_2C(JButton task_2c) {
		Task_2C = task_2c;
	}
	public JLabel getTask_2_Notes() {
		return Task_2_Notes;
	}
	public void setTask_2_Notes(JLabel task_2_Notes) {
		Task_2_Notes = task_2_Notes;
	}
	public JButton getTask_3() {
		return Task_3;
	}
	public void setTask_3(JButton task_3) {
		Task_3 = task_3;
	}
	public JLabel getTask_3_Notes() {
		return Task_3_Notes;
	}
	public void setTask_3_Notes(JLabel task_3_Notes) {
		Task_3_Notes = task_3_Notes;
	}
	public String[] getTask_1_Choices() {
		return Task_1_Choices;
	}
	public void setTask_1_Choices(String[] task_1_Choices) {
		Task_1_Choices = task_1_Choices;
	}
	public JComboBox<String> getTask_1_Box() {
		return Task_1_Box;
	}
	public void setTask_1_Box(JComboBox<String> task_1_Box) {
		Task_1_Box = task_1_Box;
	}
	public String[] getTask_2A_Choices() {
		return Task_2A_Choices;
	}
	public void setTask_2A_Choices(String[] task_2a_Choices) {
		Task_2A_Choices = task_2a_Choices;
	}
	public JComboBox<String> getTask_2A_Box() {
		return Task_2A_Box;
	}
	public void setTask_2A_Box(JComboBox<String> task_2a_Box) {
		Task_2A_Box = task_2a_Box;
	}
	public String[] getTask_2B_Choices() {
		return Task_2B_Choices;
	}
	public void setTask_2B_Choices(String[] task_2b_Choices) {
		Task_2B_Choices = task_2b_Choices;
	}
	public JComboBox<String> getTask_2B_Box() {
		return Task_2B_Box;
	}
	public void setTask_2B_Box(JComboBox<String> task_2b_Box) {
		Task_2B_Box = task_2b_Box;
	}
	public String[] getTask_2C_Choices() {
		return Task_2C_Choices;
	}
	public void setTask_2C_Choices(String[] task_2c_Choices) {
		Task_2C_Choices = task_2c_Choices;
	}
	public JComboBox<String> getTask_2C_Box() {
		return Task_2C_Box;
	}
	public void setTask_2C_Box(JComboBox<String> task_2c_Box) {
		Task_2C_Box = task_2c_Box;
	}
	public JButton getChangeCard() {
		return ChangeCard;
	}
	public void setChangeCard(JButton changeCard) {
		ChangeCard = changeCard;
	}
	public JLabel getCard_Num() {
		return card_Num;
	}
	public void setCard_Num(JLabel card_Num) {
		this.card_Num = card_Num;
	}
	public JLabel getKnight_Image() {
		return knight_Image;
	}
	public void setKnight_Image(JLabel knight_Image) {
		this.knight_Image = knight_Image;
	}
	public JLabel getUw_Image() {
		return uw_Image;
	}
	public void setUw_Image(JLabel uw_Image) {
		this.uw_Image = uw_Image;
	}
	public JLabel getRoad_Image() {
		return road_Image;
	}
	public void setRoad_Image(JLabel road_Image) {
		this.road_Image = road_Image;
	}
	public Container getPane() {
		return pane;
	}
	public void setPane(Container pane) {
		this.pane = pane;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int updateHeightLocation(){
		heightLocation = heightLocation+ 20;
	return heightLocation; 
	}
	public void setDisplay1(boolean temp) {
		Task_1.setVisible(temp);
		Task_1_Notes.setVisible(temp);
		Task_1_Box.setVisible(temp);
		//Roll.setVisible(false);	
		setDisplay2(true);
		pane.validate();
	}
	public void setDisplay2(boolean temp) {
		Task_2A.setVisible(temp);
		Task_2B.setVisible(temp);
		Task_2C.setVisible(temp);
		Task_2_Notes.setVisible(temp);
		Task_2A_Box.setVisible(temp);
		Task_2B_Box.setVisible(temp);
		Task_2C_Box.setVisible(temp);
		Task_3.setVisible(temp);
		Task_3_Notes.setVisible(temp);
		ChangeCard.setVisible(temp);
		card_Num.setVisible(temp);
		//Roll.setVisible(false);	
		pane.validate();
	}
	public void Robber() {
		Task_1.setText("ROBBER");
		Task_1.setActionCommand("Robber");
		pane.validate();
	}
	public void changeTurn() {
		Task_1.setText("Roll");
		Task_1.setActionCommand("rollDice");
		pane.validate();
	}
}
