import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в \"Калькулятор-cli\"");
        System.out.println("Будьте внимательны - программа работает только с целыми числами");

        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        do {
            calculator.setFirstNumber(sc);
            calculator.setOperator(sc);
            calculator.setSecondNumber(sc);
            printFormattedResult(calculator);
        } while (!isExit(sc));
        sc.close();
    }

    private static void printFormattedResult(Calculator calculator) {
        double result = calculator.getResult();
        String formattedResult = String.format("%.4f", result);
        if (formattedResult.endsWith("0000")) {
            formattedResult = String.format("%.0f", result);
        } else if (formattedResult.endsWith("000")) {
            formattedResult = String.format("%.1f", result);
        } else if (formattedResult.endsWith("00")) {
            formattedResult = String.format("%.2f", result);
        } else if (formattedResult.endsWith("0")) {
            formattedResult = String.format("%.3f", result);
        }
        System.out.printf("%n%d %s %d = %s%n%n",
                calculator.getFirstNumber(), calculator.getOperator(), calculator.getSecondNumber(), formattedResult);
    }

    private static boolean isExit(Scanner sc) {
        while (true) {
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            String input = sc.next();
            if (input.equalsIgnoreCase("yes")) {
                return false;
            } else if (input.equalsIgnoreCase("no")) {
                System.out.println("До свидания!");
                return true;
            }
            sc.nextLine();
        }
    }
}