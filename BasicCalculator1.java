import java.util.Scanner;

public class BasicCalculator1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Advanced Calculator!");

        while (true) {
            displayMenu();

            int choice = getValidChoice(scanner);

            if (choice == 6) {
                System.out.println("Thank you for using the calculator. Goodbye!");
                break;
            }

            double num1 = getNumber(scanner, "Enter the first number: ");
            double num2 = getNumber(scanner, "Enter the second number: ");

            performOperation(choice, num1, num2);
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Calculator Menu ===");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulus");
        System.out.println("6. Exit");
        System.out.print("Choose an operation: ");
    }

    private static int getValidChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    System.out.print("Invalid choice. Please enter a number between 1 and 6: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number between 1 and 6: ");
                scanner.next(); // Clear the invalid input
            }
        }
        return choice;
    }

    private static double getNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextDouble();
    }

    private static void performOperation(int choice, double num1, double num2) {
        switch (choice) {
            case 1:
                System.out.println("Result: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Result: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Result: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            case 5:
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 % num2));
                } else {
                    System.out.println("Error: Modulus by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }
}
