package catan;

import java.util.Random;

public class Dice {
int redNum;
int yellowNum;

public Dice() {
	do {  
	Random temp = new Random();
	redNum = temp.nextInt(7);
	yellowNum = temp.nextInt(7);
	}	
	while (redNum <= 0 || yellowNum <=0);
}

/////////////////////////////////////////////////

public int getRedNum() {
	return redNum;
}
public void setRedNum(int redNum) {
	this.redNum = redNum;
}
public int getYellowNum() {
	return yellowNum;
}
public void setYellowNum(int yellowNum) {
	this.yellowNum = yellowNum;
}
public int Total() {
	int temp = 0;
	temp = redNum + yellowNum; 
	return temp;
}
@Override
public String toString() {
	return "Dice [redNum=" + redNum + ", yellowNum=" + yellowNum + "]";
} 

}
