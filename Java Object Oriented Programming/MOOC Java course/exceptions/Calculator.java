package exceptions;

public class Calculator {


    public int multiplication(int num1, int num2) {
        if (num1 < 0 || num2 < 0) {
            throw new IllegalArgumentException("Number must be in N");
        }
        return num1 * num2;

    }

    public int binomialCoefficient(int n, int k) {
        if (n < k || n < 0 || k < 0) {
            throw new IllegalArgumentException("Error :P");
        }

        return faculty(n) / (faculty(k) * faculty(n-k));

    }

    public int faculty(int n) {

        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }

        return sum;

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.binomialCoefficient(7, 5));
    }
}