package catan;

public class CatanModel {
	
	//create the users profiles
	Cards player1Cards[] = new Cards[20];
	int player1Resources[] = new int[100];
	User user1 = new User("player1",'R',1,0,0,0,player1Cards,0,player1Resources);
	
	Cards player2Cards[] = new Cards[20];
	int player2Resources[] = new int[100];
	User user2 = new User("player2",'B',1,0,0,0,player2Cards,0,player2Resources);
	
	Cards player3Cards[] = new Cards[20];
	int player3Resources[] = new int[100];
	User user3 = new User("player3",'W',1,0,0,0,player3Cards,0,player3Resources);
	
	Cards player4Cards[] = new Cards[20];
	int player4Resources[] = new int[100];
	User user4 = new User("player4",'Y',1,0,0,0,player4Cards,0,player4Resources);

}
