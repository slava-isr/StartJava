import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в \"Калькулятор-cli\"\n");
        System.out.println("Будьте внимательны - программа работает только с натуральными числами");
        System.out.println("Допустимые операторы для использования: +, -, *, /, ^, %\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int firstNum;
        while (true) {
            if (sc.hasNextInt()) {
                firstNum = sc.nextInt();
                if (firstNum > 0) break;
            }
            System.out.print("Неправильный формат! Попробуйте снова: ");
            sc.nextLine();
        }

        System.out.print("Введите оператор: ");
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

        System.out.print("Введите второе число: ");
        int secondNum;
        while (true) {
            if (sc.hasNextInt()) {
                secondNum = sc.nextInt();
                if (secondNum > 0) break;
            }
            System.out.print("Неправильный формат! Попробуйте снова: ");
            sc.nextLine();
        }

        int result = firstNum;
        if (operator.equals("+")) {
            result += secondNum;
        } else if (operator.equals("-")) {
            result -= secondNum;
        } else if (operator.equals("*")) {
            result *= secondNum;
        } else if (operator.equals("/")) {
            result /= secondNum;
        } else if (operator.equals("%")) {
            result %= secondNum;
        } else {
            for (int i = 1; i < secondNum; i++) {
                result *= firstNum;
            }
        }

        System.out.printf("%n%d %s %d = %d", firstNum, operator, secondNum, result);
        sc.close();
    }
}