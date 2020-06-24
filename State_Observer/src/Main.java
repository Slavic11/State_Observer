import java.util.ArrayList;
import java.util.List;

public class Main {
//Надявам се, че поне част от правилното направено :)
	public static void main(String[] args) {
		Courier_company ncompany = new Courier_company();
		
		ncompany.addObserver(new ConsoleObserver(),"clon3");
		ncompany.addObserver(new ConsoleObserver(),"clon2");
		ncompany.addObserver(new ConsoleObserver(),"clon1");

		ncompany.setMeasurements(true, "Plovdiv");
		

	}

}


interface Observed {
	void addObserver(Observer o, String name);
	void removeObserver(Observer o);
	void notifyObservers();
}

class Courier_company implements Observed{
	boolean State_of_preparation;
	String destinations;
	String name;
	
	List<Observer> observers = new ArrayList<>();
	
	public void setMeasurements(boolean s, String d) {
		State_of_preparation = s;
		destinations = d;
		if(s==true)
			notifyObservers();
	}
	
	public void addObserver(Observer o, String name) {
		observers.add(o);
		this.name = name;
	}
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	public void notifyObservers() {
		for(Observer o : observers) {
			o.handleEvent(name,State_of_preparation, destinations);
		}
	}
	
}

interface Observer{
	void handleEvent(String name, boolean Stat_prep, String dest);
}


class ConsoleObserver implements Observer{
	
	public void handleEvent(String n,boolean Stat_prep, String dest) {
			System.out.println("Състоянието на Служителя " + n + " е променено. Състоянието = " + Stat_prep + ", дестинации = " + dest + ". Момче отнася пратката в склада");
	}
	
}






