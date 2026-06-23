package junit;

public class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {

        Calculator c = new Calculator();

        System.out.println("Addition = " + c.add(10, 5));
        System.out.println("Subtraction = " + c.subtract(10, 5));
        System.out.println("Multiplication = " + c.multiply(10, 5));
        System.out.println("Division = " + c.divide(10, 5));
    }
}