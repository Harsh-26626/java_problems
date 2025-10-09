import java.util.Scanner;

class Sum {
    // variables to store numbers and sum. initialized in constructor.
    final float a, b ,sum;

    // takes numbers as input and prints out the sum
    Sum(float x, float y) {
        a = x;
        b = y;
        sum = calculateSum();
        System.out.println("\nThe sum of these numbers is: " + a + " + " + b + " = " + sum);
    }

    final float calculateSum() {
        return a + b;
    }

    public static void main(String[] args) {
        // create scanner to take input from user
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------------------------");
        System.out.println("Welcome to Sum Caculator\n");

        System.out.print("Enter first number: ");
        float num1 = sc.nextFloat();
        System.out.print("Enter first number: ");
        float num2 = sc.nextFloat();

        sc.close();

        new Sum(num1, num2);
        System.out.println("-------------------------------------------");
    }
}