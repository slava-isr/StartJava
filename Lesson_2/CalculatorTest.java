import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в \"Калькулятор-cli\"");
        System.out.println("Будьте внимательны - программа работает только с целыми числами");

        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("\nВведите первое число: ");
            calculator.setFirstNumber(inputNumber(sc));
            System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
            calculator.setOperator(inputOperator(sc));
            System.out.print("Введите второе число: ");
            calculator.setSecondNumber(inputNumber(sc));
            while (calculator.getOperator().equals("/") && calculator.getSecondNumber() == 0) {
                System.out.println("Ошибка: деление на ноль запрещено");
                System.out.print("Введите второе число: ");
                calculator.setSecondNumber(inputNumber(sc));
            }
            printFormattedResult(calculator);
        } while (!isExit(sc));
        sc.close();
    }

    private static int inputNumber(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) return sc.nextInt();
            System.out.print("Неправильный формат! Попробуйте снова: ");
            sc.next();
        }
    }

    private static String inputOperator(Scanner sc) {
        while (true) {
            String operator = sc.next();
            boolean isValid = switch (operator) {
                case "+", "-", "*", "/", "^", "%" -> true;
                default -> false;
            };
            if (isValid) return operator;
            System.out.println("Ошибка: операция '" + operator + "' не поддерживается.");
            System.out.println("Доступны следующие операции: +, -, *, /, ^, %");
            System.out.print("Попробуйте снова: ");
        }
    }

    private static void printFormattedResult(Calculator calculator) {
        double result = calculator.calculate();
        String formattedResult = String.format("%.4f", result)
                .replaceAll("0+$", "")
                .replaceAll(",$", "");
        System.out.printf("%n%d %s %d = %s%n%n",
                calculator.getFirstNumber(), calculator.getOperator(), calculator.getSecondNumber(), formattedResult);
    }

    private static boolean isExit(Scanner sc) {
        while (true) {
            System.out.print("Хотите продолжить вычисления? [yes/no]: ");
            String input = sc.next();
            if (input.equalsIgnoreCase("yes")) {
                return false;
            }
            if (input.equalsIgnoreCase("no")) {
                System.out.println("До свидания!");
                return true;
            }
            sc.nextLine();
        }
    }
}