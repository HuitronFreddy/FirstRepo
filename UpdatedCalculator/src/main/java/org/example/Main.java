import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Created first two question and allows response
        System.out.println("Enter the first number:");
        Scanner scanner = new Scanner(System.in);
        double userNumber = scanner.nextDouble();

        System.out.println("Enter the second number:");
        double secondUserNumber = scanner.nextDouble();
        double sum = AddTwoNumbers(userNumber, secondUserNumber);
        double sub = SubtractTwoNumbers(userNumber, secondUserNumber);
        double product = MultiplyTwoNumbers(userNumber, secondUserNumber);
        double division = DivideTwoNumbers(userNumber, secondUserNumber);


        //Creating multiple choice prompt
        System.out.println("Possible Calculations: ");
        System.out.println("    (A)dd");
        System.out.println("    (S)ubtract");
        System.out.println("    (M)ultiply");
        System.out.println("    (D)ivide");
        System.out.println("Please select an option: ");
        scanner.nextLine();
        String possibleCalculation = scanner.nextLine();
        //needing user input
        if(possibleCalculation.equalsIgnoreCase("Add")) {
            System.out.printf("%.2f + %.2f = %.2f", userNumber, secondUserNumber, sum);
        }
        else if(possibleCalculation.equalsIgnoreCase("Subtract")) {
            System.out.printf("%.2f - %.2f = %.2f", userNumber, secondUserNumber, sub);
        }
        else if(possibleCalculation.equalsIgnoreCase("Multiply")) {
            System.out.printf("%.2f * %.2f = %.2f", userNumber, secondUserNumber, product);
        }
        else if(possibleCalculation.equalsIgnoreCase("Divide")) {
            System.out.printf("%.2f / %.2f = %.2f", userNumber, secondUserNumber, division);
        }
        else if(possibleCalculation.equalsIgnoreCase("A")) {
            System.out.printf("%.2f + %.2f = %.2f", userNumber, secondUserNumber, sum);
        }
        else if(possibleCalculation.equalsIgnoreCase("S")) {
            System.out.printf("%.2f - %.2f = %.2f", userNumber, secondUserNumber, sub);
        }
        else if(possibleCalculation.equalsIgnoreCase("M")) {
            System.out.printf("%.2f * %.2f = %.2f", userNumber, secondUserNumber, product);
        }
        else if(possibleCalculation.equalsIgnoreCase("D")) {
            if (secondUserNumber != 0) {
                System.out.printf("%.2f / %.2f = %.2f", userNumber, secondUserNumber, division);
            } else {
                System.out.println("Error: Division by zero is not allowed.");
            }
        }
        else {
            System.out.println("Invalid input. Please select a valid option.");
        }
    }
    public static double AddTwoNumbers(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
    public static double SubtractTwoNumbers(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
    public static double MultiplyTwoNumbers(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
    public static double DivideTwoNumbers(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }
}