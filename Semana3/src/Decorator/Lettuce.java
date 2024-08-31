package Decorator;

public class Lettuce extends ToppingDecorator {

    public Lettuce(Component component) {
        super(component);
        toppingName = "Lettuce";
        toppingPrice = 2.00;
    }
}
