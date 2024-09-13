package DecoratorWithTest;

public class ExtraCheese extends ToppingDecorator {

    public ExtraCheese(Component component) {
        super(component);
        toppingName = "Extra Cheese";
        toppingPrice = 1.50;
    }
}
