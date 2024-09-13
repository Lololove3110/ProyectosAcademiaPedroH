package DecoratorWithTest;

public class Principal {
	public static void main(String[] args) {

        // Creating a cheeseburger with all toppings
        Component burger1 = new ExtraCheese(new ExtraMeat(new Pickles(new Lettuce(new Cheeseburger()))));
        Component burger2 = new Pickles(new Cheeseburger());

        Component burger3 = new ExtraMeat(new ExtraMeat(new ExtraMeat(new ExtraMeat(new Cheeseburger()))));
        
        // Print and calculate the total cost for each order
        System.out.println("Order 1:");
        printCostWithDiscount(burger1);
        System.out.println("---------------");

        System.out.println("\nOrder 2:");
        printCostWithDiscount(burger2);
        System.out.println("---------------");
        System.out.println("Order 3:");
        printCostWithDiscount(burger3);

        
    }

	public static void printCostWithDiscount(Component burger) {
        System.out.println(burger.getNameAndPrice());
        double totalCost = calculateTotalCostWithDiscount(burger.getTotalCost());
        System.out.println("Total cost: $" + totalCost);
    }

    // Public method to calculate total cost with discount
    public static double calculateTotalCostWithDiscount(double totalCost) {
        if (totalCost > 16) {
            totalCost *= 0.90;
        }
        return totalCost;
    }
}

	
		