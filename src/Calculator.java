public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        return a / b; // 버그: 정수 나눗셈으로 소수점 손실
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("5 + 3 = " + calc.add(5, 3));
        System.out.println("10 - 4 = " + calc.subtract(10, 4));
        System.out.println("6 * 7 = " + calc.multiply(6, 7));
        System.out.println("7 / 2 = " + calc.divide(7, 2)); // 예상: 3.5, 실제: 3.0

        // 0으로 나누기 예외 처리 없음
        System.out.println("5 / 0 = " + calc.divide(5, 0));
    }
}
