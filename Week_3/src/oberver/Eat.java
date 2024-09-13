package oberver;

import java.util.Objects;

public class Eat extends Observer{
	String eat;
	public Eat(String eat,Subject sub) {
		super(sub);
		this.eat = eat;
	}
	void doEat() {
		System.out.println("Let´s eat: "+eat);
	}
	@Override
	public void update() {
		doEat();
	}
	@Override
	public int hashCode() {
		return Objects.hash(eat);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eat other = (Eat) obj;
		return Objects.equals(eat, other.eat);
	}

}
