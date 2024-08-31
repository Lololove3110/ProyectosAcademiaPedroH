package Decorator;

public class ExtraMeat extends ToppingDecorator {

    public ExtraMeat(Component component) {
        super(component);
        toppingName = "Extra Meat";
        toppingPrice = 2.50;
    }
}
