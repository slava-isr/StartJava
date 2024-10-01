import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в \"Калькулятор-cli\"");
        System.out.println("Будьте внимательны - программа работает только с целыми числами");
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        String userAnswer;
        do {
            inputFirstNumber(calculator, sc);
            inputOperator(calculator, sc);
            inputSecondNumber(calculator, sc);
            printFormattedResult(calculator.getFirstNumber(), calculator.getOperator(),
                    calculator.getSecondNumber(), calculator.calculate());
            do {
                System.out.print("Хотите продолжить вычисления? [yes/no]: ");
                userAnswer = sc.next().toLowerCase();
            } while (!"no".equals(userAnswer) && !"yes".equals(userAnswer));
        } while ("yes".equals(userAnswer));
        System.out.println("До свидания!");
        sc.close();
    }

    private static void inputFirstNumber(Calculator calculator, Scanner sc) {
        System.out.print("\nВведите первое число: ");
        validateInputNumber(sc);
        calculator.setFirstNumber(sc.nextInt());
    }

    private static void inputOperator(Calculator calculator, Scanner sc) {
        System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
        while (true) {
            String operator = sc.next();
            if (calculator.setOperator(operator)) break;
            System.out.println("Ошибка: операция '" + operator + "' не поддерживается.");
            System.out.println("Доступны следующие операции: +, -, *, /, ^, %");
            System.out.print("Попробуйте снова: ");
        }
    }

    private static void inputSecondNumber(Calculator calculator, Scanner sc) {
        System.out.print("Введите второе число: ");
        validateInputNumber(sc);
        calculator.setSecondNumber(sc.nextInt());
    }

    private static void validateInputNumber(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Неправильный формат! Попробуйте снова: ");
        }
    }

    private static void printFormattedResult(int firstNumber, String operator, int secondNumber, double result) {
        DecimalFormat df = new DecimalFormat("#.####");
        String formattedResult = df.format(result);
        System.out.printf("%n%d %s %d = %s%n%n", firstNumber, operator, secondNumber, formattedResult);
    }
}