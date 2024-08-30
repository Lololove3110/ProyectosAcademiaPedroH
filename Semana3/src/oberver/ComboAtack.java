package oberver;

import java.util.Objects;

public class ComboAtack extends Observer{
	String comAt;

	public ComboAtack( String comAt,Subject sub) {
		super(sub);
		this.comAt = comAt;
	}
	
	void doCombo() {
		
		System.out.println("Attack!: "+comAt);
	}
	
	@Override
	public void update() {
		doCombo();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(comAt);
	}
//This override is needed because the equals in string check if are the same object
//not the same string, this basically solve the problem and check if the strings are the same
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComboAtack other = (ComboAtack) obj;
		return Objects.equals(comAt, other.comAt);
	}
	
	
	
}
