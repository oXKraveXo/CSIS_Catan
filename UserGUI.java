package catan;
import java.awt.Container;
import javax.swing.*;
import java.awt.event.*;

public class UserGUI extends JFrame{
	private static int WIDTH = 550;
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
	private JButton build;
	
	public UserGUI(){// the constructor for the GUI
		setTitle("Hello Welcome to User Interface");
		setSize(WIDTH, HEIGHT);
		
		Container pane = getContentPane();
		pane.setLayout(null); 
		
		//Instantiate objects of GUI components
		
		errorArea = new JTextArea("Message If You Fuck Up"); 
		nameLabel = new JLabel("This is the name "+ name);
		colorLabel = new JLabel("This is the this color "+ color);
		orderNumLabel = new JLabel("This is the orderNum "+ orderNum);
		settlementsLabel = new JLabel("This is the settlements "+ settlements);
		citiesLabel = new JLabel("This is the cities "+ cities);
		roadsLabel = new JLabel("This is the roads "+ roads);
		condictionLabel = new JLabel ("This is the users condiction poiint "+ condiction);
		resorcesLabel = new JLabel ("Wheet "+resorces[0]+ " Stone " +resorces[1]+ " Clay " +resorces[2] + " Sheep " + resorces[3] + " Wood " + resorces[4] );
		build = new JButton("Build");

		processButtonHandler processBHandler = new processButtonHandler();
		build.addActionListener(processBHandler);
		
		// Method for location and size of objects
		nameLabel.setLocation(40,200);
		nameLabel.setSize(200,20);
		colorLabel.setLocation(40,220);
		colorLabel.setSize(200,20);
		orderNumLabel.setLocation(40,240);
		orderNumLabel.setSize(200,20);
		settlementsLabel.setLocation(40,260);
		settlementsLabel.setSize(200,20);
		citiesLabel.setLocation(40,280);
		citiesLabel.setSize(200,20);
		roadsLabel.setLocation(40,300);
		roadsLabel.setSize(200,20);
		condictionLabel.setLocation(40,320);
		condictionLabel.setSize(400,20);
		resorcesLabel.setLocation(40,340);
		resorcesLabel.setSize(400,20);
		errorArea.setLocation(40,10);
		errorArea.setSize(470,180);
		build.setLocation(200,440);
		build.setSize(100,20);
		
		
		// Adding objects to container
		pane.add(errorArea);
		pane.add(nameLabel);
		pane.add(colorLabel);
		pane.add(orderNumLabel);
		pane.add(settlementsLabel);
		pane.add(citiesLabel);
		pane.add(roadsLabel);
		pane.add(condictionLabel);
		pane.add(resorcesLabel);
		pane.add(build);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	// Class to handle event listener for testing
	private class processButtonHandler implements ActionListener{//class to handle the Button
		@Override
		public void actionPerformed(ActionEvent arg0) {// the method of the button controls
			System.out.println("This is a test");
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
    }
