import java.util.Scanner;

public class Calculator {
    public static int setNumber(Scanner sc) {
        int number;
        while (true) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number > 0) break;
            }
            System.out.print("Неправильный формат! Попробуйте снова: ");
            sc.nextLine();
        }
        return number;
    }

    public static String setOperator(Scanner sc) {
        String operator;
        while (true) {
            operator = sc.next();
            if (operator.equals("+")
                    || operator.equals("-")
                    || operator.equals("*")
                    || operator.equals("/")
                    || operator.equals("^")
                    || operator.equals("%")) {
                break;
            }
            System.out.print("Неправильный оператор! Попробуйте снова: ");
            sc.nextLine();
        }
        return operator;
    }

    public static int getResult(int firstNumber, String operator, int secondNumber) {
        int result = firstNumber;
        if (operator.equals("+")) {
            result += secondNumber;
        } else if (operator.equals("-")) {
            result -= secondNumber;
        } else if (operator.equals("*")) {
            result *= secondNumber;
        } else if (operator.equals("/")) {
            result /= secondNumber;
        } else if (operator.equals("%")) {
            result %= secondNumber;
        } else {
            for (int i = 1; i < secondNumber; i++) {
                result *= firstNumber;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в \"Калькулятор-cli\"\n");
        System.out.println("Будьте внимательны - программа работает только с натуральными числами");
        System.out.println("Допустимые операторы для использования: +, -, *, /, ^, %\n");

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int firstNumber = setNumber(sc);
        System.out.print("Введите оператор: ");
        String operator = setOperator(sc);
        System.out.print("Введите второе число: ");
        int secondNumber = setNumber(sc);
        int result = getResult(firstNumber, operator, secondNumber);
        System.out.printf("%n%d %s %d = %d", firstNumber, operator, secondNumber, result);
        sc.close();
    }
}