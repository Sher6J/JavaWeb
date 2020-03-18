package junit;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        int res = c.add(1, 2);
        System.out.println(res);
    }
}
