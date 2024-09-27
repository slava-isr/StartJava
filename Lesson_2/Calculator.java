import java.util.Scanner;

public class Calculator {

    private int firstNumber;
    private int secondNumber;
    private String operator;
    private double result;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Scanner sc) {
        System.out.print("\nВведите первое число: ");
        firstNumber = inputNumber(sc);
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Scanner sc) {
        System.out.print("Введите второе число: ");
        secondNumber = inputNumber(sc);
        if (operator.equals("/") && secondNumber == 0) {
            System.out.println("Ошибка: деление на ноль запрещено");
            setSecondNumber(sc);
        }
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(Scanner sc) {
        System.out.print("Введите знак операции (+, -, *, /, ^, %): ");
        operator = inputOperator(sc);
    }

    public double getResult() {
        setResult();
        return result;
    }

    private void setResult() {
        result = calculate();
    }

    private int inputNumber(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) return sc.nextInt();
            System.out.print("Неправильный формат! Попробуйте снова: ");
            sc.nextLine();
        }
    }

    private String inputOperator(Scanner sc) {
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

    private double calculate() {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> (double) firstNumber / secondNumber;
            case "%" -> firstNumber % secondNumber;
            default -> {
                int result = firstNumber;
                int tempSecondNumber = secondNumber < 0 ? -secondNumber : secondNumber;
                for (int i = 1; i < tempSecondNumber; i++) {
                    result *= firstNumber;
                }
                yield secondNumber < 0 ? 1. / result : result;
            }
        };
    }
}