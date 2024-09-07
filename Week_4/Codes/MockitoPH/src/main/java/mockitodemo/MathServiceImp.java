package mockitodemo;

public class MathServiceImp implements MathService {

    @Override
    public int factorial(int a) {
        if (a == 0 || a == 1) {
            return 1;
        }
        int fact = 1;
        for (int i = 2; i <= a; i++) {
            fact *= i;
        }
        return fact;
    }

    @Override
    public int square(int a) {
        return a * a;
    }

    @Override
    public double squareRoot(int a) {
        return Math.sqrt(a);
    }
}
