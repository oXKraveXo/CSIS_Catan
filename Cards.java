package catan;

public class Cards {
String name;
//image object;
int effect;

//Initialization of object
public Cards () {
	
}
public Cards (String name, int effect) {
	this.name = name;
	this.effect = effect;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getEffect() {
	return effect;
}
public void setEffect(int effect) {
	this.effect = effect;
}
@Override
public String toString() {
	return "Cards [name=" + name + ", effect=" + effect + "]";
} 

}
