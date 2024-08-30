package oberver;
//the observer classes most see the subject class if it changes
public abstract class Observer {
	Subject sub;
	
	Observer(Subject sub){
		this.sub=sub;
		sub.attach(this);
	}
	
	abstract void update();

}
