package Decorator;

public abstract class ToppingDecorator implements Component{
	
	private Component component;
	String toppingName;
	double toppingPrice;
	
	public ToppingDecorator(Component component) {
		this.component=component;
	}
	
	@Override
	public String getNameAndPrice() {
	return component.getNameAndPrice()+"\n"+ toppingName+"$"+toppingPrice;
	}
	
	public double getTotalCost() {
		return component.getTotalCost() + toppingPrice;
	}

}
