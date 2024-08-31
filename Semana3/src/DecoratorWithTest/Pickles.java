package DecoratorWithTest;

public class Pickles extends ToppingDecorator {

    public Pickles(Component component) {
        super(component);
        toppingName = "Pickles";
        toppingPrice = 2.00;
    }
}
