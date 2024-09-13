package oberver;
import java.util.*;

//This class make a list with all the methods that can be implemented to 
//the subject class that will have several observers
public abstract class Subject {
	List<Observer> observers = new ArrayList<>();	
	void attach(Observer o) {
		observers.add(o);
	}	
	void detach(Observer o) {
		observers.removeIf(x -> x.equals(o));
	}
	void notiffy() {
		for(Observer o:observers)
			o.update();
	}
}
