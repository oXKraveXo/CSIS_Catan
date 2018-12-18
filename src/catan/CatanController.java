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

import javax.swing.JFrame;


public class CatanController implements ActionListener, Catch{
	
	private CatanController controller;
	
	//to connect the M, V, and C together
	private CatanModel model;	
	private CatanView view;
	
	
	/**
	 * This saves the model and and view.
	 * 
	 * model is a Model for the functions of the game and the inputs
	 * from the user
	 * 
	 * view is a View for what should be displayed in the GUI
	 */
	public CatanController(CatanModel model, CatanView view) {
		
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		
		if(command.equals("Build")) {
				int counter = 0;
				for(int i =0; i<view.getStartGUI().getPlayers().length; i++) {
					view.getStartGUI().getOptions()[counter] = view.getStartGUI().getPlayers()[i].getText();	
					counter++;}
				for(int i =0; i<view.getStartGUI().getPlayers().length; i++) {
					view.getStartGUI().getOptions()[counter] = view.getStartGUI().getNewColor()[i].getSelectedItem().toString();
					counter++;}
				for (int i=0; i<view.getStartGUI().getBooleanStatements().length; i++) {
					view.getStartGUI().getOptions()[counter] = view.getStartGUI().getBooleanStatements()[i].getSelectedItem().toString();
					counter++;
				}
				view.getStartGUI().getOptions()[counter] = view.getStartGUI().getCondictionField().getText();
				model = new CatanModel(view.getStartGUI().getOptions());
				//if (LogicTest(view.getStartGUI().getOptions())) {
					for (int i =0; i<4; i++)
					System.out.println(model.users[i]);
					
					view.getStartGUI().hide();
					view.getUserInGUI().show();
					//}	
		}

//		if(command.equals("Build")) {	
//			if (LogicTest(view.getOptions())) {
//			if (model.users[0].getName().equals("a")) {
//			model = new CatanModel(view.getOptions());
//			view.hide();
//			view.getUserInGUI().show();
//			}
			//}
//			System.out.println("building board");
//			CatanView view = new CatanView();
//			view.registerListener(controller);
//			JFrame f = new JFrame();
//	        f.setContentPane(view);
//	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        f.pack();
//	        f.setLocationRelativeTo(null);
//	        f.setVisible(true);
			 //userInGUI.show();
			
		else if(command.equals("p1color")) {
			model.setUserOneColor(view.getStartGUI().getColorOne());
			System.out.println(view.getStartGUI().getNameOne() + "s color is now " + view.getStartGUI().getColorOne());
		} else if(command.equals("p2color")) {
			model.setUserTwoColor(view.getStartGUI().getColorTwo());
			System.out.println(view.getStartGUI().getNameTwo() + "s color is now " + view.getStartGUI().getColorTwo());
		} else if(command.equals("p3color")) {
			model.setUserThreeColor(view.getStartGUI().getColorThree());
			System.out.println(view.getStartGUI().getNameThree() + "s color is now " + view.getStartGUI().getColorThree());
		} else if(command.equals("p4color")) {
			model.setUserFourColor(view.getStartGUI().getColorFour());
			System.out.println(view.getStartGUI().getNameFour() + "s color is now " + view.getStartGUI().getColorFour());
			//name selection
		} else if(command.equals("p1name")) {
			model.setNameOne(view.getStartGUI().getNameOne());
		} else if(command.equals("p2name")) {
			model.setNameTwo(view.getStartGUI().getNameTwo());
		} else if(command.equals("p3name")) {
			model.setNameThree(view.getStartGUI().getNameThree());
		} else if(command.equals("p4name")) {
			model.setNameFour(view.getStartGUI().getNameFour());
			//rolling dice and recieving resources
		} else if(command.equals("rollDice")) {
				int temp = model.rollDice();
				
			view.getUserInGUI().displayRoll(temp);
			//model.giveResources(model.rollDice());
			if (temp <=6 || temp >= 8) {
				view.getUserInGUI().setDisplay1(false);
				//view.getUserInGUI().setDisplay2(true);
			}else {
				view.getUserInGUI().Robber();
				view.getUserInGUI().setDisplay1(true);
				view.getUserInGUI().setDisplay2(false);
			}}else if(command.equals("Robber")) {
			System.out.println("Pull acard from Player");
			System.out.println("Discard cards");
			view.getUserInGUI().setDisplay1(false);
			view.getUserInGUI().setDisplay2(true);
			//model.build(view.getUserInGUI().getBuilding());
			//building things
		} else if(command.equals("build")) {
			model.build(view.getUserInGUI().getBuilding());
			//moving to next turn
		} else if(command.equals("end")) {
			model.checkForWin();
			model.nextTurn();
			int turnNum = model.getWhoseTurn();
			view.getUserInGUI().clearRoll();
			view.getUserInGUI().changeColor(turnNum);
			view.getUserInGUI().setDisplay1(true);
			view.getUserInGUI().setDisplay2(false);
			view.getUserInGUI().changeTurn();
			view.getUserInGUI().validate();
			
		} else if(command.equals("winCondition")) {
			System.out.println("victory points needed to win: " + view.getStartGUI().getWinAmount());
			model.setWinCon(view.getStartGUI().getWinAmount());
		}
		
			
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
//	if (model.getUsers()[0].getColor()=="Blue") {
//		temp = false;
//	public boolean LogicTest(String input []) {
//		boolean temp = true; 
//		for (int i=0; i<4; i++) {
//		//if (model.getUsers()[0].getName()=="Orange") {
//		if (model.getUsers()[0].getName().toString()=="a") {
//			temp = false;
//			// why are we getting a 
//			System.out.print(model.getUsers()[0].getColor());
//			System.out.print(model.getUsers()[0].getName());
//		}
//		}
//		return temp;
//
//		}
}//end class
