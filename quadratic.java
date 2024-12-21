import java.util.Scanner;

public class quadratic {
    public static void main(String[] args) {
        int a, b, c;
        double root1, root2;
        
        // Input coefficients
        System.out.println("Enter coefficients a, b, c:");
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        // Calculate the discriminant
        double d = (b * b) - (4 * a * c);
        System.out.println("Discriminant: " + d);

        // Case 1: Roots are real and distinct
        if (d > 0) {
            System.out.println("Roots are real and distinct.");
            root1 = (-b + Math.sqrt(d)) / (2 * a);
            root2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Root1 = " + root1);
            System.out.println("Root2 = " + root2);
        }
        // Case 2: Roots are real and equal
        else if (d == 0) {
            System.out.println("Roots are real and equal.");
            root1 = -b / (2.0 * a); // Note: Use 2.0 to avoid integer division
            System.out.println("Root1 = Root2 = " + root1);
        }
        // Case 3: Roots are complex and imaginary
        else {
            System.out.println("Roots are imaginary and complex.");
            double realPart = -b / (2.0 * a);
            double imaginaryPart = Math.sqrt(Math.abs(d)) / (2 * a);
            System.out.println("Root1 = " + realPart + " + i" + imaginaryPart);
            System.out.println("Root2 = " + realPart + " - i" + imaginaryPart);
        }

        in.close(); // Closing the scanner
    }
}
