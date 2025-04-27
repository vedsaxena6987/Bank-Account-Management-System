import java.util.Scanner;

class MyCalculator {
    public int power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }
        return (int) Math.pow(n, p);
    }
}

public class practiceQ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyCalculator calculator = new MyCalculator();
        System.out.println("Enter base and exponent (n p):");
        System.out.println("Note:\n- n and p should not be negative.\n- n and p should not be zero.");
        while (scanner.hasNext()) {
            try {
                int n = scanner.nextInt();
                int p = scanner.nextInt();
                int result = calculator.power(n, p);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
