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


public class CatanController implements ActionListener{
	
	private CatanController controller;
	
	//to connect the M, V, and C together
	private CatanModel model;
	private StartGUI view;
	private UserGUI view2;
	
	/**
	 * This saves the model and and view.
	 * 
	 * model is a Model for the functions of the game and the inputs
	 * from the user
	 * 
	 * view is a View for what should be displayed in the GUI
	 */
	public CatanController(CatanModel model, StartGUI view, UserGUI view2) {
		
		this.model = model;
		this.view = view;
		this.view2 = view2;
	}
	
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();

		if(command.equals("Build")) {
			//builds the board
			System.out.println("building board");
			CatanView view = new CatanView();
			view.registerListener(controller);
			JFrame f = new JFrame();
	        f.setContentPane(view);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.pack();
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
	        //color selection
		} else if(command.equals("p1color")) {
			model.setUserOneColor(view.getColorOne());
			System.out.println(view.getNameOne() + "s color is now " + view.getColorOne());
		} else if(command.equals("p2color")) {
			model.setUserTwoColor(view.getColorTwo());
			System.out.println(view.getNameTwo() + "s color is now " + view.getColorTwo());
		} else if(command.equals("p3color")) {
			model.setUserThreeColor(view.getColorThree());
			System.out.println(view.getNameThree() + "s color is now " + view.getColorThree());
		} else if(command.equals("p4color")) {
			model.setUserFourColor(view.getColorFour());
			System.out.println(view.getNameFour() + "s color is now " + view.getColorFour());
			//name selection
		} else if(command.equals("p1name")) {
			model.setNameOne(view.getNameOne());
		} else if(command.equals("p2name")) {
			model.setNameTwo(view.getNameTwo());
		} else if(command.equals("p3name")) {
			model.setNameThree(view.getNameThree());
		} else if(command.equals("p4name")) {
			model.setNameFour(view.getNameFour());
			//rolling dice and recieving resources
		} else if(command.equals("rollDice")) {
				int temp = model.rollDice();
			view2.displayRoll(temp);
			//model.giveResources(model.rollDice());
			if (temp <=6 || temp >= 8) {
				view2.setDisplay1(false);
				//view2.setDisplay2(true);
			}else {
				view2.Robber();
				view2.setDisplay1(true);
				view2.setDisplay2(false);
			}}else if(command.equals("Robber")) {
			System.out.println("Pull acard from Player");
			System.out.println("Discard cards");
			view2.setDisplay1(false);
			view2.setDisplay2(true);
			//model.build(view2.getBuilding());
			//building things
		} else if(command.equals("build")) {
			model.build(view2.getBuilding());
			//moving to next turn
		} else if(command.equals("end")) {
			model.checkForWin();
			model.nextTurn();
			int turnNum = model.getWhoseTurn();
			view2.clearRoll();
			view2.changeColor(turnNum);
			view2.setDisplay1(true);
			view2.setDisplay2(false);
			view2.changeTurn();
			view2.validate();
			
		} else if(command.equals("winCondition")) {
			System.out.println("victory points needed to win: " + view.getWinAmount());
			model.setWinCon(view.getWinAmount());
		}
		
			
	}

	

}//end class
