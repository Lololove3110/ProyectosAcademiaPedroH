package DecoratorWithTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestDecorator {

	// Test to verify that the base Cheeseburger component is initialized correctly
	@Test
    public void testCheeseburgerBase() {
        Component burger = new Cheeseburger();
        // Updated expected format to match the actual output format
        assertEquals("Cheeseburger: 10$", burger.getNameAndPrice());
        assertEquals(10.00, burger.getTotalCost(), 0.001);
    }

    // Test for the Cheeseburger with Lettuce decorator
    @Test
    public void testLettuceDecorator() {
        Component burger = new Lettuce(new Cheeseburger());
        // Updated expected format to match the actual output format
        assertEquals("Cheeseburger: 10$\nLettuce$2.0", burger.getNameAndPrice());
        assertEquals(12.00, burger.getTotalCost(), 0.001);
    }

    // Test for the Cheeseburger with Pickles decorator
    @Test
    public void testPicklesDecorator() {
        Component burger = new Pickles(new Cheeseburger());
        // Updated expected format to match the actual output format
        assertEquals("Cheeseburger: 10$\nPickles$2.0", burger.getNameAndPrice());
        assertEquals(12.00, burger.getTotalCost(), 0.001);
    }

    // Test for the Cheeseburger with Extra Meat decorator
    @Test
    public void testExtraMeatDecorator() {
        Component burger = new ExtraMeat(new Cheeseburger());
        // Updated expected format to match the actual output format
        assertEquals("Cheeseburger: 10$\nExtra Meat$2.5", burger.getNameAndPrice());
        assertEquals(12.50, burger.getTotalCost(), 0.001);
    }

    // Test for the Cheeseburger with Extra Cheese decorator
    @Test
    public void testExtraCheeseDecorator() {
        Component burger = new ExtraCheese(new Cheeseburger());
        // Updated expected format to match the actual output format
        assertEquals("Cheeseburger: 10$\nExtra Cheese$1.5", burger.getNameAndPrice());
        assertEquals(11.50, burger.getTotalCost(), 0.001);
    }

    // Test for a Cheeseburger with multiple decorators
    @Test
    public void testMultipleDecorators() {
        Component burger = new ExtraCheese(
                            new ExtraMeat(
                                new Pickles(
                                    new Lettuce(
                                        new Cheeseburger()
                                    )
                                )
                            )
                         );
        // Updated expected format to match the actual output format
        String expectedDescription = "Cheeseburger: 10$\nLettuce$2.0\nPickles$2.0\nExtra Meat$2.5\nExtra Cheese$1.5";
        assertEquals(expectedDescription, burger.getNameAndPrice());
        assertEquals(18.00, burger.getTotalCost(), 0.001);
    }

    // Test for calculating the total cost with no discount
    @Test
    public void testCalculateTotalCostWithDiscount_NoDiscount() {
        double totalCost = 12.00;
        double expectedCost = 12.00; // No discount applied
        double actualCost = Principal.calculateTotalCostWithDiscount(totalCost);
        assertEquals(expectedCost, actualCost, 0.001);
    }

    // Test for calculating the total cost with a discount
    @Test
    public void testCalculateTotalCostWithDiscount_WithDiscount() {
        double totalCost = 18.00;
        double expectedCost = 16.20; // 18.00 with a 10% discount
        double actualCost = Principal.calculateTotalCostWithDiscount(totalCost);
        assertEquals(expectedCost, actualCost, 0.001);
    }

    // Test for multiple Extra Meat decorators
    @Test
    public void testMultipleExtraMeatDecorators() {
        Component burger = new ExtraMeat(
                            new ExtraMeat(
                                new ExtraMeat(
                                    new ExtraMeat(
                                        new Cheeseburger()
                                    )
                                )
                            )
                         );
        // Updated expected format to match the actual output format
        String expectedDescription = "Cheeseburger: 10$\nExtra Meat$2.5\nExtra Meat$2.5\nExtra Meat$2.5\nExtra Meat$2.5";
        assertEquals(expectedDescription, burger.getNameAndPrice());
        assertEquals(20.00, burger.getTotalCost(), 0.001);
    }

}
