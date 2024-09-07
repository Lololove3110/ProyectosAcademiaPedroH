package mockitodemo;

public class Calculator {

    private MathService mathService;

    public Calculator(MathService mathService) {
        this.mathService = mathService;
    }

    public void factorial(int a) {
        int result = mathService.factorial(a);
        System.out.println("Factorial of " + a + " = " + result);
    }

    public void square(int a) {
        int result = mathService.square(a);
        System.out.println(a + " squared = " + result);
    }

    public void squareRoot(int a) {
        double result = mathService.squareRoot(a);
        System.out.println("Square root of " + a + " = " + result);
    }
}
