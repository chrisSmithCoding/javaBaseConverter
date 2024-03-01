import java.util.Scanner;

public class SimpleBaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter a decimal number (or enter a negative number to stop): ");
                int decimalInput = scanner.nextInt();

                if (decimalInput < 0) {
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                }

                System.out.print("Enter the target base (2 to 16): ");
                int baseInput = scanner.nextInt();

                String conversionResult = decimalToBase(decimalInput, baseInput);
                System.out.println("The equivalent base-" + baseInput + " value of decimal " +
                        decimalInput + " is: " + conversionResult);

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid integer values.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        scanner.close();
    }

    private static String decimalToBase(int decimalNumber, int targetBase) {
        if (decimalNumber < 0) {
            return "Decimal number must be non-negative.";
        }

        if (targetBase < 2 || targetBase > 16) {
            return "Target base must be between 2 and 16 inclusive.";
        }

        StringBuilder result = new StringBuilder();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % targetBase;
            char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + remainder - 10);
            result.insert(0, digit);
            decimalNumber /= targetBase;
        }

        return result.length() > 0 ? result.toString() : "0";
    }
}
