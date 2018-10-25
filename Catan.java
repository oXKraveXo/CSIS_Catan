package catan;
import java.util.Random;
import java.util.Random;
import javax.swing.JFrame;
public class Catan {
	
	/*
	 * this class is just to create the MVC components
	 *  and then launch the application
	 */

	public static void main(String[] args) {
		
		//creating a user object to test
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
		System.out.println("Object1 = " + object);
		
		// creating Deck object to test
		Deck object2 = new Deck();
		System.out.println(object2);
		
		//creating Tile object to test
		Random temp = new Random();
		for (int i = 0; i<25; i++ ) {
			Tiles object3 = new Tiles(temp.nextInt(7), temp.nextInt(7));
			System.out.println(object3);
		}
		// creating Dice object to be replace by methods this is also to hold image of dice
		for (int i =0; i<100; i++){
		Dice object4 = new Dice();
		System.out.println(object4 + " Num Total " + object4.Total());
		}
		
		//creating the model, view, and controller components of the system
		CatanView view = new CatanView();
		StartGUI view2 = new StartGUI();
		UserGUI view3 = new UserGUI();
		CatanModel model = new CatanModel();
		CatanController controller = new CatanController(model, view);
		
		//make the controller listen to the view for inputs
		view.registerListener(controller);
		
		
		/*
		* the following code loads the gui using the view
		*/
		////////////////////////////////////////////////////////
		JFrame f = new JFrame();
        f.setContentPane(view);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

	}

}
