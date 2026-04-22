package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            printMenu();

            int choice = getChoice(sc);

            switch (choice) {
                case 1:
                    calculate(sc, "+");
                    break;
                case 2:
                    calculate(sc, "-");
                    break;
                case 3:
                    calculate(sc, "*");
                    break;
                case 4:
                    calculate(sc, "/");
                    break;
                case 5:
                    System.out.println("Exiting the app, see you!");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("\nSelect your Operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Exit");
    }

    private static int getChoice(Scanner sc) {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            return -1;
        }
    }

    private static void calculate(Scanner sc, String operator) {
        try {
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            double result = performOperation(num1, num2, operator);

            System.out.println("Result = " + result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers only.");
            sc.next();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double performOperation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero!");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
    }
}