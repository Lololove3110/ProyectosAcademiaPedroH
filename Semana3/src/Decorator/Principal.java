package Decorator;

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

    // Helper method to calculate and print cost with discount if applicable
    private static void printCostWithDiscount(Component burger) {
        System.out.println(burger.getNameAndPrice());

        // Calculate the total cost
        double totalCost = burger.getTotalCost();

        // Apply a 10% discount if the cost is more than $16
        if (totalCost > 16) {
            totalCost *= 0.90;
            System.out.println("Discount applied! New total cost: $" + totalCost);
        } else {
            System.out.println("Total cost: $" + totalCost);
        }
    }
}

	
		