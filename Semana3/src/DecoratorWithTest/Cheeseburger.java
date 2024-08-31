package DecoratorWithTest;

public class Cheeseburger implements Component{
	
	@Override
	public String getNameAndPrice() {
		return "Cheeseburger: 10$";
	}
	
	@Override
	public double getTotalCost() {
		return 10.00;
	}	

}
