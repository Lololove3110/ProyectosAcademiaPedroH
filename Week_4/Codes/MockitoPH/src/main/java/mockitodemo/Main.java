package mockitodemo;

public class Main {

    public static void main(String[] args) {
        MathService mathService = new MathServiceImp();
        Calculator calculator = new Calculator(mathService);

        calculator.factorial(5);
        calculator.square(4);
        calculator.squareRoot(16);
    }
}
