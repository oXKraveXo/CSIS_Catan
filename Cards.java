package catan;

public class Cards {
String name;
//image object;
//comment to test committing and pushing
int effect;

//testing testing 123 123
//Initialization of object
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
